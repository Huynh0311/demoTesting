package com.demotesting;

import com.demotesting.Repository.IUserRepo;
import com.demotesting.model.User;
import com.demotesting.service.UserService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class UserTest {
    @Mock
    private IUserRepo iUserRepo;
    @InjectMocks
    private UserService userService;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void creatUserTest(){
        User user = new User();
        user.setUsername("thuc");
        user.setEmail("thuc2t@gmail.com");

        when(iUserRepo.save(user)).thenReturn(user);
        User savedUser = userService.createUser(user);

        verify(iUserRepo).save(user);
    }

    @Test
    public void findById(){
        Long userId = 1L;
        User mockUser = new User();
        mockUser.setId(userId);
        mockUser.setUsername("testUser");
        mockUser.setEmail("test@example.com");

        // Define behavior for userRepositoryMock.findById()
        when(iUserRepo.findById(userId)).thenReturn(Optional.of(mockUser));

        // Call userService.getUserById() with the mocked user ID
        User foundUser = userService.getUserById(userId);

        // Perform assertions
        assertEquals(mockUser.getId(), foundUser.getId());
        assertEquals(mockUser.getUsername(), foundUser.getUsername());
        assertEquals(mockUser.getEmail(), foundUser.getEmail());
    }
}
