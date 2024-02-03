package com.StudentManagement.demo.Model;

import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class Student {
    private String Name;
    private Integer Age;
    private int rollno;
    private Integer classname;
    private Integer English;
    private Integer Hindi;
    private Integer Maths;
    private Integer Science;

}
