package com.herokuapp.issue_quest.auth.model;

import java.util.Collection;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.UserDetails;

import com.herokuapp.issue_quest.domain.model.User;

/**
 * 困リゴトクエストログインユーザー情報
 * @author obscure12
 *
 */
public class IssueQuestLoginUser extends User implements UserDetails{

	/**
	 * コンストラクタ
	 * @param user User
	 */
	public IssueQuestLoginUser(User user) {
		super(user.getEmail(), user.getPassword());
	}

	/**
	 * 権限リストの作成
	 */
	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		return AuthorityUtils.createAuthorityList("ROLE_USER");
	}

	/**
	 * アカウント有効期限のチェック
	 */
	@Override
	public boolean isAccountNonExpired() {
		return true;
	}

	/**
	 * アカウントロック状態のチェック
	 */
	@Override
	public boolean isAccountNonLocked() {
		return true;
	}

	/**
	 * 資格情報の有効期限チェック
	 */
	@Override
	public boolean isCredentialsNonExpired() {
		return true;
	}

	/**
	 * 有効なユーザーかチェック
	 */
	@Override
	public boolean isEnabled() {
		return true;
	}
}
