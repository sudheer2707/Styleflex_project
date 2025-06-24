package com.sudheer.Styleflex.ProductRepo;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.sudheer.Styleflex.Model.User;

@Repository
public interface UserRepository extends JpaRepository<User,Long> {
Optional<User> findByEmail(String email);
}
