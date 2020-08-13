package com.liuxin.test01;

import com.liuxin.domain.User;
import com.liuxin.mapper.IRoleMapper;
import com.liuxin.mapper.IUserMapper;
import com.liuxin.vo.RoleVo;
import com.liuxin.vo.UserVo;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

public class test {
    InputStream in = null;
    SqlSession sqlSession =null;
    IUserMapper mapper01=null;
    IRoleMapper mapper02 =null;

    @Before
    public void init() throws IOException {
//        1、读取mybatis的配置文件
        in = Resources.getResourceAsStream("mybatis.xml");
//        2、创建sqlsessionFactory对象         工厂模式
        SqlSessionFactoryBuilder factory = new SqlSessionFactoryBuilder();
        SqlSessionFactory build = factory.build(in);
//        3、创建sqlsession对象
        sqlSession = build.openSession();
//        4、创建IUserMapper的代理对象          代理模式
        mapper01 = sqlSession.getMapper(IUserMapper.class);
        mapper02 = sqlSession.getMapper(IRoleMapper.class);
    }


    @Test
    public void test01(){
        List<User> all = mapper01.findAll();
        for (User user : all) {
            System.out.println(user);
        }
    }

    @Test
    public void test02(){
        User user = new User();
        user.setUsername("孙");
        List<User> userlist = mapper01.findUserByCondition(user);
        for (User user1 : userlist) {
            System.out.println(user1);
        }
    }

    @Test
    /**
     * 查询用户及其对应的账户信息
     */
    public void text03(){
        List<UserVo> allList = mapper01.findAllUserAndAccount();
        for (UserVo userVo : allList) {
            System.out.println(userVo);
        }
    }

    @Test
    public void test04(){
        UserVo uer = mapper01.findUserByUid(3);
        System.out.println(uer);
    }

    /**
     * 查询用户和角色信息
     */
    @Test
    public void test05(){
        List<UserVo> allUserRole = mapper01.findUserAndRole();
        System.out.println(allUserRole);
    }

    /**
     * 查询所有的角色信息及其对应的用户信息
     */
    @Test
    public void test06(){
        List<RoleVo> roleAndUser = mapper02.findRoleAndUser();
        for (RoleVo roleVo : roleAndUser) {
            System.out.println(roleVo);
        }
    }

















    @After
    public void destory() throws IOException {
        //        6、关闭资源
        sqlSession.close();
        in.close();
    }
}
