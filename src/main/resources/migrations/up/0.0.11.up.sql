CREATE EXTENSION IF NOT EXISTS "uuid-ossp";

INSERT INTO permissions (id, permission) VALUES
  (uuid_generate_v4(), 'get'),
  (uuid_generate_v4(), 'create'),
    (uuid_generate_v4(), 'update'),
    (uuid_generate_v4(), 'delete');

