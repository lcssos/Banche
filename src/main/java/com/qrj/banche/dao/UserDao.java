package com.qrj.banche.dao;


import com.qrj.banche.model.User;

import java.util.List;

public interface UserDao {
    public List<User> findByUsernameAndPasswork(String user_name, String user_password);
}
