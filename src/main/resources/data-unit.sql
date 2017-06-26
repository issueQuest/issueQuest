-- 初期化
DELETE FROM quest;
DELETE FROM user;

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

--ユーザー情報
INSERT INTO user (
	id
	, username
	, email
	, password
) VALUES (
	1
	, '管理者 太郎'
	, 'admin'
	, 'pass'
);