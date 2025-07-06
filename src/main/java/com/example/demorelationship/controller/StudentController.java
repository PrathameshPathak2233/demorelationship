package com.example.demorelationship.controller;

import com.example.demorelationship.entity.EmailId;
import com.example.demorelationship.entity.Student;
import com.example.demorelationship.mail.EmailService;
import com.example.demorelationship.repository.StudentRepository;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfWriter;
import lombok.Getter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.ByteArrayOutputStream;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/student-op")
public class StudentController {

    @Autowired
    StudentRepository studentRepository;

    @Autowired
    EmailService emailService;

    @PostMapping("/add-student")
    public Student addStudent(@RequestBody Student student) {
        student.getCourseList().forEach(course -> course.setStudent(student));
        student.getPhoneNumbers().forEach(phoneNumber -> phoneNumber.setStudent(student));
        student.getEmailIdSet().forEach(emailId -> emailId.setStudent(student));
        return studentRepository.save(student);
    }

    @GetMapping("/get-all-students")
    public List<Student> findAllStudents() {
        return studentRepository.findAll();
    }

    @GetMapping("/get-by-id")
    public List<Student> findAllStudent(){
        return null;
    }

    // Write an api to download pdf
    @GetMapping("/download")
    public ResponseEntity<byte[]> getDocument() throws DocumentException {

        // Write code here to create document and write data to it

        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();

        Document document = new Document();

        PdfWriter.getInstance(document, byteArrayOutputStream);
        document.open();
        document.addTitle("Sample PDF File");

        document.add(new Paragraph("Prathmesh doing well now a days"));
        document.close();
        byte[] bytes = byteArrayOutputStream.toByteArray();

        return ResponseEntity.ok()
                .header(HttpHeaders.CONTENT_DISPOSITION, "sample.pdf")
                .contentType(MediaType.APPLICATION_PDF)
                .body(bytes);

    }

    @GetMapping("/sendEmail/{id}")
    public String sendMailToStudent(@PathVariable Long id)
    {
        Optional<Student> student = studentRepository.findById(id);
        if (student.isPresent()) {
            student.get().getEmailIdSet().forEach(emailId -> emailService.sendmail(emailId.getMailId()));
            return "Mail sent to Student";
        }
        else
        {
            return "Student not found for sending mail";
        }
    }

    public List<Student> getStudentsBYDescByPercentage() {
        // Prath please add your code here
        return null;
    }
}
