package com.kkk.mapper;

import com.kkk.service.JokeService;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

/**
 * Create By z3jjlzt on 2017/10/17
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath*:*-context.xml")
@WebAppConfiguration
public class jokeMapperTest {

    @Autowired
    JokeService jokeService;

    private MockMvc mockMvc;

    @Autowired
    private WebApplicationContext context;

    @Before
    public void before() throws Exception {
        mockMvc = MockMvcBuilders.webAppContextSetup(context).build();
    }

    @Test
    public void test1() throws Exception {
//        JokeExample example = new JokeExample();
//        example.setDistinct(true);
//        example.createCriteria().andAtagIsNotNull();
        System.out.println(mockMvc.perform(get("/joke/3")
                .accept(MediaType.parseMediaType("application/json;charset=utf8")))
                .andExpect(status().isOk())
                .andReturn().getResponse().getContentAsString());

    }
}
