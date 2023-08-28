-- Test inserts in brand table
INSERT INTO brand (
    id,
    name,
    description
)
VALUES (
    nextval('brand_seq'),
    'ZARA',
    'Corresponding to ZARA store'
);

INSERT INTO brand (
    id,
    name,
    description
) VALUES (
    nextval('brand_seq'),
    'PULL',
    'Corresponding to PULL store'
);

-- Test inserts in prices table
INSERT INTO prices (
    id,
    brand_id,
    start_date,
    end_date,
    price_list,
    product_id,
    priority,
    price,
    curr
)
VALUES (
    nextval('prices_seq'),
    (SELECT ID FROM brand WHERE NAME='ZARA'),
    parsedatetime('2020-06-14-00.00.00', 'yyyy-MM-dd-HH.mm.ss'),
    parsedatetime('2020-12-31-23.59.59', 'yyyy-MM-dd-HH.mm.ss'),
    1,
    35455,
    0,
    35.50,
    'EUR'
);

INSERT INTO prices (
    id,
    brand_id,
    start_date,
    end_date,
    price_list,
    product_id,
    priority,
    price,
    curr
)
VALUES (
    nextval('prices_seq'),
    (SELECT ID FROM brand WHERE NAME='ZARA'),
    parsedatetime('2020-06-14-15.00.00', 'yyyy-MM-dd-HH.mm.ss'),
    parsedatetime('2020-06-14-18.30.00', 'yyyy-MM-dd-HH.mm.ss'),
    2,
    35455,
    1,
    25.45,
    'EUR'
);

INSERT INTO prices (
    id,
    brand_id,
    start_date,
    end_date,
    price_list,
    product_id,
    priority,
    price,
    curr
)
VALUES (
    nextval('prices_seq'),
    (SELECT ID FROM brand WHERE NAME='ZARA'),
    parsedatetime('2020-06-15-00.00.00', 'yyyy-MM-dd-HH.mm.ss'),
    parsedatetime('2020-06-15-11.00.00', 'yyyy-MM-dd-HH.mm.ss'),
    3,
    35455,
    1,
    30.50,
    'EUR'
);

INSERT INTO prices (
    id,
    brand_id,
    start_date,
    end_date,
    price_list,
    product_id,
    priority,
    price,
    curr
)
VALUES (
    nextval('prices_seq'),
    (SELECT ID FROM brand WHERE NAME='ZARA'),
    parsedatetime('2020-06-15-16.00.00', 'yyyy-MM-dd-HH.mm.ss'),
    parsedatetime('2020-12-31-23.59.59', 'yyyy-MM-dd-HH.mm.ss'),
    4,
    35455,
    1,
    38.95,
    'EUR'
);