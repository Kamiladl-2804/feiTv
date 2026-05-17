/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.edu.fei.controller;

import br.edu.fei.view.LoginJFrame;
import br.edu.fei.view.PrincipalJFrame;

/**
 *
 * @author kamil
 */
public class PrincipalController {
    public void sair(PrincipalJFrame tela) {

        LoginJFrame login =
                new LoginJFrame();

        login.setController(
                new LoginController()
        );

        login.setVisible(true);

        tela.dispose();
    }
    
}
