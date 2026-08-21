INSERT INTO vendors (id, name, address, location, stock_capacity)
SELECT 1, 'Sharma General Store', 'MG Road, Solapur', ST_SetSRID(ST_MakePoint(75.9064, 17.6599), 4326), 500
WHERE NOT EXISTS (SELECT 1 FROM vendors WHERE id = 1);

INSERT INTO vendors (id, name, address, location, stock_capacity)
SELECT 2, 'Patil Kirana', 'Station Road, Solapur', ST_SetSRID(ST_MakePoint(75.9100, 17.6650), 4326), 300
WHERE NOT EXISTS (SELECT 1 FROM vendors WHERE id = 2);

INSERT INTO vendors (id, name, address, location, stock_capacity)
SELECT 3, 'Deshmukh Mart', 'Ashok Chowk, Solapur', ST_SetSRID(ST_MakePoint(75.9200, 17.6700), 4326), 700
WHERE NOT EXISTS (SELECT 1 FROM vendors WHERE id = 3);
