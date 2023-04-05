package bucanh.service;

import bucanh.entity.ImageOfTheDay;
import bucanh.repository.ImageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class ImageServiceImpl implements ImageService{
    @Autowired
    private ImageRepository imageRepository;
    @Override
    public List<ImageOfTheDay> findAll() {
        return imageRepository.findAll();
    }

    @Override
    public void addNew(ImageOfTheDay image) {
        imageRepository.addNew(image);
    }

    @Override
    public ImageOfTheDay findById(int id) {
        return imageRepository.findById(id);
    }

    @Override
    public void update(ImageOfTheDay image) {
        imageRepository.update(image);
    }
}
