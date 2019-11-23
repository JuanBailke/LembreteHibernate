package lembretehibernate.modelo;

import java.io.Serializable;
import java.util.Calendar;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import org.hibernate.annotations.CreationTimestamp;

/**
 *
 * @author mello
 */
@Entity
public class Lembrete implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String titulo;
    private String descricao;

    @CreationTimestamp
    @Temporal(TemporalType.TIMESTAMP)
    private Calendar dataCriacao;
    
    public Lembrete() {
    }

    public long getId() {
        return id;
    }

    public String getTitulo() {
        return titulo;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    @Override
    public String toString() {
        return "Lembrete{" + "id=" + id + ", titulo=" + titulo + ", descricao=" + descricao + ", dataCriacao=" + dataCriacao + '}';
    }

   

}
