/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package br.edu.fei.feiTv;

import br.edu.fei.controller.CadastroController;
import br.edu.fei.model.dao.Conexao;
import br.edu.fei.view.LoginJFrame;
import br.edu.fei.view.CadastroJFrame;
import java.sql.SQLException;

/**
 *
 * @author kamil
 */
public class feiTv {

    public static void main(String[] args) throws SQLException {
        CadastroJFrame cadastroView = new CadastroJFrame();
        CadastroController controller = new CadastroController(cadastroView);
        cadastroView.setController(controller);
        cadastroView.setVisible(true);
    }
}
