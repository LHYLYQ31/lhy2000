/**
 * Copyright 2018 SinoSoft. All Rights Reserved.
 */
package com.sinosoft.myboot.modules.user.service;

import java.io.UnsupportedEncodingException;
import java.util.Date;
import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Path;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.sinosoft.myboot.common.util.SystemConfig;
import com.sinosoft.myboot.modules.user.dao.UserDao;
import com.sinosoft.myboot.modules.user.model.User;

import net.sf.json.JSONObject;

@Service
@Transactional
public class UserServiceImpl implements UserService {

    @Autowired
    UserDao userDao;

    /**
     * <B>方法名称：</B><BR>
     * <B>概要说明：</B><BR>
     * 
     * @see com.example.user.service.UserService#getUser(java.lang.String)
     */
    @Override
    public String getUser(String userid) {
        JSONObject json = new JSONObject();
        try {
            json.put("username", new String((SystemConfig.getProperty("name")).getBytes("iso-8859-1")));
            json.put("age", "18");
            json.put("phone", "15934239804");
        }
        catch (UnsupportedEncodingException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return json.toString();
    }

    /**
     * <B>方法名称：</B><BR>
     * <B>概要说明：</B><BR>
     * 
     * @see com.example.user.service.UserService#page(java.lang.Integer, int, int)
     */
    @Override
    public Page<User> page(User u, int page, int size) {
        Pageable pageable = new PageRequest(page, size, new Sort(Direction.ASC, "createTime"));
        Specification<User> spec = new Specification<User>() {

            @Override
            public Predicate toPredicate(Root<User> root, CriteriaQuery<?> query, CriteriaBuilder cb) {
                Path<String> name = root.get("userName");
                Predicate p1 = cb.like(name, "%" + u.getUserName() + "%");
                Predicate p = cb.and(p1);
                return p;
            }

        };

        userDao.findAll(spec);
        return userDao.findAll(spec, pageable);
    }

    /**
     * <B>方法名称：</B><BR>
     * <B>概要说明：</B><BR>
     * 
     * @see com.example.user.service.UserService#save(com.example.user.model.User)
     */
    @Override
    public User save(User u) {
        //  userDao.save(u);
        // u.setUserName(null);
        userDao.saveAndFlush(u);

        return u;
    }

    /**
     * <B>方法名称：</B><BR>
     * <B>概要说明：</B><BR>
     * 
     * @see com.example.user.service.UserService#update(com.example.user.model.User)
     */
    @Override
    public Boolean update(User u) {

        return null;
    }

    /**
     * <B>方法名称：</B><BR>
     * <B>概要说明：</B><BR>
     * 
     * @see com.example.user.service.UserService#delete(com.example.user.model.User)
     */
    @Override
    public Boolean delete(User u) {
        userDao.delete(u);
        return true;
    }

    /**
     * <B>方法名称：</B><BR>
     * <B>概要说明：</B><BR>
     * 
     * @see com.sinosoft.myboot.modules.user.service.UserService#list(com.sinosoft.myboot.modules.user.model.User)
     */
    @Override
    public List<User> list(User u) {
        Specification<User> spec = new Specification<User>() {
            @Override
            public Predicate toPredicate(Root<User> root, CriteriaQuery<?> query, CriteriaBuilder cb) {
                Path<String> userName = root.get("userName");
                Path<Date> createTime = root.get("createTime");
                Path<Long> id = root.get("id");
                cb.lessThan(createTime, new Date());
                cb.equal(id, 1L);
                Predicate p1 = cb.like(userName, "%" + u.getUserName() + "%");
                Predicate p = cb.and(p1);
                return p;
            }

        };

        return userDao.findAll(spec, new Sort(Direction.DESC, "createTime"));
    }

}
