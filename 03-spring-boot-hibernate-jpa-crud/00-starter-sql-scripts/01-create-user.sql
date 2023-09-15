-- Drop user first if they exist
DROP USER if exists 'springstudent'@'localhost';

-- Now create user with prop privileges
CREATE USER 'springstudent'@'localhost' IDENTIFIED BY 'Springstudent@123';

GRANT ALL PRIVILEGES ON * . * TO 'springstudent'@'localhost';