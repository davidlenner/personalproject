package com.lenner.personalprojectwithapis.repository;

import com.lenner.personalprojectwithapis.models.Picture;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PictureRepo extends JpaRepository<Picture,Long> {
}
