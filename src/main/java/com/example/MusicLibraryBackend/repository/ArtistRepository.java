package com.example.MusicLibraryBackend.repository;

import com.example.MusicLibraryBackend.model.Artist;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ArtistRepository extends JpaRepository<Artist, Long> {
    List findByNameContainingIgnoreCase(String q);
}
