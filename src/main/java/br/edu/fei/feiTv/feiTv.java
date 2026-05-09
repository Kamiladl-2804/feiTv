/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package br.edu.fei.feiTv;

import br.edu.fei.controller.Controller;
import br.edu.fei.model.dao.Conexao;
import br.edu.fei.view.CadastroJFrame;
import java.sql.SQLException;

/**
 *
 * @author andrezanon
 */
public class feiTv {

    public static void main(String[] args) throws SQLException {
        CadastroJFrame cadastroView = new CadastroJFrame();
        Controller controller = new Controller(cadastroView);
        cadastroView.setController(controller);
        cadastroView.setVisible(true);
    }
}
