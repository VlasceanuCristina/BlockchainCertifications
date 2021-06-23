package models;

import java.io.File;
import java.time.LocalDate;

import org.bson.types.ObjectId;

import dev.morphia.annotations.Entity;
import dev.morphia.annotations.Id;
import dev.morphia.annotations.Property;

@Entity(value = "diplomas", noClassnameStored = true )
public class Diploma{
	@Id
    private ObjectId _id;
	@Property("issue_date")
	private LocalDate issueDate;
	@Property("expiration_date")
	private LocalDate expirationDate;
	@Property("diploma_type")
	private String typeOfDiploma;
	@Property("hash_document")
	String hashDocument;
	
	/*
	 * getters and setters
	 */
	
	public ObjectId get_id() {
		return _id;
	}
	public void set_id(ObjectId _id) {
		this._id = _id;
	}
	public LocalDate getIssueDate() {
		return issueDate;
	}
	public void setIssueDate(LocalDate issueDate) {
		this.issueDate = issueDate;
	}
	public LocalDate getExpirationDate() {
		return expirationDate;
	}
	public void setExpirationDate(LocalDate expirationDate) {
		this.expirationDate = expirationDate;
	}
	public String getTypeOfDiploma() {
		return typeOfDiploma;
	}
	public void setTypeOfDiploma(String typeOfDiploma) {
		this.typeOfDiploma = typeOfDiploma;
	}
//	public File getDocument() {
//		return document;
//	}
//	public void setDocument(File document) {
//		this.document = document;
//	}
	
	/*
	 * contructors
	 */
	
	public Diploma(LocalDate issueDate, LocalDate expirationDate, String typeOfDiploma) {
		super();
		this.issueDate = issueDate;
		this.expirationDate = expirationDate;
		this.typeOfDiploma = typeOfDiploma;
		
	}
	public Diploma() {
		
	}
	
	public Diploma(LocalDate issueDate, LocalDate expirationDate, String typeOfDiploma, String hashDocument) {
		super();
		this.issueDate = issueDate;
		this.expirationDate = expirationDate;
		this.typeOfDiploma = typeOfDiploma;
		this.hashDocument = hashDocument;
		
	}
	
}
