INSERT INTO departments (department_id, department_name, location)
VALUES 
    ('D001', 'Human Resources', 'Floor 5'),
    ('D002', 'Finance', 'Floor 3'),
    ('D003', 'Marketing', 'Floor 2'),
    ('D004', 'Operations', 'Floor 4'),
    ('D005', 'IT', 'Floor 6');
INSERT INTO people (person_id, full_name, position, phone, email)
VALUES 
    ('P001', 'John Doe', 'HR Manager', '123-456-789', 'john.doe@example.com'),
    ('P002', 'Jane Smith', 'Accountant', '987-654-321', 'jane.smith@example.com'),
    ('P003', 'Michael Johnson', 'Marketing Specialist', '555-555-555', 'michael.johnson@example.com'),
    ('P004', 'Emily Brown', 'Operations Manager', '777-777-777', 'emily.brown@example.com'),
    ('P005', 'David Lee', 'IT Director', '999-999-999', 'david.lee@example.com');
INSERT INTO facilities (facility_id, facility_name, description, purchase_date, price, status, location, department_id)
VALUES 
    ('F001', 'Conference Room', 'Large room for meetings', '2024-04-18', 2000.0, 'AVAILABLE', 'Floor 5', 'D001'),
    ('F002', 'Office Printer', 'High-speed laser printer', '2024-04-18', 1000.0, 'IN_USE', 'Floor 3', 'D002'),
    ('F003', 'Marketing Campaign Materials', 'Printed materials for campaigns', '2024-04-18', 1500.0, 'UNDER_MAINTENANCE', 'Floor 2', 'D003'),
    ('F004', 'Warehouse Space', 'Storage space for operations', '2024-04-18', 3000.0, 'AVAILABLE', 'Floor 4', 'D004'),
    ('F005', 'Server Room', 'Data center for IT infrastructure', '2024-04-18', 5000.0, 'IN_USE', 'Floor 6', 'D005');
INSERT INTO maintenances (start_date, end_date, description, cost, facility_id, person_id)
VALUES 
    ('2024-04-18', '2024-04-20', 'Repair air conditioning', 500.0, 'F001', 'P001'),
    ('2024-04-19', '2024-04-21', 'Replace toner cartridge', 200.0, 'F002', 'P002'),
    ('2024-04-20', '2024-04-22', 'Update marketing materials', 700.0, 'F003', 'P003'),
    ('2024-04-21', '2024-04-23', 'Fix warehouse door', 600.0, 'F004', 'P004'),
    ('2024-04-22', '2024-04-24', 'Upgrade server software', 1000.0, 'F005', 'P005');
