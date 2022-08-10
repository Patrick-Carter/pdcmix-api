CREATE TYPE public.enum_permissions_types AS ENUM ('VIEW', 'UPLOAD', 'EDIT', 'DELETE', 'ADD_DISCUSSIONS', 'ADD_USERS', 'EDIT_PERMISSIONS', 'ADMIN');
CREATE TYPE public.enum_notifications_types AS ENUM ('EMAIL', 'TEXT', 'POPUP');
CREATE TYPE public.enum_criteria_types AS ENUM ('PAYMENT', 'LISTEN', 'LIKE', 'FOLLOW', 'COMMENT', 'SHARE');
CREATE TYPE public.enum_file_types AS ENUM ('PROJECT', 'AVATAR', 'COVER', 'MEDIA', 'ART', 'OTHER');
