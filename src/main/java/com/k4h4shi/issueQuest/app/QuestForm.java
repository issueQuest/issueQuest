package com.k4h4shi.issueQuest.app;

import lombok.Getter;
import lombok.Setter;

/**
 * クエスト作成のためのフォーム
 * @author k4h4shi
 *
 */
@Getter
@Setter
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
