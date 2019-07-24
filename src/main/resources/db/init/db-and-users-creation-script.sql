CREATE USER 'event-user' WITH PASSWORD 'event-password';
ALTER USER 'event-user' WITH SUPERUSER;

CREATE USER 'flyway' WITH PASSWORD 'flyway';
ALTER USER 'flyway' WITH SUPERUSER;

DROP DATABASE IF EXISTS 'event_service';
CREATE DATABASE 'event_service';