package ecdc.springframework.repositories;

import ecdc.springframework.domain.Global;
import ecdc.springframework.services.GlobalServiceCustom;

import org.springframework.data.repository.CrudRepository;

import java.util.UUID;

/**
 * Created by jt on 1/10/17.
 */
public interface GlobalRepository extends CrudRepository<Global, Integer> {
	
   public Global getById(int id);
  //  Global saveOrUpdate(Global global);
}
