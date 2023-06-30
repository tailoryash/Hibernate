package com.goal.jpademo.entity.relation;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@NamedQueries({
        @NamedQuery(name = "Student.findAll", query = "select s from Student s")
})
//@SQLDelete(sql = "update student set is_deleted = true where id = ?")
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;
    private String location;
    private LocalDate birthDate;
    @OneToOne(mappedBy = "student",cascade = CascadeType.ALL)
    @ToString.Exclude
    private Passport passport;

    @ManyToMany
    @JoinTable(name = "STUDENT_COURSE",
            joinColumns = @JoinColumn(name = "student_id"),
            inverseJoinColumns = @JoinColumn(name = "course_id")
    )
    @ToString.Exclude
    @JsonManagedReference
    private List<Course> courses = new ArrayList<>();

    @JsonIgnore
    private boolean isDeleted;

    @PreRemove
    private void preRemove(){
        this.isDeleted = true;
    }

    public Student(String name, String location, LocalDate birthDate) {
        this.name = name;
        this.location = location;
        this.birthDate = birthDate;
        this.courses = new ArrayList<>();
    }

    public void addCourse(Course course){
        this.courses.add(course);
    }

    public void removeCourse(Course course){
        this.courses.remove(course);
    }
}

