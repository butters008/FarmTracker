package com.butterfield.farmtracker.database.dao;

import com.butterfield.farmtracker.database.entity.Farm_Animal;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface Farm_AnimalDAO extends JpaRepository<Farm_Animal, Long> {

}
