CREATE TABLE IF NOT EXISTS public.p2_price_guide
(
    number_beds integer NOT NULL,
    is_smoking boolean NOT NULL,
    price_per_day numeric(13, 2) NOT NULL DEFAULT 80.00,
    CONSTRAINT composite_key PRIMARY KEY (number_beds, is_smoking)
);

ALTER TABLE public.p2_price_guide
    OWNER to postgres;

COMMENT ON COLUMN public.p2_price_guide.number_beds
    IS 'number_beds basically refers to the size of the room in terms of how many people can fit in each room. Generally, larger rooms cost more.';

COMMENT ON COLUMN public.p2_price_guide.is_smoking
    IS 'Denotes whether or not smoking is allowed in the room. In this case, rooms that allow smoking cost more than rooms that don''t allow smoking because most of the rooms in the hotel do not allow smoking.';

COMMENT ON COLUMN public.p2_price_guide.price_per_day
    IS 'This is the rate that the hotel charges per day.';
    
INSERT INTO public.p2_price_guide(
	number_beds, is_smoking)
	VALUES (1, false);
	
INSERT INTO public.p2_price_guide(
	number_beds, is_smoking, price_per_day)
	VALUES (1, true, 120.00);
	
INSERT INTO public.p2_price_guide(
	number_beds, is_smoking, price_per_day)
	VALUES (2, false, 100.00);
	
INSERT INTO public.p2_price_guide(
	number_beds, is_smoking, price_per_day)
	VALUES (2, true, 150.00);
	
CREATE TABLE IF NOT EXISTS public.p2_rooms
(
    room_id integer NOT NULL GENERATED ALWAYS AS IDENTITY ( START 1 ),
    room_size integer NOT NULL DEFAULT 1,
    room_smokes boolean NOT NULL DEFAULT false,
    CONSTRAINT primary_key PRIMARY KEY (room_id),
    CONSTRAINT price_key FOREIGN KEY (room_size, room_smokes)
        REFERENCES public.p2_price_guide (number_beds, is_smoking) MATCH SIMPLE
        ON UPDATE NO ACTION
        ON DELETE NO ACTION
        NOT VALID
);

ALTER TABLE public.p2_rooms
    OWNER to postgres;

COMMENT ON TABLE public.p2_rooms
    IS 'The selection of rooms available.';

COMMENT ON COLUMN public.p2_rooms.room_id
    IS 'The room number and the id number of this room.';

COMMENT ON COLUMN public.p2_rooms.room_size
    IS 'How many people can fit in the room.';

COMMENT ON COLUMN public.p2_rooms.room_smokes
    IS 'Is smoking allowed in this room? True if yes. Otherwise false.';

COMMENT ON CONSTRAINT price_key ON public.p2_rooms
    IS 'The size of the room and whether smoking is allowed or not determine the overall price per night for the room.';
    
INSERT INTO public.p2_rooms(
	room_size, room_smokes)
	VALUES (1, true);
	
INSERT INTO public.p2_rooms(
	room_size, room_smokes)
	VALUES (2, true);
	
INSERT INTO public.p2_rooms(
	room_size, room_smokes)
	VALUES (1, true);
	
INSERT INTO public.p2_rooms(
	room_size, room_smokes)
	VALUES (1, false);
	
INSERT INTO public.p2_rooms(
	room_size, room_smokes)
	VALUES (2, false);
	
INSERT INTO public.p2_rooms(
	room_size, room_smokes)
	VALUES (1, false);
	
INSERT INTO public.p2_rooms(
	room_size, room_smokes)
	VALUES (2, false);
	
INSERT INTO public.p2_rooms(
	room_size, room_smokes)
	VALUES (1, false);
	
INSERT INTO public.p2_rooms(
	room_size, room_smokes)
	VALUES (2, false);
	
INSERT INTO public.p2_rooms(
	room_size, room_smokes)
	VALUES (1, false);

CREATE TABLE IF NOT EXISTS public.p2_customers
(
    customer_id integer NOT NULL GENERATED ALWAYS AS IDENTITY ( START 1 ),
    email character varying(75) NOT NULL,
    password character varying(75) NOT NULL DEFAULT 'myPass',
    name character varying(75) NOT NULL DEFAULT 'New Customer',
    mobile bigint NOT NULL,
    is_active boolean NOT NULL DEFAULT true,
    CONSTRAINT primary_key_customer PRIMARY KEY (customer_id),
    CONSTRAINT login UNIQUE (email)
);

ALTER TABLE public.p2_customers
    OWNER to postgres;

COMMENT ON TABLE public.p2_customers
    IS 'This table will contain information about the customers.';

COMMENT ON COLUMN public.p2_customers.customer_id
    IS 'Primary key of the customer record.';

COMMENT ON COLUMN public.p2_customers.email
    IS 'customer''s email. This is used in conjunction with password to log in.';

COMMENT ON COLUMN public.p2_customers.password
    IS 'Customer''s password. A Customer will need this and email to log in.';

COMMENT ON COLUMN public.p2_customers.name
    IS 'The Customer''s name. Ideally would be the name of the card holder.';

COMMENT ON COLUMN public.p2_customers.mobile
    IS 'cell phone number.';

COMMENT ON COLUMN public.p2_customers.is_active
    IS 'Is the user active? While I will make sure that delete operations work for these tables, I intend to have user actions to remove their account instead make is_active change to false so we can keep records.';

COMMENT ON CONSTRAINT login ON public.p2_customers
    IS 'for the sake of logging in, emails should be unique.';

INSERT INTO public.p2_customers(
	email, password, name, mobile)
	VALUES ('air@gmail.com', 'tempPass1', 'Airmanon', 9493687788);
	
INSERT INTO public.p2_customers(
	email, password, name, mobile)
	VALUES ('omega@gmail.com', 'tempPass2', 'Omega', 9491230123);
	
INSERT INTO public.p2_customers(
	email, password, name, mobile)
	VALUES ('test@gmail.com', 'tempPass3', 'Test NoSmokeTest', 9497654321);
	
INSERT INTO public.p2_customers(
	email, password, name, mobile)
	VALUES ('charcoal@gmail.com', 'tempPass4', 'Charcoal SmokeTest', 9491234567);

CREATE TABLE IF NOT EXISTS public.p2_payment
(
    card_number bigint NOT NULL,
    expiration_date date NOT NULL,
    customer_id integer NOT NULL,
    PRIMARY KEY (card_number),
    CONSTRAINT customer_pay FOREIGN KEY (customer_id)
        REFERENCES public.p2_customers (customer_id) MATCH SIMPLE
        ON UPDATE CASCADE
        ON DELETE CASCADE
        NOT VALID
);

ALTER TABLE public.p2_payment
    OWNER to postgres;

COMMENT ON TABLE public.p2_payment
    IS 'This table holds the information for paying for the reservations.';

COMMENT ON COLUMN public.p2_payment.card_number
    IS 'Essentially credit or debit card number.';

COMMENT ON COLUMN public.p2_payment.expiration_date
    IS 'When the card expires';

COMMENT ON COLUMN public.p2_payment.customer_id
    IS 'The customer that owns this card';

COMMENT ON CONSTRAINT customer_pay ON public.p2_payment
    IS 'Linking the payment table with the customers table';
   

INSERT INTO public.p2_payment(
	card_number, expiration_date, customer_id)
	VALUES (1234123412341234, '2025-04-19', 1);
	
INSERT INTO public.p2_payment(
	card_number, expiration_date, customer_id)
	VALUES (1231231231231230, '2024-01-23', 2);
	
INSERT INTO public.p2_payment(
	card_number, expiration_date, customer_id)
	VALUES (7979797979797979, '2023-10-20', 3);
	
INSERT INTO public.p2_payment(
	card_number, expiration_date, customer_id)
	VALUES (5885588558855885, '2022-04-20', 4);
	
CREATE TABLE IF NOT EXISTS public.p2_reservations
(
    reservation_id integer NOT NULL GENERATED ALWAYS AS IDENTITY ( START 1 ),
    room_id integer NOT NULL,
    customer_id integer NOT NULL,
    start_date date,
    end_date date,
    total_cost numeric(13, 2),
    paid_for boolean,
    time_made timestamp without time zone,
    PRIMARY KEY (reservation_id),
    CONSTRAINT room_to_room FOREIGN KEY (room_id)
        REFERENCES public.p2_rooms (room_id) MATCH SIMPLE
        ON UPDATE NO ACTION
        ON DELETE NO ACTION
        NOT VALID,
    CONSTRAINT guest_to_customer FOREIGN KEY (customer_id)
        REFERENCES public.p2_customers (customer_id) MATCH SIMPLE
        ON UPDATE NO ACTION
        ON DELETE NO ACTION
        NOT VALID
);

ALTER TABLE public.p2_reservations
    OWNER to postgres;
    
INSERT INTO public.p2_reservations(
	room_id, customer_id, start_date, end_date, total_cost, paid_for, time_made)
	VALUES (6, 1, '2021-12-19', '2021-12-25', 560.00, true, now());