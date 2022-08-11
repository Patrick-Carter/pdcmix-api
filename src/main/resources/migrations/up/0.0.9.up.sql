CREATE TABLE IF NOT EXISTS public.user_notifications
(
    id uuid UNIQUE NOT NULL,
    user_id uuid NOT NULL,
    notification_id uuid NOT NULL,
    created_by uuid NOT NULL,
    created_at TIMESTAMP WITH TIME ZONE DEFAULT NOW(),
    CONSTRAINT user_notifications_pkey PRIMARY KEY (id)
);

ALTER TABLE user_notifications ADD CONSTRAINT fk_user_notifications_created_by FOREIGN KEY (created_by) REFERENCES public.users(id);

ALTER TABLE user_notifications ADD CONSTRAINT fk_user_notifications_user_id FOREIGN KEY (user_id) REFERENCES public.users(id);
ALTER TABLE user_notifications ADD CONSTRAINT fk_user_notifications_notification_id FOREIGN KEY (notification_id) REFERENCES public.notifications(id);