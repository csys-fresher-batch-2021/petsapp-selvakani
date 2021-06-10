package in.selva.exception;

public class NotAbleToDeleteException extends Exception 
{
	private static final long serialVersionUID = 1L;

	public NotAbleToDeleteException(String message)
	{
		super(message);
	}
}
