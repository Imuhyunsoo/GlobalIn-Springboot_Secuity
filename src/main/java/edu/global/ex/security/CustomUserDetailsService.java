package edu.global.ex.security;

import edu.global.ex.mapper.UserMapper;
import edu.global.ex.vo.UserDetailsVO;
import edu.global.ex.vo.UserVO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class CustomUserDetailsService implements UserDetailsService {

    @Autowired
    private UserMapper userMapper;

    @Override
    // UserDetails 리턴할 것을 커스터마이징 (개발자가 해야함)
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        log.warn("Load User By UserVO number : " + username);
        UserVO vo = userMapper.getUser(username);

        log.warn("queried User By UserVO number : " + vo);
        return vo == null ? null : new UserDetailsVO(vo);
    }
}
