package fr.lauthieb.repository;

import fr.lauthieb.SpringbootApplication;
import fr.lauthieb.business.User;
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
public class UserRepositoryTest {

    @Autowired
    UserRepository userRepository;

    @Test
    public void should_get_users_by_lastName() {
        List<User> userList = userRepository.findByLastName("Bauer");
        assertThat(userList).isNotNull();
        assertThat(userList.size()).isEqualTo(2);
        assertThat(userList.get(0).getLastName()).isEqualTo("Bauer");
    }
}
