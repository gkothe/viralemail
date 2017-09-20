/*==============================================================*/
/* DBMS name:      MySQL 5.0                                    */
/* Created on:     19/9/2017 10:11:48 AM                        */
/*==============================================================*/


drop table if exists BAIRROS;

drop table if exists CATEGORIA;

drop table if exists CIDADE;

drop table if exists LOJA;

drop table if exists PEDIDO;

drop table if exists PEDIDO_ITEM;

drop table if exists PRODUTOS;

drop table if exists USUARIO;

/*==============================================================*/
/* Table: BAIRROS                                               */
/*==============================================================*/
create table BAIRROS
(
   COD_BAIRRO           INT4 not null auto_increment,
   COD_CIDADE           INT4,
   DESC_BAIRRO          TEXT not null,
   DESC_GOOGLEMAPS      text,
   primary key (COD_BAIRRO)
)
auto_increment = 1;

/*==============================================================*/
/* Table: CATEGORIA                                             */
/*==============================================================*/
create table CATEGORIA
(
   ID_CATEGORIA         int4 not null,
   DESC_CATEGORIA       text,
   DESC_KEY_WORDS       text,
   primary key (ID_CATEGORIA)
);

/*==============================================================*/
/* Table: CIDADE                                                */
/*==============================================================*/
create table CIDADE
(
   COD_CIDADE           INT4 not null auto_increment,
   DESC_CIDADE          TEXT not null,
   MAPS_LATITUDE        float(10,6),
   MAPS_LONGITUDE       float(10,6),
   primary key (COD_CIDADE)
)
auto_increment = 1;

/*==============================================================*/
/* Table: LOJA                                                  */
/*==============================================================*/
create table LOJA
(
   ID_LOJA              INT4 not null auto_increment,
   COD_CIDADE           INT4,
   COD_BAIRRO           INT4 not null,
   DESC_RAZAO_SOCIAL    TEXT,
   DESC_NOME_ABREV      TEXT,
   DESC_TELEFONE        VARCHAR(50),
   DESC_ENDERECO        TEXT not null,
   NUM_ENDEREC          VARCHAR(10) not null,
   DESC_COMPLEMENTO     TEXT,
   DESC_LOGIN           varchar(45),
   DESC_SENHA           varchar(45),
   DESC_MAIL            text,
   FLAG_ATIVO_MASTER    char(1),
   FLAG_ATIVO           char(1),
   DATE_LASTAJAX        datetime,
   TXT_OBS_HORA         text,
   DESC_LOJA            text,
   primary key (ID_LOJA)
)
auto_increment = 1;

/*==============================================================*/
/* Table: PEDIDO                                                */
/*==============================================================*/
create table PEDIDO
(
   ID_PEDIDO            INT8 not null auto_increment,
   ID_LOJA              INT4,
   ID_USUARIO           INT8,
   DATA_PEDIDO          datetime,
   FLAG_STATUS          CHAR(1),
   VAL_TOTALPROD        NUMERIC(12,2),
   NUM_PED              INT8,
   ID_MODO_PAGAMENTO    int,
   NUM_TELEFONECONTATO_CLIENTE VARCHAR(50),
   TEMPO_ESTIMADO_ENTREGA TIME,
   NOME_PESSOA          text,
   NUM_MESA_ENTREGA     TEXT,
   FLAG_VIZUALIZADO     char(1),
   NUM_TROCOPARA        numeric(12,2),
   DESC_OBSERVACAO      text,
   FLAG_MARCADO         char(1) default 'N',
   primary key (ID_PEDIDO)
)
auto_increment = 1;

/*==============================================================*/
/* Table: PEDIDO_ITEM                                           */
/*==============================================================*/
create table PEDIDO_ITEM
(
   ID_PEDIDO            INT8 not null,
   SEQ_ITEM             INT4 not null,
   VAL_UNIT             NUMERIC(12,2),
   ID_PROD              INT4 not null,
   QTD_PROD             INT8,
   FLAG_RECUSADO        char(1) default 'N',
   RECUSADO_DISPONIVEL  int4,
   primary key (ID_PEDIDO, SEQ_ITEM)
);

/*==============================================================*/
/* Table: PRODUTOS                                              */
/*==============================================================*/
create table PRODUTOS
(
   ID_PROD              INT4 not null auto_increment,
   DESC_PROD            TEXT not null,
   DESC_ABREVIADO       VARCHAR(100) not null,
   FLAG_ATIVO           CHAR(1) not null,
   QTD_IMAGES           int4 default 1,
   ID_CATEGORIA         int4,
   DESC_KEY_WORDS       text,
   VAL_UNIT             numeric(12,2),
   primary key (ID_PROD)
)
auto_increment = 1;

/*==============================================================*/
/* Table: USUARIO                                               */
/*==============================================================*/
create table USUARIO
(
   ID_USUARIO           INT8 not null auto_increment,
   DESC_NOME            TEXT,
   DESC_TELEFONE        VARCHAR(50),
   DESC_USER            VARCHAR(50),
   DESC_SENHA           VARCHAR(50),
   DESC_EMAIL           VARCHAR(150),
   COD_CIDADE           INT4,
   DESC_ENDERECO        TEXT,
   DESC_ENDERECO_NUM    VARCHAR(20),
   DESC_ENDERECO_COMPLEMENTO VARCHAR(20),
   COD_BAIRRO           INT4,
   FLAG_FACEUSER        char(1),
   ID_USER_FACE         bigint,
   FLAG_ATIVADO         char(1),
   CHAVE_ATIVACAO       varchar(100),
   DESC_NOVOEMAILVALIDACAO VARCHAR(150),
   CHAVE_ATIVACAO_NOVOEMAIL VARCHAR(100),
   FLAG_MAIORIDADE      char(1),
   FLAG_LEUTERMOS       char(1),
   FLAG_TIPO            char(1),
   primary key (ID_USUARIO)
)
auto_increment = 1;

alter table BAIRROS add constraint FK_REFERENCE_21 foreign key (COD_CIDADE)
      references CIDADE (COD_CIDADE) on delete restrict on update restrict;

alter table LOJA add constraint FK_REFERENCE_4 foreign key (COD_CIDADE)
      references CIDADE (COD_CIDADE) on delete restrict on update restrict;

alter table LOJA add constraint FK_REFERENCE_5 foreign key (COD_BAIRRO)
      references BAIRROS (COD_BAIRRO) on delete restrict on update restrict;

alter table PEDIDO add constraint FK_REFERENCE_6 foreign key (ID_LOJA)
      references LOJA (ID_LOJA) on delete restrict on update restrict;

alter table PEDIDO add constraint FK_REFERENCE_7 foreign key (ID_USUARIO)
      references USUARIO (ID_USUARIO) on delete restrict on update restrict;

alter table PEDIDO_ITEM add constraint FK_REFERENCE_1 foreign key (ID_PEDIDO)
      references PEDIDO (ID_PEDIDO) on delete restrict on update restrict;

alter table PEDIDO_ITEM add constraint FK_REFERENCE_2 foreign key (ID_PROD)
      references PRODUTOS (ID_PROD) on delete restrict on update restrict;

alter table PRODUTOS add constraint FK_REFERENCE_8 foreign key (ID_CATEGORIA)
      references CATEGORIA (ID_CATEGORIA) on delete restrict on update restrict;

alter table USUARIO add constraint FK_REFERENCE_9 foreign key (COD_BAIRRO)
      references BAIRROS (COD_BAIRRO) on delete restrict on update restrict;

