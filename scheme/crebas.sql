/*==============================================================*/
/* DBMS name:      MySQL 5.0                                    */
/* Created on:     27/7/2017 7:56:51 PM                         */
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

drop table if exists ESTADO;

drop table if exists SYS_PARAMETROS;

drop table if exists USER_IMAGE;

drop table if exists USER_IMAGE_PAGE;

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
   DESC_NOME            text,
   DESC_OBS             text,
   FLAG_ATIVO           char(1) default 'S',
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
   ID_CAMPANHA          bigint,
   DESC_TITULO_1        text,
   DESC_SUB_TITULO_1    text,
   URL_VIDEO            text,
   DESC_CAMPANHA        text,
   DESC_TITULO_2        text,
   SUB_TITULO_2         text,
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
   DESC_NAME            text,
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
   ID_ESTADO            int,
   DESC_CIDADE          TEXT not null,
   primary key (COD_CIDADE)
)
auto_increment = 1;

/*==============================================================*/
/* Table: ESTADO                                                */
/*==============================================================*/
create table ESTADO
(
   ID_ESTADO            int not null auto_increment,
   DESC_UF              varchar(4),
   DESC_ESTADO          text,
   primary key (ID_ESTADO)
)
auto_increment = 1;

/*==============================================================*/
/* Table: SYS_PARAMETROS                                        */
/*==============================================================*/
create table SYS_PARAMETROS
(
   ID_PARAM             INT4 not null,
   ID_USUARIO_ADMIN     INT8,
   ID_VISITANTE         bigint,
   FLAG_MANUTENCAO      char(1),
   DESC_KEY             text,
   SEGS_TESTE_AJAX      bigint,
   FACE_APP_ID          bigint,
   FACE_APP_SECRETKEY   text,
   FACE_APP_TOKEN       text,
   FACE_REDIRECT_URI    text,
   URL_SYSTEM           text,
   SYS_HOST_NAME_SMTP   text,
   SYS_SMTP_PORT        int4,
   SYS_EMAIL            text,
   SYS_SENHA            text,
   SYS_FROMEMAIL        text,
   SYS_FROMDESC         text,
   SYS_TLS              char(1),
   PED_HORASOKEY        int,
   NUM_MINUTOS_NOT_FINAL int,
   NUM_TEMPOMAXCANC_MINUTO int,
   COD_RECUSA           int,
   ONESIGNAL_KEY        text,
   ONESIGNAL_APPID      text,
   ONESIGNAL_URL        text,
   NUM_SEGS_NOT_FINAL_EXEC int,
   COD_CANCELAMENTOSYS  int,
   DESC_WEBAPPFOLDER    text,
   IGNORAR_REGRAMAIOR18 char(1),
   FACE_REDIRECT_URI_WEBAPP text,
   TRAGOAQUI_NUM_TELEFONE text,
   TRAGOAQUI_PAG_FACEBOOK text,
   APP_VERSAO           text,
   APPLICACAO           int,
   SYS_MINUTES_AGEN_NOT_RESP int,
   URL_WEBSOCKET        text,
   primary key (ID_PARAM)
);

/*==============================================================*/
/* Table: USER_IMAGE                                            */
/*==============================================================*/
create table USER_IMAGE
(
   ID_IMAGE             bigint not null,
   ID_USUARIO           bigint,
   DESC_IMAGE           text,
   DESC_PATH_SYSTEM     text,
   primary key (ID_IMAGE)
);

/*==============================================================*/
/* Table: USER_IMAGE_PAGE                                       */
/*==============================================================*/
create table USER_IMAGE_PAGE
(
   ID_ASSOCIACAO        bigint not null auto_increment,
   ID_IMAGE             bigint,
   ID_CAMPANHA          bigint,
   ID_PAGE              text,
   FLAG_PAGETIPE        char(1),
   primary key (ID_ASSOCIACAO)
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

alter table CIDADE add constraint FK_REFERENCE_14 foreign key (ID_ESTADO)
      references ESTADO (ID_ESTADO) on delete restrict on update restrict;

alter table USER_IMAGE add constraint FK_REFERENCE_15 foreign key (ID_USUARIO)
      references USUARIO (ID_USUARIO) on delete restrict on update restrict;

alter table USER_IMAGE_PAGE add constraint FK_REFERENCE_16 foreign key (ID_IMAGE)
      references USER_IMAGE (ID_IMAGE) on delete restrict on update restrict;

alter table USER_IMAGE_PAGE add constraint FK_REFERENCE_17 foreign key (ID_CAMPANHA)
      references CAMPANHA (ID_CAMPANHA) on delete restrict on update restrict;

alter table USUARIO add constraint FK_REFERENCE_11 foreign key (COD_CIDADE)
      references CIDADE (COD_CIDADE) on delete restrict on update restrict;

