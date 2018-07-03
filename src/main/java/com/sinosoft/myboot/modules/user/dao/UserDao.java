/**
 * Copyright 2018 SinoSoft. All Rights Reserved.
 */
package com.sinosoft.myboot.modules.user.dao;

import javax.persistence.Table;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import com.sinosoft.myboot.modules.user.model.User;

/**
 * <B>系统名称：</B><BR>
 * <B>模块名称：</B><BR>
 * <B>中文类名：</B><BR>
 * <B>概要说明：</B><BR>
 * 
 * @author 中科软科技 lihaiyi
 * @since 2018年6月22日
 */
@Repository
@Table(name = "sb_user")
@Qualifier("userDao")
public interface UserDao extends JpaRepository<User, Long>, JpaSpecificationExecutor<User> {

    //    @Query("from User  where id=?")
    //    public User findUserByName(@Param("userId") Long userId);

    //    @Query("from User where userName like : userName")
    //    public Page<User> page(Pageable pageable, @Param("userName") String userName);

    //    @Modifying  自己写必须加 这个注解
    //    @Query("update User a set a.status = ?1  where a.id in ?2")
    //    int updateAppWordRankStatus(Integer status,List<Long> id);

}
