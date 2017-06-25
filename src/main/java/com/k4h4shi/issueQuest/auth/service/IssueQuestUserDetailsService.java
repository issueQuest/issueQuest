package com.k4h4shi.issueQuest.auth.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.k4h4shi.issueQuest.auth.model.IssueQuestLoginUser;
import com.k4h4shi.issueQuest.domain.model.User;
import com.k4h4shi.issueQuest.domain.repository.UserRepository;

/**
 * 困リゴトクエスト認証サービス
 * @author obscure12
 *
 */
@Service("issueQuestUserDetailsService")
public class IssueQuestUserDetailsService implements UserDetailsService {

	@Autowired
	private UserRepository userRepository;

	@Override
	public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
		User user = userRepository.findByEmail(email);
		if (user == null) {
			throw new UsernameNotFoundException("USER NOT FOUND");
		}
		return new IssueQuestLoginUser(user);
	}
}
