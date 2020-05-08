export class Survey {
    quizID: number;
	private studentID: number;
	surveyInputField: string;
	
	constructor(quizID: number, studentID: number, surveyInputField: string) {
		this.quizID = quizID;
		this.studentID = studentID;
		this.surveyInputField = surveyInputField;
    }

    //getters and setters below------------------------------
    public getQuizID(): number {
		return this.quizID;
	}
	public setQuizID(quizID: number) {
		this.quizID = quizID;
	}
	public getStudentID(): number {
		return this.studentID;
	}
	public setStudentID(studentID: number) {
		this.studentID = studentID;
	}
	public getSurveyInputField(): string {
		return this.surveyInputField;
	}
	public setSurveyInputField(surveyInputField: string) {
		this.surveyInputField = surveyInputField;
	}
}