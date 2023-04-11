# Quarkus Reactive SQL

## Comandos do Docker:

### Servidor PostgreSQL

docker run -d --name postgresql --net rede1 --hostname postgresql.docker -e POSTGRES_PASSWORD=senha -p 5432:5432 postgres:alpine

### Cliente PostgreSQL

docker run -it --rm --net rede1 postgres:alpine psql -h postgresql -U quarkus -d quarkus

## Comandos do PostgreSQL:

### Criação de Usuário

```
CREATE USER QUARKUS WITH
LOGIN
PASSWORD 'senha@quarkus';
```

### Criação de Database

```
CREATE DATABASE QUARKUS WITH
OWNER=QUARKUS
ENCODING=UTF8;
```

### Criação de Tabela

```
CREATE TABLE TESTE AS
SELECT
  GENERATE_SERIES AS ID,
  'nome' || GENERATE_SERIES AS NOME
FROM GENERATE_SERIES(1,5);
```

### Alteração de Owner

```
ALTER TABLE TESTE OWNER TO QUARKUS;
```

### Drop dos Objetos

```
DROP TABLE TESTE;
DROP DATABASE QUARKUS;
DROP USER QUARKUS;
```