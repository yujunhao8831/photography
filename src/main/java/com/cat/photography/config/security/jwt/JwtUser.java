package com.cat.photography.config.security.jwt;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;
import lombok.experimental.Accessors;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;

import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.Collection;

/**
 * jwt对象
 *
 * @author pijingzhanji
 */
@Getter
@Setter
@ToString
@Accessors( chain = true )
@AllArgsConstructor
@NoArgsConstructor
public class JwtUser implements BasicJwtUser {

    private Long          id;
    private String        username;
    private String        password;
    private String        nickName;
    private String        realName;
    private String        email;
    private String        phone;
    private LocalDateTime lastPasswordResetDate;
    private LocalDateTime createTime;
    private LocalDateTime updateTime;
    private String        remark;
    private boolean       enabled;

    @Override
    public String getUsername() {
        return this.username;
    }

    @Override
    public boolean isEnabled() {
        return this.enabled;
    }

    @JsonIgnore
    @Override
    public Collection< ? extends GrantedAuthority > getAuthorities() {
        return Arrays.asList(new SimpleGrantedAuthority("ROLE_USER") , new SimpleGrantedAuthority("ROLE_ADMIN"));
    }

    @Override
    public String getPassword() {
        return this.password;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }


}
