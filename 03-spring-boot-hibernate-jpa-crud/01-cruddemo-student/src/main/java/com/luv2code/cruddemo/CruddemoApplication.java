package com.luv2code.cruddemo;

import com.luv2code.cruddemo.dao.StudentDAO;
import com.luv2code.cruddemo.entity.Student;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@SpringBootApplication
public class CruddemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(CruddemoApplication.class, args);
	}

	@Bean
	public CommandLineRunner commandLineRunner(StudentDAO studentDAO) {

		return runner -> {
			createStudent(studentDAO ,"Joe", "Doe", "example@mail.com");
			createStudent(studentDAO ,"Ann", "Toe", "example@mail.com");
			createStudent(studentDAO ,"Zack", "Zoe", "example@mail.com");
//			readStudent(studentDAO, 1);
//			readStudent(studentDAO, 3);
//			readStudent(studentDAO, 1111);
//			queryForStudents(studentDAO);
//			queryForStudentsByLastName(studentDAO, "Lane");
//			updateStudentFirstName(studentDAO, 1, "Piotr");
//			deleteStudentById(studentDAO, 3);
//			deleteAllStudents(studentDAO);
		};

	}

	private void deleteAllStudents(StudentDAO studentDAO) {
		int rowDeletedCount = studentDAO.deleteAll();
		System.out.println("Deleted row count: " + rowDeletedCount);
	}

	private void deleteStudentById(StudentDAO studentDAO, Integer id) {
		System.out.println("Deleting student with id: " + id);
		studentDAO.delete(id);
		System.out.println("Student with id: " + id + " has been deleted.");
	}

	private void updateStudentFirstName(StudentDAO studentDAO, Integer studentId, String firstName) {
		// retriving student based on id
		System.out.println("Looking for student with id: " + studentId + "...");
		Student theStudent = studentDAO.findById(studentId);
		System.out.println("Student found: " + theStudent);
		System.out.println("Updating...");
		theStudent.setFirstName(firstName);
		studentDAO.update(theStudent);
		System.out.println("Updated student: " + theStudent);
	}

	private void queryForStudentsByLastName(StudentDAO studentDAO, String lastName) {
		List<Student> studentList = studentDAO.findByLastName(lastName);
		for (Student student : studentList) {
			System.out.println(student);
		}
	}

	private void queryForStudents(StudentDAO studentDAO) {
		List<Student> studentList = studentDAO.findAll();
		for (Student student : studentList) {
			System.out.println(student);
		}
	}

	private void createStudent(StudentDAO studentDAO, String firstName, String lastName, String email) {
		// create the student object
		System.out.println("Creating new student object...");
		Student student = new Student(firstName, lastName, email);
		// save the student
		System.out.println("Saving the student...");
		studentDAO.save(student);
		// display the id of the saved student
		System.out.println("Saved student. Generated id: " + student.getId());
	}

	private void readStudent(StudentDAO studentDAO, Integer id) {

		// retrive student based on the id
		Student studentFound = studentDAO.findById(id);

		System.out.println("Found the student: " + studentFound);
	}

}
