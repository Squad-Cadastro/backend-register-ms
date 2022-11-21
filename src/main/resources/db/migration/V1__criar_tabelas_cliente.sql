CREATE TABLE cliente_informacoes (
"id" serial not null,
"nome" varchar(255) not null,
"documento" varchar(14) unique not null,
"tipo_pessoa" char(1) not null , --M para masculino ou F para feminino
"data_nascimento" DATE not null,
"email" varchar(255) not null,
"telefone" varchar(11) not null,
"data_criacao" timestamp not null,
"data_atualizacao" timestamp,
CONSTRAINT cliente_informacoes_pk PRIMARY KEY ("id")
);

CREATE TABLE cliente_endereco (
"id" serial not null,
"logradouro" varchar(255) not null,
"principal" boolean not null,
"numero" varchar(10),
"cep" varchar(10) not null,
"bairro" varchar(255),
"localidade" varchar(255) not null,
"uf" varchar(2) not null,
"cliente_informacoes_id" serial,
CONSTRAINT cliente_endereco_pk PRIMARY KEY ("id"),
CONSTRAINT cliente_endereco_fk
      FOREIGN KEY("cliente_informacoes_id")
	  REFERENCES cliente_informacoes("id")
);
