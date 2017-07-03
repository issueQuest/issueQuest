-- 初期化
DELETE FROM quest;
DELETE FROM account;
DELETE FROM user_info;

-- クエスト
INSERT INTO quest(
	id
	, title
	, description
	, status
)
VALUES(
	1
	, 'はじまりのクエスト'
	, 'これははじまりのクエストである。まずはこのクエストを受注して完了しよう!'
	, 'UNDONE'
);

--アカウント情報
INSERT INTO account (
	id
	, email
	, password
) VALUES (
	1
	, 'test@test.com'
	, 'test'
);

-- ユーザー情報
INSERT INTO user_info (
	account_id
	, family_name
	, given_name
	, family_name_kana
	, given_name_kana
	, gender
	, introduction
) VALUES (
	1
	, '山田'
	, '太郎'
	, 'ヤマダ'
	, 'タロウ'
	, 'MAN'
	, '自己紹介です'
);