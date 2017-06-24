package com.k4h4shi.issueQuest.app;

import com.k4h4shi.issueQuest.domain.model.Quest;
import com.k4h4shi.issueQuest.domain.service.QuestService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * アプリケーションのコントローラ
 * @author k4h4shi
 *
 */
@Controller
public class AppController {
  
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
   * トップ画面を表示する
   * @param model モデル
   * @return トップ画面
   */
  @RequestMapping(path = "/")
  public String getAllQuests(Model model) {
    List<Quest> allQuests = questService.findAllQuests();
    model.addAttribute("allQuests", allQuests);
    return "page/index";
  }
  
  /**
   * クエストを一件追加し、トップ画面へリダイレクトする
   * @return トップ画面
   */
  @RequestMapping(path = "/", method = RequestMethod.POST)
  public String createQuest(QuestForm questform) {
    String title = questform.getTitle();
    String description = questform.getDescription();
    questService.createQuest(title, description);
    return "redirect:/";
  } 
}
