package com.sudheer.Styleflex.ProductRepo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.sudheer.Styleflex.Model.Cart;
import com.sudheer.Styleflex.Model.User;

@Repository
public interface CartRepository extends JpaRepository<Cart, Long>{
    List<Cart> findByUser(User user);

}
