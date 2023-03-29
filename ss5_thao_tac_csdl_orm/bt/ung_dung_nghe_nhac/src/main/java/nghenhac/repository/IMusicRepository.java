package nghenhac.repository;

import nghenhac.entity.Music;

import java.util.List;

public interface IMusicRepository {
    void addNew(Music music);
    List<Music>findAll();
    void update(Music music);
    void delete(Music music);
    Music findById(int id);
}
