CREATE SCHEMA IF NOT EXISTS DETAILS;

CREATE TABLE DETAILS.DETAIL ("ID" INTEGER not null primary key, "DIRECTOR" VARCHAR(50) not null, "YEAR" INT, "TYPE" VARCHAR(20), "PUBLISHER" VARCHAR(50));