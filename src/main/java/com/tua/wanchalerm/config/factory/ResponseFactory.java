package com.tua.wanchalerm.config.factory;

import com.tua.wanchalerm.config.constant.Response;
import com.tua.wanchalerm.config.controller.response.GeneralResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;


@Component
public class ResponseFactory {

    public ResponseEntity success() {
        GeneralResponse<Object> responseObject = new GeneralResponse();
        responseObject.setCode(Response.SUCCESS_CODE);
        return ResponseEntity.ok(responseObject);
    }

    public ResponseEntity success(Object data, Class clazz) {
        GeneralResponse<Object> responseObject = new GeneralResponse();
        responseObject.setCode(Response.SUCCESS_CODE);
        responseObject.setData(clazz.cast(data));
        return ResponseEntity.ok(responseObject);
    }

    public ResponseEntity error(HttpStatus httpStatus, String errorCode) {
        GeneralResponse<Object> responseObject = new GeneralResponse<>();
        responseObject.setCode(errorCode);
        return new ResponseEntity(responseObject, httpStatus);
    }

    public ResponseEntity error(HttpStatus httpStatus, String errorCode, Object data, Class clazz) {
        GeneralResponse<Object> responseObject = new GeneralResponse<>();
        responseObject.setCode(errorCode);
        responseObject.setData(clazz.cast(data));
        return new ResponseEntity(responseObject, httpStatus);

    }

}
