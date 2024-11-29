/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.itson.presentation.game;

import java.awt.event.ActionEvent;
import javax.swing.JButton;
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
public class GridButton extends JButton {

    private int position;

    public GridButton(int position) {
        this.position = position;
        configureButton();

    }

    private void configureButton() {
        this.addActionListener((ActionEvent e) -> {
            // Enviamos la posición seleccionada en el grid
            GameModelView.getInstance().setActualCoordinate(getPosition());
        });
    }

}
