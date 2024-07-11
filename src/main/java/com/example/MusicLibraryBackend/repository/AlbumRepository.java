package com.example.MusicLibraryBackend.repository;

import com.example.MusicLibraryBackend.model.Album;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;
public interface AlbumRepository extends JpaRepository<Album, Long> {
    List<Album> findByArtistId(Long artistId);
}
