-- 코드를 입력하세요
SELECT DISTINCT C.CART_ID 
FROM CART_PRODUCTS C, CART_PRODUCTS T
WHERE C.CART_ID = T.CART_ID
AND (C.NAME = 'Milk' AND T.NAME = 'Yogurt') 
ORDER BY C.CART_ID