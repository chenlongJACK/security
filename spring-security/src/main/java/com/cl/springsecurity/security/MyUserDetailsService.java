package com.cl.springsecurity.security;

import com.cl.springsecurity.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Description
 * @auther chenlong
 * @date 2021/6/1510:31
 */
@Service
public class MyUserDetailsService implements UserDetailsService {
    @Autowired
    private PasswordEncoder passwordEncoder;
    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        //模拟数据库查询
        User user = this.findByUserName(s);
        if(user!=null){
            MyUserDetails myUserDetails = new MyUserDetails(user);
            List<SimpleGrantedAuthority> roles=new ArrayList<>();
            roles.add(new SimpleGrantedAuthority("ROLE_ADMIN"));
            myUserDetails.setAuthorities(roles);
            return myUserDetails;
        }
        return null;
    }

    private User findByUserName(String userName){
        Map<String,User> map=new HashMap<>();
        map.put("jack",new User("jack",passwordEncoder.encode("123456")));
        map.put("mark",new User("mark","123456"));
        if(map.containsKey(userName)){
            return map.get(userName);
        }else{
            return null;
        }
    }
}
