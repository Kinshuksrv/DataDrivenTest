import java.io.IOException;

public class TestSample {

    public static void main(String [] args) throws IOException {

        DataDrivenTest test = new DataDrivenTest();
        String accountID = test.getCellData("AccountID",1);
        String transactionID = test.getCellData("TransactionID",1);
        System.out.println("Account id = " + accountID);
        System.out.println("Transaction id = " + transactionID);

    }
}
