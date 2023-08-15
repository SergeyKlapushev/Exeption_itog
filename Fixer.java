import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.Scanner;

public class Fixer{

    // Фиксим ФИО
    public String fixingInitial(String initial) {
        Scanner scan = new Scanner(System.in, "cp866");
        initial = scan.nextLine();
        if (checkCoorectedInitial(initial)) {
            return initial;
        } else {
            return fixingInitial(initial);
        }
    }

    private boolean checkCoorectedInitial(String initial) {

        if (initial.matches("[А-ЯЁа-яё]+")) {
            return true;
        } else {
            System.out.println("Снова не верно, введите ещё раз: ");
            return false;
        }
    }

    //Фиксим дату рождения
    public String fixingDateBirth(String dateBirth){
        Scanner scan = new Scanner(System.in);
        dateBirth = scan.nextLine();

        try {
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
            LocalDate date = LocalDate.parse(dateBirth, formatter);
            if (date.getDayOfMonth() != Integer.parseInt(dateBirth.substring(0, 2)) ||
                date.getMonthValue() != Integer.parseInt(dateBirth.substring(3, 5)) ||
                date.getYear() != Integer.parseInt(dateBirth.substring(6, 10)) ||
                date.getYear() < 1900) {
                throw new DateTimeParseException("Invalid Date", dateBirth, 0);
            }
            return dateBirth;
            
        } catch (DateTimeParseException | NumberFormatException e) {
            System.out.println("Снова не верно, введите дату ещё раз (вот пример: 01-01-1900)");
            return fixingDateBirth(dateBirth);
        }
    }


    //Фиксим телефон
    public String fixingPhone(String phone) {
        Scanner scan = new Scanner(System.in);
        phone = scan.nextLine();

        if (phone.charAt(0) != 8 && phone.length() != 11) {
            System.err.println("Снова не верно, попробуйте ещё раз: ");
            return phone = fixingPhone(phone);

        } else {
            try {
                Double.parseDouble(phone);
                return phone;

            } catch (NumberFormatException nfe) {
                System.err.println("Снова не верно, попробуйте ещё раз: ");
                return fixingPhone(phone);
            }
        }

    }

    //Фиксим пол

    public String fixingGender(String gender) {
        Scanner scan = new Scanner(System.in);
        gender = scan.nextLine();
        
        if (gender.contains("m") || gender.contains("f")) {
            if(gender.length()==1){
                return gender;
            }
            else{
                System.err.println("Снова не верно, попробуйте ещё раз: ");
                return fixingGender(gender);
            }
        } else {   
            System.err.println("Снова не верно, попробуйте ещё раз: ");         
            return fixingGender(gender);
        }
    }
}
