import java.io.IOException;

public class Test {
    public static void main(String[] args) throws IOException {

        Requester requester = new Requester();
        Inputer inputer = new Inputer();
        Parser parser = new Parser();

        boolean work = true;


        while (work) {
            requester.showRequest();
            String data = inputer.inputDATA();
            String[] fio = parser.identifyInitials(data);
            String dateBirth = parser.identifyDateBirth(data);
            String phone = parser.identifyPhone(data);
            String gender = parser.identifyGender(data);
            WriterToFile writertoFile = new WriterToFile();
            writertoFile.write(fio, dateBirth, phone, gender);
        }
    }
}
