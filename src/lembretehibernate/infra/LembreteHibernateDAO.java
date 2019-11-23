package lembretehibernate.infra;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Query;
import lembretehibernate.modelo.Lembrete;

/**
 *
 * @author mello
 */
public class LembreteHibernateDAO implements ILembreteDAO {

    @Override
    public void salvar(Lembrete l) {
        //cria um gerenciador de entidades
        EntityManager em = ConnectionFactoryHibernate.getEntityManager();
        try {
            //abrir uma transacao
            em.getTransaction().begin();
            //solicita ao gerenciador que salve a entidade
            em.persist(l);
            //fechar a transacao
            em.getTransaction().commit();

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            //encerra o gerenciador de entidades
            em.close();
        }
    }

    @Override
    public void alterar(Lembrete l) {
        try {
            //cria um gerenciador de entidades
            EntityManager em = ConnectionFactoryHibernate.getEntityManager();
            //abrir uma transacao
            em.getTransaction().begin();
            //solicita ao gerenciador atualizar a entidade
            em.merge(l);
            //fechar a transacao
            em.getTransaction().commit();
            //encerra o gerenciador de entidades
            em.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void excluir(Lembrete l) {
        try {
            //cria um gerenciador de entidades
            EntityManager em = ConnectionFactoryHibernate.getEntityManager();
            //abrir uma transacao
            em.getTransaction().begin();
            //informa que o objeto é gerenciado pela sessao
            l = em.merge(l);
            //solicita ao gerenciador remover a entidade
            em.remove(l);
            //fechar a transacao
            em.getTransaction().commit();
            //encerra o gerenciador de entidades
            em.close();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    @Override
    public List<Lembrete> recuperarTodos() {
        List<Lembrete> lembretes = new ArrayList<>();

        try {
            //cria um gerenciador de entidades
            EntityManager em = ConnectionFactoryHibernate.getEntityManager();
            //solicita ao gerenciador todas as instâncias da classe Lembrete
            Query query = em.createQuery("from Lembrete");
            lembretes = query.getResultList();
            //encerra o gerenciador de entidades
            em.close();
        } catch (Exception e) {
            e.getMessage();
        }
        return lembretes;
    }

    @Override
    public Lembrete recuperaByID(long id) {
        Lembrete lembrete = new Lembrete();
        try {
            //cria um gerenciador de entidades
            EntityManager em = ConnectionFactoryHibernate.getEntityManager();

            /* busca na tabela da correspondende a classe Lembrete 
            uma entidade com chave primária = id*/
            lembrete = em.find(Lembrete.class, id);

            //encerra o gerenciador de entidades
            em.close();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return lembrete;
    }

    @Override
    public List<Lembrete> recuperaByTitulo(String titulo) {
        List<Lembrete> lembretes = new ArrayList<>();
        try {
            //cria um gerenciador de entidades
            EntityManager em = ConnectionFactoryHibernate.getEntityManager();
            Query query = em.createQuery("from Lembrete l where l.titulo Like :titulo").setParameter("titulo", "%" + titulo + "%");
            lembretes = query.getResultList();
            //encerra o gerenciador de entidades
            em.close();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return lembretes;
    }

}
