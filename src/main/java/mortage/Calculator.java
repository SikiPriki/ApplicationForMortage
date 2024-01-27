package mortage;

import javax.swing.tree.FixedHeightLayoutCache;
import java.util.ArrayList;
import java.util.List;

public class Calculator {

    //This calcualtes and returns the fixed monthly  mortage when called and given the values
    public float FixedMonthlyPayment(float totalLoan, float interestRate, float year){
        //changing years to total payments by multiplying with 12
        float totalPayments= year*12;

        //Changing % to decimals and then calculating the monthly intrest
        float monthlyIntrest=(interestRate/100)/12;


        //calculating the (1 + b)^p part of mortage calculation.
        float poweredClaculationPart= 1;

        for (float j=totalPayments; j!=0; j-- ){
            poweredClaculationPart *= (1+monthlyIntrest) ;
        }

        //final calculation and then returning it
        float fixedPayment= (totalLoan*(monthlyIntrest*poweredClaculationPart))/(poweredClaculationPart-1);
        return fixedPayment;
    }
    public void Calculation(List<String> customerName , List<Float> totalLoan,
                            List<Float> interestRate , List<Float> years){

        List<Float>answer=new ArrayList<Float>();

        //Running throught the list
        for (int i=0;i<customerName.size();i++){

            //Adding the calcuation answer to list
            answer.add(FixedMonthlyPayment(totalLoan.get(i),interestRate.get(i),years.get(i)));

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
