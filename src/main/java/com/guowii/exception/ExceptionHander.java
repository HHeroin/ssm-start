package com.guowii.exception;

import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.PrintWriter;
import java.io.StringWriter;

public class ExceptionHander implements HandlerExceptionResolver {
    @Override
    public ModelAndView resolveException(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) {

        // 取出异常信息输出到PrintWriter中
        StringWriter stringWriter = new StringWriter();
        ex.printStackTrace(new PrintWriter(stringWriter));
        ModelAndView modelAndView = new ModelAndView();
        // 设置逻辑视图名
        modelAndView.setViewName("error");
        // 添加模型数据
        modelAndView.addObject("errormsg",stringWriter.toString());
        return modelAndView;
    }
}
