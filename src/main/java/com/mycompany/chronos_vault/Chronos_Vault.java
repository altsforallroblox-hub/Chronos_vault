/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.chronos_vault;

/**
 *
 * @author jerome
 */
import javax.swing.JFrame;

public class Chronos_Vault {
    public static void main(String[] args) {

        JFrame window = new JFrame();

        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.setResizable(false);
        window.setTitle("Chronos Vault");

        GamePanel GPan = new GamePanel();

        window.add(GPan);
        window.pack();

        GPan.GameThreadStarter();

        window.setLocationRelativeTo(null);
        window.setVisible(true);
    }
}