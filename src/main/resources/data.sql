-- クエスト
-- 始まりのクエスト
INSERT INTO quest(
	id
	, title
	, description
	, status
)
VALUES(
	1
	, 'はじまりのクエスト'
	, 'これはじまりのクエストである。まずはこのクエストを受注して完了しよう!'
	, 'UNDONE'
);
-- 第二のクエスト
INSERT INTO quest(
	id
	, title
	, description
	, status
)
VALUES(
	2
	, '第二のクエスト'
	, 'これ第二のクエストである。このクエストを受注して完了しよう!'
	, 'UNDONE'
);
-- 第三のクエスト
INSERT INTO quest(
	id
	, title
	, description
	, status
)
VALUES(
	3
	, '第三のクエスト'
	, 'これ第三のクエストである。このクエストを受注して完了しよう!'
	, 'UNDONE'
);
-- 第四のクエスト
INSERT INTO quest(
	id
	, title
	, description
	, status
)
VALUES(
	4
	, '第四のクエスト'
	, 'これ第四のクエストである。このクエストを受注して完了しよう!'
	, 'UNDONE'
);

--アカウント情報
INSERT INTO account (
	id
	, email
	, password
) VALUES (
	1
	, 'admin'
	, 'pass'
);

--ユーザー情報
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
	, '自己紹介'
);