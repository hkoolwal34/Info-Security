import java.util.*; 

public class Playfair{

	public static void main(String []args)
	{
		System.out.print("Enter Your Key - ");		
		Scanner sc = new Scanner(System.in);
		String key = sc.nextLine();

		PlayFairCipher cipher = new PlayFairCipher(key);
		cipher.showKeyMatrix();

		System.out.print("\nEnter The Message : ");
		String message = sc.nextLine();
		
		cipher.setMessage(message);
		System.out.println("Encrypted Message : "+cipher.getEncryptedMessage());
	}
}


