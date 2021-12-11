import java.util.List;
import java.util.Objects;

public class Post {
    private int id;
    public int likes;
    public List<String> comments;
    private String text;
    private int authorId;

    public Post(int id, int likes, List<String> comments) {
         this.id = id;
         this.likes = likes;
         this.comments = comments;
    }

    public List<String> getComments() {
        return comments;
    }

    public Integer getLikes() {
        return likes;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Post post = (Post) o;
        return id == post.id && likes == post.likes && authorId == post.authorId && Objects.equals(comments, post.comments) && Objects.equals(text, post.text);
    }


    @Override
    public String toString() {
        return "Post{" +
                "id=" + id +
                ", likes=" + likes +
                ", comments=" + comments +
                '}';
    }
}
