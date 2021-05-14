package com.example.lab7_roomdatabase_basic.database;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;

import com.example.lab7_roomdatabase_basic.User;

import java.util.List;

@Dao
public interface UserDAO {

    @Insert
    void insertUser(User user);

    @Query("SELECT * from user")
    List<User> getListUser();


}
