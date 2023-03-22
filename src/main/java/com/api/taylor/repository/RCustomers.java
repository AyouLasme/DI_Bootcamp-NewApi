package com.api.taylor.repository;

import com.api.taylor.models.TCustomers;
import com.api.taylor.models.TUsers;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface RCustomers extends CrudRepository<TCustomers, Long> {
    public Optional<TCustomers> findByEmailAndPassword(String email, String password);
}
