CREATE TABLE IF NOT EXISTS public.user_project_notifications
(
    id uuid UNIQUE NOT NULL,
    user_id uuid NOT NULL,
    project_id uuid NOT NULL,
    notification_id uuid NOT NULL,
    created_by uuid NOT NULL,
	created_at TIMESTAMP WITH TIME ZONE DEFAULT NOW(),
    CONSTRAINT user_project_notifications_pkey PRIMARY KEY (id)
);

ALTER TABLE user_project_notifications ADD CONSTRAINT fk_user_project_notifications_created_by FOREIGN KEY (created_by) REFERENCES public.users(id);
ALTER TABLE user_project_notifications ADD CONSTRAINT fk_user_project_notifications_user_id FOREIGN KEY (user_id) REFERENCES public.users(id);
ALTER TABLE user_project_notifications ADD CONSTRAINT fk_user_project_notifications_project_id FOREIGN KEY (project_id) REFERENCES public.projects(id);
ALTER TABLE user_project_notifications ADD CONSTRAINT fk_user_project_notifications_notification_id FOREIGN KEY (notification_id) REFERENCES public.notifications(id);

CREATE TABLE IF NOT EXISTS public.user_file_notifications
(
    id uuid UNIQUE NOT NULL,
    user_id uuid NOT NULL,
    file_id uuid NOT NULL,
    notification_id uuid NOT NULL,
    created_by uuid NOT NULL,
	created_at TIMESTAMP WITH TIME ZONE DEFAULT NOW(),
    CONSTRAINT user_file_notifications_pkey PRIMARY KEY (id)
);

ALTER TABLE user_file_notifications ADD CONSTRAINT fk_user_file_notifications_created_by FOREIGN KEY (created_by) REFERENCES public.users(id);
ALTER TABLE user_file_notifications ADD CONSTRAINT fk_user_file_notifications_user_id FOREIGN KEY (user_id) REFERENCES public.users(id);
ALTER TABLE user_file_notifications ADD CONSTRAINT fk_user_file_notifications_file_id FOREIGN KEY (file_id) REFERENCES public.files(id);
ALTER TABLE user_file_notifications ADD CONSTRAINT fk_user_file_notifications_notification_id FOREIGN KEY (notification_id) REFERENCES public.notifications(id);

CREATE TABLE IF NOT EXISTS public.user_discussion_notifications
(
    id uuid UNIQUE NOT NULL,
    user_id uuid NOT NULL,
    discussion_id uuid NOT NULL,
    notification_id uuid NOT NULL,
    created_by uuid NOT NULL,
	created_at TIMESTAMP WITH TIME ZONE DEFAULT NOW(),
    CONSTRAINT user_discussion_notifications_pkey PRIMARY KEY (id)
);

ALTER TABLE user_discussion_notifications ADD CONSTRAINT fk_user_discussion_notifications_created_by FOREIGN KEY (created_by) REFERENCES public.users(id);
ALTER TABLE user_discussion_notifications ADD CONSTRAINT fk_user_discussion_notifications_user_id FOREIGN KEY (user_id) REFERENCES public.users(id);
ALTER TABLE user_discussion_notifications ADD CONSTRAINT fk_user_discussion_notifications_discussion_id FOREIGN KEY (discussion_id) REFERENCES public.discussions(id);
ALTER TABLE user_discussion_notifications ADD CONSTRAINT fk_user_discussion_notifications_notification_id FOREIGN KEY (notification_id) REFERENCES public.notifications(id);