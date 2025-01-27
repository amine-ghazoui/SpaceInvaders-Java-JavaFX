package com.example.entities;

import java.util.List;

public class Player {

    private String nomPrenom;
    private int score;

    public Player(String nomPrenom, int score) {
        this.nomPrenom = nomPrenom;
        this.score = score;
    }



    public String getNomPrenom() {
        return nomPrenom;
    }

    public void setNomPrenom(String nomPrenom) {
        this.nomPrenom = nomPrenom;
    }

    public double getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }
}
