package mortage;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ReadFile {
    public  ReadFile() {
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




                //If matches exist add to list
                if(matchFound) {
                    customerName.add(matcher.group(1).replace(","," "));
                    totalLoan.add(Float.valueOf(matcher.group(2)));
                    interestRate.add(Float.valueOf(matcher.group(3)));
                    years.add(Float.valueOf(matcher.group(4)));

                }
            }

            myReader.close();

            //Moving on to the calculation with the given data.
            new Calculator().Calculation(customerName,totalLoan,interestRate,years);

        } catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }
}
