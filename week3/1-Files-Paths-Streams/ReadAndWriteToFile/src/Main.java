import java.io.File;
import java.io.IOException;

public class Main {
    public static void main(String[] arguments) throws IOException {
        FileUtils fileUtils = FileUtils.getInstance();
        File file = new File("../../1-Files-Paths-StreamsUSAGE/RandomTextFile.txt");
        
        System.out.println("Read From File With File: " + fileUtils.readFrom(file));
        System.out.println("Read From File With Path: " + fileUtils.readFrom(file.toPath()));
        
        fileUtils.writeTo(new File("../../1-Files-Paths-StreamsUSAGE/WriteInThisTextFile.txt"), "Put some new data in here...!");
        fileUtils.writeTo(new File("../../1-Files-Paths-StreamsUSAGE/WriteInThisTextFileAgain.txt").toPath(), "Put again some new data in here...!");
        
    }
}