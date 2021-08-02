//L00085858
//JOSEPH GRIMES
//MAIN TESTER

import java.util.*;
public class main

{
  public static void main(String args[])
   {
      CreditUnionAccountValidator myCreditUnionAccountValidator = new CreditUnionAccountValidator();
      //TEST ACCOUNTS
      CreditUnionAccount cua1 = new CreditUnionAccount();
      CreditUnionAccount cua2 = new CreditUnionAccount("JOE", 400);
      CreditUnionAccount cua3 = new CreditUnionAccount("GARY", 100);
      CreditUnionAccount cua4 = new CreditUnionAccount("RALPH", 1000);
      //ACCOUNT FOR USER
      CreditUnionAccount cua = cua1;
      
      //INPUT CHOICE AND MENU
      Scanner keyboardIn = new Scanner(System.in);
      int choice = 0;
      System.out.println("Letterkenny Credit Union Menu");
      System.out.println("1. View account details");
      System.out.println("2. View account number and customer name");
      System.out.println("3. View share balance");
      System.out.println("4. View loan balance");
      System.out.println("5. Deposit to shares");
      System.out.println("6. Withdraw from shares");
      System.out.println("7. Apply for loan");
      System.out.println("8. Make loan Repayment");
      System.out.println("8. View weekly loan repayment");
      System.out.println("8. View monthly repayment");
      System.out.println("0. Exit");
      
      //DO WHILE LOOP RETURNS MENU ONCE USER IS FINISHED
      do
      {
          
         System.out.print("Enter your choice: ");      
         choice = keyboardIn.nextInt();
         
         //SWITCH FOR DIFFERNT SCENARIOS
         switch(choice)
         {
            case 1: //VIEW ACCOUNT DETAILS
            System.out.println("Name: "+ cua.getCustName() + "\nAccount Number: " + cua.getAccountNumber() +"\nYour current balance is €"+ cua.getShareBalance() );
            break;
            
            case 2: //GET CUSTOMER NAME AND ACCOUNT NUMBER
            System.out.println("Account Name: " + cua.getCustName() +  "\tAccount Number: " + cua.getAccountNumber());
            break;
            
            case 3: //DISPLAY SHARE BALANCE
            System.out.println("Share Balance €" + cua.getShareBalance());
            break;
            
            case 4: //DISPLAY LOAN BALANCE
            System.out.println("Loan Balance €" + cua.getLoanBalance());
            break;
            
            case 5: //CASE 5 CONTAINS IF STATEMENT TO CHECK IF NUMBER IS NATURAL (NOT A MINUUS VALUE)
            System.out.println("Please enter amount to deposit");
            double depositAmount = keyboardIn.nextDouble(); //DECLARE VARIABLE AND INPUT
            if(myCreditUnionAccountValidator.amountCanBeDeposited(depositAmount))
            {
               cua.depositToShares(depositAmount);
               System.out.println("Deposited €" + depositAmount);
            }
            else
            {
               System.out.println("Amount " + depositAmount + " is invalid");
            }
            break;
            
            case 6: //WITHDRAWAL CASE
            System.out.println("Please enter amount to withdraw");
            double withdrawAmount = keyboardIn.nextDouble();
            // CHECKS IF VALUE IS LESS THAN CURRENT BALANCE
            if(myCreditUnionAccountValidator.fundsCanBeWithdrawn(cua , withdrawAmount))
            {
               cua.withdrawFromShares(withdrawAmount);
               System.out.println("Withdrew €" + withdrawAmount);
            }
            else
            {
               System.out.println("Amount " + withdrawAmount + " is invalid");
            }
            break;
            
            case 7: //APPLY FOR LOAN
            System.out.println("How much would you like to borrow?");
            double loanAmount = keyboardIn.nextDouble();//DECLARE VARIABLE AND INPUT LOAN AMOUNT
            System.out.println("How long do you want it for?");
            int loanDuration = keyboardIn.nextInt();
            
            //STATEMENT TO CHECK IS LOAN GREATER THAN 12 MONTH PERIOD AND LESS THAN 3 TIMES SHARE BALANCE
            boolean isOfValidLength = myCreditUnionAccountValidator.isLoanOfValidLength(loanDuration);
            boolean isOfValidAmount =  myCreditUnionAccountValidator.isLoanValid(cua , loanAmount);
            if(isOfValidAmount && isOfValidLength)
            {
               cua.issueLoan(loanAmount , loanDuration);
               System.out.println("Loan of " + loanAmount + " in account");
            }
            else
            {
               System.out.println("Loan does not meet parameters");
            }
            break;

            case 8: //OUTPUTS REPAYMENT AMOUNT
            System.out.println("Please enter amount to repay");
            double repaymentAmount = keyboardIn.nextDouble(); //DECLARE REPAYMENT AMOUNT
            if(myCreditUnionAccountValidator.loanPaymentCanBeMade(cua, repaymentAmount)) //PASS IN VALUE FOR LOAN PAYMENT
            {
               cua.makeLoanPayment(repaymentAmount); //CALL ON PAYMENT OBJECT (CALCULATION)
               System.out.println("paid off €" + repaymentAmount);
            }
            else
            {
               System.out.println("Amount " + repaymentAmount + " is invalid");
            }
            break;
            
            case 9: //USES ALGORITHM FROM ACCOUNT CLASS TO CALCULATE WEEKLY REPAYMENT
               System.out.println("Your weekly loan repayment is €"+ cua.calcWeeklyLoan());
            break;
            
            case 10://USES ALGORITHM FROM ACCOUNT CLASS TO CALCULATE MONTHLY REPAYMENT
               System.out.println("Your monthly loan repayment is €"+ cua.calcMonthlyLoan());
            break;
            
            case 0: //EXIT MESSAGE
             System.out.println("Thank you for banking today");
            break; 
              
            default:
            System.out.println("Invalid option chosen, please choose options 0 - 10");
         }//CLOSE SWITCH
      }while(choice != 0); //LOOPS CODE UNLESS 0 IS SELECTED TO EXIT PROGRAM
    

   }//CLOSE MAIN
}//CLOSE CLASS