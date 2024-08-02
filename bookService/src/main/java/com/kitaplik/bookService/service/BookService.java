package com.kitaplik.bookService.service;

import com.kitaplik.bookService.dto.BookDto;
import com.kitaplik.bookService.dto.BookIdDto;
import com.kitaplik.bookService.exception.BookNotFoundException;
import com.kitaplik.bookService.repository.BookRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class BookService {

    private final BookRepository bookRepository;

    public BookService(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    public List<BookDto> getAllBook(){
        return bookRepository.findAll()
                .stream()
                .map(BookDto::convert)
                .collect(Collectors.toList());
    }

    public BookIdDto findBookByIsbn(String isbn){
        return bookRepository.getBookByIsbn(isbn)
                .map(book -> new BookIdDto(book.getId(),book.getIsbn()))
                .orElseThrow(() -> new BookNotFoundException("Book could not found by isbn : "+isbn));
    }

    public BookDto findBookDetailsById(String id){
        return bookRepository.findById(id)
                .map(BookDto::convert)
                .orElseThrow(() -> new BookNotFoundException("Book could not found by id : "+id));
    }

}
