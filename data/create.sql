CREATE TABLE "employee" (
    "id" bigserial   NOT NULL,
    "name" varchar   NOT NULL,
    "surname" varchar   NULL,
    "department" varchar   NULL,
    "birthday" date   NULL,
    "email" varchar   NOT NULL,
    "is_relevant" bool   NULL,
    CONSTRAINT "pk_employee" PRIMARY KEY (
        "id"
     )
);

CREATE TABLE "trip" (
    "id" bigserial   NOT NULL,
    "title" varchar   NOT NULL,
    "description" varchar   NULL,
    "employee_id" int8   NOT NULL,
    "date_start" timestamp   NULL,
    "date_end" timestamp   NULL,
    "status" varchar   NOT NULL,
    CONSTRAINT "pk_trip" PRIMARY KEY (
        "id"
     )
);

CREATE TABLE "ticket" (
    "id" bigserial   NOT NULL,
    "from" varchar   NOT NULL,
    "to" varchar   NOT NULL,
    "date" timestamp   NOT NULL,
    "price" float8   NOT NULL,
    "type" varchar   NOT NULL,
    CONSTRAINT "pk_ticket" PRIMARY KEY (
        "id"
     )
);

CREATE TABLE "user" (
    "id" bigserial   NOT NULL,
    "name" varchar   NOT NULL,
    "email" varchar   NOT NULL,
    "login" varchar   NOT NULL,
    "password" varchar   NOT NULL,
    CONSTRAINT "pk_user" PRIMARY KEY (
        "id"
     )
);

CREATE TABLE "allowance" (
    "id" bigserial   NOT NULL,
    "value" float8   NOT NULL,
    "country" varchar   NOT NULL,
    CONSTRAINT "pk_allowance" PRIMARY KEY (
        "id"
     )
);

CREATE TABLE "trip_ticket" (
    "trip_id" int8   NOT NULL,
    "ticket_id" int8   NOT NULL,
    CONSTRAINT "pk_trip_ticket" PRIMARY KEY (
        "trip_id","ticket_id"
     )
);

CREATE TABLE "trip_allowance" (
    "trip_id" int8   NOT NULL,
    "allowance_id" int8   NOT NULL,
    "days" int4   NOT NULL,
    CONSTRAINT "pk_trip_allowance" PRIMARY KEY (
        "trip_id","allowance_id"
     )
);

ALTER TABLE "trip" ADD CONSTRAINT "fk_trip_employee_id" FOREIGN KEY("employee_id")
REFERENCES "employee" ("id");

ALTER TABLE "trip_ticket" ADD CONSTRAINT "fk_trip_ticket_trip_id" FOREIGN KEY("trip_id")
REFERENCES "trip" ("id");

ALTER TABLE "trip_ticket" ADD CONSTRAINT "fk_trip_ticket_ticket_id" FOREIGN KEY("ticket_id")
REFERENCES "ticket" ("id");

ALTER TABLE "trip_allowance" ADD CONSTRAINT "fk_trip_allowance_trip_id" FOREIGN KEY("trip_id")
REFERENCES "trip" ("id");

ALTER TABLE "trip_allowance" ADD CONSTRAINT "fk_trip_allowance_allowance_id" FOREIGN KEY("allowance_id")
REFERENCES "allowance" ("id");

