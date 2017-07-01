package com.herokuapp.issue_quest.app;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

/**
 * アプリケーションのコントローラのテスト
 * 
 * @author k4h4shi
 *
 */
@RunWith(SpringRunner.class)
@WebMvcTest(
    // 単体テストではSpringSecurityを無効化するため、secure = falseとする
    secure = false, controllers = {AppController.class})
public class AppControllerTest {

  @Autowired
  MockMvc mockMvc;

  @Test
  public void アプリケーションコントローラはトップ画面を返す() throws Exception {
    mockMvc.perform(get("/")).andExpect(status().isOk())
        .andExpect(content().contentTypeCompatibleWith(MediaType.TEXT_HTML))
        .andExpect(view().name("page/index"));
  }
}
