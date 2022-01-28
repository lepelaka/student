package service;

import static utils.StudentUtil.nextInt;
import static utils.StudentUtil.nextLine;

import java.util.ArrayList;
import java.util.List;

import domain.Student;
import exception.RangeException;

public class StudentServiceImpl implements StudentService{
	List<Student> students = new ArrayList<Student>();
	{
		String[] names = {"김경보","김동엽", "김상현", "김승종", "김예찬", "김치형", "김태윤"};
		
		for(int i = 0 ; i < names.length ; i++) {
			students.add(new Student(220000 + i + 1 + "", names[i]));
		}
		System.out.println("임시 데이터 초기화 완료");
	}
	
	
	
	// 1. 조회하기
	public void list() {
		System.out.println("학번        이름        국어        영어        수학        총점        평균\r\n" + 
				"=============================================================================");
		for(int i = 0 ; i < students.size() ; i++) {
			System.out.println(students.get(i));
		}
	}
	// 2. 등록하기
	public void register() {
		students.add(new Student(nextLine("학번 >"), nextLine("이름 >", true), 
				nextInt("국어 >"), nextInt("영어 >"), nextInt("수학 >")));
	}
	
	// 3. 수정하기
	public void modify() {
		Student student = findBy(nextLine("수정할 학생의 학번 >"));
		if(student == null) {
			System.out.println("존재하지 않는 학번입니다");
			return;
		}
		student.setName(nextLine("이름 > ", true));
		
		student.setKor(nextInt("국어 > "));
		student.setEng(nextInt("영어 > "));
		student.setMat(nextInt("수학 > "));
	}
	// 10ms 12ms
	// 4. 삭제하기
	public void remove() {
		students.remove(findBy(nextLine("수정할 학생의 학번 >")));
	}
	private Student findBy(String no) {
		Student student = null;
		for(Student s : students) {
			if(s.getNo().equals(no)) {
				student = s;
			}
		}
		return student;
	}
}
