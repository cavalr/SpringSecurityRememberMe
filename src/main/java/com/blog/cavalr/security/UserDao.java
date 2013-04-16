package com.blog.cavalr.security;

import org.hibernate.Criteria;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

@Repository
@Transactional(readOnly = false)
public class UserDao {

    @Resource
    private SessionFactory sessionFactory;

    public UserFromDB findByUserName(String userName) {
        Criteria criteria = sessionFactory.getCurrentSession().createCriteria(UserFromDB.class);
        criteria.add(Restrictions.eq("userName", userName));
        return (UserFromDB) criteria.uniqueResult();
    }


    @Transactional(readOnly = false)
    public void saveOrUpdate(UserFromDB userFromDB) {
        sessionFactory.getCurrentSession().saveOrUpdate(userFromDB);
    }
}
