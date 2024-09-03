import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class TelaAdicionarPatrimonio extends JFrame {
    private JTextField textFieldCategoria, textFieldValor, textFieldDescricao, textFieldData;

    public TelaAdicionarPatrimonio() {
        setTitle("Adicionar Patrimônio");
        setSize(400, 300);
        setLayout(new GridLayout(5, 2));

        add(new JLabel("Categoria:"));
        textFieldCategoria = new JTextField();
        add(textFieldCategoria);

        add(new JLabel("Valor:"));
        textFieldValor = new JTextField();
        add(textFieldValor);

        add(new JLabel("Descrição:"));
        textFieldDescricao = new JTextField();
        add(textFieldDescricao);

        add(new JLabel("Data:"));
        textFieldData = new JTextField();
        add(textFieldData);

        JButton btnAdicionar = new JButton("Adicionar");
        btnAdicionar.addActionListener(this::adicionarPatrimonio);
        add(btnAdicionar);

        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);
        setVisible(true);
    }

    private void adicionarPatrimonio(ActionEvent e) {
        try {
            Patrimonio patrimonio = new Patrimonio();
            patrimonio.setCategoria(textFieldCategoria.getText());
            patrimonio.setValor(Double.parseDouble(textFieldValor.getText()));
            patrimonio.setDescricao(textFieldDescricao.getText());
            SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
            patrimonio.setData(sdf.parse(textFieldData.getText()));

            Usuario usuario = new Usuario(); // Suponha que você tem um método para obter o usuário logado
            patrimonio.setUsuario(usuario);

            PatrimonioDAO patrimonioDAO = new PatrimonioDAO();
            patrimonioDAO.salvar(patrimonio);

            JOptionPane.showMessageDialog(this, "Patrimônio adicionado com sucesso!");
        } catch (ParseException ex) {
            JOptionPane.showMessageDialog(this, "Erro no formato da data. Use o formato DD/MM/AAAA.");
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(this, "Erro no formato do valor. Use apenas números.");
        }
    }

    public static void main(String[] args) {
        new TelaAdicionarPatrimonio();
    }
}
