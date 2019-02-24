package com.learn.example.zookeeperweb.controller;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class ZookeeperControllerTest {

    @Autowired
    private MockMvc mvc;

    @Test
    public void add() throws Exception {
        mvc.perform(MockMvcRequestBuilders.post("/zk/add"))
                .andExpect(MockMvcResultMatchers.status().isOk()) // 期待返回状态吗码200
                // JsonPath expression  https://github.com/jayway/JsonPath
                //.andExpect(jsonPath("$[1].name").exists()) // 这里是期待返回值是数组，并且第二个值的 name 存在，所以这里测试是失败的
                .andDo(MockMvcResultHandlers.print()); // 打印返回的 http response 信息
    }

    @Test
    public void update() throws Exception {
        mvc.perform(MockMvcRequestBuilders.post("/zk/update"))
                .andExpect(MockMvcResultMatchers.status().isOk()) // 期待返回状态吗码200
                .andDo(MockMvcResultHandlers.print()); // 打印返回的 http response 信息
    }

    @Test
    public void delete() throws Exception {
        mvc.perform(MockMvcRequestBuilders.post("/zk/delete"))
                .andExpect(MockMvcResultMatchers.status().isOk()) // 期待返回状态吗码200
                .andDo(MockMvcResultHandlers.print()); // 打印返回的 http response 信息
    }

    @Test
    public void query() throws Exception {
        mvc.perform(MockMvcRequestBuilders.post("/zk/query"))
                .andExpect(MockMvcResultMatchers.status().isOk()) // 期待返回状态吗码200
                .andDo(MockMvcResultHandlers.print()); // 打印返回的 http response 信息
    }

    @Test
    public void nodeList() throws Exception {
        mvc.perform(MockMvcRequestBuilders.post("/zk/nodeList"))
                .andExpect(MockMvcResultMatchers.status().isOk()) // 期待返回状态吗码200
                .andDo(MockMvcResultHandlers.print()); // 打印返回的 http response 信息
    }
}