CREATE TABLE IF NOT EXISTS public.discussions
(
    id uuid UNIQUE NOT NULL,
    "name" character varying(255) NOT NULL,
	"status" boolean default true NOT NULL,
    "open" boolean default true NOT NULL,
    project_id uuid,
	file_id uuid,
    created_by uuid NOT NULL,
    updated_by uuid NOT NULL,
    updated_at TIMESTAMP WITH TIME ZONE DEFAULT NOW(),
	created_at TIMESTAMP WITH TIME ZONE DEFAULT NOW(),
    CONSTRAINT discussions_pkey PRIMARY KEY (id)
);

ALTER TABLE discussions ADD CONSTRAINT fk_discussions_created_by FOREIGN KEY (created_by) REFERENCES public.users(id);
ALTER TABLE discussions ADD CONSTRAINT fk_discussions_updated_by FOREIGN KEY (updated_by) REFERENCES public.users(id);

ALTER TABLE discussions ADD CONSTRAINT fk_discussions_project_id FOREIGN KEY (project_id) REFERENCES public.projects(id);
ALTER TABLE discussions ADD CONSTRAINT fk_discussions_file_id FOREIGN KEY (file_id) REFERENCES public.files(id);