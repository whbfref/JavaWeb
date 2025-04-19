package com.mycinema.service;

import com.mycinema.dao.BookDao;
import com.mycinema.model.Book;

import java.util.ArrayList;

public class BookService {
    BookDao bookDao =new BookDao();
    public ArrayList<Book> findAll()
    {
        return bookDao.selectAll();
    }
    public int remove(int id)
    {
        return bookDao.delete(id);
    }
    public int addBook(Book book) { return bookDao.insertBook(book);}
    public Book findById(int id)
    {
        return bookDao.selectByIdI(id);
    }
        public boolean updateMovie(Book book) {
            int result = bookDao.updateBook(book);
            return result > 0;
        }

}
