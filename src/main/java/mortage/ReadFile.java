package mortage;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ReadFile {
    public static void main(String[] args) {
        List<String> customerName = new ArrayList<String>();
        List<Float> totalLoan = new ArrayList<Float>();
        List<Float> interestRate = new ArrayList<Float>();
        List<Float> years = new ArrayList<Float>();

        try {
           //Reading the new file
            File prospects = new File("file/prospects.txt");
            Scanner myReader = new Scanner(prospects);

            //Looking for a pattern
            Pattern neededPattern= Pattern.compile("^\"?([^\"]*)\"?,(\\d+\\.?\\d*),(\\d+\\.?\\d*),(\\d+)$");
            while (myReader.hasNextLine()) {

                //Reading next line
                String data = myReader.nextLine();

                //Seeing if the pattern is there or not
                Matcher matcher = neededPattern.matcher(data);
                boolean matchFound = matcher.find();


                System.out.println(data);

                //If matches exist add to list
                if(matchFound) {
                    System.out.println("Match found");
                    System.out.println(matcher.group());
                    customerName.add(matcher.group(1).replace(","," "));
                    totalLoan.add(Float.valueOf(matcher.group(2)));
                    interestRate.add(Float.valueOf(matcher.group(3)));
                    years.add(Float.valueOf(matcher.group(4)));

                } else {
                    System.out.println("Match not found");
                }
            }
            for(int i = 0; i < customerName.size(); i++) {
                System.out.println(customerName.get(i));
                System.out.println(totalLoan.get(i));
                System.out.println(interestRate.get(i));
                System.out.println(years.get(i));

            }

            myReader.close();

        } catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }
}
