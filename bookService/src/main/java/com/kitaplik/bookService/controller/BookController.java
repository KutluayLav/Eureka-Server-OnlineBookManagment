package com.kitaplik.bookService.controller;

import com.kitaplik.bookService.dto.BookDto;
import com.kitaplik.bookService.dto.BookIdDto;
import com.kitaplik.bookService.service.BookService;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.util.List;

@RestController
@RequestMapping("/v1/book")
@Validated
public class BookController {

    private final BookService bookService;

    public BookController(BookService bookService) {
        this.bookService = bookService;
    }

    @GetMapping
    public ResponseEntity<List<BookDto>> getAllBooks(){
        return ResponseEntity.ok(bookService.getAllBook());
    }

    @GetMapping("/isbn/{isbn}")
    public ResponseEntity<BookIdDto> getBookByIsbn(@PathVariable @NotEmpty String isbn){
        return ResponseEntity.ok(bookService.findBookByIsbn(isbn));
    }

    @GetMapping("/{id}")
    public ResponseEntity<BookDto> getBookById(@PathVariable @NotEmpty String id){
        return ResponseEntity.ok(bookService.findBookDetailsById(id));
    }
}
