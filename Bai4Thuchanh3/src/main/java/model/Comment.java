package model;

import org.hibernate.annotations.ColumnDefault;

import javax.persistence.*;

@Entity
@Table
public class Comment {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long id;
    private String arthur;
    private String comment;
    private Long like;

    public Comment() {
    }

    public Comment(Long id, String arthur, String comment, Long like) {
        this.id = id;
        this.arthur = arthur;
        this.comment = comment;
        this.like = like;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getArthur() {
        return arthur;
    }

    public void setArthur(String arthur) {
        this.arthur = arthur;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public Long getLike() {
        return like;
    }

    public void setLike(Long like) {
        this.like = like;
    }
}
