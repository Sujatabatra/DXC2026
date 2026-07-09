package com.sujata;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.webmvc.test.autoconfigure.AutoConfigureMockMvc;
import org.springframework.test.web.servlet.MockMvc;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SpringBootTest
@AutoConfigureMockMvc
class SpringbootRestApiEmployeeProjectApplicationTests {

    @Autowired
    private MockMvc mockMvc;

    @Test
    void testEmployeeAPI() throws Exception {

        mockMvc.perform(get("/employees"))
                .andExpect(status().isOk())
                .andExpect(content()
                        .contentTypeCompatibleWith("application/json"));
    }

}
