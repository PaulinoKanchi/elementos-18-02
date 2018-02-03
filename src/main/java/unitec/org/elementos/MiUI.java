package unitec.org.elementos;

import com.vaadin.annotations.Theme;
import com.vaadin.server.VaadinRequest;
import com.vaadin.spring.annotation.SpringUI;
import com.vaadin.ui.Button;
import com.vaadin.ui.Grid;
import com.vaadin.ui.Label;
import com.vaadin.ui.TextField;
import com.vaadin.ui.UI;
import com.vaadin.ui.VerticalLayout;
import com.vaadin.ui.themes.ValoTheme;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;


@SpringUI
@Theme("valo")
public class MiUI extends UI{
@Autowired RepositorioMensajitos repoMensa;
    @Override
    protected void init(VaadinRequest request) {
    //Agregaremos un layaut vertical y dentro de el las componentesque quedaran  en orden descendente        
    VerticalLayout layout=new VerticalLayout();
    Label e1=new Label("Bienvenidos");
    e1.addStyleName(ValoTheme.LABEL_H1);
    
    Button b1=new Button("Guardar");
    b1.addStyleNames(ValoTheme.BUTTON_DANGER);
    TextField t1=new TextField();
    t1.addStyleNames(ValoTheme.TEXTAREA_LARGE);
    //Vamos  programar el eveneto del boton b1 usando programacion funcional
    b1.addClickListener(algo->{
       //Aqui ponemos el evento
    
       e1.setValue("Mi primer programacion funcional");
       Mensajitos m=new Mensajitos ("Prueba","Mi segundo menaJITO CON HIBERNATE");
       repoMensa.save(m);
    });
    //Agregamos las componentes al layout
    layout.addComponent(e1);
    layout.addComponent(b1);
    //Esto que sigue solo se hace una vez agregamos el layput a la pagina index
    //setContent(layout);
    //}
    
    List<Mensajitos> mensajitos= (List<Mensajitos>) repoMensa.findAll();

// Create a grid bound to the list
Grid<Mensajitos> grid = new Grid<>();
grid.setItems(mensajitos);
grid.addColumn(Mensajitos::getId).setCaption("ID");
grid.addColumn(Mensajitos::getTitulo).setCaption("Titulo");
grid.addColumn(Mensajitos::getCuerpo).setCaption("Cuerpo");

    layout.addComponent(grid);
    setContent(layout);
}
}