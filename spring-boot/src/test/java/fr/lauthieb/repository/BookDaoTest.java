package fr.lauthieb.repository;

import fr.lauthieb.SpringbootApplication;
import fr.lauthieb.business.Book;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = SpringbootApplication.class)
@WebAppConfiguration
@Transactional
public class BookDaoTest {

	@Autowired
	private BookDao bookDao;

	@Test
	public void should_get_books() {
		List<Book> bookList = bookDao.getBooks();
        assertThat(bookList).isNotNull();
        assertThat(bookList.size()).isEqualTo(2);
        assertThat(bookList.get(0).getTitle()).isEqualTo("Titre1");
        assertThat(bookList.get(0).getPrice()).isEqualTo(10);
	}

}
