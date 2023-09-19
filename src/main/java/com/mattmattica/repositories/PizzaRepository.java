package com.mattmattica.repositories;

import com.mattmattica.entities.Pizza;
import org.springframework.data.repository.CrudRepository;

public interface PizzaRepository extends CrudRepository<Pizza, Integer> {

}
