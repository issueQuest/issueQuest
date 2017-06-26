package com.k4h4shi.issueQuest.domain.repository;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import com.k4h4shi.issueQuest.domain.model.Quest;
import com.k4h4shi.issueQuest.domain.model.QuestStatus;
import java.util.Arrays;
import java.util.List;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * クエストリポジトリのテスト
 * 
 * @author k4h4shi
 *
 */
@RunWith(SpringRunner.class)
@DataJpaTest
@ActiveProfiles(profiles="unit")
public class QuestRepositoryTest {

  @Autowired
  QuestRepository questRepository;
  
  @Test
  public void 全てのクエストを取得するテスト() {
    // set up
    Quest quest = new Quest();
    quest.setId("1");
    quest.setTitle("はじまりのクエスト");
    quest.setDescription("これははじまりのクエストである。まずはこのクエストを受注して完了しよう!");
    
    List<Quest> expected = Arrays.asList(quest);
    
    // execute
    List<Quest> actual = questRepository.findAll();
    
    // verify
    assertThat(actual, is(expected));
  }
  
  @Test
  public void 一件のクエストを取得するテスト() {
    // set up
    Quest expected = new Quest();
    expected.setId("1");
    expected.setTitle("はじまりのクエスト");
    expected.setDescription("これははじまりのクエストである。まずはこのクエストを受注して完了しよう!");
    
    // execute
    Quest actual = questRepository.findOne(expected.getId());
    
    // verify
    assertThat(actual, is(expected));
  }
  
  @Test
  public void クエストの作成のテスト() {
    // setup
    Quest expected = new Quest();
    expected.setId("2");
    expected.setTitle("第二のクエスト");
    expected.setDescription("これは第二のクエストである。");
    questRepository.saveAndFlush(expected);
    
    // execute
    Quest actual = questRepository.findOne("2");
    
    // assert
    assertThat(actual, is(expected));
  }
  
  @Test
  public void クエストの状態の更新のテスト() {
    // setup
    Quest quest = questRepository.findOne("1");
    quest.setStatus(QuestStatus.DOING);
    questRepository.flush();
    
    // execute
    Quest actual = questRepository.findOne("1");
    
    // assert
    assertThat(actual.getStatus(), is(QuestStatus.DOING));
  }

}
