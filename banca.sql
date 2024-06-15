-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Creato il: Giu 12, 2024 alle 09:20
-- Versione del server: 10.4.32-MariaDB
-- Versione PHP: 8.0.30

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `banca`
--

-- --------------------------------------------------------

--
-- Struttura della tabella `banche`
--

CREATE TABLE `banche` (
  `id` int(10) UNSIGNED NOT NULL,
  `nome` varchar(50) NOT NULL DEFAULT '0'
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

--
-- Dump dei dati per la tabella `banche`
--

INSERT INTO `banche` (`id`, `nome`) VALUES
(1, 'Fineco'),
(2, 'Unicredit'),
(3, 'Cariparma'),
(4, 'MPS'),
(5, 'Intesa San Paolo');

-- --------------------------------------------------------

--
-- Struttura della tabella `citta`
--

CREATE TABLE `citta` (
  `id` int(10) UNSIGNED NOT NULL,
  `nome` varchar(50) NOT NULL DEFAULT '0'
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci COMMENT='anagrafica delle cittÃ ';

--
-- Dump dei dati per la tabella `citta`
--

INSERT INTO `citta` (`id`, `nome`) VALUES
(1, 'Roma'),
(2, 'Milano'),
(3, 'Genova'),
(4, 'Venezia'),
(5, 'Torino'),
(6, 'Bergamo');

-- --------------------------------------------------------

--
-- Struttura della tabella `conticorrenti`
--

CREATE TABLE `conticorrenti` (
  `id` int(10) UNSIGNED NOT NULL,
  `giacenza` double(10,3) NOT NULL DEFAULT 0.000,
  `intestatario_id` int(10) UNSIGNED NOT NULL DEFAULT 0,
  `numero` varchar(50) NOT NULL DEFAULT '0',
  `filiale_id` int(10) UNSIGNED NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

--
-- Dump dei dati per la tabella `conticorrenti`
--

INSERT INTO `conticorrenti` (`id`, `giacenza`, `intestatario_id`, `numero`, `filiale_id`) VALUES
(1, 10550.450, 1, '432543', 13),
(2, 15035.780, 4, '432588', 16),
(3, 3467.550, 5, '432505', 18);

-- --------------------------------------------------------

--
-- Struttura della tabella `filiali`
--

CREATE TABLE `filiali` (
  `id` int(10) UNSIGNED NOT NULL,
  `name` varchar(50) NOT NULL DEFAULT '0',
  `banca_id` int(10) UNSIGNED NOT NULL DEFAULT 0,
  `citta_id` int(10) UNSIGNED NOT NULL DEFAULT 0,
  `direttore_id` int(10) UNSIGNED NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

--
-- Dump dei dati per la tabella `filiali`
--

INSERT INTO `filiali` (`id`, `name`, `banca_id`, `citta_id`, `direttore_id`) VALUES
(13, 'Fineco Agenzia di Roma', 1, 4, 3),
(14, 'Fineco Filiale di Milano', 1, 2, 5),
(15, 'Unicredit Agenzia 1', 2, 1, 2),
(16, 'Cariparma Milano Centrale', 3, 5, 1),
(17, 'Cariparma Roma Prati', 3, 6, 4),
(18, 'ISP Private Banking', 5, 3, 6);

-- --------------------------------------------------------

--
-- Struttura della tabella `persone`
--

CREATE TABLE `persone` (
  `id` int(10) UNSIGNED NOT NULL,
  `cognome` varchar(100) NOT NULL DEFAULT '',
  `nome` varchar(100) NOT NULL,
  `cf` varchar(16) NOT NULL,
  `telefono` varchar(20) DEFAULT NULL,
  `email` varchar(100) NOT NULL,
  `citta_id` int(10) UNSIGNED NOT NULL DEFAULT 0
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci COMMENT='la tabella delle persone';

--
-- Dump dei dati per la tabella `persone`
--

INSERT INTO `persone` (`id`, `cognome`, `nome`, `cf`, `telefono`, `email`, `citta_id`) VALUES
(1, 'Mor', 'Fr', 'MRBFNC88T26H501K', '3333333333', 'f.morabito@mlpstudio.it', 4),
(2, 'Inc', 'An', 'NCLNDR95P03H501I', '3333333333', 'a.andrea@noemail.it', 1),
(3, 'Acc', 'Fr', 'ACCFNC87T25H501G', '3333333333', 'acc.fnc@noemail.it', 2),
(4, 'Pes', 'Mt', 'PESAND00T65H501L', '3333333333', 'mt.pes@noemail.it', 6),
(5, 'Cap', 'Lor', 'CAPLOR05T65H501L', '3333333333', 'cap.lor@noemail.it', 5),
(6, 'Ena', 'Ale', 'ENAALEF7T78H501C', '3333333333', 'ena.ale@noemail.it', 3);

--
-- Indici per le tabelle scaricate
--

--
-- Indici per le tabelle `banche`
--
ALTER TABLE `banche`
  ADD PRIMARY KEY (`id`);

--
-- Indici per le tabelle `citta`
--
ALTER TABLE `citta`
  ADD PRIMARY KEY (`id`);

--
-- Indici per le tabelle `conticorrenti`
--
ALTER TABLE `conticorrenti`
  ADD PRIMARY KEY (`id`),
  ADD UNIQUE KEY `numero` (`numero`),
  ADD KEY `fk_conticorrenti_persone` (`intestatario_id`),
  ADD KEY `fk_conticorrenti_filiale` (`filiale_id`);

--
-- Indici per le tabelle `filiali`
--
ALTER TABLE `filiali`
  ADD PRIMARY KEY (`id`),
  ADD KEY `fk_filiali_banca` (`banca_id`),
  ADD KEY `fk_filiali_citta` (`citta_id`),
  ADD KEY `fk_filiali_direttore` (`direttore_id`);

--
-- Indici per le tabelle `persone`
--
ALTER TABLE `persone`
  ADD PRIMARY KEY (`id`),
  ADD UNIQUE KEY `cf` (`cf`),
  ADD KEY `fk_persone_citta` (`citta_id`);

--
-- AUTO_INCREMENT per le tabelle scaricate
--

--
-- AUTO_INCREMENT per la tabella `banche`
--
ALTER TABLE `banche`
  MODIFY `id` int(10) UNSIGNED NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=44;

--
-- AUTO_INCREMENT per la tabella `citta`
--
ALTER TABLE `citta`
  MODIFY `id` int(10) UNSIGNED NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=16;

--
-- AUTO_INCREMENT per la tabella `conticorrenti`
--
ALTER TABLE `conticorrenti`
  MODIFY `id` int(10) UNSIGNED NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;

--
-- AUTO_INCREMENT per la tabella `filiali`
--
ALTER TABLE `filiali`
  MODIFY `id` int(10) UNSIGNED NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=20;

--
-- AUTO_INCREMENT per la tabella `persone`
--
ALTER TABLE `persone`
  MODIFY `id` int(10) UNSIGNED NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=8;

--
-- Limiti per le tabelle scaricate
--

--
-- Limiti per la tabella `conticorrenti`
--
ALTER TABLE `conticorrenti`
  ADD CONSTRAINT `fk_conticorrenti_filiale` FOREIGN KEY (`filiale_id`) REFERENCES `filiali` (`id`),
  ADD CONSTRAINT `fk_conticorrenti_persone` FOREIGN KEY (`intestatario_id`) REFERENCES `persone` (`id`);

--
-- Limiti per la tabella `filiali`
--
ALTER TABLE `filiali`
  ADD CONSTRAINT `fk_filiali_banca` FOREIGN KEY (`banca_id`) REFERENCES `banche` (`id`),
  ADD CONSTRAINT `fk_filiali_citta` FOREIGN KEY (`citta_id`) REFERENCES `citta` (`id`),
  ADD CONSTRAINT `fk_filiali_direttore` FOREIGN KEY (`direttore_id`) REFERENCES `persone` (`id`);

--
-- Limiti per la tabella `persone`
--
ALTER TABLE `persone`
  ADD CONSTRAINT `fk_persone_citta` FOREIGN KEY (`citta_id`) REFERENCES `citta` (`id`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
