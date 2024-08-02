package com.kitaplik.bookService;

import com.kitaplik.bookService.model.Book;
import com.kitaplik.bookService.repository.BookRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Arrays;
import java.util.List;

@SpringBootApplication
public class BookServiceApplication implements CommandLineRunner {

	private final BookRepository bookRepository;

    public BookServiceApplication(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    @Override
	public void run(String... args) throws Exception {
		Book book1 = new Book("Dünyanın Gözü", 2000, "Robert Jordan", "İthaki Yayınevi", "123456");
		Book book2 = new Book("Yüzüklerin Efendisi", 1960, "J.R.R Tolkien", "Metis Yayıncılık", "456789");
		Book book3 = new Book("Harry Potter ve Felsefe Taşı", 1997, "J. K. Rowling", "YKB Yayınları", "987654");

		List<Book> bookList = bookRepository.saveAll(Arrays.asList(book1, book2, book3));

		System.out.println(bookList);
	}

	public static void main(String[] args) {
		SpringApplication.run(BookServiceApplication.class, args);
	}

}
