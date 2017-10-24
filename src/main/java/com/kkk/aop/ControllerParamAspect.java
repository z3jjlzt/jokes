package com.kkk.aop;

import com.kkk.bean.ResultBean;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;

import java.util.List;

/**
 * 控制器切面
 * Create By z3jjlzt on 2017/10/20
 */
@Slf4j
@Aspect
@Component
public class ControllerParamAspect {

    /**
     * 打印入参，处理返回结果
     *
     * @param pjp
     */
    private ResultBean printParamAndProcessResult(ProceedingJoinPoint pjp) {
        try {
            log.info("the method is {}", pjp.getStaticPart());
            for (Object o : pjp.getArgs()) {
                log.info("param {}", o);
            }
            Object proceed = pjp.proceed();
            return ResultBean.success().put("data", proceed);
        } catch (Throwable throwable) {
            log.error("process fail,the msg is {}", throwable.getMessage());
            return ResultBean.fail().put("data", throwable.getMessage());
        }
    }

    /**
     * 匹配需要数据校验的方法
     *
     * @param pjp
     * @param result
     * @return
     */
    @Around("execution(* com.kkk.controller.restful.*.*(..)) && args(..,result)")
    public ResultBean validateParam(ProceedingJoinPoint pjp, BindingResult result) {
        if (result.hasErrors()) {
            ResultBean fail = ResultBean.fail();
            List<FieldError> errors = result.getFieldErrors();
            errors.forEach(x -> fail.put(x.getField(), x.getDefaultMessage()));
            return fail;
        } else {
            printParamAndProcessResult(pjp);
        }
        return ResultBean.success();
    }

    @Around("execution(* com.kkk.controller.restful.*.*(..)) && !args(..,org.springframework.validation.BindingResult)")
    public ResultBean normalAspect(ProceedingJoinPoint pjp) {
        return printParamAndProcessResult(pjp);
    }
}
