package service;

import model.Song;

import java.util.List;

public interface ISongService {
    List<Song> findAll();

    Song findOne(Long id);

    Song save(Song song);

    List<Song> save(List<Song> songs);

    boolean exists(Long id);

    List<Song> findAll(List<Long> ids);

    long count();

    void delete(Long id);

    void delete(Song song);

    void delete(List<Song> songs);

    void deleteAll();

}
