package com.kkk.service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.kkk.bean.Joke;
import com.kkk.bean.ResultBean;
import com.kkk.mapper.JokeMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

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
    public ResultBean getJokes(int pn) {
        PageHelper.startPage(pn, 10);
        List<Joke> list = jokeMapper.selectByExample(null);
        return ResultBean.success().put("pageInfo",new PageInfo<>(list));
    }

    @Override
    public ResultBean updateJoke(Joke joke) {
        return ResultBean.success()
                .put("effect_row", jokeMapper.updateByPrimaryKeySelective(joke));
    }

    @Override
    public ResultBean deleteJoke(int id) {
        return ResultBean.success().put("effect_row", jokeMapper.deleteByPrimaryKey(id));
    }

    @Override
    public ResultBean addJoke(Joke joke) {
        return ResultBean.success().put("effect_row", jokeMapper.insertSelective(joke));
    }
}
