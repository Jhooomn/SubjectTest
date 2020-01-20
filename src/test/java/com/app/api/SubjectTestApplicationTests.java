package com.app.api;
import com.app.api.infrastructure.rest.SubjectRest;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;


@SpringBootTest
@AutoConfigureMockMvc
class SubjectTestApplicationTests {

	@Autowired
	private MockMvc mockMvc;

	@Autowired
	ObjectMapper objectMapper;

	@Test
	void contextLoads() throws  Exception{
		mockMvc.perform(get("/subject")).andDo(print())
		.andExpect(status().isOk())
		.andExpect(content().contentType(MediaType.APPLICATION_JSON));
	}

	@Test
	void saveSubject() throws Exception {
			SubjectRest subjectRest = new SubjectRest();
			subjectRest.setId("");
			subjectRest.setCode("ASD752");
			subjectRest.setCredits(3);
			subjectRest.setName("MATH");

			String json = objectMapper.writeValueAsString(subjectRest);

			mockMvc.perform(post("/subject")
			.contentType(MediaType.APPLICATION_JSON)
			.content(json)).andDo(print()).andExpect(status().isOk());
		}
}
