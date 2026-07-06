package com.sujata.security;

import java.nio.charset.StandardCharsets;
import java.security.Key;
import java.util.Collection;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

import javax.crypto.SecretKey;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;

@Service
public class JwtService {

	@Value("${jwt.secret}")
	private String secret;

	@Value("${jwt.expiration}")
	private long expiration;

	/**
	 * Generate JWT
	 */
	public String generateToken(UserDetails userDetails) {

		Map<String, Object> claims = new HashMap<>();

		Collection<String> roles = userDetails.getAuthorities().stream().map(GrantedAuthority::getAuthority)
				.collect(Collectors.toList());

		claims.put("roles", roles);

		return createToken(claims, userDetails.getUsername());

	}

	/**
	 * Create JWT
	 */
	private String createToken(Map<String, Object> claims, String username) {

		Date now = new Date();

		Date expiry = new Date(now.getTime() + expiration);

		return Jwts.builder()

				.claims(claims)

				.subject(username)

				.issuedAt(now)

				.expiration(expiry)

				.signWith(getSigningKey())

				.compact();

	}

	/**
	 * Secret Key
	 */
	private SecretKey getSigningKey() {

		return Keys.hmacShaKeyFor(secret.getBytes(StandardCharsets.UTF_8));

	}

	/**
	 * Username
	 */
	public String extractUsername(String token) {

		return extractClaim(token, Claims::getSubject);

	}

	/**
	 * Expiration
	 */
	public Date extractExpiration(String token) {

		return extractClaim(token, Claims::getExpiration);

	}

	/**
	 * Generic Claim
	 */
	public <T> T extractClaim(String token, Function<Claims, T> resolver) {

		Claims claims = extractAllClaims(token);

		return resolver.apply(claims);

	}

	/**
	 * All Claims
	 */
	private Claims extractAllClaims(String token) {

		return Jwts.parser()

				.verifyWith(getSigningKey())

				.build()

				.parseSignedClaims(token)

				.getPayload();

	}

	/**
	 * Expired?
	 */
	public boolean isTokenExpired(String token) {

		return extractExpiration(token).before(new Date());

	}

	/**
	 * Validate
	 */
	public boolean isTokenValid(String token, UserDetails userDetails) {

		String username = extractUsername(token);

		return username.equals(userDetails.getUsername())

				&&

				!isTokenExpired(token);

	}

}