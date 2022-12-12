package com.restaurant.Dao;

import com.restaurant.Models.Document;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DocumentsDao extends JpaRepository<Document, Integer> {
}
