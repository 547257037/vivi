package com.tiantian.config.exception;

import com.fasterxml.jackson.databind.JsonMappingException;
import com.tiantian.common.ResponseResult;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.validation.BindException;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.validation.ConstraintViolation;
import javax.validation.ConstraintViolationException;
import java.util.List;
import java.util.Set;

/**
 *
 * @author zyx
 * @date 2017/6/26
 */
@ControllerAdvice
public class GlobalExceptionHandler {

    private Logger logger = LoggerFactory.getLogger(getClass());

    @ExceptionHandler(value = Exception.class)
    @ResponseBody
    public ResponseResult defaultErrorHandler(Exception e) throws Exception {

        logger.error(e.getMessage(), e);

        StringBuilder msg = new StringBuilder();
        if (e instanceof ConstraintViolationException) {
            return getJPAExceptionResult((ConstraintViolationException) e, msg);
        } else if (e instanceof BindException) {
            List<ObjectError> allErrors = ((BindException) e).getAllErrors();
            for (ObjectError allError : allErrors) {
                msg.append(allError.getDefaultMessage()).append(";");
            }
            return ResponseResult.putError(msg.toString());
        } else if (e instanceof JsonMappingException) {
            return ResponseResult.putError(e.getMessage());
        } else if (e instanceof MethodArgumentNotValidException) {
            for (FieldError fieldError : ((MethodArgumentNotValidException) e).getBindingResult().getFieldErrors()) {
                msg.append(fieldError.getDefaultMessage()).append(";");
            }
            return ResponseResult.putError(msg.toString());
        } else if (e instanceof StarvException) {
            return ResponseResult.putError(e.getMessage(), ((StarvException) e).getErrorCode());
        } else {
            return ResponseResult.putError(e.getMessage());
        }
    }

    private ResponseResult getJPAExceptionResult(ConstraintViolationException e, StringBuilder msg) {
        Set<ConstraintViolation<?>> constraintViolations = e.getConstraintViolations();
        for (ConstraintViolation<?> constraintViolation : constraintViolations) {
            msg.append(constraintViolation.getMessage()).append(";");
        }
        return ResponseResult.putError(msg.toString());
    }

}
