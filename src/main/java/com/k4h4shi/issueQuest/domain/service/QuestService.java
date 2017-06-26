package com.k4h4shi.issueQuest.domain.service;

import com.k4h4shi.issueQuest.domain.model.Quest;
import com.k4h4shi.issueQuest.domain.model.QuestStatus;
import com.k4h4shi.issueQuest.domain.repository.QuestRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * クエストのサービス
 * 
 * @author k4h4shi
 *
 */
@Service
public class QuestService {

  @Autowired
  QuestRepository questRepository;

  /**
   * 全てのクエストを取得する
   * 
   * @return 全てのクエスト
   */
  public List<Quest> findAllQuests() {
    return questRepository.findAll();
  }

  /**
   * クエストを一件作成する
   * 
   * @param title クエストのタイトル
   * @param description クエストの説明
   * @return 作成されたクエスト
   */
  public Quest createQuest(String title, String description) {
    Quest quest = new Quest(title, description);
    return questRepository.save(quest);
  }

  /**
   * クエストの状態を更新する
   * 
   * @param questId クエストのId
   * @param status クエストの状態
   */
  public void updateQuestStatus(String questId, QuestStatus status) {
    if (!questRepository.exists(questId)) {
      // TODO update対象が存在しない場合の例外を送出する
      return;
    }

    Quest target = questRepository.findOne(questId);
    if (target.getStatus().equals(status)) {
      // TODO 更新対象による変更がない場合の例外を送出する
      return;
    }
    target.setStatus(status);
    
    questRepository.flush();
  }
}
