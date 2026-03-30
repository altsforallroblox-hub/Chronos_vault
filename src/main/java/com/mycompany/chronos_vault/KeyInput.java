/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author jerome
 */
package com.mycompany.chronos_vault;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class KeyInput implements KeyListener{

    public boolean Upressed, Dpressed, Lpressed, Rpressed, Boost;

    @Override
    public void keyTyped(KeyEvent e) {}

    @Override
    public void keyPressed(KeyEvent e) {

        int code = e.getKeyCode();

        if(code == KeyEvent.VK_W) Upressed = true;
        if(code == KeyEvent.VK_A) Lpressed = true;
        if(code == KeyEvent.VK_S) Dpressed = true;
        if(code == KeyEvent.VK_D) Rpressed = true;
        if(code == KeyEvent.VK_SHIFT) Boost = true;
    }

    @Override
    public void keyReleased(KeyEvent e) {

        int code = e.getKeyCode();

        if(code == KeyEvent.VK_W) Upressed = false;
        if(code == KeyEvent.VK_A) Lpressed = false;
        if(code == KeyEvent.VK_S) Dpressed = false;
        if(code == KeyEvent.VK_D) Rpressed = false;
        //Testing lang yung boost
        if(code == KeyEvent.VK_SHIFT) Boost = false;
    }
}