CREATE TABLE users
(
userid bigserial NOT NULL,
fio character varying(255) NOT NULL,

login character varying(255) NOT NULL,

password character varying(255) NOT NULL,

PRIMARY KEY (userid)
);

CREATE TABLE contact
(
contactid bigserial NOT NULL,

firstname character varying(255) NOT NULL,

lastname character varying(255) NOT NULL,

middlename character varying(255) NOT NULL,

mob_phone_number character varying(255) NOT NULL,

home_phone_number character varying(255),

address character varying(255),

email character varying(255),

userid bigint,

PRIMARY KEY (contactid),
FOREIGN KEY (userid)
REFERENCES users (userid));
