CREATE TABLE IF NOT EXISTS public.user_project_permissions
(
    id uuid UNIQUE NOT NULL,
    user_id uuid NOT NULL,
    project_id uuid NOT NULL,
    permission_id uuid NOT NULL,
    created_by uuid NOT NULL,
	created_at TIMESTAMP WITH TIME ZONE DEFAULT NOW(),
    CONSTRAINT user_project_permissions_pkey PRIMARY KEY (id)
);

ALTER TABLE user_project_permissions ADD CONSTRAINT fk_user_project_permissions_created_by FOREIGN KEY (created_by) REFERENCES public.users(id);
ALTER TABLE user_project_permissions ADD CONSTRAINT fk_user_project_permissions_user_id FOREIGN KEY (user_id) REFERENCES public.users(id);
ALTER TABLE user_project_permissions ADD CONSTRAINT fk_user_project_permissions_project_id FOREIGN KEY (project_id) REFERENCES public.projects(id);
ALTER TABLE user_project_permissions ADD CONSTRAINT fk_user_project_permissions_permission_id FOREIGN KEY (permission_id) REFERENCES public.permissions(id);

CREATE TABLE IF NOT EXISTS public.user_file_permissions
(
    id uuid UNIQUE NOT NULL,
    user_id uuid NOT NULL,
    file_id uuid NOT NULL,
    permission_id uuid NOT NULL,
    created_by uuid NOT NULL,
	created_at TIMESTAMP WITH TIME ZONE DEFAULT NOW(),
    CONSTRAINT user_file_permissions_pkey PRIMARY KEY (id)
);

ALTER TABLE user_file_permissions ADD CONSTRAINT fk_user_file_permissions_created_by FOREIGN KEY (created_by) REFERENCES public.users(id);
ALTER TABLE user_file_permissions ADD CONSTRAINT fk_user_file_permissions_user_id FOREIGN KEY (user_id) REFERENCES public.users(id);
ALTER TABLE user_file_permissions ADD CONSTRAINT fk_user_file_permissions_file_id FOREIGN KEY (file_id) REFERENCES public.files(id);
ALTER TABLE user_file_permissions ADD CONSTRAINT fk_user_file_permissions_permission_id FOREIGN KEY (permission_id) REFERENCES public.permissions(id);

CREATE TABLE IF NOT EXISTS public.user_discussion_permissions
(
    id uuid UNIQUE NOT NULL,
    user_id uuid NOT NULL,
    discussion_id uuid NOT NULL,
    permission_id uuid NOT NULL,
    created_by uuid NOT NULL,
	created_at TIMESTAMP WITH TIME ZONE DEFAULT NOW(),
    CONSTRAINT user_discussion_permissions_pkey PRIMARY KEY (id)
);

ALTER TABLE user_discussion_permissions ADD CONSTRAINT fk_user_discussion_permissions_created_by FOREIGN KEY (created_by) REFERENCES public.users(id);
ALTER TABLE user_discussion_permissions ADD CONSTRAINT fk_user_discussion_permissions_user_id FOREIGN KEY (user_id) REFERENCES public.users(id);
ALTER TABLE user_discussion_permissions ADD CONSTRAINT fk_user_discussion_permissions_discussion_id FOREIGN KEY (discussion_id) REFERENCES public.discussions(id);
ALTER TABLE user_discussion_permissions ADD CONSTRAINT fk_user_discussion_permissions_permission_id FOREIGN KEY (permission_id) REFERENCES public.permissions(id);