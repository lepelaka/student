package student.service;

import static student.util.StudentUtils.*;

import java.util.Arrays;

import student.vo.Student;  

// Deck
public class StudentService {
	// 학생 배열
	private Student[] students = new Student[20];
	// 학생 수
	private int cnt;
	{
		students[cnt++] = new Student(1, "홍길동", 90, 80, 70);
		students[cnt++] = new Student(2, "김길동", 99, 85, 99);
		students[cnt++] = new Student(3, "이길동", 77, 80, 100);
	}
	
	
	// Create, Read, Update, Delete
	// 등록
	public void register() {
		int no = nextInt("학번을 입력하세요 > ");
//		int result = findIdxBy(no);
//		System.out.println(result);
		if(findIdxBy(no) >= 0) {
			System.out.println("동일 학번 학생이 존재합니다");
			return;
		}
		String name = nextLine("학생이름을 입력하세요 > ");
		if(!chkHangle(name)) {
			throw new RuntimeException("이름은 한글로 구성해야합니다.");
		}
		int kor = chkRange(nextInt("국어점수를 입력하세요 > "));  
		int eng = chkRange(nextInt("영어점수를 입력하세요 > "));
		int mat = chkRange(nextInt("수학점수를 입력하세요 > "));
		
		students[cnt++] = new Student(no, name, kor, eng, mat);
		list();
	}
	// 목록 조회
	public void list() {
		
		System.out.println("학번  이름  국어  영어  수학  총점  평균");
		System.out.println("========================================");
		for(int i = 0 ; i < cnt ; i++) {
			System.out.println(students[i]);
		}
	}
	// 학생 내용 수정
	// pk를 통한 단일 탐색(현재 소스에서는 index를 반환)
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
		int no = nextInt("수정할 학생의 학번을 입력 >");
		int idx = findIdxBy(no);
		if(idx == -1) {
			throw new RuntimeException("찾으려는 학생의 학번이 없습니다.");
		}
		Student s = students[idx];
		String name = nextLine("학생이름을 입력하세요 > ");
		if(!chkHangle(name)) {
			throw new RuntimeException("이름은 한글로 구성해야합니다.");
		}
		int kor = chkRange(nextInt("국어점수를 입력하세요 > "));  
		int eng = chkRange(nextInt("영어점수를 입력하세요 > "));
		int mat = chkRange(nextInt("수학점수를 입력하세요 > "));
		s.setName(name);
		s.setKor(kor);
		s.setEng(eng);
		s.setMat(mat);
	}
	public void remove() {
		int no = nextInt("삭제할 학생의 학번을 입력 >");
		int idx = findIdxBy(no);
		if(idx == -1) {
			System.out.println("찾으려는 학생의 학번이 없습니다.");
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
		System.out.println("학번  이름  국어  영어  수학  총점  평균");
		System.out.println("========================================");
		for(int i = 0 ; i < cnt ; i++) {
			System.out.println(arr[i]);
		}
	}
}
