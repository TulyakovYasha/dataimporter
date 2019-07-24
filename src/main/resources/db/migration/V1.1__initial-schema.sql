CREATE TABLE events
(
  sso_id         VARCHAR PRIMARY KEY,
  ts             BIGINT  NOT NULL,
  grp            VARCHAR NOT NULL,
  type           VARCHAR NOT NULL,
  subtype        VARCHAR NOT NULL,
  url            VARCHAR,
  org_id         VARCHAR,
  form_id        VARCHAR,
  ltpa           VARCHAR,
  sudir_response VARCHAR,
  ymdh           VARCHAR NOT NULL
);
