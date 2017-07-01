package com.herokuapp.issue_quest.app;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * アプリケーションのコントローラ
 * 
 * @author k4h4shi
 *
 */
@Controller
public class AppController {

  /**
   * トップ画面を表示する
   * 
   * @param model モデル
   * @return トップ画面
   */
  @RequestMapping(path = "/")
  public String getAllQuests(Model model) {
    return "page/index";
  }
}
