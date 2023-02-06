package com.swa.sra.studentservice.repository;

import com.swa.sra.studentservice.domain.Student;
import com.swa.sra.studentservice.dto.StudentDto;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;


@Repository
public interface IStudentRepository extends MongoRepository<Student,Long> {

    Optional<Student> findByStudentNumber(String studentNumber);
}
