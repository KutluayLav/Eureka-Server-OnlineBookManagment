package com.kitaplik.libraryService.service;


import com.kitaplik.libraryService.dto.LibraryDto;
import com.kitaplik.libraryService.exception.LibraryNotFoundException;
import com.kitaplik.libraryService.model.Library;
import com.kitaplik.libraryService.repository.LibraryRepository;
import org.springframework.stereotype.Service;

import java.util.stream.Collectors;

@Service
public class LibraryService {

    private final LibraryRepository libraryRepository;

    public LibraryService(LibraryRepository libraryRepository) {
        this.libraryRepository = libraryRepository;
    }

    public LibraryDto getAllBooksInLibraryById(String id){
        Library library =libraryRepository.findById(id)
                .orElseThrow(() -> new LibraryNotFoundException("Library not found by id:"+id ));

       LibraryDto libraryDto = new LibraryDto(library.getId());

        return libraryDto;
    }

    public LibraryDto createLibrary(){
        Library newLibrary = new Library();
        return new LibraryDto(newLibrary.getId());
    }

}
