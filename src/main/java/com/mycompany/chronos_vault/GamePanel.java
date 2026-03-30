/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.chronos_vault;

/**
 *
 * @author jerome
 */


import javax.swing.JPanel;
import java.awt.Dimension;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;

public class GamePanel extends JPanel implements Runnable{

    // Screen settings
    final int oTileSize = 16;
    final int scale = 3;

    final int tileSize = oTileSize * scale;
    final int maxScreenCol = 30;
    final int maxScreenRow = 20;
    final int screenWidth = tileSize * maxScreenCol;
    final int screenHeight = tileSize * maxScreenRow;
    Thread gameThread;

    // Input
    KeyInput keyInput = new KeyInput();
    Map Map = new Map();
    
    // Player position
    int plrX = 100;
    int plrY = 100;
    int plrSpd = 6;
    int orgSpd = 6;
    
    int currentRoom = 1;

    public GamePanel() {

        this.setPreferredSize(new Dimension(screenWidth, screenHeight));
        this.setBackground(Color.black);
        this.setDoubleBuffered(true);

        this.addKeyListener(keyInput);
        this.setFocusable(true);
    }

    public void GameThreadStarter(){
        gameThread = new Thread(this);
        gameThread.start();
    }

    @Override
    public void run() {

        while(gameThread != null){

            update();
            repaint();

            try{
                Thread.sleep(16);
            }
            catch(InterruptedException e){
                e.printStackTrace();
            }
        }
    }

    //UPDATE 
    public void update(){
        int pwr = 10;
        System.out.println("Player at x("+plrX+") Y("+plrY+")");
        if(keyInput.Upressed && plrY - plrSpd >= 0){
            plrY -= plrSpd;
        }

        if(keyInput.Dpressed && plrY + plrSpd <= screenHeight - tileSize){
            plrY += plrSpd;
        }

        if(keyInput.Lpressed && plrX - plrSpd >= 0){
            plrX -= plrSpd;
        }

        if(keyInput.Rpressed && plrX + plrSpd <= screenWidth - tileSize){
            plrX += plrSpd;
        }

        if (keyInput.Boost && plrSpd <= 10){
            plrSpd = pwr;
        }

        if (!keyInput.Boost && plrSpd != orgSpd){
            plrSpd = orgSpd;
        }
        //Map changing 
    }

    @Override
    protected void paintComponent(Graphics g){

        super.paintComponent(g);

        Graphics2D g2 = (Graphics2D)g;

        g2.setColor(Color.white);
        g2.fillOval(plrX, plrY, tileSize, tileSize);
        
        for(int row = 0; row < Map.mapData.length; row++){
    for(int col = 0; col < Map.mapData[0].length; col++){

        int tile = Map.mapData[row][col];

        int x = col * tileSize;
        int y = row * tileSize;

        if(tile == 1){
            g2.setColor(Color.gray); // WALL
        } else {
            g2.setColor(Color.black); // FLOOR
        }

        g2.fillRect(x, y, tileSize, tileSize);
    }
}

        g2.dispose();
    }
}