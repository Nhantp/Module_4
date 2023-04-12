package validate_music.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import validate_music.model.Music;
import validate_music.repository.IMusicRepository;

import java.util.List;
@Service
public class MusicService implements IMusicService{
    @Autowired
    IMusicRepository iMusicRepository;

    @Override
    public void insert(Music music) {
        iMusicRepository.save(music);
    }

    @Override
    public List<Music> finAll() {
        return iMusicRepository.findAll();
    }

    @Override
    public Music findById(int id) {
        return iMusicRepository.findById(id).orElse(null);
    }

    @Override
    public void update(Music music) {
        iMusicRepository.save(music);
    }
}
