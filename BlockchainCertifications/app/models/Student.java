package models;

import org.bson.types.ObjectId;

import dev.morphia.annotations.Entity;
import dev.morphia.annotations.Id;
import dev.morphia.annotations.Property;

@Entity("students")
public class Student {
	@Id
	private ObjectId _id;
	@Property("first_name")
	private String firstName;
	@Property("last_name")
	private String lastName;
	@Property("graduated_field")
	private String graduatedField;
	@Property("email")
	private String email;
	@Property("phone_number")
	private String phoneNumber;
	@Property("graduated_educational_institution")
	private EducationalInstitution graduatedEducationalInstitution;

}
