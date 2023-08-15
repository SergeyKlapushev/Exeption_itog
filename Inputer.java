import java.util.Scanner;

public class Inputer {
    Scanner scan = new Scanner(System.in, "cp866");

    public String inputDATA(){        
        String data = scan.nextLine();
        if (сheckingDataForQuantity(data) == true){
            return data;
        }
        else{
            return inputDATA();
        }
    }

    private static boolean сheckingDataForQuantity(String inputData) {
        String[] arrayData = inputData.split(" ");
        if (arrayData.length == 6) {
            return true;
        }
        if(arrayData.length < 6){
            System.err.println("Вы ввели не достаточно данных");
        }
        if(arrayData.length > 6){
            System.err.println("Вы ввели слишком много данных");
        }
        return false;
    }
}
