CREATE TABLE IF NOT EXISTS public.files
(
    id uuid UNIQUE NOT NULL,
    "name" character varying(255) NOT NULL,
    bucket character varying(255) NOT NULL,
    region character varying(255) NOT NULL,
    "type" public.enum_file_types NOT NULL,
	"description" TEXT NOT NULL,
	"status" boolean default true NOT NULL,
    "open" boolean default true NOT NULL,
    revisions integer default 0 NOT NULL,
    created_by uuid NOT NULL,
    updated_by uuid NOT NULL,
    updated_at TIMESTAMP WITH TIME ZONE DEFAULT NOW(),
	created_at TIMESTAMP WITH TIME ZONE DEFAULT NOW(),
    CONSTRAINT files_pkey PRIMARY KEY (id)
);

ALTER TABLE files ADD CONSTRAINT fk_files_created_by FOREIGN KEY (created_by) REFERENCES public.users(id);
ALTER TABLE files ADD CONSTRAINT fk_files_updated_by FOREIGN KEY (updated_by) REFERENCES public.users(id);