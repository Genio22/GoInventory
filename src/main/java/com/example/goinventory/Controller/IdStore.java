package com.example.goinventory.Controller;

public class IdStore {
    private static int loginId;

   public static void setloginId(int userId) {
        loginId = userId;
    }

    public static int getloginId() {
        return loginId;
    }
}
