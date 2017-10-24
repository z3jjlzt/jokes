package com.kkk.controller.restful;

import com.kkk.bean.Joke;
import com.kkk.exception.BusinessExceptin;
import com.kkk.service.JokeService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

/**
 * Create By z3jjlzt on 2017/10/16
 */
@RestController
@Slf4j //使用lombok 可以直接使用log.xxx进行日志打印
public class MainController {

    @Autowired
    JokeService jokeService;

    @GetMapping(value = "/joke/{id}", produces = "application/json;charset=utf8")
    public Object getJoke(@PathVariable Integer id) {
        if (id <= 0)
            throw new BusinessExceptin("id不能小于1");
        return jokeService.getJoke(id);
    }

    @GetMapping(value = "/jokes", produces = "application/json;charset=utf8")
    public Object getJokes(Integer pn) {
        //打印日志框架内部信息
//        StatusPrinter.print((Context) LoggerFactory.getILoggerFactory());
        log.info(" pn is {} .", pn);
        return jokeService.getJokes(pn);
    }

    /**
     * consumers 指明接收的数据编码
     * produces 指明返回给客户端的数据编码
     *
     * @param joke
     * @return
     */
    @PostMapping(value = "/joke", consumes = "application/json;charset=utf8", produces = "application/json;charset=utf8")
    public Object addJoke(@RequestBody Joke joke) {
        return jokeService.addJoke(joke);
    }

    /**
     * {id} 以及传入的param，只要与joke中字段名称相符，就会自动set，是在session会话中的map中遍历取得
     *
     * @param joke
     * @return
     */
    @PutMapping(value = "/joke/{id}", produces = "application/json;charset=utf8")
    public Object updateJoke(@Valid Joke joke, BindingResult result) {
        return jokeService.updateJoke(joke);
    }

    @DeleteMapping(value = "/joke/{id}", produces = "application/json;charset=utf8")
    public Object deleteJoke(@PathVariable Integer id) {
        return jokeService.deleteJoke(id);
    }

}
