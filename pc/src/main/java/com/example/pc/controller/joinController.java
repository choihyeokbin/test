package com.example.pc.controller;

import com.example.common.service.MemberService;
import com.example.common.vo.MemberVO;
import com.example.pc.auth.AuthUser;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/join")
public class joinController {

    MemberService memberService;

    public joinController(MemberService memberService){
        this.memberService = memberService;
    }

    @RequestMapping("/")
    public String joinView(){
        return "join/view";
    }

    @RequestMapping("/proc")
    public String joinProc(MemberVO memberVO){
        try {
            memberService.joinMember1(memberVO);
        }catch (Exception e){
            System.out.println(e);
        }
        return "redirect:/";
    }
}
