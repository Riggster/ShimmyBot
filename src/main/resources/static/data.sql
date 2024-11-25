-- Insert roles 
INSERT INTO "public"."roles" (name, description, is_active) VALUES
    ('Admin', 'Administrator role with full permissions', true),
    ('User', 'Regular user role with limited permissions', true);

-- Insert users
INSERT INTO "public"."users" (first_name, last_name, username, email, is_active) VALUES 
    ('John', 'Doe', 'jdoe1', 'john.doe@example.com', true), 
    ('Jane', 'Doe', 'jdoe2', 'jane.doe@example.com', true); 

-- Insert role assignments
-- Note: +01:00 is the timezone offset for Paris, France and -07:00 is the timezone offset for Denver, Colorado
Insert into "public"."role_assignments" (user_id, role_id, assigned_on, revoked_on) VALUES
    ((SELECT id FROM users WHERE username = 'jdoe1'), (SELECT id FROM roles WHERE name = 'Admin'), '2007-12-03T10:15:30+01:00', null),
    ((SELECT id FROM users WHERE username = 'jdoe2'), (SELECT id FROM roles WHERE name = 'User'), now(), null);