package cn.springmvc.controller;

import cn.springmvc.model.User;
import cn.springmvc.service.UserService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * Created by cmc on 14-12-9.
 */
@RestController
public class UserController {

    @Resource
    private UserService userService;

    @RequestMapping(value="/user/add")
    public Object addUser(User user){
        System.out.println("user:"+user);
        userService.add(user);
        return "success";

    }

    @RequestMapping(value="/numberException")
    public void testNumberFormatException(User user) {
        //这里就会发生NumberFormatException，然后就会返回定义在SpringMVC配置文件中的number视图
        Integer.parseInt("abc");
    }


}
