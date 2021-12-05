package com.yang.generator.mapper;

import com.github.pagehelper.PageHelper;
import com.yang.generator.pojo.User;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

public class UserMapperTest {

    Logger logger = LoggerFactory.getLogger(UserMapperTest.class);

    SqlSessionFactory sqlSessionFactory;

    SqlSession sqlSession;

    UserMapper mapper;

    @Before
    public void before() throws IOException {
        String resource = "mybatis.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        sqlSession = sqlSessionFactory.openSession(true);
        mapper = sqlSession.getMapper(UserMapper.class);
    }

    @After
    public void after() {
        if (sqlSession != null) {
            sqlSession.close();
        }
    }

    @Test
    public void selectAll() {

        //设置分页数据
        PageHelper.startPage(2, 3);

        List<User> users = mapper.selectAll();
        System.out.println(users);
    }

    @Test
    public void deleteByPrimaryKey() {
    }

    @Test
    public void insert() {
    }

    @Test
    public void selectByPrimaryKey() {
    }


    @Test
    public void updateByPrimaryKey() {
    }
}