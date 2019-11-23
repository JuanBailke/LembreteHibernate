package lembretehibernate;

import java.util.List;
import java.util.Scanner;
import lembretehibernate.infra.ILembreteDAO;
import lembretehibernate.infra.LembreteHibernateDAO;
import lembretehibernate.modelo.Lembrete;

/**
 *
 * @author mello
 */
public class LembreteHibernate {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        // TODO menu...  
//        int op = getOpcao();
        

        ILembreteDAO dao = new LembreteHibernateDAO();
        
        Lembrete l = new Lembrete();
        l.setTitulo("Teste turma A");
        l.setDescricao("Teste 22/11 - Teste com data.");
        dao.salvar(l);

        System.out.println("Recupera pelo id: ");
        System.out.println( dao.recuperaByID(16) );
        
        
        System.out.println("Recupera pelo titulo: ");
        List<Lembrete>lembretesTitulo =  dao.recuperaByTitulo("C");
        lembretesTitulo.forEach(System.out::println);
        
        
        System.out.println("Recupera todos os lembretes: ");
        List<Lembrete> lembretes = dao.recuperarTodos();
        
        lembretes.forEach((lem) -> {
            System.out.println(lem.toString());
            if(lem.getId() == 15){
                lem.setDescricao("Exemplo atualizado.");
//                dao.alterar(lem);
//                dao.excluir(lem);
            }
        });
    }

    public static int getOpcao() {
        System.out.println("1 - Inserir.");
        System.out.println("2 - Atualizar");
        System.out.println("3 - Excluir");
        System.out.println("4 - Listar todos");
        System.out.println("5 - Recuperar lembrete pelo titulo");
        System.out.println("6 - Recuperar lembrete pelo id");
        
        Scanner ler = new Scanner(System.in);
        System.out.printf("Opcao: ");
        int op = ler.nextInt();
        return op;
    }

    private static void inserir() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
