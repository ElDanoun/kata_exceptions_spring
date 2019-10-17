package kataexc.infrastructure.skooler;

import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.hateoas.VndErrors;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.sql.SQLOutput;
import java.util.logging.Logger;
 .class
@ControllerAdvice
@Order(Ordered.LOWEST_PRECEDENCE)
public class GlobalSkoolerControllerAdvice {
    @ResponseBody
    @ExceptionHandler(Exception.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
//    public ResponseEntity<String> handleSkoolerNotFoundException(Exception exception){
//        return new ResponseEntity<>(exception.getMessage(), HttpStatus.NOT_FOUND);
//    }

    public VndErrors.VndError handleSkoolerNotFoundException(Exception exc) {
        System.out.println("Error: " +exc.getMessage() );
        return new VndErrors.VndError("error","Something went wrong");
    }
}
