package com.herokuapp.issue_quest.app.quest;

import lombok.Data;

/**
 * クエスト作成のためのフォーム
 * @author k4h4shi
 *
 */
@Data
public class QuestForm {
  /**
   * タイトル
   */
  private String title;
  /**
   * 説明
   */
  private String description;
}
