package unitec.org.elementos;

import java.util.ArrayList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ElementosApplication implements CommandLineRunner{
    //inyeccionde depenbdencias
    @Autowired RepositorioMensajitos repoMensa;
    //autoenlazar
	public static void main(String[] args) {
		SpringApplication.run(ElementosApplication.class, args);
	}

    @Override

    public void run(String... strings) throws Exception {
            //guardar
        // Mensajitos m=new Mensajitos ("tercero","Mi segundo menaJITO CON HIBERNATE");
        //repoMensa.save(m);
        
        //probamos el de buscar
       /* ArrayList<Mensajitos> mensajitos= (ArrayList<Mensajitos>) repoMensa.findAll();
        for(Mensajitos mensa: mensajitos){
            System.out.println(mensa.getTitulo());  
            
        }*/
        //ahora probaremos buscar por id
          //Mensajitos m1= repoMensa.findOne(2);
          //System.out.println(m1.getTitulo());
          
          //actualizacion
          //repoMensa.save(new Mensajitos(4,"cuarto","cuarto"));
          //borrar
          //repoMensa.delete(4);
        }
}
