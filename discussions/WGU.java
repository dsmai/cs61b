import java.util.Scanner;

public class WGU {
    public static void main(String[] args) {
        // for (int i = 0; i < 5; i++) {
        //     for (int j = 0; j < 5; j++) {
        //         if (i != 2 && (j != 0 && j != 4)) {
        //             System.out.print(" ");
        //         } else {
        //             System.out.print("H");
        //         }
        //     }
        //     System.out.println();
        // }

        Scanner scanner = new Scanner(System.in);
        // System.out.print("Enter starting number: ");
        // int starting_num = scanner.nextInt();
        // System.out.print("Enter multiplier: ");
        // int multiplier = scanner.nextInt();
        // int result = starting_num * multiplier;
        // for (int i = 0; i < 3; i++) {
        //     System.out.print(result + " ");
        //     result *= multiplier;
        // }
        // System.out.println();
        // System.out.print("hello" + "\n");
        // System.out.println("hi");
        // System.out.printf("Staring num: %s\n", starting_num);

        int input = 0;
        System.out.println("Enter values: ");
        if (scanner.nextInt() >= 0) {
            scanner.nextInt();
            scanner.nextInt();
            input = scanner.nextInt();
        }
        System.out.println(input);
    }
}
