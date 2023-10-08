# 💙 generate_resume
이력서 자동생성을 위한 프로젝트 입니다. 데이터를 입력받으면 엑셀로 변환하여 저장합니다. 

# 📘 사용 언어
<img src="https://img.shields.io/badge/Java-007396?style=flat&logo=OpenJDK&logoColor=white"/>

# 💻 구현 기능
  - Model
    - Person : 사용자의 개인정보를 저장합니다. 멤버 변수로 name, photo, email, address, birth, phoneNumber를 가지고 있습니다. 
    - Education: 사용자의 학력정보를 저장합니다. 멤버 변수로 graduationYear, schoolName, major, graduationStatus를 가지고 있습니다.  
    - Career : 사용자의 경력정보를 저장합니다. 멤버 변수로 workPeriod, companyName, jobTitle, employmentYears를 가지고 있습니다. 
  - View
    - ResumeView : 사용자로부터 이력서 작성에 필요한 정보(개인정보, 학력정보, 경력정보, 자기소개서)를 입력받습니다. 입력받은 정보의 유효성 검사를 하여 유효하지 않을 경우 재입력 받습니다. 
  - Controller
    - ResumeController : main 메소드에서 입력받은 정보를 바탕으로 이력서를 생성합니다.



