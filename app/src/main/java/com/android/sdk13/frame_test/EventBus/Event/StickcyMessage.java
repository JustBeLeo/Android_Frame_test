package com.android.sdk13.frame_test.EventBus.Event;

public class StickcyMessage {
    String name;
    int password;

    public StickcyMessage(String name, int password) {
        this.name = name;
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPassword() {
        return password;
    }

    public void setPassword(int password) {
        this.password = password;
    }
}
