package com.qsl.ad.advice;

import com.qsl.ad.exception.AdException;
import com.qsl.ad.vo.CommonResponse;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

/**
 * @author DanielQSL
 * @date 2019/5/20
 */
@RestController
public class GlobalExceptionAdvice {

    @ExceptionHandler(value = AdException.class)
    public CommonResponse<String> handleAdExcetion(HttpServletRequest request,
                                                   AdException ex) {
        return CommonResponse.createByErrorCodeMessageData(-1, "business error", ex.getMessage());
    }
}
