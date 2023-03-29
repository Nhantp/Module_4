package bucanh.entity;

@Entity
public class ImageOfTheDay {
    private int star;
    private String author;
    private String feedback;

    public ImageOfTheday() {
    }

    public ImageOfTheday(int star, String author, String feedback) {
        this.star = star;
        this.author = author;
        this.feedback = feedback;
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
}
