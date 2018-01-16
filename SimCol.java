import java.util.*;

public class SimCol
{
	public static void main(String []args)
	{
		System.out.print("Enter Your Key - ");		
		Scanner sc = new Scanner(System.in);
		
		String key = sc.nextLine();
		System.out.print("Key : "+key);		
		
		
		SimColCipher cipher = new SimColCipher(key);

		System.out.print("\nEnter The Message : ");
		String message = sc.nextLine();
		cipher.setMessage(message);

		cipher.showKeyMatrix();
		
		System.out.println("Encrypted Message : "+cipher.getEncryptedMessage());
		System.out.println("Decrypted Message : "+cipher.getDecryptedMessage());
	}
}
