package com.yang.generator.mapper;

import com.yang.generator.pojo.Order;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.Date;

public class OrderMapperTest {

    SqlSessionFactory sqlSessionFactory;

    SqlSession sqlSession;

    OrderMapper mapper;

    @Before
    public void before() throws IOException {
        String resource = "mybatis.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        sqlSession = sqlSessionFactory.openSession(true);
        mapper = sqlSession.getMapper(OrderMapper.class);
    }

    @After
    public void after() {
        if (sqlSession != null) {
            sqlSession.close();
        }
    }

    @Test
    public void deleteByPrimaryKey() {
        Integer id = 1;
        int i = mapper.deleteByPrimaryKey(id);
        System.out.println(i);
    }

    @Test
    public void insert() {
        Order order = new Order("张三", 18, new Date(), new Date());
        int insert = mapper.insert(order);
        System.out.println(insert);
    }

    @Test
    public void selectByPrimaryKey() {
    }

    @Test
    public void selectAll() {
    }

    @Test
    public void updateByPrimaryKey() {
    }
}