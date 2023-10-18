#!/bin/bash
set -e

psql -v ON_ERROR_STOP=1 --username "postgres" --dbname "recipessource" <<-EOSQL
	CREATE TABLE event
  (
      id        INT8 GENERATED BY DEFAULT AS IDENTITY,
      date      VARCHAR(255),
      location  VARCHAR(255),
      name      VARCHAR(255),
      photo_url VARCHAR(255),
      tradition VARCHAR(7500),
      recipe_id INT8 NOT NULL,
      PRIMARY KEY (id)
  );
  CREATE TABLE recipes
  (
      id                INT8 GENERATED BY DEFAULT AS IDENTITY,
      created_date_time TIMESTAMP,
      photo_url         VARCHAR(255),
      recipe_content    VARCHAR(7500),
      recipe_title      VARCHAR(255),
      update_date_time  TIMESTAMP,
      created_by        INT8 NOT NULL,
      PRIMARY KEY (id)
  );

  CREATE TABLE roles
  (
      id   INT8 GENERATED BY DEFAULT AS IDENTITY,
      name VARCHAR(255),
      PRIMARY KEY (id)
  );

  CREATE TABLE users
  (
      id       INT8 GENERATED BY DEFAULT AS IDENTITY,
      email    VARCHAR(255),
      password VARCHAR(255),
      username VARCHAR(255),
      PRIMARY KEY (id)
  );

  CREATE TABLE users_roles
  (
      user_id INT8 NOT NULL,
      role_id INT8 NOT NULL
  );
EOSQL

exec "$@"