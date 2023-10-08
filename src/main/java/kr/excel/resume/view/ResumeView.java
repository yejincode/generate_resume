package kr.excel.resume.view;

import kr.excel.resume.model.Career;
import kr.excel.resume.model.Education;
import kr.excel.resume.model.Person;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

// 데이터 입력 받기 위함.
public class ResumeView {
    private Scanner scanner;
    public ResumeView() {
        scanner = new Scanner(System.in);
    }

    // Person 정보
    public Person inputPersonInfo() {
        System.out.print("이름을 입력하세요 : ");
        String name = scanner.nextLine();
        System.out.print("사진을 입력하세요 : ");
        String photo = scanner.nextLine();
        String email = " ";
        while (!isValidEmail(email)) { //이메일 유효성 검사
            System.out.print("이메일을 입력하세요 : ");
            email = scanner.nextLine();
            if (!isValidEmail(email)) {
                System.out.println("올바른 이메일 형식이 아닙니다.");
            }
        }
        System.out.print("주소를 입력하세요 : ");
        String address  = scanner.nextLine();
        String birth = "";
        while (!isValidBirthDate(birth)) { //생년월일 유효성 검사
            System.out.print("생년월일을 입력하세요(예: 1990-01-01) : ");
            birth = scanner.nextLine();
            if (!isValidBirthDate(birth)) {
                System.out.println("올바른 생년월일 형식이 아닙니다.");
            }
        }
        String phoneNumber = "";
        while (!isValidPhoneNumber(phoneNumber)) { //전화번호 유효성 검사
            System.out.print("전화번호를 입력하세요(예: 010-1234-5678) : ");
            phoneNumber = scanner.nextLine();
            if (!isValidPhoneNumber(phoneNumber)) {
                System.out.println("올바른 전화번호 형식이 아닙니다.");
            }
        }

        return new Person(name, photo, email, address, birth, phoneNumber); // PersonDTO 객체 생성
    }

    // 학력 정보
    public List<Education> inputEducationList() { //학력 정보 여러개 받을 수 있으므로 List
        List<Education> eduList = new ArrayList<>();
        while (true) {
            System.out.println("학력정보를 입력하세요. 각 정보마다 띄어쓰기 후 입력하고, 종료를 원할 경우 q를 입력해주세요 : ");
            System.out.println("졸업년도 전공 학교명 졸업여부");
            String eduInput = scanner.nextLine();
            if ("q".equals(eduInput)) break; // 나가기

            String[] tokens = eduInput.split(" "); //띄어쓰기 기준 split
            if (tokens.length != 4) { //정보 4개가 입력되지 않았을 경우
                System.out.println("정보를 잘못 입력했습니다. 다시 입력해주세요.");
                continue;
            }
            eduList.add(new Education(tokens[0],tokens[1], tokens[2], tokens[3]));
        }
        return eduList;
    }

    // 경력 정보
    public List<Career> inputCareerList() { //학력 정보 여러개 받을 수 있으므로 List
        List<Career> careerList = new ArrayList<>();
        while (true) {
            System.out.println("경력 정보를 입력하세요. 각 정보마다 띄어쓰기 후 입력하고, 종료를 원할 경우 q를 입력해주세요 : ");
            System.out.println("재직기간 회사명 직업명 재직연도");
            String careerInput = scanner.nextLine();
            if ("q".equals(careerInput)) break; // 나가기

            String[] tokens = careerInput.split(" "); //띄어쓰기 기준 split
            if (tokens.length != 4) { //정보 4개가 입력되지 않았을 경우
                System.out.println("정보를 잘못 입력했습니다. 다시 입력해주세요.");
                continue;
            }
            careerList.add(new Career(tokens[0],tokens[1], tokens[2], tokens[3]));
        }
        return careerList;
    }
    public String inputIntroduction(){
        System.out.println("자기소개서를 입력하세요. 여러 줄을 입력하려면 빈 줄을 입력하세요.");
        StringBuilder sb = new StringBuilder();
        String line;
        while (!(line = scanner.nextLine()).trim().isEmpty()){ //엔터치면 return
            sb.append(line).append("\n");
        }
        return sb.toString().trim();
    }

    // 유효성 검사
    public static boolean isValidEmail(String email) {
        // 이메일 유효성을 검사하는 정규 표현식
        String emailRegex = "^[A-Za-z0-9+_.-]+@(.+)$";
        Pattern pattern = Pattern.compile(emailRegex);
        Matcher matcher = pattern.matcher(email);
        return matcher.matches();
    }

    public static boolean isValidBirthDate(String birth) {
        // 생년월일 유효성을 검사하는 정규 표현식
        String birthRegex = "^\\d{4}-\\d{2}-\\d{2}$";
        Pattern pattern = Pattern.compile(birthRegex);
        Matcher matcher = pattern.matcher(birth);
        return matcher.matches();
    }

    public static boolean isValidPhoneNumber(String phoneNumber) {
        // 전화번호 유효성을 검사하는 정규 표현식
        String phoneRegex = "^\\d{3}-\\d{4}-\\d{4}$";
        Pattern pattern = Pattern.compile(phoneRegex);
        Matcher matcher = pattern.matcher(phoneNumber);
        return matcher.matches();
    }
}
