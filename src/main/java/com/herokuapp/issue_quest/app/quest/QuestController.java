package com.herokuapp.issue_quest.app.quest;

import com.herokuapp.issue_quest.domain.model.Quest;
import com.herokuapp.issue_quest.domain.model.QuestStatus;
import com.herokuapp.issue_quest.domain.service.QuestService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * クエストのコントローラ
 * @author k4h4shi
 *
 */
@RequestMapping(path = "/quests/")
@Controller
public class QuestController {
  
  @Autowired
  QuestService questService;
  
  /**
   * クエスト作成のformを初期化する
   * @return クエスト作成form
   */
  @ModelAttribute
  public QuestForm setUpForm() {
    QuestForm questForm = new QuestForm();
    return questForm;
  }
  
  /**
   * クエスト一覧画面を表示する
   * @param model モデル
   * @return トップ画面
   */
  @RequestMapping(method = RequestMethod.GET)
  public String getAllQuests(Model model) {
    List<Quest> allQuests = questService.findAllQuests();
    model.addAttribute("allQuests", allQuests);
    return "quest/questList";
  }
  
  /**
   * クエストを一件追加し、トップ画面へリダイレクトする
   * @return トップ画面
   */
  @RequestMapping(method = RequestMethod.POST)
  public String createQuest(QuestForm questform) {
    String title = questform.getTitle();
    String description = questform.getDescription();
    questService.createQuest(title, description);
    return "redirect:/quests/";
  }
  
  /**
   * クエストの状態を変更する
   * @param questId クエストのId
   * @param status クエストの状態
   * @return トップ画面
   */
  @RequestMapping(path = "{questId}/", method = RequestMethod.PUT)
  public String updateQuest(@PathVariable String questId, @RequestParam QuestStatus status) {
    questService.updateQuestStatus(questId, status);
    return "redirect:/quests/";
  }
}
