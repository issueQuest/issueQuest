package com.herokuapp.issue_quest.domain.repository;

import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.*;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;

import com.herokuapp.issue_quest.domain.model.Account;

/**
 * アカウントリポジトリのテスト
 * @author obscure12
 *
 */
@RunWith(SpringRunner.class)
@DataJpaTest
@ActiveProfiles(profiles = "unit")
public class AccountRepositoryTest  {

	@Autowired
	AccountRepository accountRepository;

	@Test
	public void 一件のアカウントを取得するテスト() {
		// set up
		Account expected = new Account();
		expected.setId(new Long(1));
		expected.setEmail("test@test.com");
		expected.setPassword("test");

		Account actual = accountRepository.findByEmail(expected.getEmail());

		assertThat(actual, is(expected));
	}

}
