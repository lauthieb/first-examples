package fr.lauthieb.service;

import fr.lauthieb.business.Book;
import fr.lauthieb.repository.BookDao;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(MockitoJUnitRunner.class)
public class BookServiceTest {

    @InjectMocks
    private BookService bookService;

    @Mock
    private BookDao bookDao;

    private List<Book> bookList;

    @Before
    public void init() {
        bookList = new ArrayList<>();
        bookList.add(Book
                .builder()
                .title("T1")
                .price(12)
                .build());
    }

    @Test
    public void should_get_books() {
        Mockito.when(bookDao.getBooks()).thenReturn(bookList);

        List<Book> res = bookService.getBooks();
        assertThat(res.size()).isEqualTo(1);
    }
}
