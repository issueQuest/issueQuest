package com.herokuapp.issue_quest.domain.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import lombok.Data;

/**
 * アカウントのクラス
 * @author obscure12
 *
 */
@Entity
@Data
public class Account {

	/**
	 * ID
	 */
	@Id @GeneratedValue
	private Long id;

	/**
	 * アドレス
	 */
	@Column(unique = true)
	private String email;

	/**
	 * パスワード
	 */
	private String password;
}
