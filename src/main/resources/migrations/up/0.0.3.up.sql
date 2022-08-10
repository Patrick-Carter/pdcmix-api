CREATE TABLE IF NOT EXISTS public.projects
(
    id uuid UNIQUE NOT NULL,
    "name" character varying(255) NOT NULL,
	"description" TEXT NOT NULL,
	"status" boolean default true NOT NULL,
    "open" boolean default true NOT NULL,
    revisions integer default 0 NOT NULL,
    created_by uuid NOT NULL,
    updated_by uuid NOT NULL,
    updated_at TIMESTAMP WITH TIME ZONE DEFAULT NOW(),
	created_at TIMESTAMP WITH TIME ZONE DEFAULT NOW(),
    CONSTRAINT project_pkey PRIMARY KEY (id)
);

ALTER TABLE projects ADD CONSTRAINT fk_projects_created_by FOREIGN KEY (created_by) REFERENCES public.users(id);
ALTER TABLE projects ADD CONSTRAINT fk_projects_updated_by FOREIGN KEY (updated_by) REFERENCES public.users(id);