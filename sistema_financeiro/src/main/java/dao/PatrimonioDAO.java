import javax.persistence.EntityManager;
import java.util.List;

public class PatrimonioDAO extends DAOGeral<Patrimonio> {
    public PatrimonioDAO() {
        super(Patrimonio.class);
    }

    public List<Patrimonio> buscarPatrimoniosPorUsuario(Usuario usuario) {
        EntityManager em = getEntityManager();
        try {
            return em.createQuery("SELECT p FROM Patrimonio p WHERE p.usuario = :usuario", Patrimonio.class)
                     .setParameter("usuario", usuario)
                     .getResultList();
        } finally {
            em.close();
        }
    }
}
