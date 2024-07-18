CREATE TABLE USERS (
	ID                   UUID                       NOT NULL,
	USERNAME             VARCHAR(250)               NOT NULL,
	PASSWORD             VARCHAR(250)               NOT NULL,
	CREATED_DATE         timestamp with time zone   NULL,
	MODIFIED_DATE        timestamp with time zone   NULL,
	CREATED_BY           VARCHAR(100)               NULL,
	MODIFIED_BY          VARCHAR(100)               NULL,
	CONSTRAINT USERS_FK PRIMARY KEY ( ID )
 );

 CREATE TABLE ROLES (
     ID                   SERIAL                    NOT NULL,
     NAME                 VARCHAR(100)              NOT NULL,
     CREATED_DATE         timestamp with time zone   NULL,
     MODIFIED_DATE        timestamp with time zone   NULL,
     CREATED_BY           VARCHAR(100)               NULL,
     MODIFIED_BY          VARCHAR(100)               NULL,
     CONSTRAINT ROLES_PK PRIMARY KEY ( ID )
 );

CREATE TABLE USERS_ROLES (
    USER_ID                UUID                     NOT NULL,
    ROLE_ID                SERIAL                   NOT NULL,
    CONSTRAINT USERS_ROLES_PK PRIMARY KEY (USER_ID, ROLE_ID)
);

ALTER TABLE USERS_ROLES ADD CONSTRAINT USERS_ROLES_USER_FK FOREIGN KEY ( USER_ID ) REFERENCES USERS( ID );
ALTER TABLE USERS_ROLES ADD CONSTRAINT USERS_ROLES_ROLE_FK FOREIGN KEY ( ROLE_ID ) REFERENCES ROLES( ID );

INSERT INTO ROLES(ID, NAME) VALUES (1, 'ADMIN');
INSERT INTO ROLES(ID, NAME) VALUES (2, 'BASIC');