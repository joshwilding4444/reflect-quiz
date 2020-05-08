package com.reflectquiz.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Surveys", schema="reflectquiz_dummy")
public class Survey {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column
	private int id;
	@Column
	private int quizID;
	@Column
	private int studentID;
	@Column
	private String surveyInputField;
	
	//----------------------- Pojo below --------------------------
	
		//----------- constructors ---------------------------
	public Survey() {
		super();
	}
	
	public Survey(int id, int quizID, int studentID, String surveyInputField) {
		super();
		this.id = id;
		this.quizID = quizID;
		this.studentID = studentID;
		this.surveyInputField = surveyInputField;
	}
	
		//----------------getters and setters ---------------------
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getQuizID() {
		return quizID;
	}
	public void setQuizID(int quizID) {
		this.quizID = quizID;
	}
	public int getStudentID() {
		return studentID;
	}
	public void setStudentID(int studentID) {
		this.studentID = studentID;
	}
	public String getSurveyInputField() {
		return surveyInputField;
	}
	public void setSurveyInputField(String surveyInputField) {
		this.surveyInputField = surveyInputField;
	}
	
		//----------------hashCode, equals. toString ---------------------
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + id;
		result = prime * result + quizID;
		result = prime * result + studentID;
		result = prime * result + ((surveyInputField == null) ? 0 : surveyInputField.hashCode());
		return result;
	}
	
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Survey other = (Survey) obj;
		if (id != other.id)
			return false;
		if (quizID != other.quizID)
			return false;
		if (studentID != other.studentID)
			return false;
		if (surveyInputField == null) {
			if (other.surveyInputField != null)
				return false;
		} else if (!surveyInputField.equals(other.surveyInputField))
			return false;
		return true;
	}
	
	@Override
	public String toString() {
		return "Survey [id=" + id + ", quizID=" + quizID + ", studentID=" + studentID + ", surveyInputField="
				+ surveyInputField + ", questionAnswers=" + "]";
	}
		
}
