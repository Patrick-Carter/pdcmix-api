CREATE TABLE IF NOT EXISTS public.project_files
(
    id uuid UNIQUE NOT NULL,
    project_id uuid NOT NULL,
	file_id uuid NOT NULL,
    CONSTRAINT project_files_pkey PRIMARY KEY (id)
);

ALTER TABLE project_files ADD CONSTRAINT fk_project_files_project_id FOREIGN KEY (project_id) REFERENCES public.projects(id);
ALTER TABLE project_files ADD CONSTRAINT fk_project_files_file_id FOREIGN KEY (file_id) REFERENCES public.files(id);