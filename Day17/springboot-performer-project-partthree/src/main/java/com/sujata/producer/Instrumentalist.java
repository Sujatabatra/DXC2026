package com.sujata.producer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;
/*
 * is-a (inheritance)
 * has-a (contains object)
 * 
 * Instrumentalist is a Performer and has an Instrument to Play
 */
@Component("Harshitha")
public class Instrumentalist implements Performer {

	/*
	 * dependency
	 * Spring Container have objects of the dependency object in its context
	 */
	private Instrument instrument; 

	/*
	 * when we do autowiring, if only one possible candidate for autowiring is available than that will be auto wired
	 * problem will come if we have multiple candidate available which can be wired in current scenario,
	 * so we need one additional annotation which will narrow down wirirng to one bean and that annotation is @Qualifier
	 */
	@Autowired
	@Qualifier("drum")
	public void setInstrument(Instrument instrument) {
		this.instrument = instrument;
	}

	@Override
	public void perform() {
		System.out.print("Instrumentalist is playing ");
		instrument.play();

	}

}
