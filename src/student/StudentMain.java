package student;

import student.service.StudentService;
import student.util.StudentUtils;
import student.vo.Student;

// 1. �л�Ÿ�Կ� ���� �⺻���� (����)
// 2. �л��� ������ ���� �л��迭 ���� 
// 2-1. ��ϱ�� �Ϻ� ����
// 3. �Է� ���� ��� ��ƿ��Ƽ ����
// 4. ������ �ݺ����� ���α׷� ���
// 5. ��Ͻ� �л� �迭�� ��Ȯ�� ��ġ�� ����, �߰����� ����(�л� ��)

// ������ ����
// 1. �л� ���� :
// 2. ���� (���� ��������) 
// 3. ����ó�� ���� 
// 3-1. �̸��� �ѱ۷θ� ���� 
// 3-2. �޴����ý� ������ ���ڸ� �Է°��� (x)
// 3-3. ���� �Է½� ���� ������ 0~100������ ���� ����
// 3-4. ���ڸ� �Է¹޾ƾ� �� �� �����Է½� ������� �ʰ� �޼��� ���

public class StudentMain {
	public static void main(String[] args) {
		StudentService service = new StudentService(); // ����� ����
		
		while(true) {
			try {
				int input = StudentUtils.nextInt("1. ��ȸ 2. ��� 3. ���� 4. ���� 5. ������ȸ 6. ����");
				switch (input) {
				case 1:
					service.list();
					break;
				case 2:
					service.register();
					break;
				case 3:
					service.modify();
					break;
				case 4:
					service.remove();
					break;
				case 5:
					service.rank();
					break;
				case 6:
					System.out.println("����Ǿ����ϴ�.");
					return;
				default:
					System.out.println("������ �޴���ȣ�� �ƴմϴ�.");
					break;
				}
			}
			catch (NumberFormatException e) {
				System.out.println("���ڷ� �Է��ϼ���");
			}
			catch (RuntimeException e) {
				System.out.println(e.getMessage());
			}
		}
	}
}
