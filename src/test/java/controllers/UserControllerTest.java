package controllers;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import ch.gmazlami.gifty.Application;
import ch.gmazlami.gifty.config.MvcConfig;
import ch.gmazlami.gifty.config.RepositoryConfig;
import ch.gmazlami.gifty.postgres.services.IUserService;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = {Application.class, MvcConfig.class, RepositoryConfig.class})
@WebAppConfiguration
public class UserControllerTest {

	@Autowired
	WebApplicationContext context;
	
	@Autowired
	IUserService userService;
	
	@Autowired
	private ObjectMapper jacksonObjectMapper;
	
	
	private MockMvc mockMvc;
	
	
	@Before
    public void setup() throws Exception {
        this.mockMvc = MockMvcBuilders.webAppContextSetup(context).build();
    }
	
	
	@Test
	public void noSuchUser() throws Exception{
		mockMvc.perform(MockMvcRequestBuilders
				.get("/user/9999"))
				.andExpect(MockMvcResultMatchers.status().isNotFound());
	}
	
	@Test
	public void successfulUserById() throws Exception {
		mockMvc.perform(MockMvcRequestBuilders
				.get("/user/2"))
				.andExpect(MockMvcResultMatchers.status().isOk())
				.andExpect(MockMvcResultMatchers.content().json(json(userService.getUserById(2L))));
	}
	
	
    protected String json(Object o) throws JsonProcessingException {
    	return jacksonObjectMapper.writeValueAsString(o);
    }
	
}
