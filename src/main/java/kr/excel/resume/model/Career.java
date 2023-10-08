package kr.excel.resume.model;
// 경력 DTO
public class Career {
    private String workPeriod; //재직 기간
    private String company; //회사 이름
    private String jobTitle; //직업
    private String employmentYears; //재직 연도

    // 생성자
    public Career() {
    }

    public Career(String workPeriod, String company, String jobTitle, String employmentYears) {
        this.workPeriod = workPeriod;
        this.company = company;
        this.jobTitle = jobTitle;
        this.employmentYears = employmentYears;
    }

    // get,set
    public String getWorkPeriod() {
        return workPeriod;
    }

    public void setWorkPeriod(String workPeriod) {
        this.workPeriod = workPeriod;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public String getJobTitle() {
        return jobTitle;
    }

    public void setJobTitle(String jobTitle) {
        this.jobTitle = jobTitle;
    }

    public String getEmploymentYears() {
        return employmentYears;
    }

    public void setEmploymentYears(String employmentYears) {
        this.employmentYears = employmentYears;
    }

    @Override
    public String toString() {
        return "Career{" +
                "workPeriod='" + workPeriod + '\'' +
                ", company='" + company + '\'' +
                ", jobTitle='" + jobTitle + '\'' +
                ", employmentYears='" + employmentYears + '\'' +
                '}';
    }
}
