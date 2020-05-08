export class Question {
    private id: number;
    question: string;
    private answerList: string;
    private correctAnswer: string;
    private difficulty: number;
    private topic: string;

    constructor(id: number, question: string, answerList: string, correctAnswer: string, difficulty: number, topic: string){
            this.id = id;
            this.question = question;
            this.answerList = answerList;
            this.correctAnswer = correctAnswer;
            this.difficulty = difficulty;
            this.topic = topic;
        }

//getters and setters below------------------------------
    public getId():number {
        return this.id;
    }
    public setId(newID:number){
        this.id = newID;
    }

    public getQuestion(): string {
        return this.question;
    }

    public setQuestion(question:string){
        this.question = question;
    }

    public getAnswerList(): string {
        return this.answerList;
    }

    public setAnswerList(answerList){
        this.answerList = answerList;
    }

    public getCorrectAnswer(): string {
        return this.correctAnswer;
    }

    public setCorrectAnswer(correctAnswer:string){
        this.correctAnswer = correctAnswer;
    }

    public getDifficulty(): number {
        return this.difficulty;
    }

    public setDifficulty(difficulty:number){
        this.difficulty = difficulty;
    }

    public getTopic(): string {
        return this.topic;
    }

    public setTopic(topic:string){
        this.topic = topic;
    }
}
