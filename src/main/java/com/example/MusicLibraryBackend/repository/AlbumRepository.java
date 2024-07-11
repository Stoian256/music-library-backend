package com.example.MusicLibraryBackend.repository;

import com.example.MusicLibraryBackend.model.Album;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AlbumRepository extends JpaRepository<Album, Long> {}
