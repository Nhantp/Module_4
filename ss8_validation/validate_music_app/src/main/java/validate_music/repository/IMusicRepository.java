package validate_music.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import validate_music.model.Music;

public interface IMusicRepository extends JpaRepository<Music,Integer> {
}
