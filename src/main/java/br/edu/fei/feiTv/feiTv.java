/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package br.edu.fei.feiTv;

import br.edu.fei.controller.LoginController;
import br.edu.fei.view.LoginJFrame;
import java.sql.SQLException;

/**
 *
 * @author kamil
 * Responsável por iniciar o programa mostrando a primeira tela que é login
 */
public class feiTv {

    public static void main(String[] args) throws SQLException{
        // Controller responsável pelo login
        LoginController controller = new LoginController();

        // Tela inicial do programa
        LoginJFrame loginView = new LoginJFrame();

        // Chama o controller
        loginView.setController(controller);

        // Abre a tela de login
        loginView.setVisible(true);
    }
}
