/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package unitec.org.elementos;

import java.io.Serializable;
import org.springframework.data.repository.CrudRepository;

/**
 *
 * @author T-107
 */
public interface RepositorioMensajitos extends CrudRepository<Mensajitos, Integer>{//clase,tipo de dato del id
    
}
