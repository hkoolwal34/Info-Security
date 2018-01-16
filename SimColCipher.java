public class SimColCipher{
	private String key;
	private String message;	
	private char keyMatrix[][];
	private String encryptedMessage="";
	private String decryptedMessage="";
	private	int messageLength;
	private int keylength;
	private int rows;

	public SimColCipher(String key){
		this.key = key;
		keylength=key.length();	
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

	private void encrypt()
	{
		for(int i=0;i<keylength;i++)
			for(int j=0;j<rows;j++)
				if(keyMatrix[j][i]==0)
					encryptedMessage+=' ';
				else
					encryptedMessage+=keyMatrix[j][i];	
	}

	private void decrypt()
	{
		for(int i=0;i<keylength;i++)
			for(int j=0;j<rows;j++)
				keyMatrix[j][i]=encryptedMessage.charAt(i*rows+j);
	
		for(int i=0;i<rows;i++)
			for(int j=0;j<keylength;j++)
				decryptedMessage+=keyMatrix[i][j];
	}



	public void showKeyMatrix()
	{
		for(int i=0;i<rows;i++)
		{
			for(int j=0;j<keylength;j++)
				System.out.print(keyMatrix[i][j]);
			System.out.println(" ");				
		}
	}

	public void setMessage(String message)
	{
		this.message = message;
		this.message = removeWhiteSpaces(this.message);
		messageLength=this.message.length();
		generateMatrix();
	}

	private void generateMatrix()
	{

		if(messageLength%keylength==0)
			rows = messageLength/keylength;
		else
			rows = messageLength/keylength+1;

		keyMatrix = new char[rows][keylength];

		int k=0;
		for(int i=0;i<rows;i++)
		{
			for(int j=0;j<keylength;j++)
			{
				keyMatrix[i][j]=message.charAt(k++);

				if(k==messageLength)
					break;
			}
		}		
	}

	private String removeWhiteSpaces(String text)
	{
		text = text.replaceAll("\\s+","");
		return text;
	}
}
