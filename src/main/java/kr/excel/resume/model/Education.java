package kr.excel.resume.model;

// 학력 정보 DTO
public class Education {
    private String graduationYear; // 졸업연도
    private String major; // 전공
    private String schoolName; // 학교
    private String graduationStatus; // 졸업여부

    //생성자
    public Education(String graduationYear) {
        this.graduationYear = graduationYear;
    }

    public Education(String graduationYear, String major, String schoolName, String graduationStatus) {
        this.graduationYear = graduationYear;
        this.major = major;
        this.schoolName = schoolName;
        this.graduationStatus = graduationStatus;
    }

    //get,set

    public String getGraduationYear() {
        return graduationYear;
    }

    public void setGraduationYear(String graduationYear) {
        this.graduationYear = graduationYear;
    }

    public String getMajor() {
        return major;
    }

    public void setMajor(String major) {
        this.major = major;
    }

    public String getSchoolName() {
        return schoolName;
    }

    public void setSchoolName(String schoolName) {
        this.schoolName = schoolName;
    }

    public String getGraduationStatus() {
        return graduationStatus;
    }

    public void setGraduationStatus(String graduationStatus) {
        this.graduationStatus = graduationStatus;
    }

    @Override
    public String toString() {
        return "Education{" +
                "graduationYear='" + graduationYear + '\'' +
                ", major='" + major + '\'' +
                ", schoolName='" + schoolName + '\'' +
                ", graduationStatus='" + graduationStatus + '\'' +
                '}';
    }
}
