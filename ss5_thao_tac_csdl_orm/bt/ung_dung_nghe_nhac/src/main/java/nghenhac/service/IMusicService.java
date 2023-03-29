package nghenhac.service;

import nghenhac.entity.Music;

import java.util.List;

public interface IMusicService {
    void addNew(Music music);
    List<Music> findAll();
    void update(Music music);
    void delete(Music music);
    Music findById(int id);
}
