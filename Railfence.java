import java.util.*;

public class Railfence
{
	public static void main(String []args)
	{
		System.out.print("Enter Your Key - ");		
		Scanner sc = new Scanner(System.in);
		
		int key = sc.nextInt();
		System.out.print("Key : "+key);		
		
		
		RailfenceCipher cipher = new RailfenceCipher(key);

		System.out.print("\nEnter The Message : ");
		String message = sc.next();
		cipher.setMessage(message);

		cipher.showKeyMatrix();
		
		System.out.println("Encrypted Message : "+cipher.getEncryptedMessage());
		System.out.println("Decrypted Message : "+cipher.getDecryptedMessage());
	}
}
