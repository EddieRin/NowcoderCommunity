package com.nowcoder.community;

import com.nowcoder.community.dao.DiscussPostMapper;
import com.nowcoder.community.dao.UserMapper;
import com.nowcoder.community.entity.DiscussPost;
import com.nowcoder.community.entity.User;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@SpringBootTest
@Slf4j
class CommunityApplicationTests {
    @Autowired
    private UserMapper userMapper;

    @Autowired
    private DiscussPostMapper discussPostMapper;

    @Test
    void contextLoads() {
        User user = userMapper.selectById(101);
        System.out.println(user);

        user = userMapper.selectByEmail("nowcoder101@sina.com");
        System.out.println(user);

        user = userMapper.selectByName("liubei");
        System.out.println(user);
    }

    @Test
    public void insertTest() {
        User user = new User();
        user.setUsername("test");
        user.setPassword("123456");
        user.setSalt("abcde");
        user.setEmail("xxx@qq.com");
        user.setType(1);
        user.setStatus(1);
        user.setHeaderUrl("http://images.nowcoder.com/head/100t.png");
        user.setCreateTime(new Date());

        int row = userMapper.insertUser(user);
        System.out.println(row);
    }

    @Test
    public void DiscussPostTest() {
        List<DiscussPost> list = new ArrayList<>();
        int rows = discussPostMapper.selectDiscussPostRows(149);
        System.out.println(rows);
        list = discussPostMapper.selectDiscussPosts(149, 0, 20);
        System.out.println(list);
    }

    @Test
    public void LoggerLevelTest() {
        log.info("info");
        log.debug("debug");
        log.warn("warn");
        log.error("error");
    }
}
