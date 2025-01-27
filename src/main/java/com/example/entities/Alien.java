package com.example.entities;

import com.example.utils.Constants;
import com.example.utils.Utility;
import javafx.scene.image.Image;
import javafx.scene.paint.ImagePattern;

// Classe représentant un alien dans le jeu Space Invaders.
// Elle hérite de la classe Entity et gère le mouvement et l'apparence des aliens.
public class Alien extends Entity {

    // Variable statique pour savoir si les aliens se déplacent vers la droite.
    private static boolean goRight = true;

    // Variable statique pour alterner l'apparence des aliens.
    private static boolean alienPosition = true;

    // Vitesse des aliens, définie par une constante.
    private static int speed = Constants.ALIEN_SPEED;

    // Type de l'alien (par exemple, un alien avec une forme ou une taille différente).
    private static int type;

    public static int getType() {
        return type;
    }

    public static void setType(int type) {
        Alien.type = type;
    }

    // Indique si l'alien est mort ou non.
    private boolean isDead;

    // Constructeur de la classe Alien. Initialise les attributs de l'alien.
    // x, y, largeur, hauteur, image, et type sont définis à la création.
    public Alien(double x, double y, double width, double height, Image image, int type) {
        super(x, y, width, height); // Appel au constructeur de la classe Entity
        super.setImg(image); // Définir l'image de l'alien
        super.setImgPattern(new ImagePattern(super.getImg())); // Définir le motif de l'image
        super.setFill(super.getImgPattern()); // Appliquer le motif à l'alien
        this.type = type; // Définir le type de l'alien
    }

    // Méthode statique qui gère le mouvement des aliens.
    public static void alienMoving(Alien[][] aliens) {

        // Déplacer les aliens à droite ou à gauche en fonction de la direction actuelle.
        if (goRight) {
            for (int column = 0; column < 10; column++) {
                for (int ligne = 0; ligne < 5; ligne++) {
                    aliens[ligne][column].setX(aliens[ligne][column].getX() + Constants.ALIEN_DELTA_X);
                }
            }
        } else {
            for (int column = 0; column < 10; column++) {
                for (int ligne = 0; ligne < 5; ligne++) {
                    aliens[ligne][column].setX(aliens[ligne][column].getX() - Constants.ALIEN_DELTA_Y);
                }
            }
        }

        // Alterner l'apparence des aliens pour donner un effet visuel de changement.
        int imageNumber;
        if (alienPosition) {
            imageNumber = 2;
            alienPosition = false;
        } else {
            imageNumber = 1;
            alienPosition = true;
        }

        // Mettre à jour la position des aliens dans le jeu.
        aliensMovingIntoBoard(aliens);

        // Afficher l'image alternée des aliens.
        Utility.displayAlternateAlienImage(aliens, imageNumber);
    }

    // Méthode qui déplace les aliens vers le bas lorsque l'un d'eux atteint les bords de l'écran.
    public static void aliensMovingIntoBoard(Alien[][] aliens) {
        // Si les aliens touchent le côté droit, ils descendent et changent de direction.
        if (Utility.aliensTouchRightSide(aliens)) {
            for (int column = 0; column < 10; column++) {
                for (int line = 0; line < 5; line++) {
                    aliens[line][column].setY(aliens[line][column].getY() + Constants.ALIEN_DELTA_Y);
                }
            }
            goRight = false; // Changer la direction à gauche
            if (Alien.getSpeed() < 9) {
                Alien.setSpeed(Alien.getSpeed() + 1); // Augmenter la vitesse des aliens
            }
        }
        // Si les aliens touchent le côté gauche, ils descendent et changent de direction.
        else if (Utility.aliensTouchLeftSide(aliens)) {
            for (int column = 0; column < 10; column++) {
                for (int line = 0; line < 5; line++) {
                    aliens[line][column].setY(aliens[line][column].getY() + Constants.ALIEN_DELTA_Y);
                }
            }
            goRight = true; // Changer la direction à droite
            if (Alien.getSpeed() < 9) {
                Alien.setSpeed(Alien.getSpeed() + 1); // Augmenter la vitesse des aliens
            }
        }
    }

    // Getter pour la vitesse des aliens.
    public static int getSpeed() {
        return speed;
    }

    // Setter pour la vitesse des aliens.
    public static void setSpeed(int speed) {
        Alien.speed = speed;
    }

    // Vérifie si l'alien est mort.
    public boolean isDead() {
        return isDead;
    }

    // Définir si l'alien est mort ou non.
    public void setDead(boolean dead) {
        isDead = dead;
    }
}
