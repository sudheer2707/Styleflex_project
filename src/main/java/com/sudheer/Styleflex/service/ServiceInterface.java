package com.sudheer.Styleflex.service;

import com.sudheer.Styleflex.Model.User;

public interface ServiceInterface {

    User registerUser(User user);
    User loginUser(String email, String password);
}
