import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;


public class Parser {
    private Fixer fix = new Fixer();

    // Идентифицируем ФИО
    public String[] identifyInitials(String data) {

        String[] arrayString = data.split(" ");
        String lastname = arrayString[0];
        String name = arrayString[1];
        String fathername = arrayString[2];

        if (!lastname.matches("[А-ЯЁа-яё]+")) {
            System.err.println("Фамилия введена не корректно, введите её ещё раз: ");
            lastname = fix.fixingInitial(lastname);
        }
        if (!name.matches("[А-ЯЁа-яё]+")) {
            System.err.println("Имя введено не корректно, введите его ещё раз");
            name = fix.fixingInitial(name);
        }
        if (!fathername.matches("[А-ЯЁа-яё]+")) {
            System.err.println("Отчесвто введено не корректно, введите его ещё раз");
            fathername = fix.fixingInitial(fathername);
        }

        String[] initials = { lastname, name, fathername };
        return initials;
    }

    // Идентифицируем дату рождения
    public String identifyDateBirth(String data) {

        String[] arrayString = data.split(" ");
        String dateBirth = arrayString[3];

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
            System.out.println("Дата введена не корректно, введите дату ещё раз (вот пример: 01-01-1900)");
            return fix.fixingDateBirth(dateBirth);
        }
    }

    // Идентифицируем телефон
    public String identifyPhone(String data) {
        String[] arrayString = data.split(" ");
        String phone = arrayString[4];

        if (phone.charAt(0) != 8 && phone.length() != 11) {

            System.err.println(
                    "Не корректно введён номер телефона\nОн должен начинаться с числа 8 и состоять из 11 чисел");
            return phone = fix.fixingPhone(phone);

        } else {
            try {
                Double.parseDouble(phone);
                return phone;

            } catch (NumberFormatException nfe) {
                System.out.println(
                        "Не корректно введён номер телефона\nОн должен начинаться с числа 8 и состоять из 11 числе");
                return fix.fixingPhone(phone);
            }
        }
    }

    // Идентифицируем пол

    public String identifyGender(String data) {
        String[] arrayString = data.split(" ");
        String gender = arrayString[5];

        if (gender.contains("m") || gender.contains("f")) {
            if (gender.length() == 1) {
                return gender;
            } else {
                System.err.println(
                        "Не коректно введён пол, чтобы инициализировать пол, либо f (если вы женщина), либо m (если вы мужчина)");
                return fix.fixingGender(gender);
            }

        } else {
            System.out.println(
                    "Не корректно введён пол, чтобы инициалищировать пол, введите либо f (если вы женщина), или m (если вы мужчина)");
            return fix.fixingGender(gender);
        }
    }
}
