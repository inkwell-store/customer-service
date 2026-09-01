-- Create a customer wilson
INSERT INTO CUSTOMER_TBL(
    id, 
    credential_id, 
    first_name, 
    last_name, 
    created_at)
VALUES (
    'd93b80e3-11c3-4829-b558-fa51c82d2868', 
    '02f2ad05-5707-4f25-b48f-6d36143011c1', 
    'Wilson', 
    'Barbosa', 
    '2026-08-10 19:45:09.94351+00');

-- Add three addresses for wilson
INSERT INTO ADDRESS_TBL (
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
        'Lake Shore Drive',
        2250,
        'Chicago',
        'IL',
        '60611',
        'Unit 1203',
        'SHIPPING',
        'd93b80e3-11c3-4829-b558-fa51c82d2868'
    );