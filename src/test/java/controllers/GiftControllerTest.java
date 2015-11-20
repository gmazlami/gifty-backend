package controllers;

import org.junit.Before;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import ch.gmazlami.gifty.Application;
import ch.gmazlami.gifty.config.MvcConfig;
import ch.gmazlami.gifty.config.RepositoryConfig;
import ch.gmazlami.gifty.postgres.services.IGiftService;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = {Application.class, MvcConfig.class, RepositoryConfig.class})
@WebAppConfiguration
public class GiftControllerTest {

	
	@Autowired
	WebApplicationContext context;
	
	@Autowired
	IGiftService giftService;
	
	private MockMvc mockMvc;
	
	
	@Before
	public void setUp(){
		this.mockMvc = MockMvcBuilders.webAppContextSetup(context).build();
	}
	
	
}
