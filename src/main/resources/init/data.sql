-- === MEMBER ===
INSERT INTO MEMBER (EMAIL, PASSWORD, ADDRESS, POST_NUM, ROLE, ENABLED) VALUES
('john@example.com', 'encoded_password1', '서울시 강남구', 12345, 'ROLE_USER', true),
('emma@example.com', 'encoded_password2', '부산시 해운대구', 54321, 'ROLE_USER', true),
('admin@example.com', 'encoded_password3', '대전시 중구', 11111, 'ROLE_ADMIN', true),
('test@test.com', '{noop}test', 'sampleAddress', 00000, 'ROLE_ADMIN', true),
('member@test.com', '{noop}test', 'sampleAddress', 00000, 'ROLE_USER', true);

-- === COFFEE ===
INSERT INTO COFFEE (COFFEE_NAME, PRICE, STOCK) VALUES
('에티오피아 예가체프', 12000, 50),
('콜롬비아 수프리모', 10000, 30),
('케냐 AA', 11000, 20),
('브라질 산토스', 9000, 100);

-- === ORDERS ===
INSERT INTO ORDERS (EMAIL, ADDRESS, POST_NUM, ORDER_TIME) VALUES
('member@test.com', '서울시 강남구', 12345, NOW()),
('member@test.com', '서울시 강남구', 12345, DATE_SUB(NOW(), INTERVAL 1 DAY)),
('emma@example.com', '부산시 해운대구', 54321, NOW());

-- === DETAIL ===
INSERT INTO DETAIL (ORDER_NUM, COFFEE_ID, QUANTITY) VALUES
(1, 1, 2),   -- john 주문: 예가체프 2개
(1, 3, 1),   -- john 주문: 케냐 AA 1개
(2, 2, 1),   -- emma 주문: 수프리모 1개
(2, 4, 3),   -- emma 주문: 산토스 3개
(3, 2, 1),  -- 콜롬비아 수프리모 1개
(3, 3, 2);  -- 케냐 AA 2개