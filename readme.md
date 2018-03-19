# Mini-Projet Java EE

## **Portail Intranet d'une université**

### Groupe :
 - Aurélien VERNIZEAU
 - Thierry GONARD

## Fonctionnement

### Base de données
Création de la base de données et des tables avec le fichier dump *.sql*. On remarquera les 5 entités :
 1. administrator
 2. teacher
 3. student
 4. section
 5. note
 6. news
 7. course

 Un *student* appartient à **une et une seule** *section* qui peut avoir plusieurs *course*. Il s'agit d'un système à la *ESME*.

 ### Description fonctionnelle
 Les 3 types d'utilisateurs sont gérés. La *barre de navigation* s'accorde avec la bonne connexion des identifiants et du type d'utilisateur pour donner accès aux bonnes pages.  
  * **/Home** : *index.jsp* contient les descriptifs de l'université, les liens vers les contacts, et possède aussi les news. La barre de navigation permet l'authentification (via la BDD), avec reprise et message approprié en cas d'erreur.
  * **/GestionComptes** : *manageUsers.jsp* possède le formulaire nécessaire à la création de n'importe quel type d'utilisateur. Cette page est accessible seulement pour l'administrateur. La vérification des champs est très limitée, mais permet de savoir quel(s) champ(s) ont été inexacts (mais ne remplit pas avec les informations précédentes).
  * **/GestionNews** : *manageNews.jsp* permet seulement l'ajout de news, sans pouvoir modifier les existantes.
  * **/News** : *news.jsp* contient les news via la JSP *displayNews.jsp* en plus de la barre de navigation.
  * **/MesNotes** : permet à un *student* de visualiser ses notes.