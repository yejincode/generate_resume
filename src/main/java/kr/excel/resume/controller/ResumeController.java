package kr.excel.resume.controller;

import kr.excel.resume.model.Career;
import kr.excel.resume.model.Education;
import kr.excel.resume.model.Person;
import kr.excel.resume.view.ResumeView;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.*;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.*;
import java.util.List;

public class ResumeController {
    private ResumeView view;
    private Workbook workbook; // 엑셀 파일 생성 위함 (메모리 엑셀)
    public ResumeController(){
        view = new ResumeView();
        workbook = new XSSFWorkbook(); // 엑셀 생셩
    }
    private void createResume() {
        Person person = view.inputPersonInfo();
        List<Education> educationList = view.inputEducationList();
        List<Career> careerList = view.inputCareerList();
        String introduction = view.inputIntroduction();

        createResumeSheet(person,educationList,careerList);  //이력서 생성
        createIntroductionSheet(introduction); // 자소서 생성

        saveWorkbookToFile();

        System.out.println("이력서가 생성되었습니다. ");

    }

    private void createResumeSheet(Person person, List<Education> educationList, List<Career> careerList) {
        Sheet sheet = workbook.createSheet("이력서");
        //헤더 생성
        Row headerRow = sheet.createRow(0);
        headerRow.createCell(0).setCellValue("사진");
        headerRow.createCell(1).setCellValue("이름");
        headerRow.createCell(2).setCellValue("이메일");
        headerRow.createCell(3).setCellValue("주소");
        headerRow.createCell(4).setCellValue("생일");
        headerRow.createCell(5).setCellValue("전화번호");

        // 데이터 삽입
        Row dataRow = sheet.createRow(1);
        String photoFilename = person.getPhoto(); //사진 정보 가져오기
        try (InputStream photoStream = new FileInputStream(photoFilename)){
            // 사진 읽기
            BufferedImage originImage = ImageIO.read(photoStream);

            // 이미지 사이즈 조절(가로 35mm, 세로 45mm)
            int newWidth = (int) (35 * 2.83465);
            int newHeight = (int) (45 * 2.83465);
            Image resizedImage = originImage.getScaledInstance(newWidth, newHeight, Image.SCALE_SMOOTH);
            BufferedImage resizedBufferedImage = new BufferedImage(newWidth, newHeight, BufferedImage.TYPE_4BYTE_ABGR);
            Graphics2D g2d = resizedBufferedImage.createGraphics();
            g2d.drawImage(resizedImage, 0, 0, null);
            g2d.dispose();

            // 조절된 이미지 -> 바이트 배열 변환
            ByteArrayOutputStream baos = new ByteArrayOutputStream();
            ImageIO.write(resizedBufferedImage, "png", baos);
            byte[] imageBytes = baos.toByteArray();
            int imageIndex = workbook.addPicture(imageBytes, Workbook.PICTURE_TYPE_PNG);

            // Drawing 객체 생성 및 이미지 삽입
            XSSFDrawing drawing = (XSSFDrawing) sheet.createDrawingPatriarch();
            XSSFClientAnchor anchor = new XSSFClientAnchor(0, 0, 0, 0, 0, 1, 1, 2);
            drawing.createPicture(anchor, imageIndex);

            // 이미지가 삽입된 행의 높이,열의 너비를 조정
            dataRow.setHeightInPoints(newHeight*72/96); // 픽셀을 point로 변경
            int columnWidth = (int) Math.floor(((float) newWidth / (float) 8) * 256);
            sheet.setColumnWidth(0, columnWidth);

        } catch (IOException ex) {
            ex.printStackTrace();
        }

        dataRow.createCell(1).setCellValue(person.getName());
        dataRow.createCell(2).setCellValue(person.getEmail());
        dataRow.createCell(3).setCellValue(person.getAddress());
        dataRow.createCell(4).setCellValue(person.getBirth());
        dataRow.createCell(5).setCellValue(person.getPhoneNumber());

        // 학력사항 헤더 생성
        int educationStartRow = 3;
        Row educationHeaderRow = sheet.createRow(educationStartRow - 1);
        educationHeaderRow.createCell(0).setCellValue("졸업연도");
        educationHeaderRow.createCell(1).setCellValue("전공");
        educationHeaderRow.createCell(2).setCellValue("학교");
        educationHeaderRow.createCell(3).setCellValue("졸업여부");

        // 학력사항 데이터 삽입
        int educationRowNum = educationStartRow;
        for (Education education : educationList) {
            Row educationDataRow = sheet.createRow(educationRowNum++);
            educationDataRow.createCell(0).setCellValue(education.getGraduationYear());
            educationDataRow.createCell(1).setCellValue(education.getMajor());
            educationDataRow.createCell(2).setCellValue(education.getSchoolName());
            educationDataRow.createCell(3).setCellValue(education.getGraduationStatus());
        }

        // 경력사항 헤더 생성
        int careerStartRow = educationRowNum + 1;
        Row careerHeaderRow = sheet.createRow(careerStartRow - 1);
        careerHeaderRow.createCell(0).setCellValue("재직 기간");
        careerHeaderRow.createCell(1).setCellValue("회사명");
        careerHeaderRow.createCell(2).setCellValue("담당 업무");
        careerHeaderRow.createCell(3).setCellValue("근속 연수");

        // 경력사항 데이터 삽입
        int careerRowNum = careerStartRow;
        for (Career career : careerList) {
            Row careerDataRow = sheet.createRow(careerRowNum++);
            careerDataRow.createCell(0).setCellValue(career.getWorkPeriod());
            careerDataRow.createCell(1).setCellValue(career.getCompany());
            careerDataRow.createCell(2).setCellValue(career.getJobTitle());
            careerDataRow.createCell(3).setCellValue(career.getEmploymentYears());

        }
    }

    private void createIntroductionSheet(String selfIntroduction) {
        Sheet sheet = workbook.createSheet("자기소개서");

        // 데이터 삽입
        Row dataRow = sheet.createRow(0);
        Cell selfIntroductionCell = dataRow.createCell(0);
        selfIntroductionCell.setCellStyle(getWrapCellStyle());
        selfIntroductionCell.setCellValue(new XSSFRichTextString(selfIntroduction.replaceAll("\n", String.valueOf((char) 10))));
    }

    private XSSFCellStyle getWrapCellStyle() {
        XSSFCellStyle style = (XSSFCellStyle) workbook.createCellStyle();
        style.setWrapText(true); //자동 줄바꿈 할 수 있도록.
        return style;
    }

    private void saveWorkbookToFile() {
        try (FileOutputStream fileOut = new FileOutputStream("이력서.xlsx")) {
            workbook.write(fileOut);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        ResumeController controller = new ResumeController();
        controller.createResume();
    }
}
