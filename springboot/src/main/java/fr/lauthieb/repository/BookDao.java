package fr.lauthieb.repository;


import fr.lauthieb.business.Book;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Slf4j
@PropertySource("classpath:db/sql/book-requests.properties")
public class BookDao {

    @Autowired
    JdbcTemplate jdbcTemplate;

    @Value("${book.select.books}")
    private String bookSelectBooks;

    public List<Book> getBooks() {
        return jdbcTemplate.query(bookSelectBooks, (rs, rowNum) -> Book.builder()
                .title(rs.getString("BOOK_TITLE"))
                .price(rs.getInt("BOOK_PRICE"))
                .build()
        );
    }
}
