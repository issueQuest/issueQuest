package com.k4h4shi.issueQuest.domain.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.k4h4shi.issueQuest.domain.model.User;

/**
 * ユーザーのリポジトリ
 * @author obscure12
 *
 */
public interface UserRepository extends JpaRepository<User, String> {

	User findByEmail(String email);
}
