package com.kkk.service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.kkk.bean.Joke;
import com.kkk.bean.JokeExample;
import com.kkk.exception.BusinessExceptin;
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

    /**
     * @param id
     * @return
     */
    @Override
    public Joke getJoke(int id) {
        return jokeMapper.selectByPrimaryKey(id);
    }

    @Override
    public PageInfo<Joke> getJokes(int pn) {
        PageHelper.startPage(pn, 10);
        List<Joke> list = jokeMapper.selectByExample(null);
        return new PageInfo<>(list);
    }

    @Override
    public boolean updateJoke(Joke joke) {
        int update = jokeMapper.updateByPrimaryKeySelective(joke);
        if (update == 0) {
            throw new BusinessExceptin("更新id为" + joke.getId() + "的记录失败");
        }
        return true;
    }

    @Override
    public boolean deleteJoke(int id) {
        int delNum = jokeMapper.deleteByPrimaryKey(id);
        if (0 == delNum) {
            throw new BusinessExceptin("删除id为" + id + "的记录失败");
        }
        return true;
    }

    @Override
    public boolean addJoke(Joke joke) {
        JokeExample example = new JokeExample();
        JokeExample.Criteria criteria = example.createCriteria();
        criteria.andAuthorEqualTo(joke.getAuthor())
                .andAtagEqualTo(joke.getAtag());
        if (jokeMapper.selectByExample(example).size() != 0) {
            throw new BusinessExceptin("记录已存在，插入失败");
        }
        jokeMapper.insertSelective(joke);
        return true;
    }
}
