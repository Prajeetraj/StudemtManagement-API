package com.prajeet.student_api.model;
import jakarta.persistence.*;
import com.prajeet.student_api.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;
@Entity                                     ///Makes this class a table in DB                                          
@Table(name = "students")
public class Student {
	

	

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}@Id                                                            //Primary key
    @GeneratedValue(strategy = GenerationType.IDENTITY)              //Auto increments ID
    private Integer id;

	//private Integer id;

    private String name;
    private int age;
    private String gender;       // Male/Female/Other
    private String rollNumber;   // Unique roll number
    private String phoneNumber;  // Contact number
    private String address;      // Home address

    // Getters and Setters
    public Integer getId() { return id; }
    public void setId(Integer id) { this.id = id; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public int getAge() { return age; }
    public void setAge(int age) { this.age = age; }

    public String getGender() { return gender; }
    public void setGender(String gender) { this.gender = gender; }

    public String getRollNumber() { return rollNumber; }
    public void setRollNumber(String rollNumber) { this.rollNumber = rollNumber; }

    public String getPhoneNumber() { return phoneNumber; }
    public void setPhoneNumber(String phoneNumber) { this.phoneNumber = phoneNumber; }

    public String getAddress() { return address; }
    public void setAddress(String address) { this.address = address; }
}
