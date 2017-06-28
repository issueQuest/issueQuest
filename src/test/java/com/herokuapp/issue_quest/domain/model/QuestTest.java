package com.herokuapp.issue_quest.domain.model;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import org.junit.Before;
import org.junit.Test;

import com.herokuapp.issue_quest.domain.model.Quest;
import com.herokuapp.issue_quest.domain.model.QuestStatus;

/**
 * クエストのテスト
 * @author k4h4shi
 *
 */
public class QuestTest {

  private Quest quest;
  
  @Before
  public void setup() {
    this.quest = new Quest();
  }
  
  @Test
  public void クエストにはタイトルを設定し参照出来る() {
    String title = "はじまりのクエスト";
    quest.setTitle(title);
    assertThat(quest.getTitle(), is(title));
  }
  
  @Test
  public void クエストには説明を設定し参照出来る() {
    String description = "これははじまりのクエストである";
    quest.setDescription(description);
    assertThat(quest.getDescription(), is(description));
  }
  
  @Test
  public void クエストには状態を設定し参照出来る() {
    QuestStatus status = QuestStatus.UNDONE;
    quest.setStatus(status);
    assertThat(quest.getStatus(), is(status));
  }
  
  @Test
  public void クエスト作成時にタイトルと説明を設定できる() throws Exception {
    String title = "第二のクエスト";
    String description = "これは第二のクエストです";
    quest = new Quest(title, description);
  }
  
  @Test
  public void クエスト作成時の初期状態は未受注である() {
    assertThat(quest.getStatus(), is(QuestStatus.UNDONE));
  }
  
}
