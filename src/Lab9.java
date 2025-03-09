import java.io.*;
import java.io.FileNotFoundException;
import java.util.*;

public class Lab9 {
    public static void main(String[] args) throws FileNotFoundException {
        String fileName1, fileName2;
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter first filename: ");
        fileName1 = sc.nextLine();
        System.out.print("Enter second filename: ");
        fileName2 = sc.nextLine();
        sc.close();
        System.out.println();

        if (getNumberOfLines(fileName1) == getNumberOfLines(fileName2)) {
            Scanner s1 = new Scanner(new File(fileName1));
            Scanner s2 = new Scanner(new File(fileName2));
            int lineNum = 1;
            String first, second;

            while (s1.hasNext() && s2.hasNext()) {
                first = s1.nextLine();
                second = s2.nextLine();
                if (!first.equals(second)) {
                    System.out.println("Line " + lineNum);
                    System.out.println("<" + first);
                    System.out.println(">" + second);
                }
                lineNum++;
            }
            s1.close();
            s2.close();
        } else {
            System.out.println("Files have different number of lines");
        }
    }
    public static int getNumberOfLines(String fileName) throws FileNotFoundException {
        Scanner sc = new Scanner(new File(fileName));
        int count = 0;

        while (sc.hasNext()) {
            sc.nextLine();
            count++;
        }
        sc.close();
        return count;
    }
}