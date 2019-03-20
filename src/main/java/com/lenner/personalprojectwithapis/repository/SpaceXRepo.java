package com.lenner.personalprojectwithapis.repository;

import com.lenner.personalprojectwithapis.models.SpaceXData;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SpaceXRepo extends JpaRepository<SpaceXData,Long> {
}
