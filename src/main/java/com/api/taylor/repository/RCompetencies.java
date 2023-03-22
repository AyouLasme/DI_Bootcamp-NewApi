package com.api.taylor.repository;

import com.api.taylor.models.TCompetencies;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RCompetencies extends JpaRepository <TCompetencies,Long> {
}
