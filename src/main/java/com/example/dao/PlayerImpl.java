package com.example.dao;

import com.example.entities.Player;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class PlayerImpl {


    public void add(String name){

        try {
            Connection connection = SingletonConnexionDB.getConnection();
            PreparedStatement stm = connection.prepareStatement(
                    "INSERT INTO player(nomPrenom,score) VALUES (?,?)"
            );
            stm.setString(1, name);
            stm.setInt(2, 0);

            stm.executeUpdate();

            System.out.println("Player saved successfully.");
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public List<Player> findAll(){
        List<Player> playerList = new ArrayList<>();
        try{
            Connection connection = SingletonConnexionDB.getConnection();
            PreparedStatement stm = connection.prepareStatement("select * from player");
            ResultSet rs = stm.executeQuery();
            while (rs.next()){
                Player player = new Player(
                        rs.getString("nomPrenom"),
                        rs.getInt("score")
                );
                playerList.add(player);
                System.out.printf(player.toString());
            }

        }catch (Exception e){
            e.printStackTrace();
        }
        return playerList;
    }
    public void updateScore(int newScore, String playerName){
        try{
            Connection connection = SingletonConnexionDB.getConnection();
            PreparedStatement stm = connection.prepareStatement("UPDATE player SET score = ? WHERE nomPrenom = ?");
            stm.setInt(1,newScore);
            stm.setString(2,playerName);
            stm.executeUpdate();
        }catch (Exception e){
            e.printStackTrace();
        }
    }
    public Player findByName(String name) {
        Player player=null;
        try {
            Connection connection = SingletonConnexionDB.getConnection();
            PreparedStatement stm = connection.prepareStatement("SELECT * FROM player where nomPrenom = ?");
            stm.setString(1, name);
            ResultSet rs = stm.executeQuery();
            while (rs.next()) {
                player = new Player(
                        rs.getString("nomPrenom"),
                        rs.getInt("score")
                );
                System.out.printf("Player found: " + player.getNomPrenom()+", "+player.getScore());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return player;
    }
}
