import java.io.File;
import java.util.Scanner;

public class ReadFile {
        private Scanner x;

        public void openFile(){
            try{
                x=new Scanner(new File("/Users/carlosbeiramar/Desktop/Logs2.txt"));
            }catch (Exception e){
                System.out.println("O ficheiro nao existe");
            }
        }

        public void readFile() {
            System.out.println("\n");
            while(x.hasNext()){
                System.out.println(x.nextLine()+"\n");
            }
        }

        public void closeFile(){
            x.close();
        }
}
