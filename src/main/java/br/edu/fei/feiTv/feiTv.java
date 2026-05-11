/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package br.edu.fei.feiTv;

import br.edu.fei.controller.UsuarioController;
import br.edu.fei.view.CadastroJFrame;
import java.sql.SQLException;

/**
 *
 * @author kamil
 */
public class feiTv {

    public static void main(String[] args) throws SQLException{
        CadastroJFrame cadastroView = new CadastroJFrame();
        UsuarioController controller = new UsuarioController();
        cadastroView.setController(controller);
        cadastroView.setVisible(true);
    }
}
