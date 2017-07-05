package com.herokuapp.issue_quest.domain.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

/**
 * ユーザークラス
 * @author obscure12
 *
 */
@Entity
@Table(name = "user_info")
@Data
public class UserInfo {

	/**
	 * アカウントID
	 */
	@Id
	@Column(name = "account_id")
	private Long accountId;

	/**
	 * 氏名（姓）
	 */
	@Column(name = "family_name")
	private String familyName;

	/**
	 * 氏名（名）
	 */
	@Column(name = "given_name")
	private String givenName;

	/**
	 * かな氏名（姓）
	 */
	@Column(name = "family_name_kana")
	private String familyNameKana;

	/**
	 * かな氏名（姓）
	 */
	@Column(name = "given_name_kana")
	private String givenNameKana;

	/**
	 * 性別
	 */
	@Enumerated(EnumType.STRING)
	private Gender gender;

	/**
	 * 自己紹介
	 */
	private String introduction;

}
