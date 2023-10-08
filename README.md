# 💙 generate_resume
이력서 자동생성을 위한 프로젝트. 데이터를 입력받으면 엑셀로 변환하여 저장합니다. 

# 📘 사용 언어
<img src="https://img.shields.io/badge/Java-007396?style=flat&logo=OpenJDK&logoColor=white"/>

# 💻 구현 기능
  - Model
    - Person : 사용자의 개인정보를 저장한다. 멤버 변수로 name, photo, email, address, birth, phoneNumber를 가지고 있다. 
    - Education: 사용자의 학력정보를 저장한다. 멤버 변수로 graduationYear, schoolName, major, graduationStatus를 가지고 있다.  
    - Career : 사용자의 경력정보를 저장한다. 멤버 변수로 workPeriod, companyName, jobTitle, employmentYears를 가지고 있다. 
  - View
    - ResumeView : 사용자로부터 이력서 작성에 필요한 정보(개인정보, 학력정보, 경력정보, 자기소개서)를 입력받는다. 입력받은 정보의 유효성 검사를 하여 유효하지 않을 경우 재입력 받는다. 
  - Controller
    - ResumeController : main 메소드에서 입력받은 정보를 바탕으로 이력서를 생성한다.

# 💙 사용 방법
- 개인정보, 학력정보, 경력정보, 자기소개서를 순서대로 입력한다.
- 만약 양식에 맞지 않는 경우 다시 입력한다.
- 학력정보, 경력정보는 여러 개를 입력할 수 있다. 입력할 내용이 없을 경우 q를 입력한다.
- 입력이 완료되면 엑셀 파일이 생성된다. 
![image](https://github.com/yejincode/generate_resume/assets/69861207/f9df6935-b4d3-472d-90d7-c07a84a1252f)




