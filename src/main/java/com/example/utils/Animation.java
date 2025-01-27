package com.example.utils;

import javafx.animation.FadeTransition;
import javafx.animation.Interpolator;
import javafx.animation.TranslateTransition;
import javafx.scene.image.ImageView;
import javafx.util.Duration;
/*
Déclare une classe utilitaire contenant des méthodes statiques pour
gérer des animations spécifiques dans le jeu.
 */
public class Animation {
    /*
    Cette méthode crée une animation combinée
    (translation et fondu) pour un objet ImageView (ex. le logo du jeu).
     */
    public static void animateLogoSpaceInvaders(ImageView imgLogo, double fromY, double toY, int delay, double fromValue, double toValue, int fadeDuration ) {
        //Déplacer l'objet imgLogo verticalement sur une durée spécifiée en millisecondes (delay).

        TranslateTransition animation = new TranslateTransition(Duration.millis(delay), imgLogo);

        animation.setFromY(fromY);// La position de départ verticale.

        animation.setToY(toY);// La position finale verticale.

        animation.setInterpolator(Interpolator.EASE_OUT);// Rend l'animation plus naturelle en la faisant ralentir à la fin (effet de décélération).

        animation.play();// Lance l'animation de translation.

        /*
        Créer une animation qui change l'opacité (transparence)
        de l'image sur une durée spécifiée (fadeDuration).javaCopier le code
         */
        FadeTransition fade = new FadeTransition(Duration.millis(fadeDuration), imgLogo);
        fade.setFromValue(fromValue);//  Opacité de départ (0 = transparent, 1 = opaque).
        fade.setToValue(toValue);// Opacité finale.
        fade.play(); //  Lance l'animation de fondu.
    }

    
}
