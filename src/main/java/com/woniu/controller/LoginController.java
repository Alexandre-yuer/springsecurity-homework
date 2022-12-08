package com.woniu.controller;

import org.springframework.security.access.annotation.Secured;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LoginController {

    @RequestMapping("son")
    public String login(){
        return "我的好大儿";
    }

    @RequestMapping("insert")
    @PreAuthorize("hasAuthority('insert')")
    public String addUserInfo(){
        return "insert";
    }

    @RequestMapping("update")
    @PreAuthorize("hasAuthority('update')")
    public String updateUserInfo(){
        return "update";
    }

    @RequestMapping("delete")
    @PreAuthorize("hasAuthority('delete')")
    public String delete(){
        return "delete";
    }

    @RequestMapping("select")
    @PreAuthorize("hasAuthority('select')")
    public String select(){
        return "select";
    }
}
