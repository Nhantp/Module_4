package bucanh.repository;

import bucanh.entity.ImageOfTheDay;

import java.util.List;

public interface ImageRepository {
   List<ImageOfTheDay>findAll();
   void addNew(ImageOfTheDay image);
   ImageOfTheDay findById(int id);
   void update(ImageOfTheDay image);
}
