CREATE TABLE IF NOT EXISTS public.user_permissions
(
    id uuid UNIQUE NOT NULL,
    user_id uuid NOT NULL,
    permission_id uuid NOT NULL,
    created_by uuid NOT NULL,
    created_at TIMESTAMP WITH TIME ZONE DEFAULT NOW(),
    CONSTRAINT user_permissions_pkey PRIMARY KEY (id)
);

ALTER TABLE user_permissions ADD CONSTRAINT fk_user_permissions_created_by FOREIGN KEY (created_by) REFERENCES public.users(id);

ALTER TABLE user_permissions ADD CONSTRAINT fk_user_permissions_user_id FOREIGN KEY (user_id) REFERENCES public.users(id);
ALTER TABLE user_permissions ADD CONSTRAINT fk_user_permissions_permission_id FOREIGN KEY (permission_id) REFERENCES public.permissions(id);