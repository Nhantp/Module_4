package nghenhac.service;

import nghenhac.entity.Music;
import nghenhac.repository.IMusicRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class MusicService implements IMusicService {
    @Autowired
    private IMusicRepository iMusicRepository;
    @Override
    public void addNew(Music music) {
        iMusicRepository.addNew(music);
    }

    @Override
    public List<Music> findAll() {
        return iMusicRepository.findAll();
    }

    @Override
    public void update(Music music) {
        iMusicRepository.update(music);
    }

    @Override
    public void delete(Music music) {
        iMusicRepository.delete(music);
    }

    @Override
    public Music findById(int id) {
        return iMusicRepository.findById(id);
    }
}
