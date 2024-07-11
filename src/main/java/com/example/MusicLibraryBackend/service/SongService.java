package com.example.MusicLibraryBackend.service;

import com.example.MusicLibraryBackend.dto.SongDTO;
import com.example.MusicLibraryBackend.model.Song;
import com.example.MusicLibraryBackend.repository.SongRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class SongService {
    private final SongRepository songRepository;

    public List<SongDTO> getSongsByAlbum(Long albumId) {
        List<Song> songs = songRepository.findByAlbumId(albumId);
        return songs.stream()
                .map(song -> new SongDTO(song.getId(), song.getTitle(), song.getLength()))
                .collect(Collectors.toList());
    }

    public SongDTO findById(Long id) {
        Song song = songRepository.findById(id).orElse(null);
        return new SongDTO(song.getId(), song.getTitle(), song.getLength());
    }

    public Song save(Song song) {
        return songRepository.save(song);
    }

    public void deleteById(Long id) {
        songRepository.deleteById(id);
    }
}
