import java.io.*;
import java.time.LocalDateTime;

/**
 * Class to handle methods regarding the program's Logs.
 */

public class Logs implements Serializable
{
    private PrintWriter printWriter;

    public Logs() throws IOException {
        String filename = LocalDateTime.now().toString();
        //String filename = "log";
        FileWriter fw;
        File file = new File(filename);
        if(file.exists()) {
            fw = new FileWriter(file,true);
        } else {
            file.createNewFile();
            fw = new FileWriter(file);
        }
        BufferedWriter bw = new BufferedWriter(fw);
        printWriter = new PrintWriter(bw);

    }

    public void addToLogUser(User user){
        StringBuilder stringBuilder = new StringBuilder("Utilizador criado em ");
        stringBuilder.append(LocalDateTime.now());
        stringBuilder.append(" com o nome ");
        stringBuilder.append(user.getNome());
        stringBuilder.append(" , do tipo ");
        stringBuilder.append(user.getClass().toString());
        stringBuilder.append(" , e com o username ");
        stringBuilder.append(user.getUsername());
        printWriter.println(stringBuilder.toString());
    }

    public void flushLog() {
        printWriter.flush();
    }

}
