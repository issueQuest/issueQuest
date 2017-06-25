package com.k4h4shi.issueQuest.domain.service;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import static org.mockito.Matchers.any;
import static org.mockito.Mockito.when;

import com.k4h4shi.issueQuest.domain.model.Quest;
import com.k4h4shi.issueQuest.domain.model.QuestStatus;
import com.k4h4shi.issueQuest.domain.repository.QuestRepository;
import java.util.Arrays;
import java.util.List;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

/**
 * クエストサービスのテスト
 * @author k4h4shi
 *
 */
@RunWith(MockitoJUnitRunner.class)
public class QuestServiceTest {

  @InjectMocks
  QuestService questService;
  
  @Mock
  QuestRepository questRepository;
  
  @Test
  public void findAllQuestsで全てのクエストが取得出来る() {
    // set up
    List<Quest> expected = Arrays.asList(new Quest());
    when(questRepository.findAll()).thenReturn(expected);
    
    // execute
    List<Quest> actual = questService.findAllQuests();
    
    // verify
    assertThat(actual, is(expected));
  }
  
  @Test
  public void createQuestでクエストを一件作成できる() {
    // setup
    String title = "初めてのクエスト";
    String description = "これは初めてのクエストです";
    Quest expected = new Quest(title, description);
    
    when(questRepository.save(any(Quest.class))).thenReturn(expected);
    
    // execute
    Quest actual = questService.createQuest(title, description);
    
    // verify
    assertThat(actual, is(expected));
  }
  
  @Test
  public void updateQuestStatusでクエストの状態を更新できる() {
    // setup
    String questId = "1";
    Quest foundQuest = new Quest();
    when(questRepository.exists(questId)).thenReturn(true);
    when(questRepository.findOne(questId)).thenReturn(foundQuest);
    
    // execute
    QuestStatus status = QuestStatus.DOING;
    questService.updateQuestStatus(questId, status);
    
    // verify
    assertThat(foundQuest.getStatus(), is(status));
  }
}
