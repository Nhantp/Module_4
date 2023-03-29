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
    private Date Time;
    private String image;
    private String category;

    public Blog(String title, String content, Date time, String image, String category) {
        this.title = title;
        this.content = content;
        Time = time;
        this.image = image;
        this.category = category;
    }

    public Blog(int id, String title, String content, Date time, String image, String category) {
        this.id = id;
        this.title = title;
        this.content = content;
        Time = time;
        this.image = image;
        this.category = category;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Blog() {
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

    public Date getTime() {
        return Time;
    }

    public void setTime(Date time) {
        Time = time;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }
}
