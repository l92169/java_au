import java.util.Objects;
public class Comment {
    private int id;
    private String text;
    private int authorId;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Comment comment = (Comment) o;
        return id == comment.id && authorId == comment.authorId && Objects.equals(text, comment.text);
    }
}
