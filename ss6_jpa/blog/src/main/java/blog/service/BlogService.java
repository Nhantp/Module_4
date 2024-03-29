package blog.service;

import blog.entity.Blog;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import blog.repository.IBlogRepository;

import java.util.List;
@Service
public class BlogService implements IBlogService{
    @Autowired
    IBlogRepository iBlogRepository;
    @Override
    public void addNew(Blog blog) {
        iBlogRepository.addNew(blog);
    }

    @Override
    public List<Blog> findAll() {
        return iBlogRepository.findAll();
    }

    @Override
    public Blog findById(int id) {
        return iBlogRepository.findById(id);
    }

    @Override
    public void update(Blog blog) {
        iBlogRepository.update(blog);
    }

    @Override
    public void delete(Blog blog) {
        iBlogRepository.delete(blog );
    }
}
