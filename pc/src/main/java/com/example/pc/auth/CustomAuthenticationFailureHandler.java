package com.example.pc.auth;

import com.example.pc.mapper.LoginMapper;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.InsufficientAuthenticationException;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.SimpleUrlAuthenticationFailureHandler;
import org.springframework.stereotype.Component;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Component
public class CustomAuthenticationFailureHandler extends SimpleUrlAuthenticationFailureHandler {

    private LoginMapper loginMapper;

    public CustomAuthenticationFailureHandler(LoginMapper loginMapper){
        this.loginMapper = loginMapper;
    }

    @Override
    public void onAuthenticationFailure(HttpServletRequest request, HttpServletResponse response, AuthenticationException exception) throws IOException, ServletException {

        String msg = "";
        if(exception instanceof BadCredentialsException){
           int result = failLogin(request.getParameter("userId"));

            if(result >= 5){
                msg = "로그인 5회 이상 실패로 계정이 잠금상태입니다.";
            }else {
                msg = "비밀번호 혹은 아이디가 틀립니다." + result + "회 틀렸습니다.";
            }
        }


        setDefaultFailureUrl("/login?error=true&exception="+msg);

        request.setAttribute("test",msg);
        RequestDispatcher dispatcher = request.getRequestDispatcher("/login");
        dispatcher.forward(request, response);
    }

    protected int failLogin(String userId){

         int update = loginMapper.failCnt(userId);

         int result = update > 0 ? loginMapper.selectFailCnt(userId) : -1;

         return result;
    }
}