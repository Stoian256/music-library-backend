package com.example.MusicLibraryBackend.utils;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import com.example.MusicLibraryBackend.model.Album;
import com.example.MusicLibraryBackend.model.Artist;
import com.example.MusicLibraryBackend.model.Song;
import org.springframework.boot.CommandLineRunner;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Component;
import com.example.MusicLibraryBackend.repository.AlbumRepository;
import com.example.MusicLibraryBackend.repository.ArtistRepository;
import com.example.MusicLibraryBackend.repository.SongRepository;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Component
@RequiredArgsConstructor
public class DataLoader implements CommandLineRunner {

    private final ArtistRepository artistRepository;

    @Override
    public void run(String... args) throws Exception {
        ObjectMapper mapper = new ObjectMapper();
        InputStream inputStream = new ClassPathResource("data.json").getInputStream();

        try {
            List<Map<String, Object>> artistsData = mapper.readValue(inputStream, new TypeReference<>() {});

            for (Map<String, Object> artistData : artistsData) {
                Artist artist = new Artist();
                List<Album> albums = new ArrayList<>();
                List<Song> songs= new ArrayList<>();
                artist.setName((String) artistData.get("name"));

                List<Map<String, Object>> albumsData = (List<Map<String, Object>>) artistData.get("albums");
                for (Map<String, Object> albumData : albumsData) {
                    Album album = new Album();
                    album.setTitle((String) albumData.get("title"));
                    album.setDescription((String) albumData.get("description"));
                    album.setArtist(artist);
                    albums.add(album);
                    List<Map<String, Object>> songsData = (List<Map<String, Object>>) albumData.get("songs");
                    for (Map<String, Object> songData : songsData) {
                        Song song = new Song();
                        song.setTitle((String) songData.get("title"));
                        song.setLength((String) songData.get("length"));
                        song.setAlbum(album);
                        songs.add(song);
                    }
                    album.setSongs(songs);
                }
                artist.setAlbums(albums);
                artistRepository.save(artist);
            }
            System.out.println("Data loaded successfully!");
        } catch (IOException e) {
            System.out.println("Unable to load data: " + e.getMessage());
        }
    }
}

