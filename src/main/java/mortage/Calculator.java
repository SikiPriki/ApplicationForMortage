package mortage;

import javax.swing.tree.FixedHeightLayoutCache;
import java.util.ArrayList;
import java.util.List;

public class Calculator {

    public void Calculation(List<String> customerName , List<Float> totalLoan,
                            List<Float> interestRate , List<Float> years){


        List<Float>answer=new ArrayList<Float>();

        for (int i=0;i<customerName.size();i++){

            //changing years to total payments by multiplying with 12
            float totalPayments= years.get(i)*12;

            //Changing % to decimals and then calculating the monthly intrest
            float monthlyIntrest=(interestRate.get(i)/100)/12;


            //calculating the (1 + b)^p part of mortage calculation.
            float poweredClaculationPart= 1;

            for (float j=totalPayments; j!=0; j-- ){
                poweredClaculationPart *= (1+monthlyIntrest) ;
            }

            //final calculation
            float fixedMonthlyPayment= (totalLoan.get(i)*(monthlyIntrest*poweredClaculationPart))/(poweredClaculationPart-1);

            //Adding the calcuation answer to list
            answer.add(fixedMonthlyPayment);

        }

        //Printing out the answers
        for (int n=0; n<customerName.size();n++){
            System.out.println(
                    "****************************************************************************************************\n"
                            + "Prospect " + (n + 1) + ": " + customerName.get(n) + " wants to borrow "
                            + totalLoan.get(n)+ "€ for a period of " + years.get(n) +
                            " years and pay " + answer.get(n)+ "€ each month.\n" +
                            "****************************************************************************************************");
        }



    }
}
