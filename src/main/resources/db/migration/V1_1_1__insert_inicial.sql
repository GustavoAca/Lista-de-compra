INSERT INTO ROLES(ID, NAME, VERSION) VALUES (1, 'ADMIN', 0);
INSERT INTO ROLES(ID, NAME, VERSION) VALUES (2, 'BASIC', 0);

INSERT INTO USERS(ID, USERNAME, PASSWORD, CREATED_DATE, CREATED_BY, MODIFIED_DATE, MODIFIED_BY, VERSION) VALUES
('f91f0dd3-0f21-46df-af3d-086448fe8bdf', 'galasdalas50@gmail.com', '$2a$10$jRKnXdhbTvMV4urPwxL4gOHkoSpLDXXC5BaElwqrU5409f4vLJbyi', CURRENT_TIMESTAMP, 'GUSTAVO', CURRENT_TIMESTAMP, 'GUSTAVO', 0);

INSERT INTO USERS_ROLES(USER_ID, ROLE_ID) VALUES
((SELECT ID FROM USERS WHERE USERNAME = 'galasdalas50@gmail.com'), 1);

insert into locais (id, nome, created_date, modified_date, created_by, modified_by, version)
values ('f71d0268-7cbe-47c0-847b-0b2604c301eb', 'Shibata', current_timestamp, current_timestamp, 'GUSTAVO', 'GUSTAVO', 0);


INSERT INTO ITENS (id, nome, promocao, quantidade, valor, local_id, modified_date, modified_by, created_date, created_by, version) VALUES
 (5107, 'Arroz',false, 1, 20.50, 'f71d0268-7cbe-47c0-847b-0b2604c301eb', current_timestamp, 'admin', current_timestamp, 'admin', 1),
 (5108, 'Feijão',false, 2, 15.30, 'f71d0268-7cbe-47c0-847b-0b2604c301eb', current_timestamp, 'admin', current_timestamp, 'admin', 1),
 (5109, 'Macarrão', false,3, 8.99, 'f71d0268-7cbe-47c0-847b-0b2604c301eb', current_timestamp, 'admin', current_timestamp, 'admin', 1),
 (5110, 'Açúcar',false, 1, 5.40, 'f71d0268-7cbe-47c0-847b-0b2604c301eb', current_timestamp, 'admin', current_timestamp, 'admin', 1),
 (5111, 'Sal',false, 1, 2.99, 'f71d0268-7cbe-47c0-847b-0b2604c301eb', current_timestamp, 'admin', current_timestamp, 'admin', 1);

