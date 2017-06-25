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