package com.cisco.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Embeddable
public class ClassStudentPK implements Serializable {
    @Column(name = "class_id")
    private String classId;
    @Column(name = "student_id", unique = true)
    private String studentId;
}
