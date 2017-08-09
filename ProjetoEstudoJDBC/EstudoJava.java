package estudojava;

import javax.swing.JOptionPane;

public class EstudoJava {

    public static void main(String[] args) {
        DAO dao = new DAO();

        int opcao = Integer.parseInt(JOptionPane.showInputDialog(null, "", "Selecione uma opção [1],[2] e [3]", 1));

        if (opcao == 1) {
            String apelido = JOptionPane.showInputDialog(null, "", "Pesquisar apelido", 1);
            dao.buscarApelido(apelido);
        }
        if (opcao == 2) {
            String nome = JOptionPane.showInputDialog(null, "", "Pesquisar nome", 1);
            dao.buscarNome(nome);
        } 
        if (opcao == 3) {
            String apelido = JOptionPane.showInputDialog(null, "", "Alterar apelido", 1);
            dao.alterarApelido(apelido);
        }else {
            JOptionPane.showConfirmDialog(null, "Opção invalida [1]Pesquisar apelido." + "\n" + "[2]Pesquisar nome.");
        }

    }

}
