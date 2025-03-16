# ProjetExamenMaster_IABD_1_2023_2024bis

## Description
Ce projet, développé dans le cadre de l'examen de Master M1-IABD, porte sur le calcul parallèle appliqué à divers algorithmes (calcul de la suite de Fibonacci, produits matriciels, etc.).  
Il s’appuie sur deux approches de parallélisme : itératif et récursif, avec une analyse détaillée des performances selon différents paramètres (nombre de threads, groupSize, MaxDepth, etc.).

## Table des Matières
- [Contexte et Objectifs](#contexte-et-objectifs)
- [Structure du Projet](#structure-du-projet)
- [Méthodologie et Implémentation](#méthodologie-et-implémentation)
- [Compilation et Exécution](#compilation-et-exécution)
- [Résultats et Analyse](#résultats-et-analyse)
- [Documentation](#documentation)
- [Contributeurs](#contributeurs)
- [Licence](#licence)

## Contexte et Objectifs
Le projet a pour objectif d'explorer et d'évaluer différentes techniques de calcul parallèle, notamment :
- **Parallélisme itératif** : Mise en œuvre et analyse de performances pour le calcul de produits matriciels.
- **Parallélisme récursif** : Optimisation et vérification via le calcul de la suite de Fibonacci à l'aide du compilateur FJComp.

## Structure du Projet
- **build.xml** : Fichier de build (Ant) pour compiler le projet.
- **nbproject/** : Fichiers de configuration spécifiques à NetBeans.
- **src/** : Code source Java organisé par packages.
  - `comparer` : Contient le code pour la comparaison de matrices.
  - `fjcomp` : Implémentation de l'algorithme de Fibonacci (séquentiel et parallèle).
  - `parallel` : Algorithmes de produits matriciels en parallèle (static et self scheduling).
  - `schedule` : Différentes stratégies de scheduling pour la parallélisation.
  - `sequentiel` : Version séquentielle des algorithmes de calcul.
- **doc/** : Documentation et rapports, notamment le rapport sur le calcul parallèle.

## Méthodologie et Implémentation
Le projet se divise en deux parties majeures :
1. **Calcul Parallèle Itératif**  
   - Analyse des performances de produits matriciels en parallèle.
   - Tests avec différentes configurations (nombre de threads, groupSize).
2. **Calcul Parallèle Récursif**  
   - Implémentation d'un algorithme récursif pour la suite de Fibonacci.
   - Utilisation du compilateur FJComp pour générer du code parallèle.
   - Comparaison des performances et vérification de la cohérence entre les versions séquentielles et parallèles.

## Compilation et Exécution
### Prérequis
- **Java JDK** (version 8 ou supérieure)
- **Ant** (pour la compilation via `build.xml`)
- **NetBeans** (optionnel, pour ouvrir et modifier le projet)

### Compilation
Pour compiler le projet en utilisant Ant, exécutez la commande suivante à la racine du projet :
```bash
ant
```

### Exécution

    Exécution du produit matriciel parallèle
    Les classes principales se trouvent dans le package parallel et schedule. Utilisez NetBeans ou la ligne de commande pour exécuter les classes correspondantes.
    Exécution de l’algorithme Fibonacci
    Pour tester l’algorithme parallèle de Fibonacci, exécutez la classe fjcomp.Fibonacci :

```bash
java -cp out/production/ProjetExamenMaster_IABD_1_2023_2024bis fjcomp.Fibonacci
```
### Résultats et Analyse

Les performances ont été évaluées en fonction de divers paramètres tels que le nombre de threads, le groupSize pour les produits matriciels et le MaxDepth pour la parallélisation récursive.
Les documents et graphiques inclus dans le rapport [doc/Projet_Calcul_Parallele_Aboubakar_Saly.docx](doc/Projet_Calcul_Parallele_Aboubakar_Saly.docx) détaillent l’analyse des accélérations et l’identification des paramètres optimaux.
### Documentation

Pour plus de détails sur la méthodologie, l’analyse des performances et l’optimisation des algorithmes, consultez le rapport en [doc/Projet_Calcul_Parallele_Aboubakar_Saly.docx](doc/Projet_Calcul_Parallele_Aboubakar_Saly.docx).
### Contributeurs
	Pr Abdourahmane Senghor
    Aboubakar Saly

### Licence

Tous droits réservés.
