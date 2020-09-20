public class TryMatrix
{	
	public static void main(String[] args)
	{
		try
		{
			Matrix matrix = new Matrix(new double[][] {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}});
			matrix.Print();
			matrix.RotateAntiClockwiseBySwap();
			matrix.Print();
			matrix.ScalarMultiplication(3);
			matrix.Print();
			
		}
		catch (IncorrectMatrixException | RectangularMatrixException e)
		{
			e.printStackTrace();
		}
	}
}