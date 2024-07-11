package com.example.MusicLibraryBackend.repository;

import com.example.MusicLibraryBackend.model.Song;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface SongRepository extends JpaRepository<Song, Long> {
    List<Song> findByAlbumId(Long albumId);
}
