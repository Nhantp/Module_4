package bucanh.entity;

import javax.persistence.*;

@Entity
public class ImageOfTheDay {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="id")
    private int id;
    private int star;
    private String author;
    private String feedback;
    private int likes;

    public ImageOfTheDay() {
    }

    public ImageOfTheDay(int id, int star, String author, String feedback, int likes) {
        this.id = id;
        this.star = star;
        this.author = author;
        this.feedback = feedback;
        this.likes = likes;
    }

    public ImageOfTheDay(int star, String author, String feedback, int likes) {
        this.star = star;
        this.author = author;
        this.feedback = feedback;
        this.likes = likes;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getStar() {
        return star;
    }

    public void setStar(int star) {
        this.star = star;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getFeedback() {
        return feedback;
    }

    public void setFeedback(String feedback) {
        this.feedback = feedback;
    }

    public int getLikes() {
        return likes;
    }

    public void setLikes(int likes) {
        this.likes = likes;
    }
}
