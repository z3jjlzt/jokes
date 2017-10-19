package com.kkk.service;

import com.alibaba.fastjson.JSON;
import com.kkk.bean.Joke;
import org.junit.After;
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

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;

/**
 * JokeServiceImpl Tester.
 *
 * @author z3jjlzt
 * @version 1.0
 */
@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@ContextConfiguration("classpath*:*context.xml")
public class JokeServiceImplTest {
    @Autowired
    JokeService jokeService;

    private MockMvc mockMvc;

    @Autowired
    private WebApplicationContext context;

    @Before
    public void before() throws Exception {
        mockMvc = MockMvcBuilders.webAppContextSetup(context).build();
    }


    @After
    public void after() throws Exception {
    }

    /**
     * Method: getJoke(int id)
     */
    @Test
    public void testGetJoke() throws Exception {
        mockMvc.perform(get("/jokes")
                .param("pn","3")
                .characterEncoding("utf8")
                .contentType(MediaType.APPLICATION_JSON))
                .andDo(print());
    }

    /**
     * Method: updateJoke(int id)
     */
    @Test
    public void testUpdateJoke() throws Exception {
        System.out.println(mockMvc.perform(put("/joke/2")
                .characterEncoding("utf-8")
                .contentType(MediaType.APPLICATION_FORM_URLENCODED_VALUE)
                .param("atype", "2")
                .param("article", "mock mock mock")
                .param("author", "mock")
        ).andDo(print()).andReturn().getResponse().getContentAsString());
    }

    /**
     * Method: deleteJoke(int id)
     */
    @Test
    public void testDeleteJoke() throws Exception {
        mockMvc.perform(delete("/joke/3")
                .characterEncoding("utf8")
        ).andDo(print());
    }

    /**
     * Method: addJoke(Joke joke)
     */
    @Test
    public void testAddJoke() throws Exception {
        Joke joke = new Joke();
        joke.setAuthor("mockmvc");
        joke.setAtag("java");
        joke.setArticle("hello world!!!");
//        System.out.println(jokeService.addJoke(joke));
        System.out.println(JSON.toJSONString(joke));
        mockMvc.perform(post("/joke")
                .characterEncoding("utf-8")
                .contentType(MediaType.APPLICATION_JSON)
                .content(JSON.toJSONString(joke))).andDo(print()).andReturn().getResponse().getContentAsString();
    }


} 
