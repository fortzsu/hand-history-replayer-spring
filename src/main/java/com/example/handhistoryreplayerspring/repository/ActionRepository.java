package com.example.handhistoryreplayerspring.repository;

import com.example.handhistoryreplayerspring.domain.Action;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ActionRepository extends JpaRepository<Action, Long> {
}
