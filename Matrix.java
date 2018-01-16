import java.util.*;

public class Matrix{
	int row;
	int col;
	int mat[][];

	public Matrix(int x,int y)
	{
		row=x;
		col=y;
	
		mat=new int[row][col];
	}

	public void takeInput()
	{
		Scanner sc = new Scanner(System.in);
		for(int i=0;i<row;i++)
			for(int j=0;j<col;j++)
				mat[i][j]=sc.nextInt();
	}

	public void showKeyMatrix()
	{
		for(int i=0;i<row;i++)
		{
			for(int j=0;j<col;j++)
				System.out.print(mat[i][j]+" ");

			System.out.println(" ");		
		}						
	}

	public Matrix multiply(Matrix b)
	{
		int bcol=b.getCols();
		Matrix c = new Matrix(3,1);


		for (int i = 0; i < row; i++)
            	for (int j = 0; j <bcol ; j++)
	            {
				int sum=0;
					
				for(int k=0;k<col;k++)
					sum+=(b[k]*mat[i][k]);
				c.setElement(sum,i,j);
            	}

		return c;
	}

	public void mod26()
	{
		for(int i=0;i<row;i++)
			for(int j=0;j<col;j++)
				mat[i][j]=mat[i][j]%26;
	}

	public int getCols()
	{
		return col;
	}

	public void setElement(int x,int row,int col)
	{
		mat[row][col]=x;	
	}

	public int getElement(int row,int col)
	{
		return mat[row][col];
	}
}
