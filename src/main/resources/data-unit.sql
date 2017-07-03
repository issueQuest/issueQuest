-- 初期化
DELETE FROM quest;
DELETE FROM account;

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
INSERT INTO account (
	id
	, email
	, password
) VALUES (
	1
	, 'admin'
	, 'pass'
);