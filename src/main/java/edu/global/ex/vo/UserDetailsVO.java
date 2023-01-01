package edu.global.ex.vo;

import edu.global.ex.vo.AuthVO;
import edu.global.ex.vo.UserVO;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class UserDetailsVO implements UserDetails {

    private String username;
    private String password;
    private List<GrantedAuthority> authorities;

    public UserDetailsVO(UserVO user) {

        this.setAuthorities(user);
        this.setPassword(user.getPassword());
        this.setUseranme(user.getUsername());

    }

    private void setUseranme(String username) {

        this.username = username;
    }

    private void setPassword(String password) {

        this.password = password;
    }

    private void setAuthorities(UserVO userVO) {

        List<GrantedAuthority> authorities = new ArrayList<GrantedAuthority>();

        for (AuthVO auth : userVO.getAuthList()) {
            authorities.add(new SimpleGrantedAuthority(auth.getAuthority()));
        }
        this.authorities = authorities;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return authorities;
    }

    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public String getUsername() {
        return username;
    }


    @Override
    // 계정이 만료 되지 않았는가?
    public boolean isAccountNonExpired() {
        return true;
    }


    @Override
    // 계정이 잠기지 않았는가?
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    // 패스워드가 만료되지 않았는가?
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    // 계정이 활성화 되었는가?
    public boolean isEnabled() {
        return true;
    }
}
