package com.android.sdk13.frame_test.EventBus.Event;

public class MessageEvent {
    String name;

    public MessageEvent(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
