import java.util.List;

public class Main {
    public static void main(String[] args) {
        String userSource = "C://Users//liza_//IdeaProjects//generator//src//solution.txt";
        String source = "C://Users//liza_//IdeaProjects//generator//src//array.md";
        List<String> userSolutionContent = IOUtils.readData(userSource);
        List<String> oldFileContent = IOUtils.readData(source);
        String[] parts = source.split("//");
        String fileName = parts[parts.length-1];
        SolutionFile old = SolutionFile.parseFile(oldFileContent, FileType.MARKDOWN, fileName);
        old.add(MarkdownEntity.parseEntity(userSolutionContent));
        IOUtils.writeData(source, old.toString());
    }
}
