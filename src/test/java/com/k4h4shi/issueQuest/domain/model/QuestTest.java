package com.k4h4shi.issueQuest.domain.model;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import org.junit.Before;
import org.junit.Test;

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

}