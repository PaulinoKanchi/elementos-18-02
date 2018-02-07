package unitec.org.elementos;

import com.vaadin.annotations.Theme;
import com.vaadin.server.VaadinRequest;
import com.vaadin.spring.annotation.SpringUI;
import com.vaadin.ui.Button;
import com.vaadin.ui.Grid;
import com.vaadin.ui.Grid.SelectionMode;
import com.vaadin.ui.Label;
import com.vaadin.ui.Notification;
import com.vaadin.ui.TextField;
import com.vaadin.ui.UI;
import com.vaadin.ui.VerticalLayout;
import com.vaadin.ui.Window;
import com.vaadin.ui.themes.ValoTheme;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;

 
@SpringUI
@Theme("valo")
public class MiUI extends UI{
   public TextField t1;
   public TextField t2;
@Autowired RepositorioMensajitos repoMensa;
    @Override
    protected void init(VaadinRequest request) {
    //Agregaremos un layaut vertical y dentro de el las componentesque quedaran  en orden descendente        
    VerticalLayout layout=new VerticalLayout();
    Label e1=new Label("Bienvenidos");
    e1.addStyleName(ValoTheme.LABEL_H1);
    t1=new TextField();
    t2=new TextField();
    
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
    //setContent(layout);
    //}
    
    List<Mensajitos> mensajitos= (List<Mensajitos>) repoMensa.findAll();

// Create a grid bound to the list
Grid<Mensajitos> grid = new Grid<>();
grid.setItems(mensajitos);
grid.addColumn(Mensajitos::getId).setCaption("ID");
grid.addColumn(Mensajitos::getTitulo).setCaption("Titulo");
grid.addColumn(Mensajitos::getCuerpo).setCaption("Cuerpo");

        grid.setSelectionMode(SelectionMode.SINGLE);

        grid.addItemClickListener(evento -> {
            Notification.show("Valor: " + evento.getItem().getTitulo());
            MiVentana sub = new MiVentana();

            UI.getCurrent().addWindow(sub);
        t1.setValue(evento.getItem().getTitulo());
        t2.setValue(evento.getItem().getCuerpo());
            
        });


    layout.addComponent(grid);
    setContent(layout);
}class MiVentana extends Window {

    public MiVentana() {
        super("Actualizar o borrar");
        center();
        VerticalLayout vl2 = new VerticalLayout();

        
       // t1.setValue(evento.getItem().getTitulo());
        
        Button boton = new Button("Actualizar");
        boton.addClickListener(evento -> {
            close();
        });
        vl2.addComponent(t1);
        vl2.addComponent(t2);
        vl2.addComponent(boton);

        setContent(vl2);
    }
}
}
