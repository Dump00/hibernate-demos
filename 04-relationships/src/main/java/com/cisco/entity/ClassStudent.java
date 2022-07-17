package com.cisco.entity;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.sql.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "class_student")
public class ClassStudent implements Serializable {
    @EmbeddedId
    private ClassStudentPK classStudentPK;
    @Column(nullable = false)
    private Date date;
    @Setter(AccessLevel.NONE)
    @ManyToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "class_id", referencedColumnName = "id", insertable = false, updatable = false)
    private Class classRef;
    @OneToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "student_id", referencedColumnName = "id", insertable = false, updatable = false)
    private Student student;

    public ClassStudent(ClassStudentPK classStudentPK, Date date) {
        this.classStudentPK = classStudentPK;
        this.date = date;
    }

    public ClassStudent(String classId, String studentId, Date date) {
        this.classStudentPK = new ClassStudentPK(classId, studentId);
        this.date = date;
    }

    public ClassStudent(ClassStudentPK classStudentPK, Date date, Student student) {
        this.classStudentPK = classStudentPK;
        this.date = date;
        this.student = student;
    }
}
