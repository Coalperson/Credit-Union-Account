//LOOO85858
//JOSEPH GRIMES
//VALIDATES THE ABIITIES OF A CREDIT UNION ACCOUNT
//CREDIT UNION ACCOUNTS MAY BE REQUIRED AS ARGUMENTS
//VALIDATION MAY BE DEPENDENT ON INSTANCE VARIABLES
public class CreditUnionAccountValidator
{
   //DECLARE MINIMUM LOAN LENGTH
   private int minLoanLength = 12;
    
   //CHECK VALIDITY OF LOAN LENGTH
   public boolean isLoanOfValidLength(int loanLength)
   {
      return loanLength >= minLoanLength;
   }
  
  //CHECKS IF LOAN IS MORE THAN 3 TIMES SHARE BALANCE
   public boolean isLoanValid(CreditUnionAccount cua, double amountRequired)
   {
      if(amountRequired < 0)
      {
         return false; 
      }
     
      return amountRequired < (cua.getShareBalance() * 3); 
   }
   
   //CHECKS IF WITHDRAL AMOUNT IS GREATER THAN SHARE BALANCE AND 
   public boolean fundsCanBeWithdrawn(CreditUnionAccount cua, double amountToWithdraw)
   {
      if(amountToWithdraw < 0)
      {
         return false;
      }
      return cua.getShareBalance() > amountToWithdraw;
   }
  
   //HANDLE USER ENTERING A MINUS VALUE AND OVERPAYING A LOAN
   public boolean loanPaymentCanBeMade(CreditUnionAccount cua, double loanPayment)
   {
      if(loanPayment < 0)
      {
         return false;
      }
      return loanPayment <= cua.getLoanBalance();
   }
   //HANDLES DEPOSIT BEING BELOW ZERO
   public boolean amountCanBeDeposited(double depositAmount)
   {
      return depositAmount > 0;
   }
}