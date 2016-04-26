package fr.lauthieb.service;

import fr.lauthieb.business.Book;
import fr.lauthieb.repository.BookDao;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
public class BookService {

    @Autowired
    private BookDao bookDao;

    public List<Book> getBooks() {
        return bookDao.getBooks();
    }
}
