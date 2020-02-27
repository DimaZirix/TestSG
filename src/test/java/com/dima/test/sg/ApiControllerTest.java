package com.dima.test.sg;

import org.springframework.test.web.servlet.MockMvc;

import static org.hamcrest.Matchers.containsString;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

/**
 * Необходимо создать тестовый профиль, иначе сборка maven'ом падает
 */

//@SpringBootTest
//@AutoConfigureMockMvc
class ApiControllerTest {

    private final MockMvc mockMvc;

    //@Autowired
    ApiControllerTest(final MockMvc mockMvc) {
        this.mockMvc = mockMvc;
    }

    //@Test
    void putMethod() throws Exception {
        this.mockMvc
            .perform(get("/put/?parent=рут&child=элемент_1"))
            .andDo(print())
            .andExpect(status().isOk());

        this.mockMvc
            .perform(get("/get/1/"))
            .andDo(print())
            .andExpect(status().isOk())
            .andExpect(content().string(containsString("{\"id\":1,\"name\":\"рут\",\"childList\":[{\"id\":2,\"name\":\"элемент_1\",\"childList\":[]}]}")));
    }
}
