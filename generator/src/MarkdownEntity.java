import java.util.List;
import java.util.StringJoiner;


public class MarkdownEntity implements ItemEntity {
    private String taskTitle;
    private String taskUrl;
    private String taskSolution;


    MarkdownEntity(String taskTitle, String taskUrl, String taskSolution){
        this.taskTitle = taskTitle;
        this.taskUrl = taskUrl;
        this.taskSolution = taskSolution;
    }


    static   MarkdownEntity parseEntity(List<String> s){
        StringJoiner joiner = new StringJoiner("\n");
        if (s.size() < 5) {
            return new MarkdownEntity(null, null, null);
        }
        for (int i = 2; i<s.size();i++){
            joiner.add(s.get(i));
        }
        String solution = "``` java" + "\n" + joiner + "\n```\n";
        return new MarkdownEntity(s.get(0), s.get(1), solution);
    }


    @Override
    public String getTitle() {
        return "+ [" + this.taskTitle + "]" + "(#" + this.taskUrl.split("/")[4] + ")";
    }


    @Override
    public String getFormatted() {
        return "## " + this.taskTitle + "\n\n" + this.taskUrl + "\n\n"  + this.taskSolution;
    }
}
