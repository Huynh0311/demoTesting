package com.demotesting.Repository;

import com.demotesting.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IUserRepo extends JpaRepository<User, Long> {

}
