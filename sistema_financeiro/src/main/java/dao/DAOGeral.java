import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.List;

public class DAOGeral<T> {
    private static EntityManagerFactory emf = Persistence.createEntityManagerFactory("FinanceiroPU");
    private Class<T> classeEntidade;

    public DAOGeral(Class<T> classeEntidade) {
        this.classeEntidade = classeEntidade;
    }

    protected EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public T buscar(int id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(classeEntidade, id);
        } finally {
            em.close();
        }
    }

    public void salvar(T entidade) {
        EntityManager em = getEntityManager();
        try {
            em.getTransaction().begin();
            em.persist(entidade);
            em.getTransaction().commit();
        } finally {
            em.close();
        }
    }

    public void atualizar(T entidade) {
        EntityManager em = getEntityManager();
        try {
            em.getTransaction().begin();
            em.merge(entidade);
            em.getTransaction().commit();
        } finally {
            em.close();
        }
    }

    public void remover(T entidade) {
        EntityManager em = getEntityManager();
        try {
            em.getTransaction().begin();
            em.remove(em.contains(entidade) ? entidade : em.merge(entidade));
            em.getTransaction().commit();
        } finally {
            em.close();
        }
    }

    public List<T> buscarTodos() {
        EntityManager em = getEntityManager();
        try {
            return em.createQuery("FROM " + classeEntidade.getName(), classeEntidade).getResultList();
        } finally {
            em.close();
        }
    }
}
