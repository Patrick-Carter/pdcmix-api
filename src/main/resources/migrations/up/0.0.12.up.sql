ALTER TABLE user_project_permissions ADD COLUMN updated_at TIMESTAMP WITH TIME ZONE DEFAULT NOW();
ALTER TABLE user_project_permissions ADD COLUMN updated_by uuid NOT NULL;

ALTER TABLE user_project_permissions ADD CONSTRAINT fk_user_project_permissions_updated_by FOREIGN KEY (updated_by) REFERENCES public.users(id);
