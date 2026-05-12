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
 */
public class feiTv {

    public static void main(String[] args) throws SQLException{
        // Controller responsável pelo login
        LoginController controller = new LoginController();

        // Tela inicial do sistema (Login)
        LoginJFrame loginView = new LoginJFrame();

        // Injeta o controller na view
        loginView.setController(controller);

        // Abre a tela de login
        loginView.setVisible(true);
    }
}
