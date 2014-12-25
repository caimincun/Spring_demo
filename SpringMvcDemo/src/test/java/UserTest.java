import cn.springmvc.model.User;
import cn.springmvc.service.UserService;
import org.activiti.engine.ProcessEngine;
import org.activiti.engine.RepositoryService;
import org.activiti.engine.repository.Deployment;


import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.io.InputStream;
import java.util.List;


/**
 * Created by cmc on 14-12-9.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:applicationContext.xml"})
public class UserTest {

//    private static Log logger = LogFactory.getLog(UserTest.class.getClass());
static Logger logger = LogManager.getLogger(LogManager.ROOT_LOGGER_NAME);
//static Logger logger = LogManager.getLogger(UserTest.class.getClass());// 似乎是传递的类的名称有问题

    @Test
    public void testLog(){

        User user=new User();
        user.setId(4);
        user.setName("cmc");
        user.setPassword("123456");

        //  记录 debug 级别的信息

        logger.debug("This log message leavel.debug:"+user);

        //  记录 info 级别的信息

        logger.info("This log message leavel.info:"+user);

        //  记录 error 级别的信息

        logger.error("This log message leavel.error:"+user);

        userService.add(user);

    }


    @Autowired
    private UserService userService;

    @Autowired
    private ProcessEngine processEngine;

    @Autowired
    private RepositoryService repositoryService;

    /**
     * 简单的springmvc mybatis junit 插入测试
     */
    @Test
    public void addUser(){
        try {
            User user=new User();
            user.setId(2);
            user.setName("cmc");
            user.setPassword("123456");
            userService.add(user);
        }catch (Exception e){
            System.out.println(e);
        }
        System.out.println("测试成功");

    }

    /**
     * 一对一的级联测试
     */
    @Test
    public void testUser(){
        List<User> users=userService.findAll();
        for(User user:users){
            System.out.println(user);
        }

    }

    /**
     * 测试 activiti 的注入
     */
    @Test
    public void testActiviti(){

        // 添加资源发布文件
        InputStream inBpmn=this.getClass().getResourceAsStream("MyProcess.bpmn");  // 文件路劲下去寻找资源 ,需要设置bulid Path默认只读取.java文件
        InputStream inPng=this.getClass().getResourceAsStream("MyProcess.png");
        Deployment deployment; // 完成部署
        deployment = (Deployment) repositoryService.createDeployment() // 创建部署对象
                .name("部署") // 添加部署名称
                .addInputStream("MyProcess.bpmn", inBpmn)
                .addInputStream("MyProcess.png", inPng)
                .deploy();
        System.out.println("部署ID:"+deployment.getId());
        System.out.println("部署名称:" + deployment.getName());
    }

    @Test
    public void testNumberFormatException() {
        //这里就会发生NumberFormatException，然后就会返回定义在SpringMVC配置文件中的number视图
        Integer.parseInt("abc");
    }
}
