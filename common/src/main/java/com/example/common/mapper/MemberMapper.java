package com.example.common.mapper;

import com.example.common.vo.MemberVO;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface MemberMapper {

    @Insert("  INSERT INTO USER\n" +
            "        (\n" +
            "            USER_ID,\n" +
            "            USER_PW,\n" +
            "            USER_NAME,\n" +
            "            ROLE_NO\n" +
            "        )\n" +
            "        VALUES\n" +
            "        (\n" +
            "         #{userId},\n" +
            "         #{userPw},\n" +
            "         #{userName},\n" +
            "         #{roleNo}\n" +
            "        )")
    public int joinMember(MemberVO memberVO);
}
