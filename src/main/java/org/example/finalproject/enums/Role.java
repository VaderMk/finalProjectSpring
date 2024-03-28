package org.example.finalproject.enums;

public enum Role {
    USER(5), ADMIN(6);
    private int value;
    Role(int value) {
        this.value = value;
    }
}
