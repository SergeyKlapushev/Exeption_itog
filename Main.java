/*import java.io.FileWriter;
import java.io.IOException;
import java.nio.charset.Charset;
import java.util.Date;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Scanner;

public class Main {
    String data = new String("UTF-8");

    public static void main(String[] args) throws Exception {
        Main dt = new Main();
        dt.data = inputDATA("Фамилию, Имя, Отчество, Дату рождения(формат: 01-01-1900), Номер телефона и Пол");
        сheckingDataForQuantity(dt.data);
        writeToFile(dt.data);
    }

    private static String inputDATA(String requestedData) {
        System.out.print("Введите ваши " + requestedData + ": ");
        Scanner scan = new Scanner(System.in, "cp866");
        String data = scan.nextLine();
        return data;
    }

    private static void сheckingDataForQuantity(String inputData) throws Exception {
        String[] arrayData = inputData.split(" ");
        if (arrayData.length != 6) {
            throw new Exception("Вы ввели не все данные");
        } else {
            parsDATA(arrayData);
        }
    }

    private static void parsDATA(String[] arrayData) {
        String firstname = parsFIO(arrayData[0], "Фамилия");
        String name = parsFIO(arrayData[1], "Имя");
        String fathername = parsFIO(arrayData[2], "Отчество");
        String birhday = parsDate(arrayData[3], "Дату рождения");
    }

    //////// Парсим Фамилию, Имя и Отчество ////////

    private static String parsFIO(String data, String inputData) {
        if (data.matches("[А-ЯЁа-яё]+")) {
            return data;
        } else {
            System.out.println(inputData + " не может быть пустым, содержать цифры, знаки и пробелы \nВведите "
                    + inputData + " ещё раз: ");
            data = fixAtErrore();
            return parsFIO(data, inputData);
        }

    }
    /////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

    //////// Парсим Дату рождения ////////

    private static String parsDate(String birthDate, String inputData) {
        DateFormat inputFormat = new SimpleDateFormat("dd-MM-yyyy");
        DateFormat outputFormat = new SimpleDateFormat("dd-MM-yyyy");
        
        try {
            Date date = (Date) inputFormat.parse(birthDate);
            String formattedDate = outputFormat.format(date);
            String RightDateBirth = chekingDateForQuantity(formattedDate);
            return formattedDate;
        } catch (ParseException e) {
            System.out.println("Не верно введена дата рождения\nПопробуйе снава: ");
            return parsDate(fixAtErrore(), inputData);
        }
    }

    private static String chekingDateForQuantity(String birthDate){
        String[] arrayData = birthDate.split("-");
        if (arrayData.length != 3) {
            if()
        } else {
            parsDATA(arrayData);
        }
    }

    //// Исправляем ошибку в Фамилии, Имени или Отчество ////
    private static String fixAtErrore() {
        Scanner scan = new Scanner(System.in, "cp866");
        String newData = scan.nextLine();
        return newData;
    }
    //////////////////////////////////////////////////////////

    private static void writeToFile(String fio) {
        try (FileWriter writer = new FileWriter("FIO.txt", Charset.forName("UTF-8"))) {
            writer.append(fio);
        } catch (IOException ex) {

            System.out.println(ex.getMessage());
        }
    }
}
*/