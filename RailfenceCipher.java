public class RailfenceCipher{

	private int key;
	private String message;	
	private char keyMatrix[][];
	private String encryptedMessage="";
	private String decryptedMessage="";
	int messageLength;

	public RailfenceCipher(int key)
	{
		this.key = key;
	}

	public void setMessage(String message)
	{
		this.message = message;
		generateMatrix();
	}

	private String removeWhiteSpaces(String text)
	{
		text = text.replaceAll("\\s+","");
		return text;
	}

	public String getEncryptedMessage()
	{
		encrypt();
		return encryptedMessage;
	}

	public String getDecryptedMessage()
	{
		decrypt();
		return decryptedMessage;
	}

	private void decrypt()
	{
		for(int i=0;i<key;i++)
			for(int j=0;j<messageLength;j++)
				if(keyMatrix[j][i]==0)
					continue;
				else
					keyMatrix[j][i]='-';

		int k=0;
		for(int i=0;i<key;i++)
			for(int j=0;j<messageLength;j++)
				if(keyMatrix[j][i]==0)
					continue;
				else
					keyMatrix[j][i]=encryptedMessage.charAt(k++);

		int j=0;
		int down=1;
		for(int i=0;i<messageLength;i++)
		{
			if(down==1)
			{
				decryptedMessage+=keyMatrix[i][j++];
				
				if(j==(key-1))
					down=0;	
			}
			else
			{
				decryptedMessage+=keyMatrix[i][j--];

				if(j==0)
					down=1;
			}
		}
				
	}


	private void encrypt()
	{
		for(int i=0;i<key;i++)
			for(int j=0;j<messageLength;j++)
				if(keyMatrix[j][i]==0)
					continue;
				else
					encryptedMessage+=keyMatrix[j][i];
	}

	public void showKeyMatrix()
	{
		for(int i=0;i<messageLength;i++)
		{
			System.out.println("");
			for(int j=0;j<key;j++)
				System.out.print(keyMatrix[i][j]+"\t");
			System.out.println("");
		}
	}	

	private void generateMatrix()
	{
		message = removeWhiteSpaces(message);
		messageLength = message.length();

		keyMatrix = new char[messageLength][key];

		int i=0;
		int j=0;
		int down=1;
		while(i<messageLength)
		{
			if(down==1)
			{
				keyMatrix[i][j++]=message.charAt(i);
				
				if(j==(key-1))
					down=0;
			}			
			else
			{
				keyMatrix[i][j--]=message.charAt(i);
				
				if(j==0)
					down=1;			
			}	
			i++;		
		}
	}	
}
