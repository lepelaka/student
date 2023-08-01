package student;

import student.service.StudentService;
import student.util.StudentUtils;
import student.vo.Student;

// 1. 학생타입에 대한 기본정의 (변수)
// 2. 학생들 관리를 위한 학생배열 생성 
// 2-1. 등록기능 일부 구현
// 3. 입력 관련 기능 유틸리티 정의
// 4. 메인의 반복적인 프로그램 운용
// 5. 등록시 학생 배열의 정확한 위치를 지정, 추가변수 생성(학생 수)

// 과제의 내용
// 1. 학생 삭제 :
// 2. 정렬 (석차 내림차순) 
// 3. 예외처리 적용 
// 3-1. 이름은 한글로만 구성 
// 3-2. 메뉴선택시 지정된 숫자만 입력가능 (x)
// 3-3. 점수 입력시 값의 범위를 0~100사이의 값만 지정
// 3-4. 숫자를 입력받아야 할 때 문자입력시 종료되지 않고 메세지 출력

public class StudentMain {
	public static void main(String[] args) {
		StudentService service = new StudentService(); // 기능의 집합
		
		while(true) {
			try {
				int input = StudentUtils.nextInt("1. 조회 2. 등록 3. 수정 4. 삭제 5. 석차조회 6. 종료");
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
					System.out.println("종료되었습니다.");
					return;
				default:
					System.out.println("지정된 메뉴번호가 아닙니다.");
					break;
				}
			}
			catch (NumberFormatException e) {
				System.out.println("숫자로 입력하세요");
			}
			catch (RuntimeException e) {
				System.out.println(e.getMessage());
			}
		}
	}
}
