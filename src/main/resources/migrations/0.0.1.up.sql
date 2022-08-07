CREATE TABLE IF NOT EXISTS public.users
(
    id uuid NOT NULL,
    email character varying(255) NOT NULL,
	username character varying(255) NOT NULL,
	encrypted_password character varying(255) NOT NULL,
    email_verification_status boolean NOT NULL,
    email_verification_token character varying(255),
    updated_at date,
	created_at date,
    CONSTRAINT users_pkey PRIMARY KEY (id)
);

create unique index users_email on users(email);