//L00085858
//JOSEPH GRIMES
//CREDIT UNION CLASS
//L00085858
//JOSEPH GRIMES
//CREDIT UNION CLASS
public class CreditUnionAccount
{

   //DECLARE PRIVATE VARIBLES
   private static int accountNumberHolder = 1;
   private String custName = "John Doe";
   private double shareBalance = 50;
   private double loanBalance  = 0;
   private int loanDuration = 0;
   private int accountNumber;
   
   //CONSTRUCTORS
   public CreditUnionAccount()
   {
      accountNumber = accountNumberHolder; //PASS IN VALUES FOR ACCOUNT NUMBER AND INCREMENT
      accountNumberHolder++;
   }
   //ALTERNATE CONSTRUCTOR 
   public CreditUnionAccount(String custNameIn, double shareBalanceIn)
   {
      custName = custNameIn; //PASS IN VALUES FOR NAME AND BALANCE
      shareBalance = shareBalance + shareBalanceIn;
      accountNumber = accountNumberHolder;
      accountNumberHolder++;
   } 
   
   public void setCustName(String custNameIn)
   {
      custName = custNameIn;
   }
   
   public int getAccountNumber() //RETURN VALUE FOR ACCOUNT NUMBER
   {
      return accountNumber;
   }
   
   public String getCustName() //RETURN NAME
   {
      return custName;
   }
   
   public double getShareBalance()//RETURN SHARE BALANCE VALUE
   {
      return shareBalance;
   }
   
   public double getLoanBalance() //GETS LOAN BALANCE
   {
      return loanBalance;
   }
   
   public void depositToShares(double shareDepositAmount) 
   {
       shareBalance = shareBalance + shareDepositAmount; //ALGORITHM FOR INCREASING SHARE DEPOSIT
   }
   
   public void makeLoanPayment(double paymentAmount)
   {
      loanBalance = loanBalance - paymentAmount; //SUM TO PAY OFF LOAN
   }
   
   public void withdrawFromShares(double withdrawAmount)
   {
      shareBalance = shareBalance - withdrawAmount; //WITHDRAW FROM SHARES
   } 
   
   //PASS IN VALUES FOR LOAN AMOUNT AND TIME
   public void issueLoan(double loanBalanceIn, int loanDurationIn)
   {
      loanBalance = loanBalanceIn;
      loanDuration = loanDurationIn; 
   }
   
   public double calcWeeklyLoan()
   {
      if(loanDuration > 0)
      {
         return loanBalance / loanDuration / 4; //CALCULATE WEEKLY REPAYMENT
      }
      //DIVIDE BY ZERO FIX
      else
      {
         return loanBalance;
      }
   }
   
   public double calcMonthlyLoan() //CALCULATE MONTHLY REPAYMENT
   {
      if(loanDuration > 0)
      {
         return loanBalance / loanDuration;
      }
      else
      {
         return loanBalance;
      }
   }
   
   
   public String toString() //FORMATING FOR CONSTRUCTOR
   {
      return "balance " + shareBalance + " name " + custName + " accNo " + accountNumber ;
   }
   
}