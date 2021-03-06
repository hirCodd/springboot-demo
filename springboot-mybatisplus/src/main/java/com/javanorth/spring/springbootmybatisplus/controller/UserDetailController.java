package com.javanorth.spring.springbootmybatisplus.controller;

import com.javanorth.spring.springbootmybatisplus.bean.CustomIdGenerator;
import com.javanorth.spring.springbootmybatisplus.dao.UserDetailDao;
import com.javanorth.spring.springbootmybatisplus.dto.UserDetailDTO;
import com.javanorth.spring.springbootmybatisplus.entity.UserDetail;
import com.javanorth.spring.springbootmybatisplus.service.UserDetailService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user")
public class UserDetailController {

    @Autowired
    private UserDetailDao userDetailDao;

    @Autowired
    CustomIdGenerator customIdGenerator;

    @Autowired
    UserDetailService userDetailService;

    @GetMapping("/test")
    public ResponseEntity test() {
        return ResponseEntity.ok().body("success");
    }

    @RequestMapping("/userList")
    public List testList() {
        return userDetailDao.selectList(null);
    }

    @RequestMapping("/add")
    public boolean addUser(@RequestBody UserDetailDTO userDetailDTO) {
        UserDetail userDetail = new UserDetail();
        BeanUtils.copyProperties(userDetailDTO, userDetail);
        userDetail.setId(customIdGenerator.nextUUID(userDetail));
        return userDetailService.save(userDetail);
    }

    @RequestMapping("/delete")
    public boolean deleteUser(@RequestParam("id") String id) {
        System.out.println(id);
        return userDetailService.removeById(id);
    }


}
