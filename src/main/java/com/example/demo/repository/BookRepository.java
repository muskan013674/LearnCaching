package com.example.demo.repository;

import com.example.demo.dto.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

@org.springframework.stereotype.Repository
public interface BookRepository extends JpaRepository<Book, Integer> {
    @Transactional
    @Modifying
    @Query("update Book u set u.name = ?2 where u.id = ?1")
    int updateAddBook(int id, String Name);
}
