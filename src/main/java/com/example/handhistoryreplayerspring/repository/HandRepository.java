package com.example.handhistoryreplayerspring.repository;

import com.example.handhistoryreplayerspring.domain.Hand;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface HandRepository extends JpaRepository<Hand, Long> {



}
