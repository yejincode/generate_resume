package kr.excel.resume.model;

// 개인정보 저장 위한 DTO
public class Person {
    private String name;//이름
    private String photo;//사진
    private String email;//이메일
    private String address;//주소
    private String birth;//생일
    private String phoneNumber;//전화번호

    public Person() {//생성자
    }

    public Person(String name, String photo, String email, String address, String birth, String phoneNumber) {
        this.name = name;
        this.photo = photo;
        this.email = email;
        this.address = address;
        this.birth = birth;
        this.phoneNumber = phoneNumber;
    }

    // get,set 생성(각 멤버변수 별로)
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getBirth() {
        return birth;
    }

    public void setBirth(String birth) {
        this.birth = birth;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", photo='" + photo + '\'' +
                ", email='" + email + '\'' +
                ", address='" + address + '\'' +
                ", birth='" + birth + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                '}';
    }

    public static class Education {
    }
}
