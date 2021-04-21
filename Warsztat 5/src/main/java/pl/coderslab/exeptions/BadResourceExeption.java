package pl.coderslab.exeptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class BadResourceExeption extends RuntimeException{

    public BadResourceExeption() {
    }

    public BadResourceExeption(String message){
        super(message);
    }
}
