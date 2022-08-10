CREATE TABLE IF NOT EXISTS public.comments
(
    id uuid UNIQUE NOT NULL,
    "comment" character varying(255) NOT NULL,
	"status" boolean default true NOT NULL,
    edited boolean default false NOT NULL,
    likes integer default 0 NOT NULL,
    discussion_id uuid NOT NULL,
    created_by uuid NOT NULL,
    updated_by uuid NOT NULL,
    updated_at TIMESTAMP WITH TIME ZONE DEFAULT NOW(),
	created_at TIMESTAMP WITH TIME ZONE DEFAULT NOW(),
    CONSTRAINT comments_pkey PRIMARY KEY (id)
);

ALTER TABLE comments ADD CONSTRAINT fk_comments_created_by FOREIGN KEY (created_by) REFERENCES public.users(id);
ALTER TABLE comments ADD CONSTRAINT fk_comments_updated_by FOREIGN KEY (updated_by) REFERENCES public.users(id);
ALTER TABLE comments ADD CONSTRAINT fk_comments_discussion_id FOREIGN KEY (discussion_id) REFERENCES public.discussions(id);