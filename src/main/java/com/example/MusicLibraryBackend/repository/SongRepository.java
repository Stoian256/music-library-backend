package com.example.MusicLibraryBackend.repository;

import com.example.MusicLibraryBackend.model.Song;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SongRepository extends JpaRepository<Song, Long> {}
