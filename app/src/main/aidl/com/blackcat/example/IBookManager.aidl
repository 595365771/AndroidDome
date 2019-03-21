package com.blackcat.example;

import com.blackcat.example.Book;

interface IBookManager {
    List<Book> getBookList();
    void addBook(in Book book);
}
