package com.k4h4shi.issueQuest.domain.service;

import com.k4h4shi.issueQuest.domain.model.Quest;
import com.k4h4shi.issueQuest.domain.repository.QuestRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * クエストのサービス
 * @author k4h4shi
 *
 */
@Service
public class QuestService {
  
  @Autowired
  QuestRepository questRepository;
  
  /**
   * 全てのクエストを取得する
   * @return 全てのクエスト
   */
  public List<Quest> findAllQuests() {
    return questRepository.findAll();
  }
}
