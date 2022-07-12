import java.nio.file.*;

public class ReadFile 
{
    /**
     * Class that deals with opening and reading the save file;
     * @param fileName
     * @return a string with the read file.
     * @throws Exception
     */
    public String readFileAsString(String fileName) throws Exception
    {
        String data = "";
        data = new String(Files.readAllBytes(Paths.get(fileName)));
        return data;
    }
}
