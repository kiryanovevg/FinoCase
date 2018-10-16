package com.kiryanov.finocase.data;

public class MockData {

    public static boolean getUser(String login, int passwordHash) {
        return login.equals("1") && passwordHash == "1".hashCode();
    }
}
