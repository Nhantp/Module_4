package blog.entity;

import javax.persistence.*;
import java.util.Date;
@Entity
public class Blog {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private int id;
    private String title;
    private String content;
    private String time;
    private String image;
    @ManyToOne(cascade = CascadeType.MERGE)
    @JoinColumn(name = "categoryId",referencedColumnName = "categoryId")
    private Category category;

    public Blog(int id, String title, String content, String time, String image, Category category) {
        this.id = id;
        this.title = title;
        this.content = content;
        this.time = time;
        this.image = image;
        this.category = category;
    }

    public Blog() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }
}
