package student.exception;

public class RangeException extends RuntimeException{
	public RangeException() {
		super("값의 범위를 초과했습니다.");
	}
}
