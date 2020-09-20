
public class MatrixOperations {
	
	public static double[][] Addition(double[][] a, double[][] b) throws DifferentMatrixSizeException
	{
		if(a.length != b.length || a[0].length != b[0].length) throw new DifferentMatrixSizeException("The size of matrices are different.");
		
		double[][] matrix = new double[a.length][a[0].length];
		
		for(int i = 0; i < a.length;i++)
		{
			for(int j = 0; j < a[i].length; j++)
			{	
				matrix[i][j] = a[i][j] + b[i][j];
			}
		}
		
		return matrix;
	}
	
	public static double[][] Subtraction(double[][] a, double[][] b) throws DifferentMatrixSizeException
	{
		if(a.length != b.length || a[0].length != b[0].length) throw new DifferentMatrixSizeException("The size of matrices are different.");
		
		double[][] matrix = new double[a.length][a[0].length];
		
		for(int i = 0; i < a.length;i++)
		{
			for(int j = 0; j < a[i].length; j++)
			{	
				matrix[i][j] = a[i][j] - b[i][j];
			}
		}
		
		return matrix;
	}
	
	public static double[][] ScalarMultiplication(double a, double[][] b)
	{
		double[][] matrix = new double[b.length][b[0].length];
		
		for(int i = 0; i < b.length;i++)
		{
			for(int j = 0; j < b[i].length; j++)
			{	
				matrix[i][j] = a * b[i][j];
			}
		}
		
		return matrix;
	}
	
	public static double[][] MatrixMultiplication(double[][] a, double[][] b) throws IncorrectMultiplicationException
	{
		if(a[0].length != b.length) throw new IncorrectMultiplicationException("Width of first matrix and height of second matrix are different.");
		
		double[][] matrix = new double[a.length][b[0].length];
		
		for(int i = 0; i < a.length;i++)
		{
			for(int j = 0; j < b[i].length; j++)
			{	
				
				double value = 0;
						
				for(int k = 0; k < a[i].length; k++)
				{
					value += a[i][k] * b[k][j];
					System.out.println(a[i][k] +  "*" + b[j][k]);
				}
				System.out.println("Done");
				matrix[i][j] = value;
			}
		}
		
		return matrix;
	}
}
