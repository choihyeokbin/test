package com.example.common.service;

import com.example.common.mapper.MemberMapper;
import com.example.common.vo.MemberVO;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class MemberService {
    private MemberMapper memberMapper;

    public MemberService(MemberMapper memberMapper){
        this.memberMapper = memberMapper;
    }

    public int joinMember1(MemberVO memberVO){
        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        memberVO.setUserPw(passwordEncoder.encode(memberVO.getUserPw()));


        return memberMapper.joinMember(memberVO);
    }
}
