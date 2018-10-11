package bicycleRentShop;

import java.util.Scanner;

public class InputDriver {
    public  int scanUserInputAsInteger() {
        Scanner scanner = new Scanner(System.in);
        return scanner.nextInt();
    }

    public  String scanUserInputAsString() {
        Scanner scanner = new Scanner(System.in);
        return scanner.next();
    }
}
