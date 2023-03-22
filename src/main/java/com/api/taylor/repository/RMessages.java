package com.api.taylor.repository;

import com.api.taylor.models.TMessages;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RMessages extends JpaRepository<TMessages,Long> {
}
