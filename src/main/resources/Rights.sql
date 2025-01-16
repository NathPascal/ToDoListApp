-- Utilisation de la base de données Tasklist
USE Tasklist;

-- Création de la table des utilisateurs
CREATE TABLE T_Users (
    username varchar(25) PRIMARY KEY,
    password varchar(250),
    active boolean
) ENGINE = InnoDB;

-- Insertion des utilisateurs
INSERT INTO T_Users (username, password, active) VALUES ('paul', '$2a$12$A.1omyeduJjn9BulU5TVxuLmvfC6FFiqUQieW2Y8Nc2xGwr44p5N2', true);
INSERT INTO T_Users (username, password, active) VALUES ('julie', '$2a$12$/FxJ4RIYiIcO8eZp6wT.1e54T9q5uk4HVtHmUteGZqW2XGKs0RMRm', true);

-- Sélection des utilisateurs pour vérification
SELECT * FROM T_Users;

-- Création de la table des rôles
CREATE TABLE T_Roles (
    role varchar(25) PRIMARY KEY
) ENGINE = InnoDB;

-- Insertion des rôles
INSERT INTO T_Roles (role) VALUES ('USER');

-- Création de la table des rôles par utilisateur
CREATE TABLE T_Users_Roles (
    username varchar(25),
    role varchar(25),
    PRIMARY KEY(username, role),
    FOREIGN KEY (username) REFERENCES T_Users(username),
    FOREIGN KEY (role) REFERENCES T_Roles(role)
) ENGINE = InnoDB;

-- Insertion des rôles par utilisateur
INSERT INTO T_Users_Roles (username, role) VALUES ('paul', 'USER');
INSERT INTO T_Users_Roles (username, role) VALUES ('julie', 'USER');

