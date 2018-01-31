package unitec.org.elementos;

import com.vaadin.annotations.Theme;
import com.vaadin.server.VaadinRequest;
import com.vaadin.spring.annotation.SpringUI;
import com.vaadin.ui.Button;
import com.vaadin.ui.Label;
import com.vaadin.ui.UI;
import com.vaadin.ui.VerticalLayout;
import com.vaadin.ui.themes.ValoTheme;
import java.util.ArrayList;

@SpringUI
@Theme("valo")
public class MiUI extends UI{

    @Override
    protected void init(VaadinRequest request) {
    //Agregaremos un layaut vertical y dentro de el las componentesque quedaran  en orden descendente        
    VerticalLayout layout=new VerticalLayout();
    Label e1=new Label("Bienvenidos");
    e1.addStyleName(ValoTheme.LABEL_H1);
    
    Button b1=new Button("Guardar");
    b1.addStyleNames(ValoTheme.BUTTON_DANGER);
    //Vamos  programar el eveneto del boton b1 usando programacion funcional
    b1.addClickListener(algo->{
       //Aqui ponemos el evento
       e1.setValue("Mi primer programacion funcional");
    });
    //Agregamos las componentes al layout
    layout.addComponent(e1);
    layout.addComponent(b1);
    //Esto que sigue solo se hace una vez agregamos el layput a la pagina index
    setContent(layout);
    }
    
    ArrayList<Mensajitos> MEN = ArrayList(
    new Mensajitos("Nicolaus Copernicus", "1543"),
    new Mensajitos("Galileo Galilei", "1564"),
    new Mensajitos("Johannes Kepler", "1"));

// Create a grid bound to the list
Grid<MEN> grid = new Grid<>();
grid.setItems(Mensajitos);
grid.addColumn(Mensajitos::getTitulo).setCaption("Name");
grid.addColumn(Mensajitos::getCuerpo).setCaption("Year of birth");

    
}
