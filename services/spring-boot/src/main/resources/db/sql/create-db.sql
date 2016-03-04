CREATE SCHEMA "STORE";
CREATE TABLE "STORE"."ITEMS" ("ID" INTEGER NOT NULL, "NAME" VARCHAR(100), "DESCRIPTION" VARCHAR(2000), "PRICE" DECIMAL(10,2), "SHORTNAME" VARCHAR(20));
ALTER TABLE "STORE"."ITEMS" ADD CONSTRAINT "SQL160219014409770" PRIMARY KEY ("ID");