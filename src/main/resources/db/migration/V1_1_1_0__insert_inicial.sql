INSERT INTO ROLES(ID, NAME) VALUES (1, 'ADMIN');
INSERT INTO ROLES(ID, NAME) VALUES (2, 'BASIC');

INSERT INTO USERS(ID, USERNAME, PASSWORD, CREATED_DATE, CREATED_BY, MODIFIED_DATE, MODIFIED_BY) VALUES
('f91f0dd3-0f21-46df-af3d-086448fe8bdf', 'galasdalas50@gmail.com', '$2a$10$jRKnXdhbTvMV4urPwxL4gOHkoSpLDXXC5BaElwqrU5409f4vLJbyi', CURRENT_TIMESTAMP, 'GUSTAVO', CURRENT_TIMESTAMP, 'GUSTAVO');

INSERT INTO USERS_ROLES(USER_ID, ROLE_ID) VALUES
((SELECT ID FROM USERS WHERE USERNAME = 'galasdalas50@gmail.com'), 1);