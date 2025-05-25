CREATE DATABASE IF NOT EXISTS carbuild_db;
USE carbuild_db;
CREATE TABLE IF NOT EXISTS CarBuild (
  id INT PRIMARY KEY AUTO_INCREMENT,
  make VARCHAR(50),
  model VARCHAR(50),
  engine VARCHAR(50),
  transmission VARCHAR(50),
  color VARCHAR(50),
  wheels VARCHAR(50),
  basePrice DOUBLE,
  seatMaterial VARCHAR(50),
  dashboardMaterial VARCHAR(50),
  ambientLighting BOOLEAN,
  sunroof BOOLEAN,
  navigation BOOLEAN,
  premiumSound BOOLEAN
);