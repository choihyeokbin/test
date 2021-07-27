package com.example.pc.auth;


import com.example.pc.mapper.LoginMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;


@Service
public class UserDetailServiceImpl implements UserDetailsService {

    private static BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();

    /*@Autowired private AuthenticationManager authenticationManager;*/

    @Autowired
    private LoginMapper loginMapper;

    @Override
    public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {

        AuthUser authUser = loginMapper.selectUser(userName);
        List<GrantedAuthority> authorities = new ArrayList<>();
        String role = "";
        if(authUser != null){
            authUser.setAuthorities(getAuthorities(userName));
            if(authUser.getRoleNo() == 1){
                role = "ROLE_ADMIN";
            }else if(authUser.getRoleNo() == 2){
                role = "ROLE_USER";
            }
            authorities.add(new SimpleGrantedAuthority(role));
        }
        return new User(authUser.getUserId(),authUser.getPassword(),authorities);
    }
    private Collection<GrantedAuthority> getAuthorities(String username)
    {
        List<String> string_authorities = new ArrayList<String>();
        string_authorities.add(username);

        List<GrantedAuthority> authorities = new ArrayList<GrantedAuthority>();
        for (String authority : string_authorities)
            authorities.add(new SimpleGrantedAuthority(authority));

        return authorities;
    }

    public BCryptPasswordEncoder getPasswordEncoder()
    {
        return passwordEncoder;
    }

    public AuthUser processLogin(String userName, String passWord, HttpSession session){
        AuthUser authUser = new AuthUser();
      /*  try{
            UsernamePasswordAuthenticationToken token = new UsernamePasswordAuthenticationToken(userName, passWord);
            Authentication authentication = authenticationManager.authenticate(token);

            SecurityContextHolder.getContext().setAuthentication(authentication);
            session.setAttribute(HttpSessionSecurityContextRepository.SPRING_SECURITY_CONTEXT_KEY, SecurityContextHolder.getContext());
            authUser = (AuthUser) loadUserByUsername(userName);
            session.setAttribute("authUser", authUser);

        }catch (Exception e){

        }*/

        return authUser;
    }

}
