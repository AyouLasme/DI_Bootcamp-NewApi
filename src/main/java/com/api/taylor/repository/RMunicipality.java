package com.api.taylor.repository;

import com.api.taylor.models.TMessages;
import com.api.taylor.models.TMunicipality;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RMunicipality extends JpaRepository<TMunicipality,Long> {
}
