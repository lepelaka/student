package student.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

// 클래스 내의 필드, 메서드 생성자
// 1. 필드
// 1.5초기화블럭
// 2. 생성자
// 3. getter / setter
// 4. 추가 정의 메서드
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Student implements Cloneable{
	private int no;
	private String name;
	private int kor;
	private int eng;
	private int mat;

	public int total() {
		return kor + eng + mat;
	}
	public double avg() {
		return total() / 3d;
	}
	public String toString() {
		return String.format("%4d  %s  %3d  %3d  %3d  %3d  %.2f", no, name, kor, eng, mat, total(), avg());
	}
}
