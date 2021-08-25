package com.example.MainTest.service;

import org.springframework.data.repository.CrudRepository;

import com.example.MainTest.model.Book;


public interface BookRepo extends CrudRepository<Book,Integer> {

}
