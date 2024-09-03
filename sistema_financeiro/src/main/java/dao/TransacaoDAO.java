import javax.persistence.EntityManager;
import java.util.List;

public class TransacaoDAO extends DAOGeral<Transacao> {
    public TransacaoDAO() {
        super(Transacao.class);
    }

    public List<Transacao> buscarTransacoesPorUsuario(Usuario usuario) {
        EntityManager em = getEntityManager();
        try {
            return em.createQuery("SELECT t FROM Transacao t WHERE t.usuario = :usuario", Transacao.class)
                     .setParameter("usuario", usuario)
                     .getResultList();
        } finally {
            em.close();
        }
    }
}
