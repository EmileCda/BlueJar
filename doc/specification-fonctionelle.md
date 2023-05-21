[< précédent](../README.md)

# Analyse fonctionnelle

# Profile Admin

## fonctions

1. CRUD magasinier
1. CRUS administrateur
1. CRUD client webservice

# Profile Magasinier

# Profile Client

# web service

## libre

1. getCommentaires(Integer idArticle)
1. getCommentaires()
1. getNbCommandesParVille()

## avec login

1. getUtilisateursAvecPanierNonVide()

# Sécurité

## règles de bases

1. confidentialité (répartition des profils)
1. intégrité (encapsulation + encryption)
1. disponibilité (web service, persistance des données)
1. non-répudiation (garantie par le login)
1. authentification (garantie par le login)
1. autorisation (Admin, magasinier, client)

## application au projet

1. sécurité JVM
1. sécurité codage
1. sécurité des accèss (login)
1. sécurité des données (cryptage des données sensible)

# les entités

## Order.java

## Param.java

## Address.java

## BankCard.java

## Category.java

## Code.java

## OrderLine.java

## Comment.java

## Item.java

## CartItem.java

## User.java

lors de la lecture d'un utilisateur le systeme doit récuperer en même temps les objects suivants :

1. Address.java
1. BankCard.java
1. CartItem.java

les objets a récupé en différé :

1. Order.java
1. Comment.java
