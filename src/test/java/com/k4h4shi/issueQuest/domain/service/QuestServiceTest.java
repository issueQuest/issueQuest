package com.k4h4shi.issueQuest.domain.service;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import com.k4h4shi.issueQuest.domain.model.Quest;
import java.util.List;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * クエストサービスのテスト
 * @author k4h4shi
 *
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class QuestServiceTest {

  @Autowired
  QuestService questService;
  
  @Test
  public void findAllQuestsで全てのクエストが取得出来る() {
    List<Quest> allQuests = questService.findAllQuests();
    assertThat(allQuests.size(), is(1));
  }
  
  @Test
  public void createQuestでクエストを一件作成できる() {
    String title = "初めてのクエスト";
    String description = "これは初めてのクエストです。";
    Quest actual = questService.createQuest(title, description);
    assertThat(actual.getTitle(), is(title));
    assertThat(actual.getDescription(), is(description));
  }

}
