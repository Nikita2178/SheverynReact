package ua.com.reactive.reactive.entity;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.List;

@Data
@NoArgsConstructor
@Table(name = "users")
public class User implements UserDetails {
    @Id
    private Long id;
    private String username;
    private String password;
    private Role role; // Поле для ролі

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        if (role != null) {
            return List.of(new SimpleGrantedAuthority(role.getName()));
        }
        return List.of(); // Повертає порожній список, якщо роль не задана
    }

    @Override
    public String getPassword() {
        return password; // Повертає пароль
    }

    @Override
    public String getUsername() {
        return username; // Повертає ім'я користувача
    }

    @Override
    public boolean isAccountNonExpired() {
        return true; // Повертає true, якщо обліковий запис не прострочений
    }

    @Override
    public boolean isAccountNonLocked() {
        return true; // Повертає true, якщо обліковий запис не заблокований
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true; // Повертає true, якщо облікові дані не прострочені
    }

    @Override
    public boolean isEnabled() {
        return true; // Повертає true, якщо обліковий запис активний
    }
}
