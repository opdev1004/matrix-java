
public class Matrix
{
	double [][] matrix;

	public Matrix(double[][] matrix) throws IncorrectMatrixException
	{
		int height = matrix.length;
		int width = matrix[0].length;
		this.matrix = new double[height][width];
		
		for(int i = 0; i < matrix.length;i++)
		{
			if(width != matrix[i].length)
				throw new IncorrectMatrixException(
						String.format("Incorrect Matrix Exception at Matrix[ %d ][ ? ]. Wrong array length.", i)
				);
			
			for(int j = 0; j < matrix[i].length; j++) this.matrix[i][j] = matrix[i][j];
		}
	}
	
	public void RotateClockwiseBySwap() throws RectangularMatrixException
	{ 
		if(matrix.length != matrix[0].length) throw new RectangularMatrixException("Matrix must be square for rotation.");
		
		double[][] tempMatrix = new double[matrix.length][matrix[0].length];
		
		for(int i = 0; i < matrix.length; i++)
		{
			for(int j = 0; j < matrix[i].length; j++)
			{
				tempMatrix[i][j] = matrix[matrix.length - 1 - j][i];
			}
		}
		
		matrix = tempMatrix;
	}
	
	public void RotateAntiClockwiseBySwap() throws RectangularMatrixException
	{ 
		if(matrix.length != matrix[0].length) throw new RectangularMatrixException("Matrix must be square for rotation.");
		
		double[][] tempMatrix = new double[matrix.length][matrix[0].length];
		
		for(int i = 0; i < matrix.length; i++)
		{
			for(int j = 0; j < matrix[i].length; j++)
			{
				tempMatrix[i][j] = matrix[j][matrix.length - 1 - i];
			}
		}
		
		matrix = tempMatrix;
	}
	
	public void flipVerticallyByMultiplication() throws IncorrectMultiplicationException
	{
		double[][] flipMatrix = new double[matrix.length][matrix.length];
		
		int x = 0;
		int y = matrix.length - 1;
		
		for(int i = 0; i < matrix[0].length;i++)
		{
			flipMatrix[x][y] = 1;
			++x;
			--y;
		}
		
		matrix = MatrixOperations.MatrixMultiplication(flipMatrix, matrix);
	}
	
	public void flipVerticallyBySwap()
	{
		for(int i = 0; i < matrix.length / 2; i++)
		{
			for(int j = 0; j < matrix[i].length; j++)
			{
				double value = matrix[i][j];
				
				matrix[i][j] = matrix[matrix.length - 1 - i][j];
				matrix[matrix.length - 1 - i][j] = value;
			}
		}
	}
	
	public void flipHorizontallyByMultiplication() throws IncorrectMultiplicationException
	{
		double[][] flipMatrix = new double[matrix[0].length][matrix[0].length];
		
		int x = 0;
		int y = matrix[0].length - 1;
		
		for(int i = 0; i < matrix[0].length; i++)
		{
			flipMatrix[x][y] = 1;
			++x;
			--y;
		}
		
		matrix = MatrixOperations.MatrixMultiplication(matrix, flipMatrix);
	}
	
	public void flipHorizontallyBySwap()
	{
		for(int i = 0; i < matrix.length; i++)
		{
			for(int j = 0; j < matrix[i].length / 2; j++)
			{
				double value = matrix[i][j];
				
				matrix[i][j] = matrix[i][matrix[i].length - 1 - j];
				matrix[i][matrix[i].length - 1 - j] = value;
			}
		}
	}
	
	public void ScalarMultiplication(double scalar)
	{
		matrix = MatrixOperations.ScalarMultiplication(scalar, matrix);
	}
	
	public double[][] To2DArrays()
	{
		return matrix;
	}
	
	public int GetDigit()
	{
		int biggestLength = Integer.MIN_VALUE;
		
		for(int i = 0; i < matrix.length;i++)
		{
			for(int j = 0; j < matrix[i].length; j++)
			{
				int lengthOfValue = String.valueOf(matrix[i][j]).length();
				
				if(biggestLength < lengthOfValue) biggestLength = lengthOfValue;
			}
		}
		
		return biggestLength;
	}
	
	public void Print()
	{
		System.out.println(ToString());
	}
	
	public String ToString()
	{
		StringBuilder stringBuilder= new StringBuilder();
		int digit = GetDigit();
		
		for(int i = 0; i < matrix.length;i++)
		{
			for(int j = 0; j < matrix[i].length; j++)
			{
				String value = String.valueOf(matrix[i][j]);
				
				for(int k = 0; k < digit - value.length(); k++) stringBuilder.append(" ");
				
				stringBuilder.append(value);
				stringBuilder.append("   ");
			}
			
			stringBuilder.append("\n");
		}
		
		return stringBuilder.toString();
	}
}
