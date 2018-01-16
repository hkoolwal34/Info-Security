public class HillCipher{
	private Matrix key;
	private String message;
	private int messagelength;
	private String encryptedMessage="";
	private String decryptedMessage="";

	public HillCipher(Matrix k)
	{
		this.key = k;
	}

	public String getEncryptedMessage()
	{
		encrypt();
		return encryptedMessage;
	}

	private void encrypt()
	{
		if(messagelength>=3)
		{
			Matrix part= new Matrix(3,1);
//			Matrix enc_part = new Matrix(3,1);		

			int x=messagelength;

			int k=0;
			while(x>=3)
			{
				for(int i=0;i<3;i++)
					part.setElement(message.charAt(k++)-'a',i,0);
	
				part=key.multiply(part);
				part.mod26();
				x=x-3;
				for(int i=0;i<3;i++)
					encryptedMessage+=part.getElement(i,0)+'a';		
			}
			if(x!=0)
			{
				Matrix part2=new Matrix(x,1);
				for(int i=0;i<x;i++)
					part2.setElement(message.charAt(k++)-'a',i,0);

				for(int i=0;i<x;i++)
					encryptedMessage+=part.getElement(i,0)+'a';			
			}
		}
	}


	private String removeWhiteSpaces(String text)
	{
		text = text.replaceAll("\\s+","");
		return text;
	}

	public void setMessage(String m)
	{
		this.message = m;
		this.message = removeWhiteSpaces(message);
		messagelength=message.length();
	}
}
