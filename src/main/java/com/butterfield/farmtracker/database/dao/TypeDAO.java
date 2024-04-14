package com.butterfield.farmtracker.database.dao;

import com.butterfield.farmtracker.database.entity.Type;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TypeDAO extends JpaRepository<Type, Long> {

}
