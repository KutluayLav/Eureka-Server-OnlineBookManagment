package com.kitaplik.libraryService.client;

import com.kitaplik.libraryService.dto.BookDto;
import com.kitaplik.libraryService.dto.BookIdDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "bookService",path = "/v1/book")
public interface BookServiceClient {

    @GetMapping("/isbn/{isbn}")
    ResponseEntity<BookIdDto> getBookByIsbn(@PathVariable  String isbn);

    @GetMapping("/{id}")
    ResponseEntity<BookDto> getBookById(@PathVariable String id);


}
