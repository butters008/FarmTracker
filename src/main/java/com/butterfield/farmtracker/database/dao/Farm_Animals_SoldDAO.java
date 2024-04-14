package com.butterfield.farmtracker.database.dao;

import com.butterfield.farmtracker.database.entity.Farm_Animals_Sold;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface Farm_Animals_SoldDAO extends JpaRepository<Farm_Animals_Sold, Long> {
}
