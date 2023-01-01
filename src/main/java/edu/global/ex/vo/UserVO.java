package edu.global.ex.vo;

import lombok.*;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class UserVO {

    private String username;
    private String password;
    private int enabled;

    private List<AuthVO> authList;  // resultMap 사용하기 위한 List

}
