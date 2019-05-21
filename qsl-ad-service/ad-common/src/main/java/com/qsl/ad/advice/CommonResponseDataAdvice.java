package com.qsl.ad.advice;

import com.qsl.ad.annotation.IgnoreResponseAdvice;
import com.qsl.ad.vo.CommonResponse;
import org.springframework.core.MethodParameter;
import org.springframework.http.MediaType;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.server.ServerHttpRequest;
import org.springframework.http.server.ServerHttpResponse;
import org.springframework.lang.Nullable;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseBodyAdvice;

/**
 * @author DanielQSL
 * @date 2019/5/20
 */
@RestControllerAdvice
public class CommonResponseDataAdvice implements ResponseBodyAdvice<Object> {
    @Override
    @SuppressWarnings("all")
    public boolean supports(MethodParameter returnType, Class<? extends HttpMessageConverter<?>> converterType) {
        if (returnType.getDeclaringClass().isAnnotationPresent(IgnoreResponseAdvice.class)) {
            return false;
        }
        if (returnType.getMethod().isAnnotationPresent(IgnoreResponseAdvice.class)) {
            return false;
        }
        return true;
    }

    @SuppressWarnings("all")
    @Override
    public Object beforeBodyWrite(Object body, MethodParameter returnType, MediaType selectedContentType,
                                  Class<? extends HttpMessageConverter<?>> selectedConverterType,
                                  ServerHttpRequest request, ServerHttpResponse response) {

        //todo 记得修改
//        CommonResponse<Object> result = new CommonResponse<>();
//        if (null == body) {
//            return CommonResponse.createBySuccess();
//        } else if (body instanceof CommonResponse) {
//            result = (CommonResponse<Object>) body;
//        } else {
//            result.setData(body);
//        }
//        return result;
        return null;
    }
}
