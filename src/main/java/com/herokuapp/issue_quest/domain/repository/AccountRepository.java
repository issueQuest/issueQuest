package com.herokuapp.issue_quest.domain.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.herokuapp.issue_quest.domain.model.Account;

/**
 * アカウントのリポジトリ
 * @author obscure12
 *
 */
public interface AccountRepository extends JpaRepository<Account, String>{

	Account findByEmail(String email);
}
