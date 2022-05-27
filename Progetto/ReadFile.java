import java.nio.file.*;

public class ReadFile 
{
    public ReadFile()
    {}

    public String readFileAsString(String fileName) throws Exception
    {
        String data = "";
        data = new String(Files.readAllBytes(Paths.get(fileName)));
        return data;
    }
}
