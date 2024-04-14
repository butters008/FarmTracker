package com.butterfield.farmtracker.database.dao;

import com.butterfield.farmtracker.database.entity.Client;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClientDAO extends JpaRepository<Client, Long> {
}
