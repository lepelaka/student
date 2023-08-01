package student.service;

import static student.util.StudentUtils.*;

import java.util.Arrays;

import student.vo.Student;  

// Deck
public class StudentService {
	// �л� �迭
	private Student[] students = new Student[20];
	// �л� ��
	private int cnt;
	{
		students[cnt++] = new Student(1, "ȫ�浿", 90, 80, 70);
		students[cnt++] = new Student(2, "��浿", 99, 85, 99);
		students[cnt++] = new Student(3, "�̱浿", 77, 80, 100);
	}
	
	
	// Create, Read, Update, Delete
	// ���
	public void register() {
		int no = nextInt("�й��� �Է��ϼ��� > ");
//		int result = findIdxBy(no);
//		System.out.println(result);
		if(findIdxBy(no) >= 0) {
			System.out.println("���� �й� �л��� �����մϴ�");
			return;
		}
		String name = nextLine("�л��̸��� �Է��ϼ��� > ");
		if(!chkHangle(name)) {
			throw new RuntimeException("�̸��� �ѱ۷� �����ؾ��մϴ�.");
		}
		int kor = chkRange(nextInt("���������� �Է��ϼ��� > "));  
		int eng = chkRange(nextInt("���������� �Է��ϼ��� > "));
		int mat = chkRange(nextInt("���������� �Է��ϼ��� > "));
		
		students[cnt++] = new Student(no, name, kor, eng, mat);
		list();
	}
	// ��� ��ȸ
	public void list() {
		
		System.out.println("�й�  �̸�  ����  ����  ����  ����  ���");
		System.out.println("========================================");
		for(int i = 0 ; i < cnt ; i++) {
			System.out.println(students[i]);
		}
	}
	// �л� ���� ����
	// pk�� ���� ���� Ž��(���� �ҽ������� index�� ��ȯ)
	private int findIdxBy(int no) {
		int idx = -1;
		for(int i = 0 ; i < cnt ; i++) {
			if(no == students[i].getNo()) {
				idx = i;
				break;
			}
		}
		return idx;
		
	}
	public void modify() {
		int no = nextInt("������ �л��� �й��� �Է� >");
		int idx = findIdxBy(no);
		if(idx == -1) {
			throw new RuntimeException("ã������ �л��� �й��� �����ϴ�.");
		}
		Student s = students[idx];
		String name = nextLine("�л��̸��� �Է��ϼ��� > ");
		if(!chkHangle(name)) {
			throw new RuntimeException("�̸��� �ѱ۷� �����ؾ��մϴ�.");
		}
		int kor = chkRange(nextInt("���������� �Է��ϼ��� > "));  
		int eng = chkRange(nextInt("���������� �Է��ϼ��� > "));
		int mat = chkRange(nextInt("���������� �Է��ϼ��� > "));
		s.setName(name);
		s.setKor(kor);
		s.setEng(eng);
		s.setMat(mat);
	}
	public void remove() {
		int no = nextInt("������ �л��� �й��� �Է� >");
		int idx = findIdxBy(no);
		if(idx == -1) {
			System.out.println("ã������ �л��� �й��� �����ϴ�.");
			return;
		}
		System.arraycopy(students, idx+1, students, idx, cnt-- - idx - 1);
	}
	
	public void rank() {
//		Student[] arr = new Student[cnt];
//		for (int i = 0; i < arr.length; i++) {
//			arr[i] = students[i];
//		}
		Student[] arr = students.clone();
		
		for (int j = 0; j < cnt - 1; j++) {
			for (int i = 0; i < cnt - 1 - j; i++) {
				if (arr[i].total() < arr[i + 1].total()) {
					Student tmp = arr[i];
					arr[i] = arr[i + 1];
					arr[i + 1] = tmp;
				}
			}
		}
		System.out.println("�й�  �̸�  ����  ����  ����  ����  ���");
		System.out.println("========================================");
		for(int i = 0 ; i < cnt ; i++) {
			System.out.println(arr[i]);
		}
	}
}
