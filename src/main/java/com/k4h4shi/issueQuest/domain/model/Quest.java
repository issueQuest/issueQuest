package com.k4h4shi.issueQuest.domain.model;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import lombok.Data;

/**
 * クエストのクラス
 * @author k4h4shi
 *
 */
@Entity
@Data
public class Quest {
  /**
   * ID
   */
  @Id @GeneratedValue
  private String id;
  /**
   * タイトル
   */
  private String title;
  /**
   * 説明
   */
  private String description;
  /**
   * クエストの状態 
   */
  @Enumerated(EnumType.STRING)
  private QuestStatus status;
}
