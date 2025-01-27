package com.example.utils;

import com.example.entities.Alien;
import com.example.entities.Brick;
import com.example.entities.Ship;
import com.example.entities.ShipShoot;
import javafx.scene.Group;
import javafx.scene.layout.Pane;
import javafx.scene.paint.ImagePattern;
import javafx.scene.shape.Rectangle;

import java.util.List;

// La classe Initialisation gère l'ajout et la configuration des éléments du jeu Space Invaders sur le tableau de bord.

public class Initialisation {

    // Ajoute le vaisseau spatial au tableau de bord (pane)
    public static void initShip(Ship ship, Pane board) {
        board.getChildren().add(ship);
    }

    // Ajoute un tir de vaisseau spatial au tableau de bord
    public static void initShipShoot(ShipShoot shipShoot, Pane board) {
        board.getChildren().add(shipShoot);
    }

    // Initialise les murs avec des briques à des positions spécifiques
    public static void initWalls(int x, int y, int xNextLine, List<Brick> walls, Pane board) {
        for (int i = 0; i <= 3; i++ ) { // Boucle pour créer des lignes de briques
            for (int j = 0; j <= 6; j++) { // Boucle pour les colonnes de briques
                walls.add(new Brick(x, y, Constants.BRICK_WIDTH, Constants.BRICK_HEIGHT, Brick.setRandomBrick()));
                x += 10; // Espacement horizontal entre les briques
            }
            x = xNextLine; // Réinitialise la position horizontale pour la ligne suivante
            y += 10; // Espacement vertical entre les lignes
        }
        // Répétition pour les autres groupes de briques à des positions différentes
        for (int i = 0; i <= 3; i++ ) {
            for (int j = 0; j <= 6; j++) {
                walls.add(new Brick(x + 120, y - 40, Constants.BRICK_WIDTH, Constants.BRICK_HEIGHT, Brick.setRandomBrick()));
                x += 10;
            }
            x = xNextLine;
            y += 10;
        }
        // Continue avec des ajustements similaires
        for (int i = 0; i <= 3; i++ ) {
            for (int j = 0; j <= 6; j++) {
                walls.add(new Brick(x + 240, y - 80, Constants.BRICK_WIDTH, Constants.BRICK_HEIGHT, Brick.setRandomBrick()));
                x += 10;
            }
            x = xNextLine;
            y += 10;
        }
        for (int i = 0; i <= 3; i++ ) {
            for (int j = 0; j <= 6; j++) {
                walls.add(new Brick(x + 360, y - 120, Constants.BRICK_WIDTH, Constants.BRICK_HEIGHT, Brick.setRandomBrick()));
                x += 10;
            }
            x = xNextLine;
            y += 10;
        }
        board.getChildren().addAll(walls); // Ajoute toutes les briques au tableau de bord
    }

    // Initialise une grille d'aliens avec différentes positions et niveaux
    public static void initAliens(Alien[][] aliens, Pane board) {
        for (int column = 0; column < 10; column++) { // Colonnes des aliens
            // Première ligne d'aliens (haut)
            aliens[0][column] = new Alien(Constants.X_POS_INIT_ALIEN +
                    (Constants.ALIEN_WIDTH + Constants.GAP_COLUMNS_ALIEN) * column,
                    Constants.Y_POS_INIT_ALIEN, Constants.ALIEN_WIDTH, Constants.ALIEN_HEIGHT, Images.ALIEN_HIGH_1, 3);
            for (int line = 1; line < 3; line++) { // Lignes intermédiaires
                aliens[line][column] = new Alien(Constants.X_POS_INIT_ALIEN +
                        (Constants.ALIEN_WIDTH + Constants.GAP_COLUMNS_ALIEN) * column,
                        Constants.Y_POS_INIT_ALIEN + (Constants.ALIEN_HEIGHT + Constants.GAP_LINES_ALIEN) * line,
                        Constants.ALIEN_WIDTH, Constants.ALIEN_HEIGHT, Images.ALIEN_MIDDLE_1, 2);
            }
            for (int line = 3; line < 5; line++) { // Lignes inférieures
                aliens[line][column] = new Alien(Constants.X_POS_INIT_ALIEN +
                        (Constants.ALIEN_WIDTH + Constants.GAP_COLUMNS_ALIEN) * column,
                        Constants.Y_POS_INIT_ALIEN + (Constants.ALIEN_HEIGHT + Constants.GAP_LINES_ALIEN) * line,
                        Constants.ALIEN_WIDTH, Constants.ALIEN_HEIGHT, Images.ALIEN_BOTTOM_1, 1);
            }
        }
        // Ajoute tous les aliens au tableau de bord
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 10; j++) {
                board.getChildren().addAll(aliens[i][j]);
            }
        }
    }

    // Initialise un groupe d'explosion (effets visuels)
    public static void initExplosion(Group groupExplosion, Pane board) {
        board.getChildren().add(groupExplosion);
    }

    // Initialise une soucoupe volante avec un score de 100
    public static void initSaucer100(Rectangle saucer100Rect, Pane board) {
        saucer100Rect.setWidth(Constants.SAUCER_WIDTH); // Largeur de la soucoupe
        saucer100Rect.setHeight(Constants.SHIP_HEIGHT); // Hauteur de la soucoupe
        ImagePattern saucer100 = new ImagePattern(Images.SAUCER_100); // Image de la soucoupe
        saucer100Rect.setFill(saucer100); // Applique l'image à la soucoupe
        saucer100Rect.setX(Constants.X_POS_SAUCER_SCORE); // Position initiale hors du tableau
        saucer100Rect.setY(Constants.Y_POS_SAUCER_SCORE);
        board.getChildren().add(saucer100Rect);
    }

}
