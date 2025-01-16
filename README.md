<h1>Expression des besoins</h1>
<p>Application de gestion de tâches à faire, à savoir une TodoList.<br>
L'application doit être simple pour permettre à l'utilisateur connecté
d'ajouter, supprimer, mettre à jour, ainsi que de rechercher une tâche à faire,
classée ou pas par catégorie.<br>
Quant à l'utilisateur non authentifié, il aura accès à la page d'accueil du site
avec pour exemple un ensemble de tâches fictives.<br>
Une tâche doit être définie par : nom, date, description et toute autre information
pertinente.</p>

<h4>Use case : </h4> 
![useCase.png](Diagrams/useCase.png)

<h4> Class Diagram : </h4>

![img.png](Diagrams/img.png)

<h1>Spécifications fonctionnelles</h1>
<p>Pour le visiteur du site, l'appli permet:<br>
.Afficher la page d'accueil qui montre des exemples de tâches.<br>
.Se connecter<br>
Pour l'utilisateur connecté, l'appli permet en plus: <br>
.Afficher la page des tâches personnalisées et leurs catégories<br>
.Ajouter une tâche <br>
.Supprimer une tâche<br>
.Modifier une tâche<br>
.Rechercher par mot-clé<br>
.Sélectionner une catégorie spécifique<br>
</p>

<h1>Spécifications techniques</h1>
<p>-> Spring Boot 2.6.0/Spring Data Jpa Hibernate/Spring Mvc/Thymeleaf/Lombok<br>
-> Java 11/IntelliJ Community/SGBD MariaDB/BootStrap
</p>