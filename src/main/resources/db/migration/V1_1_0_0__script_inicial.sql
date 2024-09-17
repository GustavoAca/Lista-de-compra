CREATE TABLE USERS (
	ID                   UUID                       NOT NULL,
	USERNAME             VARCHAR(250)               NOT NULL,
	PASSWORD             VARCHAR(250)               NOT NULL,
	CREATED_DATE         timestamp with time zone   NULL,
	MODIFIED_DATE        timestamp with time zone   NULL,
	CREATED_BY           VARCHAR(100)               NULL,
	MODIFIED_BY          VARCHAR(100)               NULL,
	CONSTRAINT USERS_PK PRIMARY KEY ( ID )
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

CREATE TABLE LOCAIS (
	ID                   UUID                      NOT NULL,
	NOME                 VARCHAR(250)              NOT NULL,
	CREATED_DATE         timestamp with time zone  NULL,
	MODIFIED_DATE        timestamp with time zone  NULL,
	CREATED_BY           VARCHAR(100)              NULL,
	MODIFIED_BY          VARCHAR(100)              NULL,
	CONSTRAINT LOCAIS_PK PRIMARY KEY ( ID )
 );

CREATE TABLE COMPRAS (
    	ID                   SERIAL                     NOT NULL,
    	CREATED_DATE         timestamp with time zone   NULL,
    	VALOR_TOTAL          NUMERIC(15, 2)             NOT NULL,
    	MODIFIED_DATE        timestamp with time zone   NULL,
    	CREATED_BY           VARCHAR(100)               NULL,
    	MODIFIED_BY          VARCHAR(100)               NULL,
    	CONSTRAINT COMPRA_UK PRIMARY KEY ( ID )
 );

CREATE TABLE CARRINHO_DE_COMPRA (
     	ID                   SERIAL                     NOT NULL,
     	USER_ID               UUID                      NOT NULL,
     	CREATED_DATE         timestamp with time zone   NULL,
     	MODIFIED_DATE        timestamp with time zone   NULL,
     	CREATED_BY           VARCHAR(100)               NULL,
     	MODIFIED_BY          VARCHAR(100)               NULL,
     	CONSTRAINT CARRINHO_DE_COMPRA_UK PRIMARY KEY ( ID )
  );

ALTER TABLE CARRINHO_DE_COMPRA ADD CONSTRAINT FK_CARRINHO_DE_COMPRA_USER_ID FOREIGN KEY ( USER_ID ) REFERENCES USERS( ID );


CREATE TABLE ITENS_NO_CARRINHO (
	ID                    SERIAL                    NOT NULL,
	CARRINHO_DE_COMPRA_ID SERIAL                    NOT NULL,
	NOME                  VARCHAR(250)              NULL,
	QUANTIDADE            BIGINT                    NULL,
	PROMOCAO              BOOLEAN                   NULL,
	VALOR                 NUMERIC(15, 2)            NULL,
	CREATED_DATE          timestamp with time zone  NULL,
	MODIFIED_DATE         timestamp with time zone  NULL,
	CREATED_BY            VARCHAR(100)              NULL,
	MODIFIED_BY           VARCHAR(100)              NULL,
	CONSTRAINT ITENS_NO_CARRINHO_PK PRIMARY KEY ( ID )
 );

ALTER TABLE ITENS_NO_CARRINHO ADD CONSTRAINT FK_ITENS_NO_CARRINHO_CARRINHO_DE_COMPRA_ID FOREIGN KEY ( CARRINHO_DE_COMPRA_ID ) REFERENCES CARRINHO_DE_COMPRA( ID );

CREATE TABLE ITENS (
	ID                    SERIAL                    NOT NULL,
	COMPRA_ID             SERIAL                    NOT NULL,
	CARRINHO_DE_COMPRA_ID SERIAL                    NOT NULL,
	LOCAL_ID              UUID                      NOT NULL,
	NOME                  VARCHAR(250)              NOT NULL,
	QUANTIDADE            BIGINT                    NOT NULL,
	PROMOCAO              BOOLEAN                   NOT NULL,
	VALOR                 NUMERIC(15, 2)            NOT NULL,
	CREATED_DATE          timestamp with time zone  NULL,
	MODIFIED_DATE         timestamp with time zone  NULL,
	CREATED_BY            VARCHAR(100)              NULL,
	MODIFIED_BY           VARCHAR(100)              NULL,
	CONSTRAINT ITENS_PK PRIMARY KEY ( ID )
 );

ALTER TABLE ITENS ADD CONSTRAINT FK_ITENS_COMPRA_ID FOREIGN KEY ( COMPRA_ID ) REFERENCES COMPRAS( ID );
ALTER TABLE ITENS ADD CONSTRAINT FK_ITENS_LOCAL_ID FOREIGN KEY ( LOCAL_ID ) REFERENCES LOCAIS( ID );

CREATE TABLE HISTORICO_ITENS (
 	ID                   SERIAL                     NOT NULL,
 	ITEM_ID              SERIAL                     NOT NULL,
 	COMPRA_ID            SERIAL                     NOT NULL,
 	LOCAL_ID             UUID                       NOT NULL,
	VALOR                NUMERIC(15, 2)             NOT NULL,
 	CREATED_DATE         timestamp with time zone   NULL,
 	MODIFIED_DATE        timestamp with time zone   NULL,
 	CREATED_BY           VARCHAR(100)               NULL,
 	MODIFIED_BY          VARCHAR(100)               NULL,
 	CONSTRAINT HISTORICO_ITENS_PK PRIMARY KEY ( ID )
);