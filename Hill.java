import java.util.*;

public class Hill
{
	public static void main(String []args)
	{
		System.out.println("Enter Key Matrix elements row wise.");
		Matrix key=new Matrix(3,3);

		key.takeInput();
		key.showKeyMatrix();
				
		HillCipher cipher = new HillCipher(key);
		Scanner sc = new Scanner(System.in);

		System.out.print("\nEnter The Message : ");
		String message = sc.nextLine();
		cipher.setMessage(message);
		
		System.out.println("Encrypted Message : "+cipher.getEncryptedMessage());
//		System.out.println("Decrypted Message : "+cipher.getDecryptedMessage());
	}
}


