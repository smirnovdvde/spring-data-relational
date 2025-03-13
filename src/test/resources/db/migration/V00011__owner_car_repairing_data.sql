INSERT INTO owner (id, name, address, city, telephone)
VALUES ('0df29411-adef-4dca-9297-2d83c5c73321', 'John Smith', 'Pushkina str 8', 'London', '9991234567');
INSERT INTO owner (id, name, address, city, telephone)
VALUES ('d6425a6a-5914-475d-a217-b51487a26a20', 'Samanta Power', 'Lenina str 12', 'Paris', '3331234567');

INSERT INTO car (id, model_id, mark_id, plate_number, owner_id)
VALUES ('b4e4ab1f-29d5-4397-b793-5fcb6343eca2', 'f5140f96-1bfe-48f3-81bf-b10eabd0ecd2',
        'f07c4287-a190-43b0-ab1c-5c1613507bf8',
        'XX1234YY', '0df29411-adef-4dca-9297-2d83c5c73321');

INSERT INTO repairing (id, car_service_name, car_service_address, visit_date_time, car_id)
VALUES ('bd016e07-3993-4d3b-a9d7-b92a2f04ec4b', 'super service', 'London, Stalina str 3',
        '2025-03-10T18:00:41+00:00','b4e4ab1f-29d5-4397-b793-5fcb6343eca2');

INSERT INTO repairing (id, car_service_name, car_service_address, visit_date_time, car_id)
VALUES ('2b9a2107-1402-4310-b510-b2150f73b2c7', 'super service', 'London, Stalina str 3',
        '2025-03-09T18:00:41+00:00','b4e4ab1f-29d5-4397-b793-5fcb6343eca2');