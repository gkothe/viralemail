/*==============================================================*/
/* DBMS name:      MySQL 5.0                                    */
/* Created on:     17/7/2017 4:38:04 PM                         */
/*==============================================================*/


drop table if exists CAMPANHA;

drop table if exists CAMPANHA_EMAIL;

drop table if exists CAMPANHA_EMAIL_PREMIO;

drop table if exists CAMPANHA_LANDPAGE;

drop table if exists CAMPANHA_LANDPAGE_FEATURES;

drop table if exists CAMPANHA_LEADS;

drop table if exists CAMPANHA_PREMIOS;

drop table if exists CAMPANHA_THANKSPAGE;

drop table if exists CIDADE;

drop table if exists USUARIO;

/*==============================================================*/
/* Table: CAMPANHA                                              */
/*==============================================================*/
create table CAMPANHA
(
   ID_CAMPANHA          bigint not null auto_increment,
   ID_USUARIO           bigint,
   DATA_CRIACAO         datetime,
   LINK_INICIAL         text,
   primary key (ID_CAMPANHA)
)
auto_increment = 1;

/*==============================================================*/
/* Table: CAMPANHA_EMAIL                                        */
/*==============================================================*/
create table CAMPANHA_EMAIL
(
   ID_EMAIL             bigint not null auto_increment,
   ID_CAMPANHA          bigint,
   DESC_EMAIL           text,
   DESC_TITULO          text,
   primary key (ID_EMAIL)
)
auto_increment = 1;

/*==============================================================*/
/* Table: CAMPANHA_EMAIL_PREMIO                                 */
/*==============================================================*/
create table CAMPANHA_EMAIL_PREMIO
(
   ID_EMAIL             bigint not null,
   ID_PREMIO            bigint not null,
   primary key (ID_EMAIL, ID_PREMIO)
);

/*==============================================================*/
/* Table: CAMPANHA_LANDPAGE                                     */
/*==============================================================*/
create table CAMPANHA_LANDPAGE
(
   ID_LANDPAGE          bigint not null auto_increment,
   ID_CAMPANHA          bigint not null,
   DESC_TITULO_1        text,
   DESC_SUB_TITULO_1    text,
   URL_VIDEO            text,
   DESC_CAMPANHA        text,
   DESC_TITULO_2        text,
   SUB_TITULO_2         text,
   QTD_IMAGE            int,
   primary key (ID_LANDPAGE)
)
auto_increment = 1;

/*==============================================================*/
/* Table: CAMPANHA_LANDPAGE_FEATURES                            */
/*==============================================================*/
create table CAMPANHA_LANDPAGE_FEATURES
(
   ID_LANDPAGE          bigint not null,
   ID_FEATURE           int not null,
   DESC_FEATURE         text,
   DESC_CLASS_ICON      varchar(30),
   primary key (ID_FEATURE, ID_LANDPAGE)
);

/*==============================================================*/
/* Table: CAMPANHA_LEADS                                        */
/*==============================================================*/
create table CAMPANHA_LEADS
(
   ID_LEAD              bigint not null auto_increment,
   ID_CAMPANHA          bigint,
   ID_LEAD_REFERENCIA   bigint,
   DESC_EMAIL           text,
   DESC_LINK_REFERAL    text,
   primary key (ID_LEAD)
)
auto_increment = 1;

/*==============================================================*/
/* Table: CAMPANHA_PREMIOS                                      */
/*==============================================================*/
create table CAMPANHA_PREMIOS
(
   ID_PREMIO            bigint not null auto_increment,
   ID_CAMPANHA          bigint,
   DESC_NAME            text,
   DESC_EXTENSAO        text,
   DESC_PATH            text,
   DATA_INSERCAO        datetime,
   primary key (ID_PREMIO)
)
auto_increment = 1;

/*==============================================================*/
/* Table: CAMPANHA_THANKSPAGE                                   */
/*==============================================================*/
create table CAMPANHA_THANKSPAGE
(
   ID_THANKSPAGE        bigint not null auto_increment,
   ID_CAMPANHA          bigint,
   MSG_THANKS           text,
   SUB_TITULO           text,
   URL_VIDEO            text,
   DESC_FRASE           text,
   DESC_FRASE2          text,
   DESC_TEXTO           text,
   primary key (ID_THANKSPAGE)
)
auto_increment = 1;

/*==============================================================*/
/* Table: CIDADE                                                */
/*==============================================================*/
create table CIDADE
(
   COD_CIDADE           integer not null auto_increment,
   DESC_CIDADE          TEXT not null,
   primary key (COD_CIDADE)
)
auto_increment = 1;

/*==============================================================*/
/* Table: USUARIO                                               */
/*==============================================================*/
create table USUARIO
(
   ID_USUARIO           bigint not null auto_increment,
   COD_CIDADE           integer,
   DESC_NOME            TEXT,
   DESC_TELEFONE        VARCHAR(50),
   DESC_ENDERECO        TEXT not null,
   NUM_ENDEREC          VARCHAR(10) not null,
   DESC_COMPLEMENTO     TEXT,
   DESC_LOGIN           varchar(45),
   DESC_SENHA           varchar(45),
   DESC_MAIL            text,
   FLAG_ATIVO           char(1),
   DATE_LASTAJAX        datetime,
   NUM_CPF              varchar(11),
   DESC_CEP             varchar(8),
   FLAG_ATIVADO         char(1),
   CHAVE_ATIVACAO       varchar(100),
   DESC_NOVOEMAILVALIDACAO varchar(150),
   CHAVE_ATIVACAO_NOVOEMAIL varchar(100),
   primary key (ID_USUARIO)
);

alter table CAMPANHA add constraint FK_REFERENCE_13 foreign key (ID_USUARIO)
      references USUARIO (ID_USUARIO) on delete restrict on update restrict;

alter table CAMPANHA_EMAIL add constraint FK_REFERENCE_6 foreign key (ID_CAMPANHA)
      references CAMPANHA (ID_CAMPANHA) on delete restrict on update restrict;

alter table CAMPANHA_EMAIL_PREMIO add constraint FK_REFERENCE_7 foreign key (ID_PREMIO)
      references CAMPANHA_PREMIOS (ID_PREMIO) on delete restrict on update restrict;

alter table CAMPANHA_EMAIL_PREMIO add constraint FK_REFERENCE_8 foreign key (ID_EMAIL)
      references CAMPANHA_EMAIL (ID_EMAIL) on delete restrict on update restrict;

alter table CAMPANHA_LANDPAGE add constraint FK_REFERENCE_3 foreign key (ID_CAMPANHA)
      references CAMPANHA (ID_CAMPANHA) on delete restrict on update restrict;

alter table CAMPANHA_LANDPAGE_FEATURES add constraint FK_REFERENCE_12 foreign key (ID_LANDPAGE)
      references CAMPANHA_LANDPAGE (ID_LANDPAGE) on delete restrict on update restrict;

alter table CAMPANHA_LEADS add constraint FK_REFERENCE_2 foreign key (ID_CAMPANHA)
      references CAMPANHA (ID_CAMPANHA) on delete restrict on update restrict;

alter table CAMPANHA_LEADS add constraint FK_REFERENCE_9 foreign key (ID_LEAD_REFERENCIA)
      references CAMPANHA_LEADS (ID_LEAD) on delete restrict on update restrict;

alter table CAMPANHA_PREMIOS add constraint FK_REFERENCE_5 foreign key (ID_CAMPANHA)
      references CAMPANHA (ID_CAMPANHA) on delete restrict on update restrict;

alter table CAMPANHA_THANKSPAGE add constraint FK_REFERENCE_4 foreign key (ID_CAMPANHA)
      references CAMPANHA (ID_CAMPANHA) on delete restrict on update restrict;

alter table USUARIO add constraint FK_REFERENCE_11 foreign key (COD_CIDADE)
      references CIDADE (COD_CIDADE) on delete restrict on update restrict;

