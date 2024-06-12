package com.example.messenger;

import java.util.Random;

public class ListElement {
    private String names;
    private String message;
    private String timeOrDay;
    private final int imageResource;
    private boolean isActive;
    private boolean isViewMessage;
    private final Random random;




    public ListElement(String names, String message, String timeOrDay, int imageResource) {
        this.names = names;
        this.message = message;
        this.timeOrDay = timeOrDay;
        this.imageResource = imageResource;
        this.random = new Random();
        this.isActive = generateRandomActiveState();
        this.isViewMessage = generateRandomViewMessage();
    }

    private boolean generateRandomActiveState() {
        return random.nextBoolean();
    }

    private boolean generateRandomViewMessage() {
        return random.nextBoolean();
    }

    public String getNames() {
        return names;
    }

    public void setNames(String names) {
        this.names = names;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getTimeOrDay() {
        return timeOrDay;
    }

    public void setTimeOrDay(String timeOrDay) {
        this.timeOrDay = timeOrDay;
    }

    public int getImageResource() {
        return imageResource;
    }

    public boolean isActive() {
        return isActive;
    }

    public boolean isViewMessage() {
        return isViewMessage;
    }

    public void setActive(boolean active) {
        isActive = active;
    }

    public void setViewMessage(boolean viewMessage) {
        isViewMessage = viewMessage;
    }
}


