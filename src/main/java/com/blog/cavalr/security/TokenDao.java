package com.blog.cavalr.security;

import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.Date;

@Repository
@Transactional (readOnly = false)
public class TokenDao {

    @Resource
    private  SessionFactory sessionFactory;

    @Transactional (readOnly = true)
    public void createNewToken(Token token) {
        sessionFactory.getCurrentSession().save(token);
    }

    @Transactional (readOnly = true)
    public void updateToken(String series, String tokenValue, Date lastUsed) {

        Token existingToken = (Token) sessionFactory.getCurrentSession().get(Token.class, series);
        existingToken.setTokenValue(tokenValue);
        existingToken.setDate(lastUsed);
        sessionFactory.getCurrentSession().merge(existingToken);
    }

    public Token getTokenForSeries(String seriesId) {
        return (Token) sessionFactory.getCurrentSession().get(Token.class, seriesId);
    }

    @Transactional (readOnly = true)
    public void removeUserTokens(final String username) {

        Token token =
                (Token) sessionFactory.getCurrentSession().createCriteria(Token.class)
                        .add(Restrictions.eq("username", username)).uniqueResult();
        if (token != null) {
            sessionFactory.getCurrentSession().delete(token);
        }
    }
}
