package com.studentfeedback.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.studentfeedback.model.Student;

import java.util.List;
import java.util.Optional;

@Repository
public interface StudentRepository extends JpaRepository<Student, Long> {
    // Find student by email (assuming Student model has an email field)
    Optional<Student> findByEmail(String email);

    // Find students by course
    List<Student> findByCourse(String course);

    // Find students by name (partial match)
    List<Student> findByNameContainingIgnoreCase(String name);

    // Check if a student exists by email
    boolean existsByEmail(String email);

    // Find students by department (assuming Student model has a department field)
    List<Student> findByDepartment(String department);

    // Custom query to find students with specific attributes
    @Query("SELECT s FROM Student s WHERE s.course = :course AND s.department = :department")
    List<Student> findStudentsByCourseAndDepartment(
        @Param("course") String course, 
        @Param("department") String department
    );

    // Find students by admission year (assuming Student model has an admissionYear field)
    List<Student> findByAdmissionYear(int year);

    // Custom query to find active students
    @Query("SELECT s FROM Student s WHERE s.isActive = true")
    List<Student> findActiveStudents();

    // Count students in a specific course
    int countByCourse(String course);

    // Count students in a specific department
    int countByDepartment(String department);

    // Find top N students by CGPA (assuming Student model has a cgpa field)
    @Query("SELECT s FROM Student s ORDER BY s.cgpa DESC")
    List<Student> findTopStudents(org.springframework.data.domain.Pageable pageable);
}