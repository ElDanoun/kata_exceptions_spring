package kataexc.infrastructure.skooler;

import kataexc.domain.Skooler;
import org.springframework.hateoas.VndErrors;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.util.SortedMap;

@ControllerAdvice(assignableTypes = SkoolerController.class)
public class SkoolerControllerAdvice {
    @ResponseBody
    @ExceptionHandler(SkoolerNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public ResponseEntity<String> handleSkoolerNotFoundException(SkoolerNotFoundException exc){
        return new ResponseEntity<>(exc.getMessage(), HttpStatus.NOT_FOUND);
    }
//    public VndErrors.VndError handleSkoolerNotFoundException(SkoolerNotFoundException exc) {
//        return new VndErrors.VndError("error",exc.getMessage());
//    }
}
