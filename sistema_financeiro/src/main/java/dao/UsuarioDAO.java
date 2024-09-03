import javax.persistence.EntityManager;

public class UsuarioDAO extends DAOGeral<Usuario> {
    public UsuarioDAO() {
        super(Usuario.class);
    }

    public Usuario buscarPorEmail(String email) {
        EntityManager em = getEntityManager();
        try {
            return em.createQuery("SELECT u FROM Usuario u WHERE u.email = :email", Usuario.class)
                     .setParameter("email", email)
                     .getSingleResult();
        } catch (Exception e) {
            return null; // Retornar null caso não encontre o usuário
        } finally {
            em.close();
        }
    }

    public boolean autenticarUsuario(String email, String senha) {
        Usuario usuario = buscarPorEmail(email);
        return usuario != null && usuario.getSenha().equals(senha);
    }
}
