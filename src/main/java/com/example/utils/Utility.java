package com.example.utils;

import com.example.entities.Alien;
import javafx.scene.image.Image;
import javafx.scene.paint.ImagePattern;

public class Utility {

    public static boolean aliensTouchRightSide(Alien[][] aliens){
        boolean reponse = false;
        for (int column = 0 ; column < 10 ; column++){
            for (int line = 0 ; line < 5 ; line++){
                if (aliens[line][column].getX() > Constants.WINDOW_WIDTH - Constants.ALIEN_WIDTH - Constants.WINDOW_MARGIN - Constants.ALIEN_DELTA_X){
                    reponse = true;
                    break;
                }
            }
        }
        return reponse;
    }

    public static boolean aliensTouchLeftSide(Alien[][] aliens){
        boolean reponse = false;
        for (int column = 0 ; column < 10 ; column++){
            for (int line = 0 ; line < 5 ; line++){
                if (aliens[line][column].getX() < Constants.WINDOW_MARGIN + Constants.ALIEN_DELTA_X){
                    reponse = true;
                    break;
                }
            }
        }
        return reponse;
    }

    public static void displayAlternateAlienImage(Alien[][] aliens, int imageNumber){
        for (int column = 0 ; column < 10 ; column++){
            if (imageNumber == 1){
                aliens[0][column].setFill(new ImagePattern(Images.ALIEN_HIGH_1));
            }
            else if (imageNumber == 2) {
                aliens[0][column].setFill(new ImagePattern(Images.ALIEN_HIGH_2));
            }
        }
    }
}
