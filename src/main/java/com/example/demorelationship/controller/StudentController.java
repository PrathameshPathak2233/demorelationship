package com.example.demorelationship.controller;

import com.example.demorelationship.entity.Student;
import com.example.demorelationship.repository.StudentRepository;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfWriter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.awt.*;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.util.List;

@RestController
@RequestMapping("/student-op")
public class StudentController {

    @Autowired
    StudentRepository studentRepository;

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



}
