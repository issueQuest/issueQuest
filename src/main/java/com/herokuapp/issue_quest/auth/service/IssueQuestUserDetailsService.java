package com.herokuapp.issue_quest.auth.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.herokuapp.issue_quest.auth.model.IssueQuestLoginUser;
import com.herokuapp.issue_quest.domain.model.Account;
import com.herokuapp.issue_quest.domain.model.UserInfo;
import com.herokuapp.issue_quest.domain.repository.AccountRepository;
import com.herokuapp.issue_quest.domain.repository.UserInfoRepository;

/**
 * 困リゴトクエスト認証サービス
 * @author obscure12
 *
 */
@Service("issueQuestUserDetailsService")
public class IssueQuestUserDetailsService implements UserDetailsService {

	@Autowired
	private AccountRepository accountRepository;

	@Autowired
	private UserInfoRepository userRepository;

	@Override
	public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
		Account account = accountRepository.findByEmail(email);
		if (account == null) {
			throw new UsernameNotFoundException("USER NOT FOUND");
		}

		IssueQuestLoginUser loginUser = new IssueQuestLoginUser(account);

		setUserInfo(loginUser);

		return loginUser;
	}

	/**
	 * ユーザー情報の設定
	 * @param loginUser ログインユーザー
	 */
	private void setUserInfo(IssueQuestLoginUser loginUser) {
		UserInfo userInfo = userRepository.findByAccountId(loginUser.getAccountId());
		loginUser.setUserInfo(userInfo);
	}
}
