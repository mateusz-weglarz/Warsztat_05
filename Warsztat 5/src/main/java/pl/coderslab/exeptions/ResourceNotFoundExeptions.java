package pl.coderslab.exeptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class ResourceNotFoundExeptions extends RuntimeException {

    public ResourceNotFoundExeptions() {
    }

    public ResourceNotFoundExeptions(String message) {
        super(message);
    }

}
