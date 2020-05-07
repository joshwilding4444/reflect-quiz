package com.reflectquiz.model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name = "questions", schema="reflectquiz_dummy")
public class Question {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	@Column
	private String question;
	@Column
	private String answerlist;
	@Column
	private String correctanswer;
	@Column
	private int difficulty;
	@Column
	private String topic;
	@Column 
	private int creator;
	//@ManyToMany(mappedBy="questions", fetch=FetchType.LAZY)
	//private Set<Quiz> quizzes = new HashSet<Quiz>();
	
	public Question() {
		super();
	}
	
	public Question(int id, String question, String answerlist, String correctanswer, int difficulty, String topic,
			int creator) {
		super();
		this.id = id;
		this.question = question;
		this.answerlist = answerlist;
		this.correctanswer = correctanswer;
		this.difficulty = difficulty;
		this.topic = topic;
		this.creator = creator;
	}
	
	public Question(int id, String question, String answerlist, String correctanswer, int difficulty, String topic, int creator, Set<Quiz> quizzes) {
		super();
		this.id = id;
		this.question = question;
		this.answerlist = answerlist;
		this.correctanswer = correctanswer;
		this.difficulty = difficulty;
		this.topic = topic;		
		this.creator = creator;
		//this.quizzes = quizzes;
	}
	
	@Override
	public String toString() {
		return "Question [id=" + id + ", question=" + question + ", answerlist=" + answerlist + ", correctanswer="
				+ correctanswer + ", difficulty=" + difficulty + ", topic=" + topic + ", creator=" + creator + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((answerlist == null) ? 0 : answerlist.hashCode());
		result = prime * result + ((correctanswer == null) ? 0 : correctanswer.hashCode());
		result = prime * result + difficulty;
		result = prime * result + id;
		result = prime * result + creator;
		result = prime * result + ((question == null) ? 0 : question.hashCode());
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
		Question other = (Question) obj;
		if (answerlist == null) {
			if (other.answerlist != null)
				return false;
		} else if (!answerlist.equals(other.answerlist))
			return false;
		if (correctanswer == null) {
			if (other.correctanswer != null)
				return false;
		} else if (!correctanswer.equals(other.correctanswer))
			return false;
		if (difficulty != other.difficulty)
			return false;
		if (id != other.id)
			return false;
		if (creator != other.creator)
			return false;
		if (question == null) {
			if (other.question != null)
				return false;
		} else if (!question.equals(other.question))
			return false;
		if (topic == null) {
			if (other.topic != null)
				return false;
		} else if (!topic.equals(other.topic))
			return false;
		return true;
	}

	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getQuestion() {
		return question;
	}
	public void setQuestion(String question) {
		this.question = question;
	}
	public String getAnswerlist() {
		return answerlist;
	}
	public void setAnswerlist(String answerlist) {
		this.answerlist = answerlist;
	}
	public String getCorrectanswer() {
		return correctanswer;
	}
	public void setCorrectanswer(String correctanswer) {
		this.correctanswer = correctanswer;
	}
	public int getDifficulty() {
		return difficulty;
	}
	public void setDifficulty(int difficulty) {
		this.difficulty = difficulty;
	}
	public String getTopic() {
		return topic;
	}
	public void setTopic(String topic) {
		this.topic = topic;
	}
	public int getCreator() {
		return creator;
	}

	public void setCreator(int creator) {
		this.creator = creator;
	}

//	public Set<Quiz> getQuizzes() {
//		return quizzes;
//	}
//	public void setQuizzes(Set<Quiz> quizzes) {
//		this.quizzes = quizzes;
//	}
}
