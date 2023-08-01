package student.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

// Ŭ���� ���� �ʵ�, �޼��� ������
// 1. �ʵ�
// 1.5�ʱ�ȭ��
// 2. ������
// 3. getter / setter
// 4. �߰� ���� �޼���
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
