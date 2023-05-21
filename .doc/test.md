[< précédent](../README.md)

# Test

# Test unitaire

## Utilisateur

1. pré-requis
1. script de test
   TReadUser.java
   TUpdateUser.java
   TCreateUser.java
1. resultat attendu

## Adresse

1. pré-requis
1. script de test
   CreateAddress.java
1. resultat attendu

## carte de paiement

1. pré-requis
1. script de test
   TCreateBankCard.java
   TReadBankCard.java
1. resultat attendu

## Commande

1. pré-requis
1. script de test
1. resultat attendu

## LigneDeCommande

1. pré-requis
1. script de test
1. resultat attendu

## Commentaire

L'objet java s'appelle Comment

1. pré-requis
   l'utilisateur doit exister sinon : lancer le test `TCreateUser.java`
   l'article doit exister lancer le test ` TCreateItem.java`

1. script de test
   TCreateComment.java
   TReadComment.java
1. resultat attendu

## ArticlePanier

l'object s'appelle CartItem

1. pré-requis
   l'utilisateur doit exister sinon : lancer le test `TCreateUser.java`
   l'article doit exister lancer le test ` TCreateItem.java`

1. script de test
   `
1. resultat attendu

## Article

l'objet Java s'apelle Item

1. pré-requis
1. script de test
   TReadItem.java
   TCreateItem.java
1. resultat attendu

## Categorie

1. pré-requis
1. script de test
   TCreateCategory.java
   TReadCategory.java
1. resultat attendu

## Params

1. pré-requis
1. script de test
   TCreateParam.java
   TEncryptDecryptDB.java

1. resultat attendu

## connexion à la base de donnée

1. pré-requis
1. script de test
   TConnect.java
1. resultat attendu

## utilitaire

TUnit.java

# Ordonnancement

1. `TCreateUser.java`
1. `TCreateCategory.java`
1. `TCreateComment.java`
1. `TCreateCartItem.java`

T
