[< précédent](../README.md)

# Spécification technique

# découpe en profil (macro fonctionnalité)

# Commun

1. Page de connexion
1. Encription des donnés
1. Template xhtml
1. création des entity bean
1. creation de backing bean
1. creation des DAO

## profils

les profils généré par l'applicatoion sont :

1. administrateur
1. magasinier
1. client
1. client-webservice-basic
1. client-webservice-advance

## création de compte master-account

le premier compte est un compte administrateur défini lors de l'installation du produit.
le user/pass et défini lors de l'installation.

## création du compte manager

celui-ci est validé par le master account.
le compte manager a le droit de

1. CRUD sur les users client
1. CRUD sur les users magasinier
1. CRUD sur les users admin
1. CRUD sur les users client-webservice-basic
1. CRUD sur les users client-webservice-advance

## compte Client

1. Page de « accueil
1. déconnexion
1. gestion des achat
1. Panier
1. commande
1. historique des commandes

## compte magasinier

    1. CRUD article

1. connexion
