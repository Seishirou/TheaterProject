package exception;

public class MyException extends RuntimeException {

	public MyException(String msg) {
		super(msg);
	}

	@Override
	public String getMessage() {
		StringBuilder sb = new StringBuilder();
		sb.append("\n===========================\n");
		sb.append("오류 : " + super.getMessage());
		sb.append("\n===========================\n");
		return sb.toString();
	} // end of getMessage()
} // end of class
