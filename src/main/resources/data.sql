-- Create a customer wilson
INSERT INTO CUSTOMER_TBL(
    id, 
    credential_id, 
    first_name, 
    last_name,
    photo,
    date_of_birth,    
    created_at)
VALUES (
    'd93b80e3-11c3-4829-b558-fa51c82d2868', 
    '02f2ad05-5707-4f25-b48f-6d36143011c1', 
    'Wilson Diego', 
    'Barbosa', 
    'happy-dog.jpg',
    '2007-12-03',
    '2026-08-10 19:45:09.94351+00');

-- Add three addresses for wilson
INSERT INTO ADDRESS_TBL (
    name,
    street,
    number,
    city,
    state,
    postal_code,
    line,
    type,
    customer_id
)
VALUES
    (
        'My house',
        'Main Street',
        742,
        'Austin',
        'TX',
        '78701',
        'Apartment 4B',
        'SHIPPING',
        'd93b80e3-11c3-4829-b558-fa51c82d2868'
    ),
    (
        'Company',
        'Market Street',
        135,
        'San Francisco',
        'CA',
        '94105',
        NULL,
        'BILLING',
        'd93b80e3-11c3-4829-b558-fa51c82d2868'
    ),
    (
        'Some custom name',
        'Lake Shore Drive',
        2250,
        'Chicago',
        'IL',
        '60611',
        'Unit 1203',
        'BILLING_AND_SHIPPING',
        'd93b80e3-11c3-4829-b558-fa51c82d2868'
    );

-- Create a new test user 
INSERT INTO CUSTOMER_TBL(
    id, 
    credential_id, 
    first_name, 
    last_name,
    photo,
    date_of_birth,    
    created_at)
VALUES (
    '36365124-a55d-4cbb-8509-6ff868a37a97', 
    'e4825462-f160-41db-9cc0-69a7f5279b52', 
    'NOT_SET_YET', 
    'NOT_SET_YET', 
    NULL,
    NULL,
    '2026-08-10 19:45:09.94351+00');
