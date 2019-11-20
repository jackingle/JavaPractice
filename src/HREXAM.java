import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

/*
 * Create TransactionException, DigitalWallet, and DigitalWalletTransaction classes here.
 */
class TransactionException extends Exception {
    /**
	 * 
	 */
	private static final long serialVersionUID = -5351845538494322824L;
	String errorMessage;
    String errorCode;
    
    public TransactionException(String errorCode) {
    	this.errorCode = errorCode;
    	
    }
    public String getMessage() {
    	switch (this.errorCode) {
    		case("USER_NOT_AUTHORIZED") : 
    			return "User not authorized.";
    		case("INVALID_AMOUNT") :
    			return "Amount should be greater than zero.";
    		case("INSUFFICIENT_BALANCE") :
    			return "Insufficient balance.";
    		default :
    			return "An undefined exception has occurred.";
    	}
       
    }
    public String getErrorCode() {
    	return this.errorCode;
//        if (errorCode == "USER_NOT_AUTHORIZED") 
//            return errorMessage = "User not authorized.";
//
//        if (errorCode == "INVALID_AMOUNT")
//            return errorMessage = "Amount should be greater than zero.";
//
//        if (errorCode == "INSUFFICIENT_BALANCE")
//            return errorMessage = "Insufficient balance.";
//        return errorCode;
    }
}
class DigitalWallet {
    String walletId;
    String userName;
    String userAccessCode;
    int walletBalance;

    public DigitalWallet(String walletId, String userName) {
    	
        this.walletId = walletId;
        this.userName = userName;
    }

    public DigitalWallet(String walletId, String userName, String userAccessCode) {
		
		this.walletId = walletId;
		this.userName = userName;
		this.userAccessCode = userAccessCode;
	}
	public String getWalletId() {
        return walletId;
    }
    public String getUsername() {
        return userName;
    }
    public String getUserAccessToken() {
        return userAccessCode;
    }
    public int getWalletBalance() {
        return walletBalance;
    }
    public void setWalletBalance(int walletBalance) {
        
    }
}
class DigitalWalletTransaction {
    public void addMoney(DigitalWallet wallet, int amount) throws TransactionException {
        if (wallet.userAccessCode != null) {
             wallet.walletBalance = amount + wallet.walletBalance;
        }else {
        	throw new TransactionException("USER_NOT_AUTHORIZED");
        }	
    }
    public void payMoney(DigitalWallet wallet, int amount) throws TransactionException {
        if (wallet.userAccessCode != null)
            wallet.walletBalance = wallet.walletBalance - amount;
        else 
        	throw new TransactionException("USER_NOT_AUTHORIZED");
    }
}
 

public class Solution {
    private static final Scanner INPUT_READER = new Scanner(System.in);
    private static final DigitalWalletTransaction DIGITAL_WALLET_TRANSACTION = new DigitalWalletTransaction();

    private static final Map<String, DigitalWallet> DIGITAL_WALLETS = new HashMap<>();

    public static void main(String[] args) {
        int numberOfWallets = Integer.parseInt(INPUT_READER.nextLine());
        while (numberOfWallets-- > 0) {
            String[] wallet = INPUT_READER.nextLine().split(" ");
            DigitalWallet digitalWallet;

            if (wallet.length == 2) {
                digitalWallet = new DigitalWallet(wallet[0], wallet[1]);
            } else {
                digitalWallet = new DigitalWallet(wallet[0], wallet[1], wallet[2]);
            }

            DIGITAL_WALLETS.put(wallet[0], digitalWallet);
        }

        int numberOfTransactions = Integer.parseInt(INPUT_READER.nextLine());
        while (numberOfTransactions-- > 0) {
            String[] transaction = INPUT_READER.nextLine().split(" ");
            DigitalWallet digitalWallet = DIGITAL_WALLETS.get(transaction[0]);

            if (transaction[1].equals("add")) {
                try {
                    DIGITAL_WALLET_TRANSACTION.addMoney(digitalWallet, Integer.parseInt(transaction[2]));
                    System.out.println("Wallet successfully credited.");
                } catch (TransactionException ex) {
                    System.out.println(ex.getErrorCode() + ": " + ex.getMessage() + ".");
                }
            } else {
                try {
                    DIGITAL_WALLET_TRANSACTION.payMoney(digitalWallet, Integer.parseInt(transaction[2]));
                    System.out.println("Wallet successfully debited.");
                } catch (TransactionException ex) {
                    System.out.println(ex.getErrorCode() + ": " + ex.getMessage() + ".");
                }
            }
        }
// 2
// XXXXX 
// 1 Julia dfjakfld;jaklfd;ja
        System.out.println();

        List<String> digitalWalletIds = new ArrayList<>();
        digitalWalletIds.addAll(DIGITAL_WALLETS.keySet());

        Collections.sort(digitalWalletIds);
        for (String digitalWalletId: digitalWalletIds) {
            DigitalWallet digitalWallet = DIGITAL_WALLETS.get(digitalWalletId);
            System.out.println(digitalWallet.getWalletId()
                    + " " + digitalWallet.getUsername()
                    + " " + digitalWallet.getWalletBalance());
        }
    }
}
