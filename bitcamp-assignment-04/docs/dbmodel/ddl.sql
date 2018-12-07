-- 첫번째 테이블
DROP TABLE IF EXISTS `FIRST_TABLE` RESTRICT;

-- 두번째_테이블
DROP TABLE IF EXISTS `SECOND_TABLE` RESTRICT;

-- 첫번째 테이블
CREATE TABLE `FIRST_TABLE` (
    `id`   INTEGER     NOT NULL COMMENT '아이디 컬럼의 주석입니다.', -- 아이디
    `COL1` VARCHAR(10) NULL     COMMENT '컬럼1', -- 컬럼1
    `COL2` INTEGER     NULL     COMMENT '컬럼2' -- 컬럼2
)
COMMENT '첫번째 테이블의 주석입니다.';

-- 첫번째 테이블
ALTER TABLE `FIRST_TABLE`
    ADD CONSTRAINT `PK_FIRST_TABLE` -- 첫번째 테이블 기본키
        PRIMARY KEY (
            `id` -- 아이디
        );

-- 첫번째 테이블
ALTER TABLE `FIRST_TABLE`
    ADD CONSTRAINT `CK_FIRST_TABLE` -- 첫번째 테이블 체크 제약
        CHECK (col2 > 10);

-- 첫번째 테이블 유니크 제약사항 인덱스
CREATE UNIQUE INDEX `UCIX_FIRST_TABLE`
    ON `FIRST_TABLE` ( -- 첫번째 테이블
    );

-- 첫번째 테이블 유니크 인덱스
CREATE UNIQUE INDEX `UIX_FIRST_TABLE`
    ON `FIRST_TABLE` ( -- 첫번째 테이블
    );

-- 새 트리거
CREATE TRIGGER `TRIGGER`
BEFORE INSERT ON someTable
FOR EACH ROW
BEGIN
CALL doSanityCheck(@resultBool, @resultMessage);
IF @resultBool = 0 THEN
UPDATE ThereWasAnError_Call_privilegeSanityCheck_ToViewTheError SET ThereWas='an error';
END IF;
END;

-- 두번째_테이블
CREATE TABLE `SECOND_TABLE` (
    `id`  INTEGER     NOT NULL COMMENT '아이디', -- 아이디
    `COL` VARCHAR(10) NULL     COMMENT '컬럼' -- 컬럼
)
COMMENT '두번째_테이블';

-- 두번째_테이블
ALTER TABLE `SECOND_TABLE`
    ADD CONSTRAINT `PK_SECOND_TABLE` -- 두번째_테이블 기본키
        PRIMARY KEY (
            `id` -- 아이디
        );

-- 두번째_테이블 인덱스
CREATE INDEX `IX_SECOND_TABLE`
    ON `SECOND_TABLE`( -- 두번째_테이블
        `COL` DESC -- 컬럼
    );

-- 두번째_테이블
ALTER TABLE `SECOND_TABLE`
    ADD CONSTRAINT `FK_FIRST_TABLE_TO_SECOND_TABLE` -- 첫번째 테이블 -> 두번째_테이블
        FOREIGN KEY (
            `id` -- 아이디
        )
        REFERENCES `FIRST_TABLE` ( -- 첫번째 테이블
            `id` -- 아이디
        ),
    ADD INDEX `FK_FIRST_TABLE_TO_SECOND_TABLE` (
        `id` ASC -- 아이디
    );

-- 첫번째_뷰
CREATE VIEW `FIRST_VIEW` AS SELECT * FROM FIRST_TABLE