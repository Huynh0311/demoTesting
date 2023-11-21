package com.demotesting.service;

import com.demotesting.Repository.IUserRepo;
import com.demotesting.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    private IUserRepo iUserRepo;

    public User createUser(User user) {
        return iUserRepo.save(user);
    }

    public User getUserById(Long id) {
        return iUserRepo.findById(id).get();
    }

    public void deleteUser(Long id) {
        iUserRepo.deleteById(id);
    }


}
