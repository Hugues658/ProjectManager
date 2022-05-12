-- phpMyAdmin SQL Dump
-- version 5.1.1
-- https://www.phpmyadmin.net/
--
-- Hôte : 127.0.0.1
-- Généré le : mer. 11 mai 2022 à 23:17
-- Version du serveur : 10.4.22-MariaDB
-- Version de PHP : 8.1.1

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de données : `ttt`
--

-- --------------------------------------------------------

--
-- Structure de la table `company`
--

CREATE TABLE `company` (
  `id_company` int(10) UNSIGNED NOT NULL,
  `company_name` varchar(200) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Déchargement des données de la table `company`
--

INSERT INTO `company` (`id_company`, `company_name`) VALUES
(9, 'SofiTech'),
(18, 'LOGI');

-- --------------------------------------------------------

--
-- Structure de la table `project`
--

CREATE TABLE `project` (
  `id_project` int(10) UNSIGNED NOT NULL,
  `project_name` varchar(200) NOT NULL,
  `id_company` int(10) UNSIGNED NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Déchargement des données de la table `project`
--

INSERT INTO `project` (`id_project`, `project_name`, `id_company`) VALUES
(1, 'gestion_stock', 9),
(2, 'Domotique', 18),
(4, 'Wifi zone', 9);

-- --------------------------------------------------------

--
-- Structure de la table `task`
--

CREATE TABLE `task` (
  `id_task` int(10) UNSIGNED NOT NULL,
  `id_project` int(10) UNSIGNED NOT NULL,
  `task_name` varchar(200) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Déchargement des données de la table `task`
--

INSERT INTO `task` (`id_task`, `id_project`, `task_name`) VALUES
(1, 1, 'Commande'),
(2, 1, 'Livrer'),
(3, 2, 'Porte automatisée');

-- --------------------------------------------------------

--
-- Structure de la table `task_log`
--

CREATE TABLE `task_log` (
  `id_task_log` int(10) UNSIGNED NOT NULL,
  `id_task` int(10) UNSIGNED NOT NULL,
  `username` varchar(10) NOT NULL,
  `task_description` varchar(2000) NOT NULL,
  `task_log_date` date NOT NULL,
  `task_minutes` int(10) UNSIGNED NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Déchargement des données de la table `task_log`
--

INSERT INTO `task_log` (`id_task_log`, `id_task`, `username`, `task_description`, `task_log_date`, `task_minutes`) VALUES
(1, 1, 'Hugues', 'Passer commandes', '2022-04-14', 15),
(2, 1, 'Hugues', 'Livraison des commandes', '2022-04-24', 60),
(3, 1, 'Camille', 'Récupération des marchandises', '2022-04-18', 120),
(4, 3, 'Hugues', 'nouvelle technologie', '2022-05-01', 276);

-- --------------------------------------------------------

--
-- Structure de la table `user`
--

CREATE TABLE `user` (
  `username` varchar(10) NOT NULL,
  `first_name` varchar(100) NOT NULL,
  `last_name` varchar(100) NOT NULL,
  `email` varchar(100) NOT NULL,
  `password` varchar(100) NOT NULL,
  `admin_role` char(1) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Déchargement des données de la table `user`
--

INSERT INTO `user` (`username`, `first_name`, `last_name`, `email`, `password`, `admin_role`) VALUES
('Camille', 'Koffi', 'EDOH', 'edoh@gmail.com', '1234', 's'),
('Hugues', 'Hugo', 'TEKO', 'teko@gmail.com', '12345', 'y');

-- --------------------------------------------------------

--
-- Structure de la table `user_log`
--

CREATE TABLE `user_log` (
  `id_user_log` int(11) NOT NULL,
  `ip_address` varchar(255) NOT NULL,
  `log_date` datetime DEFAULT NULL,
  `status` char(1) NOT NULL,
  `username` varchar(255) NOT NULL
) ENGINE=MyISAM DEFAULT CHARSET=utf8;

--
-- Déchargement des données de la table `user_log`
--

INSERT INTO `user_log` (`id_user_log`, `ip_address`, `log_date`, `status`, `username`) VALUES
(1, '192.168.0.1', '2022-05-04 11:56:18', 'y', 'Hugues');

--
-- Index pour les tables déchargées
--

--
-- Index pour la table `company`
--
ALTER TABLE `company`
  ADD PRIMARY KEY (`id_company`);

--
-- Index pour la table `project`
--
ALTER TABLE `project`
  ADD PRIMARY KEY (`id_project`),
  ADD KEY `id_company` (`id_company`);

--
-- Index pour la table `task`
--
ALTER TABLE `task`
  ADD PRIMARY KEY (`id_task`),
  ADD KEY `id_project` (`id_project`);

--
-- Index pour la table `task_log`
--
ALTER TABLE `task_log`
  ADD PRIMARY KEY (`id_task_log`),
  ADD KEY `id_task` (`id_task`),
  ADD KEY `username` (`username`);

--
-- Index pour la table `user`
--
ALTER TABLE `user`
  ADD PRIMARY KEY (`username`),
  ADD UNIQUE KEY `email` (`email`);

--
-- Index pour la table `user_log`
--
ALTER TABLE `user_log`
  ADD PRIMARY KEY (`id_user_log`);

--
-- AUTO_INCREMENT pour les tables déchargées
--

--
-- AUTO_INCREMENT pour la table `company`
--
ALTER TABLE `company`
  MODIFY `id_company` int(10) UNSIGNED NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=19;

--
-- AUTO_INCREMENT pour la table `project`
--
ALTER TABLE `project`
  MODIFY `id_project` int(10) UNSIGNED NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;

--
-- AUTO_INCREMENT pour la table `task`
--
ALTER TABLE `task`
  MODIFY `id_task` int(10) UNSIGNED NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;

--
-- AUTO_INCREMENT pour la table `task_log`
--
ALTER TABLE `task_log`
  MODIFY `id_task_log` int(10) UNSIGNED NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;

--
-- AUTO_INCREMENT pour la table `user_log`
--
ALTER TABLE `user_log`
  MODIFY `id_user_log` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;

--
-- Contraintes pour les tables déchargées
--

--
-- Contraintes pour la table `project`
--
ALTER TABLE `project`
  ADD CONSTRAINT `project_ibfk_1` FOREIGN KEY (`id_company`) REFERENCES `company` (`id_company`);

--
-- Contraintes pour la table `task`
--
ALTER TABLE `task`
  ADD CONSTRAINT `task_ibfk_1` FOREIGN KEY (`id_project`) REFERENCES `project` (`id_project`);

--
-- Contraintes pour la table `task_log`
--
ALTER TABLE `task_log`
  ADD CONSTRAINT `task_log_ibfk_1` FOREIGN KEY (`id_task`) REFERENCES `task` (`id_task`),
  ADD CONSTRAINT `task_log_ibfk_2` FOREIGN KEY (`username`) REFERENCES `user` (`username`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
