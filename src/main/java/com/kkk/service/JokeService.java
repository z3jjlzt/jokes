package com.kkk.service;

import com.github.pagehelper.PageInfo;
import com.kkk.bean.Joke;

/**
 * Create By z3jjlzt on 2017/10/17
 */
public interface JokeService {

    Joke getJoke(int id);

    PageInfo<Joke> getJokes(int pn);

    boolean updateJoke(Joke joke);

    boolean deleteJoke(int id);

    boolean addJoke(Joke joke);

}
