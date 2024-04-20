package com.butterfield.farmtracker.database.dao;

import com.butterfield.farmtracker.database.entity.User_Farm_Animals;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface User_Farm_AnimalDAO extends JpaRepository<User_Farm_Animals, Long> {
}
