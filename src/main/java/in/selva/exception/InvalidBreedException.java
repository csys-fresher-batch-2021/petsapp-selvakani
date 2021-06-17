package in.selva.exception;

public class InvalidBreedException extends Exception {
	
	/**
	 * This method is used to raise product invalid message
	 */
	
	private static final long serialVersionUID = 1L;

		public InvalidBreedException(String message)
		{
			super(message);
	}
}