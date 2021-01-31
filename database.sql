    set names none;

    set sql dialect 3;

    set clientlib 'gds32.dll';

    create database 'KUTUPHANEMU'
    user "SYSDBA" password 'ktp135'
    page_size 8192
    default character set none;

CREATE GENERATOR GEN_VISIT_ID;

CREATE TABLE VISIT (
    ID          INTEGER,
    FIRSTNAME   VARCHAR(100),
    LASTNAME    VARCHAR(100),
    MOBILE      VARCHAR(20),
    ADDRESS     VARCHAR(100),
    CITY        VARCHAR(100),
    BLOODGROUP  VARCHAR(6)
);

/* Trigger: TRG_VISIT_ID */
CREATE OR ALTER TRIGGER TRG_VISIT_ID FOR VISIT
ACTIVE BEFORE INSERT OR UPDATE POSITION 0
as
begin
  if ((new.ID is null) or (new.ID=0)) then
    new.ID = gen_id(GEN_VISIT_ID, 1);
  else if ((new.ID) > gen_id(GEN_VISIT_ID, 0)) then
  begin
    execute statement 'set generator GEN_VISIT_ID to ' || new.ID;
  end
end;

CREATE GENERATOR GEN_NEXT_ID;

CREATE TABLE CITY (
    CODE         VARCHAR(30),
    DESCRIPTION  VARCHAR(100),
    ID           INTEGER
);


/* Trigger: TRG_CITY_ID */
CREATE OR ALTER TRIGGER TRG_CITY_ID FOR CITY
ACTIVE BEFORE INSERT OR UPDATE POSITION 0
as
begin
  if ((new.ID is null) or (new.ID=0)) then
    new.ID = gen_id(GEN_NEXT_ID, 1);
  else if ((new.ID) > gen_id(GEN_NEXT_ID, 0)) then
  begin
    execute statement 'set generator GEN_NEXT_ID to ' || new.ID;
  end
end;
