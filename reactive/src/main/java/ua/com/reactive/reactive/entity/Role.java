package ua.com.reactive.reactive.entity;

public enum Role {
    ROLE_USER, ROLE_ADMIN;

    public String getName() {
        return name(); // Повертає назву enum, наприклад, "ROLE_USER"
    }
}
