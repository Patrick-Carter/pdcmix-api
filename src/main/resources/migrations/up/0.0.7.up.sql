CREATE TABLE IF NOT EXISTS public.notifications
(
    id uuid UNIQUE NOT NULL,
    "notification" character varying(255) NOT NULL,
    CONSTRAINT notifications_pkey PRIMARY KEY (id)
);

CREATE TABLE IF NOT EXISTS public.permissions
(
    id uuid UNIQUE NOT NULL,
    "permission" character varying(255) NOT NULL,
    CONSTRAINT permissions_pkey PRIMARY KEY (id)
);


