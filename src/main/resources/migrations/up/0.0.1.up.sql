CREATE TABLE IF NOT EXISTS public.users
(
    id uuid UNIQUE NOT NULL,
    email character varying(255) UNIQUE NOT NULL,
	username character varying(255) NOT NULL,
	encrypted_password character varying(255) NOT NULL,
    email_verification_status boolean NOT NULL,
    email_verification_token character varying(255),
    updated_at TIMESTAMP WITH TIME ZONE DEFAULT NOW(),
	created_at TIMESTAMP WITH TIME ZONE DEFAULT NOW(),
    CONSTRAINT users_pkey PRIMARY KEY (id)
);

