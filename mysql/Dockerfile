FROM mysql:8.0

COPY setup.sh /docker-entrypoint-initdb.d/
COPY setup.sql /docker-entrypoint-initdb.d/

RUN chmod +x /docker-entrypoint-initdb.d/setup.sh

CMD ["mysqld"]
