import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;

public class TelaPrincipal extends JFrame {
    private JTextField textFieldEmail;
    private JPasswordField passwordFieldSenha;
    private UsuarioDAO usuarioDAO;

    public TelaPrincipal() {
        super("Sistema de Gestão Financeira");
        setSize(300, 200);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new GridLayout(4, 2));

        setupUI();
        setupListeners();
        usuarioDAO = new UsuarioDAO();
        setLocationRelativeTo(null);
        setVisible(true);
    }

    private void setupUI() {
        add(new JLabel("Email:"));
        textFieldEmail = new JTextField();
        add(textFieldEmail);

        add(new JLabel("Senha:"));
        passwordFieldSenha = new JPasswordField();
        add(passwordFieldSenha);

        JButton btnLogin = new JButton("Entrar");
        add(btnLogin);

        JButton btnRegistrar = new JButton("Registrar");
        add(btnRegistrar);
    }

    private void setupListeners() {
        JButton btnLogin = (JButton) getContentPane().getComponent(4);
        btnLogin.addActionListener(this::login);

        JButton btnRegistrar = (JButton) getContentPane().getComponent(5);
        btnRegistrar.addActionListener(this::registrar);
    }

    private void login(ActionEvent e) {
        String email = textFieldEmail.getText();
        String senha = new String(passwordFieldSenha.getPassword());
        boolean autenticado = usuarioDAO.autenticarUsuario(email, senha);

        if (autenticado) {
            JOptionPane.showMessageDialog(this, "Login bem-sucedido!");
            new TelaControleFinancas();  // Abre a tela de controle financeiro
            this.dispose();  // Fecha a tela de login
        } else {
            JOptionPane.showMessageDialog(this, "Email ou senha incorretos!", "Erro", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void registrar(ActionEvent e) {
        String email = textFieldEmail.getText();
        String senha = new String(passwordFieldSenha.getPassword());

        if (!email.isEmpty() && !senha.isEmpty()) {
            Usuario usuario = new Usuario("Nome Padrão", email, senha);
            usuarioDAO.salvar(usuario);
            JOptionPane.showMessageDialog(this, "Usuário registrado com sucesso!");
            new TelaControleFinancas();  // Abre a tela de controle financeiro
            this.dispose();  // Fecha a tela de login
        } else {
            JOptionPane.showMessageDialog(this, "Email e senha não podem ser vazios!", "Erro", JOptionPane.ERROR_MESSAGE);
        }
    }

    public static void main(String[] args) {
        new TelaPrincipal();
    }
}
