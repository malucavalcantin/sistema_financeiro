import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;

public class TelaControleFinancas extends JFrame {
    public TelaControleFinancas() {
        super("Controle de Finanças");
        setSize(350, 250);
        setLayout(new GridLayout(3, 1, 10, 10));
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        JButton btnRegistrarTransacao = new JButton("Registrar Transação");
        btnRegistrarTransacao.addActionListener(this::abrirTelaRegistroTransacoes);

        JButton btnAdicionarPatrimonio = new JButton("Adicionar Patrimônio");
        btnAdicionarPatrimonio.addActionListener(this::abrirTelaAdicionarPatrimonio);

        JButton btnGerarRelatorio = new JButton("Gerar Relatório Financeiro");
        btnGerarRelatorio.addActionListener(this::abrirTelaGerarRelatorio);

        add(btnRegistrarTransacao);
        add(btnAdicionarPatrimonio);
        add(btnGerarRelatorio);

        setVisible(true);
    }

    private void abrirTelaRegistroTransacoes(ActionEvent e) {
        new TelaRegistroTransacoes();
    }

    private void abrirTelaAdicionarPatrimonio(ActionEvent e) {
        new TelaAdicionarPatrimonio();
    }

    private void abrirTelaGerarRelatorio(ActionEvent e) {
        new TelaGerarRelatorio();
    }

    public static void main(String[] args) {
        new TelaControleFinancas();
    }
}
