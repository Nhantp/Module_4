package blog.controller;

import blog.entity.Blog;
import blog.service.IBlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Slice;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/v2/blog")
public class BlogRestController {
    @Autowired
    IBlogService iBlogService;

    @GetMapping("list")
    public ResponseEntity<List<Blog>>display(){
        List<Blog>blogList=iBlogService.findAll();
        if(blogList.isEmpty()){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(blogList, HttpStatus.OK);
    }
    @GetMapping("check")
    public ResponseEntity<Blog>findById(@RequestParam(name = "id")int id){
        Blog blog=iBlogService.findById(id);
        if (blog == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(blog, HttpStatus.OK);
    }
    @GetMapping("/search")
    public ResponseEntity<Slice<Blog>> searchAll(@RequestParam(name = "searchAll") String searchAll ,
                         @RequestParam(name = "page") Optional<Integer> page,
                         @RequestParam(name = "size") Optional<Integer> size, Model model){
        int currentPage=page.orElse(1);
        int pageSize=size.orElse(4);
        Sort sortBy = Sort.by("time").descending().and(Sort.by("title").ascending());
        Slice<Blog> blog=iBlogService.findAllWithSlice(PageRequest.of(currentPage-1,pageSize,sortBy));
        Slice<Blog>search=iBlogService.findAllByCategory_CategoryNameContainingOrTitleContainingOrContentContainingOrTimeContaining(searchAll,searchAll,searchAll,searchAll, PageRequest.of(currentPage-1,pageSize,sortBy));
        model.addAttribute("blog",blog.getContent());
        model.addAttribute("page",blog);
        return new ResponseEntity<>(search,HttpStatus.OK);

    }
}
