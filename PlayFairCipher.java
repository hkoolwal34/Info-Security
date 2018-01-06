import java.util.*;

public class PlayFairCipher
{
	private String key;
	private char keyMatrix[][];
	private String message;
	private String encryptedMessage="";

	public String getEncryptedMessage()
	{
		encrypt();
		return encryptedMessage;
	}

	private void encrypt()
	{
		if(message.isEmpty()||message == null)
			System.out.println("No Message Found");

		else
		{
			message = removeWhiteSpaces(message);
			message = message.replaceAll("j","i");
			int length = message.length();	
			if(length%2==1)
			{
				message+="x";		
				length++;					
			}			

			char char1,char2;			
			int row1,row2,col1,col2;

			for(int i=0;i<length/2;i++)
			{
				char1 = message.charAt(2*i);
				char2 = message.charAt(2*i+1);
		
				row1 = getRowIndex(char1);
				col1 = getColIndex(char1);
		
				row2 = getRowIndex(char2);
				col2 = getColIndex(char2);
		
				if(row1 == row2)
					encryptedMessage+=keyMatrix[row1][++col1%5]+""+keyMatrix[row1][++col2%5];	
				
				else if(col1 == col2)
					encryptedMessage+=keyMatrix[++row1%5][col1]+""+keyMatrix[++row2%5][col1];	

				else
					encryptedMessage+=keyMatrix[row1][col2]+""+keyMatrix[row2][col1];
			}			
		
		}		
	}

	private String removeWhiteSpaces(String message)
	{
		message = message.replaceAll("\\s+","");
		return message;
	}

	private int getRowIndex(char c)
	{
		for(int i=0;i<5;i++)
			for(int j=0;j<5;j++)
				if(keyMatrix[i][j]==c)
					return i;
		return -1;
	}

	private int getColIndex(char c)
	{
		for(int i=0;i<5;i++)
			for(int j=0;j<5;j++)
				if(keyMatrix[i][j]==c)
					return j;
		return -1;
	}


	public void setMessage(String message)
	{
		this.message = message;
	}

	PlayFairCipher(String key)
	{
		this.key = key;
		generateMatrix();
	}

	public void showKeyMatrix()
	{
		System.out.println("\nKey Matrix\n****************\n");
		for(int i=0;i<5;i++)
		{
			for(int j=0;j<5;j++)
				System.out.print(keyMatrix[i][j]+"\t");
		
			System.out.println("");
		}	
	}

	private void generateMatrix()	
	{
		ArrayList<Character> list = new ArrayList<Character>();
		list.add('a');		list.add('b');
		list.add('c');		list.add('d');
		list.add('e');		list.add('f');
		list.add('g');		list.add('h');
		list.add('i');		list.add('k');
		list.add('l');		list.add('m');
		list.add('n');		list.add('o');
		list.add('p');		list.add('q');
		list.add('r');		list.add('s');
		list.add('t');		list.add('u');
		list.add('v');		list.add('w');
		list.add('x');		list.add('y');
		list.add('z');

		ArrayList<Character> list2 = new ArrayList<Character>();

		keyMatrix = new char[5][5];
		int length = key.length();
		
		char temp;
		for(int i=0;i<length;i++)
		{
			temp = key.charAt(i);
			if(temp=='j')
				temp='i';

			if(list.contains(temp))
			{
				list.remove(new Character(temp));
				list2.add(temp);
			}
		}

		while(!list.isEmpty())
		{
			list2.add(list.get(0));
			list.remove(0);
		}


		int k=0;
		for(int i=0;i<5;i++)
			for(int j=0;j<5;j++)
				keyMatrix[i][j]=list2.get(k++);
	}
}
