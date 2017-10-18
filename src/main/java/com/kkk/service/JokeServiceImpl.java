package com.kkk.service;

import com.kkk.bean.Joke;
import com.kkk.bean.ResultBean;
import com.kkk.mapper.JokeMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Create By z3jjlzt on 2017/10/17
 * Service 加在实现类上.如果有多个实现类，需要指明具体实现类的名称
 */
@Service
public class JokeServiceImpl implements JokeService {

    private JokeMapper jokeMapper;

    @Autowired
    public JokeServiceImpl(JokeMapper jokeMapper) {
        this.jokeMapper = jokeMapper;
    }

    /**
     * 要有无参构造器，不然使用构造器注入会报npe.
     */
    public JokeServiceImpl() {
        super();
    }

    @Override
    public ResultBean getJoke(int id) {
        Joke joke = jokeMapper.selectByPrimaryKey(id);
        return ResultBean.success().put("joke", joke);
    }

    @Override
    public ResultBean updateJoke(int id) {
        return null;
    }

    @Override
    public ResultBean deleteJoke(int id) {
        return null;
    }

    @Override
    public ResultBean addJoke(int id) {
        return null;
    }
}
