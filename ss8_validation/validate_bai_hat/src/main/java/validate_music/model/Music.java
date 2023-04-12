package validate_music.model;

import javax.persistence.*;
import javax.validation.constraints.Max;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Entity
public class Music {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
//    @NotBlank(message = "{create.notEmpty}")
    private String name;
    private String singer;
    private String category;

    public Music(int id, String name, String singer, String category) {
        this.id = id;
        this.name = name;
        this.singer = singer;
        this.category = category;
    }

    public Music() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSinger() {
        return singer;
    }

    public void setSinger(String singer) {
        this.singer = singer;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }
}
