package com.javanorth.spring.springbootshiro;

import com.javanorth.spring.springbootshiro.dao.UserRoleDao;
import com.javanorth.spring.springbootshiro.entity.Role;
import com.javanorth.spring.springbootshiro.handler.InitExecutorHandler;
import com.javanorth.spring.springbootshiro.senum.AdminType;
import com.javanorth.spring.springbootshiro.util.LogUtil;
import com.javanorth.spring.springbootshiro.util.SpringUtils;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.util.StringUtils;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@SpringBootTest
class SpringbootShiroApplicationTests {

    @Test
    void contextLoads() {
    }

    @Autowired
    UserRoleDao userRoleDao;

    @Test
    public void initRoleDatabase() {
        List<Role> roles = new ArrayList<>();
        AdminType[] adminTypes = AdminType.values();
        LogUtil.info(InitExecutorHandler.class, "all roles: {}");
        for (AdminType adminType : adminTypes) {
            roles.add(new Role(adminType.getId(), adminType.getType()));
        }
        LogUtil.info(InitExecutorHandler.class, "all roles: {}", roles);
        userRoleDao.insertAllUserRole(roles);
    }





























    @Test
    void test2() {
        String name = null;
        System.out.println(StringUtils.isEmpty(name));
    }

}
