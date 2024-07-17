CREATE TABLE ITEM (
	ID                   SERIAL                     NOT NULL,
	COMPRA_ID            SERIAL                     NOT NULL,
	NOME                 VARCHAR(250)               NOT NULL,
	QUANTIDADE           BIGINT                     NOT NULL,
	VALOR                NUMERIC(15, 2)             NOT NULL,
	CREATED_DATE         timestamp with time zone  NULL,
	MODIFIED_DATE        timestamp with time zone  NULL,
	CREATED_BY           VARCHAR(100)              NULL,
	MODIFIED_BY          VARCHAR(100)              NULL,
	CONSTRAINT ITEM_PK PRIMARY KEY ( ID )
 );

CREATE TABLE HISTORICO_ITEM (
 	ID                   SERIAL                     NOT NULL,
 	ITEM_ID              SERIAL                     NOT NULL,
 	COMPRA_ID            SERIAL                     NOT NULL,
	VALOR                NUMERIC(15, 2)             NOT NULL,
 	CREATED_DATE         timestamp with time zone   NULL,
 	MODIFIED_DATE        timestamp with time zone   NULL,
 	CREATED_BY           VARCHAR(100)               NULL,
 	MODIFIED_BY          VARCHAR(100)               NULL,
 	CONSTRAINT HISTORICO_ITEM_PK PRIMARY KEY ( ID )
);

CREATE TABLE COMPRA (
   	ID                   SERIAL                     NOT NULL,
   	CREATED_DATE         timestamp with time zone   NULL,
   	MODIFIED_DATE        timestamp with time zone   NULL,
   	CREATED_BY           VARCHAR(100)               NULL,
   	MODIFIED_BY          VARCHAR(100)               NULL,
   	CONSTRAINT COMPRA_UK PRIMARY KEY ( ID )
);

ALTER TABLE ITEM ADD CONSTRAINT FK_ITEM_COMPRA FOREIGN KEY ( COMPRA_ID ) REFERENCES COMPRA( ID );