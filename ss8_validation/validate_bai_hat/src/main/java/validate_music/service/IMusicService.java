package validate_music.service;

import validate_music.model.Music;

import java.util.List;

public interface IMusicService {
    void insert(Music music);
    List<Music>finAll();
    Music findById(int id);
    void update(Music music);
}
