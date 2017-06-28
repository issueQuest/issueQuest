package com.herokuapp.issue_quest.domain.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import lombok.Data;

/**
 * ユーザークラス
 * @author obscure12
 *
 */
@Entity
@Data
public class User {

	/**
	 * ID
	 */
	@Id @GeneratedValue
	private Long id;

	/**
	 * ユーザー名
	 */
	private String username;

	/**
	 * メールアドレスアドレス
	 */
	@Column(unique = true)
	private String email;

	/**
	 * パスワード
	 */
	private String password;

	/**
	 * デフォルトコンストラクタ
	 */
	protected User() {}

	/**
	 * コンストラクタ
	 * @param email メールアドレス
	 * @param password パスワード
	 */
	public User(String email, String password) {
		super();
		this.email = email;
		this.password = password;
	}
}
