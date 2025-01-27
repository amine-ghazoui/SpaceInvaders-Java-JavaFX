package com.example.utils;

public interface Constants {

    /********************************  WINDOW  *********************************/

    int WINDOW_WIDTH = 600;
    int WINDOW_HEIGHT = 600;
    int WINDOW_MARGIN = 50;

    /***********************************  ALIEN  ***************************************/

    int ALIEN_WIDTH = 32;  // Largeur d'un alien
    int ALIEN_HEIGHT = 24;  // Hauteur d'un alien

    int X_POS_INIT_ALIEN = 40 + WINDOW_MARGIN;  // Position initiale X des aliens
    int Y_POS_INIT_ALIEN = 50;  // Position initiale Y des aliens
    int GAP_LINES_ALIEN = 10;  // Espace entre les lignes d'aliens
    int GAP_COLUMNS_ALIEN = 10;  // Espace entre les colonnes d'aliens

    int ALIEN_DELTA_X = 5;  // Déplacement horizontal des aliens
    int ALIEN_DELTA_Y = 20;  // Déplacement vertical des aliens
    int ALIEN_SPEED = 1;  // Vitesse des aliens
    int ALIEN_POINT = 10; // Points attribués par alien

    /******************************** SHIP   *********************************/
    int SHIP_WIDTH = 39;
    int SHIP_HEIGHT = 24;
    int X_POS_INIT_SHIP = (WINDOW_WIDTH - SHIP_WIDTH) / 2;
    int Y_POS_INIT_ShIP = 500;
    int SHIP_DELTA_X = 5;

    int SHIP_LEFT_WINDOW_LIMIT = 30;
    int SHIP_RIGHT_WINDOW_LIMIT = 530;

    /********************************  SHIP SHOOT  *********************************/
    int SHIP_SHOOT_WIDTH = 10;
    int SHIP_SHOOT_HEIGHT = 10;
    int SHIP_SHOOT_DELTA_Y = 5;
    int SHIP_SHOOT_ALIEN_SHOOT = 50;

    /***********************************  BRICK  ***************************************/
    int BRICK_WIDTH = 10;
    int BRICK_HEIGHT = 10;
    int BRICK_POINT = 5;

    /***********************************  AUDIO  ***************************************/
    double AUDIO_VOLULME = 0.03;

    /***********************************   ALIEN SHOOT   *****************************************/
    int ALIEN_SHOOT_WIDTH = 10;
    int ALIEN_SHOOT_HEIGHT = 10;
    int ALIEN_SHOOT_DELTA_Y = 4;
    int ALIEN_SHOOT_PROBABILITY = 6000;

    /***********************************  SAUCER  ***********************************************/
    int X_POS_INIT_SAUCER = WINDOW_WIDTH;
    int Y_POS_INIT_SAUCER = 15;
    int SAUCER_WIDTH = 42;
    int SAUCER_HEIGHT = 22;
    int SAUCER_DELTA_X = 2;

    /***********************************  SAUCER SCORE RECTANGLE ***********************************************/
    int X_POS_SAUCER_SCORE = WINDOW_WIDTH;
    int Y_POS_SAUCER_SCORE = Y_POS_INIT_SAUCER;
    int SAUCER_SCORE_WIDTH = 42;
    int SAUCER_SCORE_HEIGHT = 22;
    int SAUCER_SCORE_POINTS = 100;

    /***********************************  SEND GAME ***********************************************/
    String END_GAME_WIN = "YOU WIN";
    String END_GAME_LOOSE = "YOU LOOSE";

}
