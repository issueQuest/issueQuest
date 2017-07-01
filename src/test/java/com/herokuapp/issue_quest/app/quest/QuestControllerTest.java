package com.herokuapp.issue_quest.app.quest;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.model;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;

import com.herokuapp.issue_quest.domain.model.Quest;
import com.herokuapp.issue_quest.domain.service.QuestService;
import java.util.ArrayList;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

/**
 * クエストのコントローラのテスト
 * 
 * @author k4h4shi
 *
 */
@RunWith(SpringRunner.class)
@WebMvcTest(
    // 単体テストではSpringSecurityを無効化するため、secure = falseとする
    secure = false, controllers = {QuestController.class})
public class QuestControllerTest {

  @Autowired
  MockMvc mockMvc;

  @MockBean
  QuestService questService;

  @Test
  public void questsをGETした場合にクエスト一覧を返す() throws Exception {
    mockMvc.perform(get("/quests/")).andExpect(status().isOk())
        .andExpect(content().contentTypeCompatibleWith(MediaType.TEXT_HTML))
        .andExpect(model().attribute("allQuests", new ArrayList<Quest>()))
        .andExpect(model().attribute("questForm", new QuestForm()))
        .andExpect(view().name("quest/questList"));
  }

  @Test
  public void questsにPOSTした場合にクエストを作成してクエスト一覧にリダイレクトする() throws Exception {
    mockMvc.perform(post("/quests/")).andExpect(status().is3xxRedirection())
        .andExpect(view().name("redirect:/quests/"));
  }

  @Test
  public void quests_questIdにPUTした場合にクエストの状態を変更してクエスト一覧にリダイレクトする() throws Exception {
    mockMvc.perform(put("/quests/{questId}/", "1").param("status", "DOING"))
        .andExpect(status().is3xxRedirection())
        .andExpect(view().name("redirect:/quests/"));
  }

}
