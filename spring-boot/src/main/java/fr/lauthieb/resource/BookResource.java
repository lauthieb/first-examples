package fr.lauthieb.resource;

import fr.lauthieb.business.Book;
import fr.lauthieb.service.BookService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api")
@Slf4j
public class BookResource {

    @Autowired
    private BookService bookService;

    @RequestMapping(path = "/books", method = RequestMethod.GET)
    @ResponseBody
    public List<Book> getBooks() {
        return bookService.getBooks();
    }

}
