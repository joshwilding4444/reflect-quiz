package com.reflectquiz.model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name = "quizzes", schema="public")
public class Quiz {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	@Column
	private int quizlength;
	@Column
	private int startingdifficulty;
	@Column
	private String topic;
	@ManyToMany(fetch=FetchType.EAGER)
    @JoinTable(name="quiz_questions", schema="public", 
        joinColumns= {@JoinColumn(name="quiz_id")},
        inverseJoinColumns= {@JoinColumn(name="question_id")}
        )
    private Set<Question> questions = new HashSet<Question>();

	public Quiz() {
		super();
	}
	public Quiz(int id, int quizlength, int startingdifficulty, String topic) {
		super();
		this.id = id;
		this.quizlength = quizlength;
		this.startingdifficulty = startingdifficulty;
		this.topic = topic;
	}
	public Quiz(int id, int quizlength, int startingdifficulty, String topic, Set<Question> questions) {
		super();
		this.id = id;
		this.quizlength = quizlength;
		this.startingdifficulty = startingdifficulty;
		this.topic = topic;
		this.questions = questions;
	}
	
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + id;
		result = prime * result + ((questions == null) ? 0 : questions.hashCode());
		result = prime * result + quizlength;
		result = prime * result + startingdifficulty;
		result = prime * result + ((topic == null) ? 0 : topic.hashCode());
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
		Quiz other = (Quiz) obj;
		if (id != other.id)
			return false;
		if (questions == null) {
			if (other.questions != null)
				return false;
		} else if (!questions.equals(other.questions))
			return false;
		if (quizlength != other.quizlength)
			return false;
		if (startingdifficulty != other.startingdifficulty)
			return false;
		if (topic == null) {
			if (other.topic != null)
				return false;
		} else if (!topic.equals(other.topic))
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "Quiz [id=" + id + ", quizlength=" + quizlength + ", startingdifficulty=" + startingdifficulty
				+ ", topic=" + topic + ", questions=" + questions + "]";
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getQuizlength() {
		return quizlength;
	}
	public void setQuizlength(int quizlength) {
		this.quizlength = quizlength;
	}
	public int getStartingdifficulty() {
		return startingdifficulty;
	}
	public void setStartingdifficulty(int startingdifficulty) {
		this.startingdifficulty = startingdifficulty;
	}
	public String getTopic() {
		return topic;
	}
	public void setTopic(String topic) {
		this.topic = topic;
	}
	public Set<Question> getQuestions() {
		return questions;
	}
	public void setQuestions(Set<Question> questions) {
		this.questions = questions;
	}
	
}
