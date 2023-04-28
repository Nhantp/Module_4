package blog.service;

import blog.entity.Blog;
import blog.entity.Category;
import blog.repository.ICategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Slice;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import blog.repository.IBlogRepository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class BlogService implements IBlogService{
    @Autowired
    IBlogRepository iBlogRepository;
   @Autowired
    ICategoryRepository iCategoryRepository;

    @Override
    public void addNew(Blog blog) {
        iBlogRepository.save(blog);
    }

    @Override
    public List<Blog> findAll() {
        return iBlogRepository.findAll();
    }

    @Override
    public Blog findById(int id) {
        return iBlogRepository.findById(id).orElse(null);
    }

    @Override
    public void update(Blog blog) {
        Optional<Category> optional = iCategoryRepository.findById(blog.getCategory().getCategoryId());
        blog.setCategory(optional.orElse(null));
        iBlogRepository.save(blog);
    }

    @Override
    public void delete(Blog blog) {
        iBlogRepository.delete(blog);
    }

    @Override
    public List<Blog> findAllByCategory_CategoryNameContaining(String category) {
        return iBlogRepository.findAllByCategory_CategoryNameContaining(category);
    }

    @Override
    public Slice<Blog> findAllWithSlice(Pageable pageable) {
        return iBlogRepository.findAll(pageable);
    }

    @Override
    public Page<Blog> findAllWithPage(Pageable pageable) {
        return iBlogRepository.findAll(pageable);
    }

    @Override
    public List<Blog> SortByTime() {
        Sort sort=Sort.by("time").ascending();
        return iBlogRepository.findAll(sort);
    }

//    @Override
//    public List<Blog> getBlogsByOrder(String order) {
//        if ("timeAsc".equals(order)) {
//            return iBlogRepository.findAll(Sort.by(Sort.Direction.ASC, "time"));
//        } else if ("timeDesc".equals(order)) {
//            return iBlogRepository.findAll(Sort.by(Sort.Direction.DESC, "time"));
//        } else if ("titleAsc".equals(order)) {
//            return iBlogRepository.findAll(Sort.by(Sort.Direction.ASC, "title"));
//        } else if ("titleDesc".equals(order)) {
//            return iBlogRepository.findAll(Sort.by(Sort.Direction.DESC, "title"));
//        } else {
//            return iBlogRepository.findAll();
//        }
//    }


}
