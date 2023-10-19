FROM postgres
LABEL authors="stryk"

COPY ./preloaded_db.sql /docker-entrypoint-initdb.d/preloaded_db.sql
RUN chmod -R 644 ./docker-entrypoint-initdb.d/preloaded_db.sql
CMD ["docker-entrypoint.sh", "postgres"]