package com.k4h4shi.issueQuest.app;

import com.k4h4shi.issueQuest.domain.model.Quest;
import com.k4h4shi.issueQuest.domain.service.QuestService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

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
   * トップ画面を表示
   * @param model モデル
   * @return トップ画面
   */
  @RequestMapping(path = "/")
  public String getAllQuests(Model model) {
    List<Quest> allQuests = questService.findAllQuests();
    model.addAttribute("allQuests", allQuests);
    return "page/index";
  }
}