CREATE TABLE IF NOT EXISTS owner
(
    id UUID NOT NULL DEFAULT gen_random_uuid(),
    name VARCHAR(256) NOT NULL,
    address VARCHAR(1024) NOT NULL,
    city VARCHAR(256) NOT NULL,
    telephone VARCHAR(10) NOT NULL,
    CONSTRAINT owner_pkey PRIMARY KEY (id)
);

CREATE TABLE IF NOT EXISTS car
(
    id UUID NOT NULL DEFAULT gen_random_uuid(),
    model_id UUID NOT NULL,
    mark_id UUID NOT NULL,
    plate_number VARCHAR(10) NOT NULL,
    owner_id UUID NOT NULL,
    CONSTRAINT car_pkey PRIMARY KEY (id),
    CONSTRAINT car_ownerid_fkey FOREIGN KEY (owner_id) REFERENCES owner(id)
);

CREATE TABLE IF NOT EXISTS repairing
(
    id UUID NOT NULL DEFAULT gen_random_uuid(),
    car_service_name VARCHAR(256) NOT NULL,
    car_service_address VARCHAR(1024) NOT NULL,
    visit_date_time TIMESTAMP NOT NULL,
    car_id UUID NOT NULL,
    CONSTRAINT repairing_pkey PRIMARY KEY (id),
    CONSTRAINT repairing_carid_fkey FOREIGN KEY (car_id) REFERENCES car(id)
);