INSERT INTO roles (name)
VALUES ('ADMIN'),
       ('USER');

INSERT INTO permissions (name)
VALUES ('READ'),
       ('WRITE'),
       ('DELETE');

INSERT INTO role_permissions (role_id, permission_id)
VALUES (1, 1),
       (1, 2),
       (1, 3),
       (2,1);