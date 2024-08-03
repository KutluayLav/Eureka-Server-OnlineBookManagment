package com.kitaplik.libraryService.repository;

import com.kitaplik.libraryService.model.Library;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LibraryRepository extends JpaRepository<Library,String> {
}
