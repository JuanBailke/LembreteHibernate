package lembretehibernate.infra;

import lembretehibernate.modelo.Lembrete;
import java.util.*;

/**
 *
 * @author mello
 */
public interface ILembreteDAO {
    public void salvar(Lembrete l);
    public void alterar(Lembrete l);
    public void excluir(Lembrete l);
    public List<Lembrete> recuperarTodos();
    public Lembrete recuperaByID(long id);
    public List<Lembrete> recuperaByTitulo(String Titulo);
}
