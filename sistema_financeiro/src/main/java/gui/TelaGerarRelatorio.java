import javax.swing.*;
import java.awt.*;
import java.util.List;

public class TelaGerarRelatorio extends JFrame {
    private JTextArea textAreaReport;

    public TelaGerarRelatorio() {
        setTitle("Relatório Financeiro");
        setSize(400, 300);
        setLayout(new BorderLayout());

        textAreaReport = new JTextArea();
        add(new JScrollPane(textAreaReport), BorderLayout.CENTER);

        JButton btnGerar = new JButton("Gerar Relatório");
        btnGerar.addActionListener(e -> gerarRelatorio());
        add(btnGerar, BorderLayout.SOUTH);

        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);
        setVisible(true);
    }

    private void gerarRelatorio() {
        Usuario usuario = new Usuario(); // Suponha que você tem um método para obter o usuário logado

        TransacaoDAO transacaoDAO = new TransacaoDAO();
        List<Transacao> transacoes = transacaoDAO.buscarTransacoesPorUsuario(usuario);

        double saldo = transacoes.stream()
            .filter(t -> t.getTipo().equals("Entrada"))
            .mapToDouble(Transacao::getValor)
            .sum() - transacoes.stream()
            .filter(t -> t.getTipo().equals("Saída"))
            .mapToDouble(Transacao::getValor)
            .sum();

        PatrimonioDAO patrimonioDAO = new PatrimonioDAO();
        List<Patrimonio> patrimonios = patrimonioDAO.buscarPatrimoniosPorUsuario(usuario);

        double totalPatrimonio = patrimonios.stream()
            .mapToDouble(Patrimonio::getValor)
            .sum();

        String report = "Relatório Financeiro para " + usuario.getNome() + ":\n\n" +
                        "Total Patrimônio: R$ " + String.format("%.2f", totalPatrimonio) + "\n" +
                        "Saldo das Transações: R$ " + String.format("%.2f", saldo);

        textAreaReport.setText(report);
    }

    public static void main(String[] args) {
        new TelaGerarRelatorio();
    }
}
