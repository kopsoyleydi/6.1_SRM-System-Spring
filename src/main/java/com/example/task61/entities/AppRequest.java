package com.example.task61.entities;


import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "applications")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class AppRequest {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;
    @Column(name = "userName")
    private String userName;

    @Column(name = "commentary")
    private String commentary;
    @Column(name = "phone")
    private String phone;
    @Column(name = "handled")
    private boolean handled;
    @ManyToOne(fetch = FetchType.LAZY)
    private CourseEntity courses;
}
