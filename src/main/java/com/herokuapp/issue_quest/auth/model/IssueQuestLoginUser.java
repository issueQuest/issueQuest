package com.herokuapp.issue_quest.auth.model;

import java.util.Collection;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.UserDetails;

import com.herokuapp.issue_quest.constants.Constants;
import com.herokuapp.issue_quest.domain.model.Account;
import com.herokuapp.issue_quest.domain.model.UserInfo;

/**
 * 困リゴトクエストログインユーザー情報
 * @author obscure12
 *
 */
public class IssueQuestLoginUser  implements UserDetails{

	/**
	 * アカウントID
	 */
	private Long accountId;

	/**
	 * パスワード
	 */
	private String password;

	/**
	 * ユーザー情報
	 */
	private UserInfo userInfo;

	/**
	 * コンストラクタ
	 * @param user User
	 */
	public IssueQuestLoginUser(Account account) {
		super();
		this.password = account.getPassword();
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

	/**
	 * アカウントIDの取得
	 * @return アカウントID
	 */
	public Long getAccountId() {
		return accountId;
	}

	/**
	 * アカウントIDの設定
	 * @param accountId アカウントID
	 */
	public void setAccountId(Long accountId) {
		this.accountId = accountId;
	}

	@Override
	public String getPassword() {
		return this.password;
	}

	@Override
	public String getUsername() {
		if (this.userInfo == null) {
			return null;
		}
		return this.userInfo.getFamilyName() + Constants.Character.SPACE + this.userInfo.getGivenName();
	}

	/**
	 * ユーザー情報の取得
	 * @return ユーザー情報
	 */
	public UserInfo getUserInfo() {
		return userInfo;
	}

	/**
	 * ユーザー情報の設定
	 * @param userInfo ユーザー情報
	 */
	public void setUserInfo(UserInfo userInfo) {
		this.userInfo = userInfo;
	}
}