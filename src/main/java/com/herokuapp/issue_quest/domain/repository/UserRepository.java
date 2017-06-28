package com.herokuapp.issue_quest.domain.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.herokuapp.issue_quest.domain.model.User;

/**
 * ユーザーのリポジトリ
 * @author obscure12
 *
 */
public interface UserRepository extends JpaRepository<User, String> {

	User findByEmail(String email);
}
