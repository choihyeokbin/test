package com.example.pc.mapper;

import com.example.pc.auth.AuthUser;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface LoginMapper {

     AuthUser selectUser(String userName);

     void successCnt(String userName);

     int failCnt(String userId);

     int selectFailCnt(String userId);
}
