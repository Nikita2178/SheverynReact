package ua.com.reactive.reactive.controller;

public class UserDto {
    private String firstName; // Ім'я
    private String lastName; // Прізвище
    private String username; // Логін
    private String password; // Пароль
    private String phone; // Телефон

    // Геттер для firstName
    public String getFirstName() {
        return firstName;
    }

    // Сеттер для firstName
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    // Геттер для lastName
    public String getLastName() {
        return lastName;
    }

    // Сеттер для lastName
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    // Геттер для username
    public String getUsername() {
        return username;
    }

    // Сеттер для username
    public void setUsername(String username) {
        this.username = username;
    }

    // Геттер для password
    public String getPassword() {
        return password;
    }

    // Сеттер для password
    public void setPassword(String password) {
        this.password = password;
    }

    // Геттер для phone
    public String getPhone() {
        return phone;
    }

    // Сеттер для phone
    public void setPhone(String phone) {
        this.phone = phone;
    }
}
