import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class TelaRegistroTransacoes extends JFrame {
    private JTextField textFieldCategoria, textFieldValor, textFieldDescricao, textFieldData;
    private JComboBox<String> comboBoxTipo;

    public TelaRegistroTransacoes() {
        setTitle("Registro de Transações");
        setSize(400, 300);
        setLayout(new GridLayout(6, 2));

        add(new JLabel("Tipo:"));
        comboBoxTipo = new JComboBox<>(new String[]{"Entrada", "Saída"});
        add(comboBoxTipo);

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

        JButton btnRegistrar = new JButton("Registrar");
        btnRegistrar.addActionListener(this::registrarTransacao);
        add(btnRegistrar);

        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);
        setVisible(true);
    }

    private void registrarTransacao(ActionEvent e) {
        try {
            Transacao transacao = new Transacao();
            transacao.setTipo(comboBoxTipo.getSelectedItem().toString());
            transacao.setCategoria(textFieldCategoria.getText());
            transacao.setValor(Double.parseDouble(textFieldValor.getText()));
            transacao.setDescricao(textFieldDescricao.getText());
            SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
            Date data = sdf.parse(textFieldData.getText());
            transacao.setData(data);

            Usuario usuario = new Usuario(); // Suponha que 
