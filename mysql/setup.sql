-- Create the databases
CREATE DATABASE IF NOT EXISTS employeedb;
CREATE DATABASE IF NOT EXISTS residentdb;
CREATE DATABASE IF NOT EXISTS reservationdb;

-- Grant privileges to the root user for these databases
GRANT ALL PRIVILEGES ON employeedb.* TO 'root'@'%';
GRANT ALL PRIVILEGES ON residentdb.* TO 'root'@'%';
GRANT ALL PRIVILEGES ON reservationdb.* TO 'root'@'%';

-- Refresh privileges
FLUSH PRIVILEGES;
