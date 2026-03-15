-- Countries

INSERT INTO countries(name, continent)
VALUES  ('Brazil', 'South America'),
        ('France', 'Europe'),
        ('South Africa', 'Africa'),
        ('New Zealand', 'Oceania'),
        ('India', 'Asia'),
        ('Mexico', 'North America'),
        ('Italy', 'Europe'),
        ('Egypt', 'Africa');

-- Hosts

INSERT INTO hosts(created_at, updated_at, name, surname, country_id)
VALUES  (now(), now(), 'Maria', 'Garcia', (SELECT id FROM countries WHERE name = 'Brazil')),
        (now(), now(), 'Pierre', 'Dubois', (SELECT id FROM countries WHERE name = 'France')),
        (now(), now(), 'Sipho', 'Ndlovu', (SELECT id FROM countries WHERE name = 'South Africa')),
        (now(), now(), 'Emma', 'Smith', (SELECT id FROM countries WHERE name = 'New Zealand')),
        (now(), now(), 'Rahul', 'Sharma', (SELECT id FROM countries WHERE name = 'India')),
        (now(), now(), 'Carlos', 'Ruiz', (SELECT id FROM countries WHERE name = 'Mexico')),
        (now(), now(), 'Giulia', 'Bianchi', (SELECT id FROM countries WHERE name = 'Italy')),
        (now(), now(), 'Amira', 'Hassan', (SELECT id FROM countries WHERE name = 'Egypt'));

-- Accommodations

INSERT INTO accommodations(created_at, updated_at, name, category, host_id, state, num_rooms, rented)
VALUES  (now(), now(), 'Amazonia Lodge', 'HOUSE', (SELECT id FROM hosts WHERE name = 'Maria'), 'GOOD', 5, false),
        (now(), now(), 'Parisian Chic Studio', 'FLAT', (SELECT id FROM hosts WHERE name = 'Pierre'), 'GOOD', 1, true),
        (now(), now(), 'Safari View Resort', 'HOTEL', (SELECT id FROM hosts WHERE name = 'Sipho'), 'GOOD', 45, false),
        (now(), now(), 'Kiwi Breeze Motel', 'MOTEL', (SELECT id FROM hosts WHERE name = 'Emma'), 'BAD', 15, true),
        (now(), now(), 'Taj Gateway', 'ROOM', (SELECT id FROM hosts WHERE name = 'Rahul'), 'GOOD', 2, false),
        (now(), now(), 'Cabo Ocean Villa', 'HOUSE', (SELECT id FROM hosts WHERE name = 'Carlos'), 'GOOD', 6, true),
        (now(), now(), 'Roman Holiday Flat', 'APARTMENT', (SELECT id FROM hosts WHERE name = 'Giulia'), 'BAD', 3, false),
        (now(), now(), 'Nile Delta Room', 'ROOM', (SELECT id FROM hosts WHERE name = 'Amira'), 'GOOD', 1, true);