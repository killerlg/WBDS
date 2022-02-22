package model;


import javax.persistence.*;

@Entity
@Table
public class Comment {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long id;
    private String arthur;
    private String comment;
    private Long totalLike;

    public Comment() {
        this.totalLike = new Long("0");
    }

    public Comment(String arthur, String comment) {
        this.arthur = arthur;
        this.comment = comment;
        this.totalLike = new Long("0");
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

    public Long getTotalLike() {
        return totalLike;
    }

    public void setTotalLike(Long like) {
        this.totalLike = like;
    }
}
