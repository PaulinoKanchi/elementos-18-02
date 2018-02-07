package unitec.org.elementos;

//import javax.persistence.Column;
import com.vaadin.ui.TextField;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity

//las entidades se mapean todas con jpa
public class Mensajitos { 
    @Id
    @GeneratedValue//para el autoincremento
    //@Column(name="id") solo si el nombre de la tabla no fuese igual al de java class
    private Integer id;
    private String titulo;
    private String cuerpo;
    
    public Mensajitos() {
    }

    public Mensajitos(Integer id) {
        this.id = id;
    }

    public Mensajitos(String titulo, String cuerpo) {
        this.titulo = titulo;
        this.cuerpo = cuerpo;
    }

    public Mensajitos(Integer id, String titulo, String cuerpo) {
        this.id = id;
        this.titulo = titulo;
        this.cuerpo = cuerpo;
    }
    

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getCuerpo() {
        return cuerpo;
    }

    public void setCuerpo(String cuerpo) {
        this.cuerpo = cuerpo;
    }
    
}
