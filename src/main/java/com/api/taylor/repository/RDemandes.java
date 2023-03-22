package com.api.taylor.repository;

import com.api.taylor.models.TDemandes;
import com.api.taylor.models.TTaylors;
import com.api.taylor.models.TUsers;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface RDemandes extends CrudRepository<TDemandes, Long> {
    public List<TDemandes> findByMunicipality(long municipality_fk);
    public List<TDemandes> findBySender(long sender_fk);
    public List<TDemandes> findByReceiver(long receiver_fk);

}
