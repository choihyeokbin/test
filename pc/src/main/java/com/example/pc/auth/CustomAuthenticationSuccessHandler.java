package com.example.pc.auth;

import com.example.pc.mapper.LoginMapper;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.SimpleUrlAuthenticationSuccessHandler;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Component
public class CustomAuthenticationSuccessHandler extends SimpleUrlAuthenticationSuccessHandler {

    private LoginMapper loginMapper;

    public CustomAuthenticationSuccessHandler(LoginMapper loginMapper){
        this.loginMapper = loginMapper;
    }

    @Override
    public void onAuthenticationSuccess(HttpServletRequest req, HttpServletResponse httpServletResponse, Authentication authentication) throws IOException, ServletException {
        loginMapper.successCnt(req.getParameter("userId"));

        super.onAuthenticationSuccess(req, httpServletResponse, authentication);
    }

    protected int getFailCnt(String userId){
        int result = 0;


        return result;
    }
}
