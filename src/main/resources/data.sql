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