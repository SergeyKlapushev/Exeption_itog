import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.StandardOpenOption;

public class WriterToFile {

    public void write(String[] fio, String dateBirth, String phone, String gender) throws IOException {
        
        String string = fio[0] + " " + fio[1] + " " + fio[2] + dateBirth + " " + phone + " " + gender + " " + "\n";

        try(FileWriter writer = new FileWriter(fio[0]+".txt", Charset.forName("UTF-8"), true)){
            writer.write(string);
            System.out.println("Данные записаны");
        }
        catch(IOException ex){

            System.out.println(ex.getMessage());
        }
    }
}
