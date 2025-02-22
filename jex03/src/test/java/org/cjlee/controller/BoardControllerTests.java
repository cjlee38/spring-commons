package org.cjlee.controller;

import lombok.extern.log4j.Log4j;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@ContextConfiguration(classes = {
        org.cjlee.config.RootConfig.class,
        org.cjlee.config.ServletConfig.class
})
@Log4j
public class BoardControllerTests {

    @Autowired
    private WebApplicationContext ctx;

    private MockMvc mockMvc;

    @Before
    public void setup() {
        this.mockMvc = MockMvcBuilders.webAppContextSetup(ctx).build();
    }

    @Test
    public void testList() throws Exception {

        log.info(
                mockMvc.perform(MockMvcRequestBuilders.get("/board/list"))
                        .andReturn()
                        .getModelAndView()
                        .getModelMap()
        );

    }

    @Test
    public void testRegister() throws Exception {
        String result = mockMvc.perform(MockMvcRequestBuilders.post("/board/register")
                .param("title", "테스트 타이틀")
                .param("content", "테스트 내용")
                .param("writer", "테스트 작성자")
        ).andReturn().getModelAndView().getViewName();

        log.info(result);
    }

    @Test
    public void testGet() throws Exception {

        log.info(mockMvc.perform(MockMvcRequestBuilders.get("/board/get")
                .param("bno", "5"))
                .andReturn()
                .getModelAndView()
                .getModelMap());
    }

    @Test
    public void testModify() throws Exception {
        String result = mockMvc
                .perform(MockMvcRequestBuilders.post("/board/modify")
                        .param("bno", "5")
                        .param("title", "테스트에서 수정된 제목")
                        .param("content", "테스트에서 수정된 내용")
                        .param("writer", "writer in test")
                        .param("regDate", "2020-01-01")
                        .param("updateDate", "2020-01-01")
                ).andReturn().getModelAndView().getViewName();

        log.info(result);

    }

    @Test
    public void testListPaging() throws Exception {
        log.info(mockMvc.perform(MockMvcRequestBuilders.get("/board/list")
                .param("pageNum", "2")
                .param("amount", "50"))
                .andReturn().getModelAndView().getModelMap());
    }

    @Test
    public void testRemove() throws Exception {
        String result = mockMvc.perform(MockMvcRequestBuilders.post("/board/remove")
                .param("bno", "6"))
                .andReturn()
                .getModelAndView()
                .getViewName();

        log.info(result);
    }

}
