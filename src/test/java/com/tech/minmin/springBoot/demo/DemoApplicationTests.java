package com.tech.minmin.springBoot.demo;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import static org.hamcrest.Matchers.equalTo;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@SpringBootTest
public class DemoApplicationTests {

	private MockMvc mvc;
	@Autowired
	private Properties properties;

	@Before
	public void setUp() throws Exception{
		mvc = MockMvcBuilders.standaloneSetup(new GreetingController()).build();//GreetingController@Before函数中创建并传递到MockMvcBuilders.standaloneSetup（）函数中
	}
	@Test
	public void getHello()throws Exception{
		mvc.perform(MockMvcRequestBuilders.get("/hello/winner").accept(MediaType.APPLICATION_JSON)).andExpect(status().isOk()).andExpect(content().string(equalTo("Hello, winner!")));
	}

	@Test
	public void getProperties() throws Exception{
		Assert.assertEquals(properties.getName(), "WANG Minmin");
	}

}
