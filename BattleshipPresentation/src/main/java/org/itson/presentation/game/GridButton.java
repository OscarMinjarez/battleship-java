/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.itson.presentation.game;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JToggleButton;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * GridButton
 * @author PabloCeasxr
 */
@Getter
@Setter
@NoArgsConstructor
public class GridButton extends JToggleButton implements ActionListener {

    private int position;
    private GameView gameView;
    private String who;
    
    public GridButton(int position, GameView gameView, String who) {
        super();
        this.position = position;
        this.gameView = gameView;
        this.who = who;
        this.addActionListener(this);
    }


    @Override
    public void actionPerformed(ActionEvent e) {
        if (this.who.equalsIgnoreCase("enemy")) {
            this.gameView.setSelectedIndex(this.position);
        }
    }
}
