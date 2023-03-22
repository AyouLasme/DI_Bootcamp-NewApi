package com.api.taylor.repository;

import com.api.taylor.models.TReponse;
import com.api.taylor.models.TUsers;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface RReponse  extends CrudRepository<TReponse, Long> {
    public List<TReponse> findByDemande(long id);
}
