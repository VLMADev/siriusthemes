-- Комментарий
SELECT
    *
FROM
    USERS
WHERE
    ID = 1
ORDER BY
    NAME ASC;

/* Многострочный комментарий */

-- Обновление
UPDATE USERS
SET
    NAME = 'VLMADev'
WHERE
    ID = 1;

-- Агрегация
SELECT
    COUNT(*) AS TOTAL_USERS
FROM
    USERS;

-- Подзапрос
SELECT
    NAME
FROM
    USERS
WHERE
    ID IN (
        SELECT
            USER_ID
        FROM
            ORDERS
        WHERE
            TOTAL > 100
    );