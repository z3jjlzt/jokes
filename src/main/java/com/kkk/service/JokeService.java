package com.kkk.service;

import com.kkk.bean.Joke;
import com.kkk.bean.ResultBean;

/**
 * Create By z3jjlzt on 2017/10/17
 */
public interface JokeService {

    ResultBean getJoke(int id);

    ResultBean getJokes(int pn);

    ResultBean updateJoke(Joke joke);

    ResultBean deleteJoke(int id);

    ResultBean addJoke(Joke joke);

}
