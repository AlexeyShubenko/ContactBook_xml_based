# ContactBook_xml_based
Spring, Hibernate, xml configuration
1.
create database agricultural;

2.
\connect agricultural;

3.
CREATE TABLE workplace (
id bigserial NOT NULL,
name character varying(255),
PRIMARY KEY (id));

CREATE TABLE employee(
id bigserial NOT NULL,
fio character varying(255),
wage int,
position character varying(255),
workplace_id bigint,
PRIMARY KEY (id),
CONSTRAINT FK_Workplaca FOREIGN KEY (workplace_id) REFERENCES workplace (id));

CREATE TABLE operations(
id bigserial NOT NULL,
operation character varying(255),
PRIMARY KEY (id));

CREATE TABLE machines(
id bigserial NOT NULL,
machine character varying(255),
PRIMARY KEY (id)
);

CREATE TABLE detaildatahectare(
id bigserial NOT NULL,
cultivatedArea character varying(255),
givenFuel character varying(255),
machine character varying(255),
operation character varying(255),
usedFuelArea character varying(255) ,
PRIMARY KEY (id)
);

CREATE TABLE detaildatahour(
id bigserial NOT NULL,
givenFuel character varying(255),
machine character varying(255),
operation character varying(255),
usedFuelArea character varying(255),
workedHours character varying(255),
PRIMARY KEY (id)
);


CREATE TABLE hectaretable (
id bigserial NOT NULL ,
PRIMARY KEY (id)
);

CREATE TABLE hectaremade (
id bigserial NOT NULL,
cultivatedarea double precision,
givenfuel double precision,
usedfuel double precision,
workcost double precision,
overallworkcost double precision,
machine_id bigint,
operation_id bigint,
hect_id bigint,
detailHect_id bigint,
PRIMARY KEY (id),
CONSTRAINT FK_MachineHectare FOREIGN KEY (machine_id) REFERENCES machines (id),
CONSTRAINT FK_DetailHectare FOREIGN KEY (detailHect_id) REFERENCES detaildatahectare (id),
CONSTRAINT FK_HectareTable FOREIGN KEY (hect_id) REFERENCES hectaretable (id),
CONSTRAINT FK_OperationHectare  FOREIGN KEY (operation_id) REFERENCES operations (id)
);

CREATE TABLE hourtable (
id bigserial NOT NULL,
PRIMARY KEY (id)
);

CREATE TABLE hourmade (
id bigserial NOT NULL,
workedHours double precision,
givenfuel double precision,
usedfuel double precision,
workcost double precision,
overallworkcost double precision,
machine_id bigint,
operation_id bigint,
hour_id bigint,
detailHour_id bigint,
PRIMARY KEY (id),
CONSTRAINT FK_MachineHour FOREIGN KEY (machine_id) REFERENCES machines (id),
CONSTRAINT FK_DetailHour FOREIGN KEY (detailHour_id) REFERENCES detaildatahour (id),
CONSTRAINT FK_HourTable FOREIGN KEY (hour_id) REFERENCES hourtable (id),
CONSTRAINT FK_OperationHour  FOREIGN KEY (operation_id) REFERENCES operations (id)
);

CREATE TABLE dateandinformation (
id bigserial NOT NULL,
month character varying(255),
year int,
empl_id bigint,
hect_id bigint,
hour_id bigint,
PRIMARY KEY (id),
CONSTRAINT FK_HectareTableDate FOREIGN KEY (hect_id) REFERENCES hectaretable (id),
CONSTRAINT FK_Employee  FOREIGN KEY (empl_id) REFERENCES employee (id),
CONSTRAINT FK_HourTableDate  FOREIGN KEY (hour_id) REFERENCES hourtable (id)
);
