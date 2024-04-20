package com.example.handhistoryreplayerspring.repository;

import com.example.handhistoryreplayerspring.domain.Player;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PlayerRepository extends JpaRepository<Player, Long> {
}
