package com.herokuapp.issue_quest.domain.repository;

import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.*;

import java.util.Arrays;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;

import com.herokuapp.issue_quest.domain.model.Gender;
import com.herokuapp.issue_quest.domain.model.UserInfo;

/**
 * ユーザー情報リポジトリのテスト
 * @author obscure12
 *
 */
@RunWith(SpringRunner.class)
@DataJpaTest
@ActiveProfiles(profiles = "unit")
public class UserInfoRepositoryTest {

	@Autowired
	UserInfoRepository userInfoRepository;

	@Test
	public void すべてのユーザー情報を取得するテスト() {
		// set up
		UserInfo userInfo = new UserInfo();
		userInfo.setAccountId(new Long(1));
		userInfo.setFamilyName("山田");
		userInfo.setGivenName("太郎");
		userInfo.setFamilyNameKana("ヤマダ");
		userInfo.setGivenNameKana("タロウ");
		userInfo.setGender(Gender.MAN);
		userInfo.setIntroduction("自己紹介です");

		List<UserInfo> expected = Arrays.asList(userInfo);

		List<UserInfo> actual = userInfoRepository.findAll();

		assertThat(actual, is(expected));
	}

	@Test
	public void 一件のユーザー情報を取得するテスト() {
		// set up
		UserInfo expected = new UserInfo();
		expected.setAccountId(new Long(1));
		expected.setFamilyName("山田");
		expected.setGivenName("太郎");
		expected.setFamilyNameKana("ヤマダ");
		expected.setGivenNameKana("タロウ");
		expected.setGender(Gender.MAN);
		expected.setIntroduction("自己紹介です");

		UserInfo actual = userInfoRepository.findByAccountId(expected.getAccountId());

		assertThat(actual, is(expected));
	}
}
