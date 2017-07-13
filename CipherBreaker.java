/**
 * See CipherBreaker.txt for instructions.
 * TODO: add your netid to the line below
 * 
 * @author kenneth2
 */
public class CipherBreaker {
    public static void main(String[] args) {
        char c;
        String line;
        int punctuationCount = 0;
        int numberCount = 0;
        int alphabetCount = 0;
        int spaceCount = 0;
        int count = 0;

        TextIO.putln("Text?");
        line = TextIO.getln();
        TextIO.putln(line);
        line = line.toUpperCase();

        for (int i = 32; i <= 166; i++) {
            alphabetCount = 0;
            c = (char)i;
            for (int x = 0; x < line.length(); x++) {
                if (line.charAt(x) == i) {
                    if (line.charAt(x) >= 48 && line.charAt(x) <= 57) numberCount++;
                    else if (line.charAt(x) == 32) spaceCount++;
                    //check for the following 6 punctuation marks " ' - ! , .
                    else if (line.charAt(x) == 33 || line.charAt(x) == 34 || line.charAt(x) == 39 ||
                            (line.charAt(x) >= 44 && line.charAt(x) <= 46))  punctuationCount++;
                    else if ((line.charAt(x) >= 65 && line.charAt(x) <= 90) || (line.charAt(x) >= 97 && line.charAt(x) <= 122)) alphabetCount++;
                }
            }
            char cUpper = Character.toUpperCase(c);
            if (alphabetCount > 0 && c >= 65 && c <=90) System.out.println(cUpper + ":" + alphabetCount);
        }

        if (numberCount > 0) System.out.println("DIGITS:" + numberCount);
        if (spaceCount > 0) System.out.println("SPACES:" + spaceCount);
        if (punctuationCount > 0) System.out.println("PUNCTUATION:" + punctuationCount);
    }
}
