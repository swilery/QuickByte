package com.revature.overknight;

import com.revature.overknight.beans.User;
import com.revature.overknight.dao.UserDaoImpl;

public class MainClassTest {
    public static void main(String[] args){
        UserDaoImpl dao = new UserDaoImpl();
        dao.insertUser(new User(1,
                "username",
                "password",
                2,
                "fName",
                "lName",
                "email",
                4564564562L,
                1234432112344321L,
                "profileImgKey"));
        dao.insertUser(new User(2,
                "usernombre",
                "password",
                2,
                "fName",
                "lName",
                "email",
                4564564562L,
                1234432112344321L,
                "profileImgKey"));
        dao.insertUser(new User(3,
                "userNAMEname",
                "password",
                2,
                "fName",
                "lName",
                "email",
                4564564562L,
                1234432112344321L,
                "profileImgKey"));
        dao.insertUser(new User(4,
                "Bobbertha",
                "password",
                2,
                "fName",
                "lName",
                "email",
                4564564562L,
                1234432112344321L,
                "profileImgKey"));
    }
}
