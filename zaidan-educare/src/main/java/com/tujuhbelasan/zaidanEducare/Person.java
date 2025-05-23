package com.tujuhbelasan.zaidanEducare;

import java.util.ArrayList;
import java.util.List;

public class Person {
    private int location = 0;
    private static final int HEARING_DISTANCE = 15; // Maksimal jarak mendengar
    private List<String> messagesHeard = new ArrayList<>();

    public void moveTo(int distance) {
        this.location = distance;
    }

    public void shout(String message, List<Person> listeners) {
        for (Person listener : listeners) {
            int distance = Math.abs(this.location - listener.location);
            if (distance <= HEARING_DISTANCE) {
                listener.hear(message);
            }
        }
    }

    private void hear(String message) {
        messagesHeard.add(message);
    }

    public List<String> getMessagesHeard() {
        return messagesHeard;
    }
}