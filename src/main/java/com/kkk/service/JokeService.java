package com.kkk.service;

import com.kkk.bean.ResultBean;

/**
 * Create By z3jjlzt on 2017/10/17
 */
public interface JokeService {

    ResultBean getJoke(int id);

    ResultBean updateJoke(int id);

    ResultBean deleteJoke(int id);

    ResultBean addJoke(int id);

}
