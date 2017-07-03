package com.herokuapp.issue_quest.app.login;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

/**
 * ログインコントローラーのテスト
 * @author obscure12
 *
 */
@RunWith(SpringRunner.class)
@WebMvcTest(
		// 単体テストではSpringSecurityを無効化するため、secure = falseとする
		secure = false,
		controllers = {LoginController.class}
		)
public class LoginControllerTest {

	@Autowired
	MockMvc mockMvc;

	@Test
	public void ログインコントローラーはログイン画面を返す() throws Exception {
		mockMvc.perform(get("/login/")).andExpect(status().isOk())
			.andExpect(content().contentTypeCompatibleWith(MediaType.TEXT_HTML))
			.andExpect(view().name("login/login"));
	}

}
