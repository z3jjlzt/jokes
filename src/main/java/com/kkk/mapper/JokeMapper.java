package com.kkk.mapper;

import com.kkk.bean.Joke;
import com.kkk.bean.JokeExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface JokeMapper {
    long countByExample(JokeExample example);

    int deleteByExample(JokeExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(Joke record);

    int insertSelective(Joke record);

    List<Joke> selectByExampleWithBLOBs(JokeExample example);

    List<Joke> selectByExample(JokeExample example);

    Joke selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") Joke record, @Param("example") JokeExample example);

    int updateByExampleWithBLOBs(@Param("record") Joke record, @Param("example") JokeExample example);

    int updateByExample(@Param("record") Joke record, @Param("example") JokeExample example);

    int updateByPrimaryKeySelective(Joke record);

    int updateByPrimaryKeyWithBLOBs(Joke record);

    int updateByPrimaryKey(Joke record);
}