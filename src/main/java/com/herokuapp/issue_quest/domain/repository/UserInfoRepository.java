package com.herokuapp.issue_quest.domain.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.herokuapp.issue_quest.domain.model.UserInfo;

/**
 * ユーザーのリポジトリ
 * @author obscure12
 *
 */
public interface UserInfoRepository extends JpaRepository<UserInfo, String> {

	UserInfo findByAccountId(Long accountId);
}
