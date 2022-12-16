package com.macro.imagegallery.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.macro.imagegallery.entity.ImageGallery;


@Repository
public interface ImageGalleryRepository extends JpaRepository<ImageGallery, Long>{

}

