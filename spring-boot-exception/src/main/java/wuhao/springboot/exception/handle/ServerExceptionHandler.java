package wuhao.springboot.exception.handle;

import lombok.extern.slf4j.Slf4j;

import org.springframework.validation.BindException;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import wuhao.springboot.exception.enums.ErrorCode;
import wuhao.springboot.exception.exception.ServerException;


import wuhao.springboot.exception.result.Result;

/**
 * @author PC
 */
@Slf4j
@RestControllerAdvice
public class ServerExceptionHandler {

    @ExceptionHandler(ServerException.class)
    public Result<String> handleException(ServerException exception){
        return Result.error(exception.getCode(),exception.getMsg());
    }

    @ExceptionHandler(BindException.class)
    public Result<String> bindException(BindException exception){
        FieldError fieldError = exception.getFieldError();
        assert fieldError != null;
        return Result.error(fieldError.getDefaultMessage());
    }

    @ExceptionHandler(Exception.class)
    public Result<String> handleException(Exception ex){
        log.error(ex.getMessage(),ex);
        return Result.error(ErrorCode.INTERNAL_SERVER_ERROR);
    }
}
