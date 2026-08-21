INSERT INTO vendors (name, address, location, stock_capacity)
VALUES
('Sharma General Store', 'MG Road, Solapur', ST_SetSRID(ST_MakePoint(75.9064, 17.6599), 4326), 500),
('Patil Kirana', 'Station Road, Solapur', ST_SetSRID(ST_MakePoint(75.9100, 17.6650), 4326), 300),
('Deshmukh Mart', 'Ashok Chowk, Solapur', ST_SetSRID(ST_MakePoint(75.9200, 17.6700), 4326), 700)
ON CONFLICT DO NOTHING;
