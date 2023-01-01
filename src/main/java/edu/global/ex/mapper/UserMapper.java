package edu.global.ex.mapper;

import edu.global.ex.vo.UserVO;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface UserMapper {

    UserVO getUser(String name);

    @Insert("insert into users(username,password,enabled) values(#{username},#{password},#{enabled})")
    public int insertUser(UserVO userVO);

    @Insert("insert into AUTHORITIES (username,AUTHORITY) values(#{username},'ROLE_USER')")
    public void insertAuthorities(UserVO UserVO);

}
