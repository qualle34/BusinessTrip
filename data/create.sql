CREATE TABLE "allowance" (
    "id" bigserial   NOT NULL,
    "value" float8   NOT NULL,
    "country" varchar   NOT NULL,
    CONSTRAINT "pk_allowance" PRIMARY KEY (
        "id"
     )
);

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

CREATE TABLE "ticket" (
    "id" bigserial   NOT NULL,
    "member_id" int8   NOT NULL,
    "from" varchar   NOT NULL,
    "to" varchar   NOT NULL,
    "date" timestamp   NOT NULL,
    "price" float8   NOT NULL,
    "type" varchar   NOT NULL,
    CONSTRAINT "pk_ticket" PRIMARY KEY (
        "id"
     )
);

CREATE TABLE "trip" (
    "id" bigserial   NOT NULL,
    "title" varchar   NOT NULL,
    "description" varchar   NULL,
    "date_start" timestamp   NULL,
    "date_end" timestamp   NULL,
    "status" varchar   NOT NULL,
    "additional_expenses" float8   NULL,
    CONSTRAINT "pk_trip" PRIMARY KEY (
        "id"
     )
);

CREATE TABLE "member_allowance" (
    "member_id" int8   NOT NULL,
    "allowance_id" int8   NOT NULL,
    "days" int4   NOT NULL,
    CONSTRAINT "pk_member_allowance" PRIMARY KEY (
        "member_id","allowance_id"
     )
);

CREATE TABLE "member" (
    "id" bigserial   NOT NULL,
    "employee_id" int8   NOT NULL,
    "trip_id" int8   NOT NULL,
    "role" varchar   NOT NULL,
    CONSTRAINT "pk_member" PRIMARY KEY (
        "id"
     )
);

ALTER TABLE "ticket" ADD CONSTRAINT "fk_ticket_member_id" FOREIGN KEY("member_id")
REFERENCES "member" ("id");

ALTER TABLE "member_allowance" ADD CONSTRAINT "fk_member_allowance_member_id" FOREIGN KEY("member_id")
REFERENCES "member" ("id");

ALTER TABLE "member_allowance" ADD CONSTRAINT "fk_member_allowance_allowance_id" FOREIGN KEY("allowance_id")
REFERENCES "allowance" ("id");

ALTER TABLE "member" ADD CONSTRAINT "fk_member_employee_id" FOREIGN KEY("employee_id")
REFERENCES "employee" ("id");

ALTER TABLE "member" ADD CONSTRAINT "fk_member_trip_id" FOREIGN KEY("trip_id")
REFERENCES "trip" ("id");