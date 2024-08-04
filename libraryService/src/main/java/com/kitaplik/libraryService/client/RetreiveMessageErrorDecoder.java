package com.kitaplik.libraryService.client;

import com.kitaplik.libraryService.exception.BookNotFoundException;
import com.kitaplik.libraryService.exception.ExceptionMessage;
import feign.Response;
import feign.codec.ErrorDecoder;
import org.apache.commons.io.IOUtils;
import org.springframework.http.HttpStatus;

import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;

public class RetreiveMessageErrorDecoder implements ErrorDecoder {

    private final ErrorDecoder errorDecoder = new Default();


    @Override
    public Exception decode(String methodKey, Response response) {

        ExceptionMessage exceptionMessage = null;

        try(InputStream body =response.body().asInputStream()){
            exceptionMessage = new ExceptionMessage((String) response.headers().get("date").toArray()[0],
                    response.status(),
                    HttpStatus.resolve(response.status()).getReasonPhrase(),
                    IOUtils.toString(body, StandardCharsets.UTF_8),
                    response.request().url());


        }catch (IOException e){
            return new Exception(e.getMessage());
        }
        switch (response.status()) {
            case 404:
                throw new BookNotFoundException(exceptionMessage);
            default:
                return errorDecoder.decode(methodKey, response);
        }
    }
}
