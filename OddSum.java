import javax.xml.soap.Text;

/**
 * Prints sum of odd numbers in a specific format.
 * TODO: add your netid to the line below
 * @author kenneth2
 */
public class OddSum {
    /**
     * Example output if user enters 10:
     * Max?
     * 1 + 3 + 5 + 7 + 9 = 25
     * 25 = 9 + 7 + 5 + 3 + 1
     * <p>
     * Example output if user enters 11:
     * Max?
     * 1 + 3 + 5 + 7 + 9 + 11 = 36
     * 36 = 11 + 9 + 7 + 5 + 3 + 1
     */
    public static void main(String[] args) {
        int total = 0;

        System.out.println("Max?");
        int max = TextIO.getlnInt();
        while (max <= 0) {
            System.out.println("Max?");
            max = TextIO.getlnInt();
        }

        if (max % 2 == 0) {
            max = max - 1;
        }

        for (int i = 1; i <= max; i += 2) {
            total += i;
            System.out.print(i);
            if (max - i > 1) System.out.print(" + ");
        }

        System.out.println(" = " + total);
        System.out.print(total + " = ");

        for (int i = max; i >= 1; i -= 2) {
            System.out.print(i);
            if (i > 1) System.out.print(" + ");
        }
    }
}
