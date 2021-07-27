package com.example.common.vo;

import lombok.Data;
import org.apache.ibatis.type.Alias;

@Data
@Alias("MemberVO")
public class MemberVO {

    private String userId;
    private String userPw;
    private String userName;
    private String roleNo;

}
