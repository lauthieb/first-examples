package fr.lauthieb.service;

import fr.lauthieb.business.User;
import fr.lauthieb.repository.UserRepository;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(MockitoJUnitRunner.class)
public class UserServiceTest {

    @InjectMocks
    UserService userService;

    @Mock
    UserRepository userRepository;

    List<User> userList;

    private Iterable<User> userIterable;

    @Before
    public void init() {
        userList = new ArrayList<>();
        userList.add(new User("Laurent", "Thiebault"));

        userIterable = new Iterable<User>() {
            @Override
            public Iterator<User> iterator() {
                return userList.iterator();
            }
        };
    }

    @Test
    public void should_get_books() {
        Mockito.when(userRepository.findAll()).thenReturn(userIterable);

        Iterable<User> res = userService.getUsers();
        assertThat(res).isNotNull();
    }
}
