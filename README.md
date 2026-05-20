#  DIGITRANS-CM — Module CRM SavoirManger

> **Projet de Modernisation du Système d'Information d'AGROCAM S.A.**
> Développé par **CAMTECH SOLUTIONS S.A.** (Douala, Cameroun)  
> Date de début : 19/05/2026 | Date de livraison : 22/05/2026

---

##  Présentation du Projet

Le projet **DIGITRANS-CM** est une initiative d'envergure menée par l'ESN **CAMTECH SOLUTIONS S.A.** pour le compte d'**AGROCAM S.A.** (groupe agroalimentaire de plus de 1 200 employés). L'objectif est de remplacer un système monolithique obsolète datant de 2009 par un écosystème applicatif moderne, modulaire et hautement évolutif.

Le système complet est subdivisé en 4 modules majeurs (ERP, CRM, Supply Chain, BI). Ce dépôt contient l'implémentation du **Module CRM SavoirManger**, destiné à centraliser, automatiser et optimiser la relation client pour la chaîne de restauration rapide *SavoirManger* présente dans les grandes villes du Cameroun.

---

##  Équipe Projet & Rôles

* **TAMO FOTSO** — *Responsable Technique & Lead DevOps (Backend + Infrastructure)*
    * Initialisation et architecture Spring Boot (Entités, Repositories, Services, DTOs, Mappers, REST).
    * Sécurisation avec Spring Security et JSON Web Tokens (JWT).
    * Gestion du dépôt GitHub (Branches, Jalons, Issues, Tableau Kanban).
    * Configuration et déploiement de l'infrastructure Cloud AWS (EC2, S3, RDS).
* **DONGMO STEPHANIE** — *Développeuse Frontend (Angular + UI/UX)*
    * Conception de l'interface utilisateur web moderne responsive.
    * Consommation des APIs REST du backend.
    * Création des vues métiers (Clients, Commandes, Réclamations, Dashboards).
* **MAGNE PETRONIE** — *Développeuse Backend (API + Base de données)*
    * Modélisation relationnelle et création du script SQL de la base de données.
    * Développement des contrôleurs et logique métier complémentaire.
    * Tests fonctionnels des routes API (Postman / Swagger).

---

##  Stack Technique

### Backend
* **Framework :** Spring Boot 3.x (Java 17)
* **Sécurité :** Spring Security + JWT (Rôles : `ADMIN`, `MANAGER`, `AGENT`)
* **Persistance :** Spring Data JPA / Hibernate
* **Gestionnaire de dépendances :** Maven

### Frontend
* **Framework :** Angular (Vues réactives, Modules de gestion client, Routage sécurisé)
* **Design :** CSS moderne adapté aux spécifications UI/UX de CAMTECH SOLUTIONS

### Base de Données
* **SGBD :** MySQL (Fuseau horaire : `Africa/Douala`)

### DevOps & Cloud
* **Infrastructure :** Amazon Web Services (AWS EC2 pour le serveur, S3 pour le stockage)
* **Versionnage :** Git & GitHub (Workflow basé sur une branche principale `main`)

---

##  Fonctionnalités du MVP

1.  **Authentification et Contrôle d'Accès :** Sécurisation JWT avec habilitations strictes par profil utilisateur (`ADMIN`, `MANAGER`, `AGENT`).
2.  **Gestion des Clients :** Enregistrement, modification, consultation et archivage logique des comptes clients de la chaîne *SavoirManger*.
3.  **Gestion des Commandes :** Suivi en temps réel des transactions et historique d'achat.
4.  **Gestion des Réclamations :** Système de ticketing pour traiter rapidement les retours clients et améliorer la satisfaction.
5.  **Fidélisation & Marketing :** Suivi des points de fidélité et ciblage des campagnes promotionnelles locales.
6.  **Tableau de Bord Intégré :** Visualisation des indicateurs clés de performance (KPI) pour les directeurs de restaurants et la direction générale.

---

##  Installation et Démarrage Local

### 1. Prérequis
Assurez-vous d'avoir installé sur votre machine :
* Java JDK 17 ou supérieur
* Node.js & Angular CLI
* MySQL Server 8.x
* Git

### 2. Configuration de la Base de Données
Exécutez le script suivant sur votre instance MySQL locale pour initialiser l'environnement :

```sql
CREATE DATABASE crm_savoirmanger;
CREATE USER 'crm_user'@'localhost' IDENTIFIED BY 'CrmSecure@2026!';
GRANT ALL PRIVILEGES ON crm_savoirmanger.* TO 'crm_user'@'localhost';
FLUSH PRIVILEGES;