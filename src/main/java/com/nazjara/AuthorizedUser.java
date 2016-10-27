package com.nazjara;

public class AuthorizedUser {

    private static int id = 1;

    public static int id() {
        return id;
    }

    public static void setId(int id) {
        AuthorizedUser.id = id;
    }
}
