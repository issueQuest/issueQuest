package com.herokuapp.issue_quest.app.login;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * ログイン画面コントローラー
 * @author obscure12
 *
 */
@Controller
@RequestMapping("login")
public class LoginController {

	/**
	 * ログインページを表示する
	 * @return ログインページ
	 */
	@RequestMapping("/")
	public String showLoginForm() {
		return "/login/login";
	}
}