package com.example.utils;

import javafx.animation.AnimationTimer;

/*
La classe FixedFrameRateTimer permet de contrôler les FPS,
c'est-à-dire combien de frames (images) le jeu doit afficher chaque seconde.
    - Si le jeu est trop rapide, il pourrait être difficile à jouer.
    - Si le jeu est trop lent, l'expérience ne serait pas agréable.
 */

public abstract class FixedFrameRateTimer extends AnimationTimer {

    //private double frameRateWanted;
    private long timeNeededBetweenTicks;// Temps nécessaire (en nanosecondes) entre deux frames pour respecter le FPS.

    private final long NANOS_IN_A_SECOND = 1_000_000_000L; // Constante pour convertir les secondes en nanosecondes.

    private long nanoLastTickStamp;// Timestamp du dernier tick (frame rendue).
    private long nanoTimeSinceLastTick;// Temps écoulé depuis le dernier tick.

    private double frameRate; // Fréquence réelle des frames (calculée dynamiquement)
    private float frameCount = 0; // Nombre de frames comptées dans une seconde.
    private long deltaTime = 0; // Temps entre deux appels de la méthode handle.(représente le temps entre deux frames successives.)
    private long timeCounter = 0; //  Compteur pour mesurer le temps écoulé.
    private long last = System.nanoTime();// Timestamp de la dernière frame.

    public FixedFrameRateTimer(double FPSWanted) {
        //timeNeededBetweenTicks pour calculer l'intervalle nécessaire entre deux frames en fonction du FPS désiré (FPSWanted).
        timeNeededBetweenTicks = (long) (NANOS_IN_A_SECOND / FPSWanted);
    }

    /*
    Retourne la fréquence d’images actuelle (FPS réel).
    Utile pour déboguer ou afficher les performances du jeu.
     */
    public double getFrameRate() {return frameRate;}

    // ! Cela permet de mesurer la durée d'une frame.
    @Override
    public void handle(long now) {
        deltaTime = now - last;
        last = now;
        timeCounter += deltaTime;
        nanoTimeSinceLastTick = now - nanoLastTickStamp;
        if (nanoTimeSinceLastTick > timeNeededBetweenTicks) {
            nanoLastTickStamp = now;
            frameCount++;
            loop();
        }
        if (timeCounter > NANOS_IN_A_SECOND) {
            frameRate = frameCount;
            frameCount = 0;
            timeCounter %= NANOS_IN_A_SECOND;
        }
    }


    protected abstract void loop();
}
