package com.example.studentCouncil.Model;
import lombok.Data;
import javax.persistence.*;

@Data
@Entity
@Table(name = "student")
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long stuID;
    private String LevelOfEducation;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "userID", referencedColumnName = "userID")
    private User userID;

//    @ManyToOne(cascade = CascadeType.ALL)
//    @JoinColumn(name = "constID", referencedColumnName = "consID")
//    private Consultant constID;
//
//    @OneToMany(mappedBy = "students", fetch = FetchType.LAZY)
//    private List<StudentConcil> studentConcilList;


    //    student  + consultant
//    @ManyToMany
//    private Set<Consultant> consultants;
//
//
//    public void assignConsultantToStudent(Consultant consultant) {
//        this.consultants.add(consultant);
//    }
}
