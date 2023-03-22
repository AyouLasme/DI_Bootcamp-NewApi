package com.api.taylor.repository;

import com.api.taylor.models.TCompetencies;
import com.api.taylor.models.TImages;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RImages extends JpaRepository<TImages,Long> {
}
