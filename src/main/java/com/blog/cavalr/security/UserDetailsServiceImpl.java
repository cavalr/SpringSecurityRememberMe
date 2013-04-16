package com.blog.cavalr.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;

@Service("userDetailsService")
public class UserDetailsServiceImpl implements UserDetailsService {

    @Autowired
    private UserDao userDao;

    @PostConstruct
    public void init() {
        userDao.saveOrUpdate(new UserFromDB("test1", "test1", "ROLE_USER"));
        userDao.saveOrUpdate(new UserFromDB("test2", "test2", "ROLE_USER,ROLE_ADMIN"));
        userDao.saveOrUpdate(new UserFromDB("test3", "test3", "ROLE_ADMIN"));
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        UserFromDB userFromDB = userDao.findByUserName(username);

        return new User(userFromDB.getUserName(), userFromDB.getPassword(),
                AuthorityUtils.commaSeparatedStringToAuthorityList(userFromDB.getRoles()));
    }

}
