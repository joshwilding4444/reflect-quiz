export class Question {
    public id: number;
    public question: string;
    public answerlist: string;
    public correctanswer: string;
    public difficulty: number;
    public topic: string;

    constructor(id: number, question: string, answerList: string, correctAnswer: string, difficulty: number, topic: string){
            this.id = id;
            this.question = question;
            this.answerlist = answerList;
            this.correctanswer = correctAnswer;
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

    public setQuestion(newQuestion:string){
        this.question = newQuestion;
    }

    public getAnswerList(): string {
        return this.answerlist;
    }

    public setAnswerList(newAnswerList){
        this.answerlist = newAnswerList;
    }

    public getCorrectAnswer(): string {
        return this.correctanswer;
    }

    public setCorrectAnswer(newCorrectAnswer:string){
        this.correctanswer = newCorrectAnswer;
    }

    public getDifficulty(): number {
        return this.difficulty;
    }

    public setDifficulty(newDifficulty:number){
        this.difficulty = newDifficulty;
    }

    public getTopic(): string {
        return this.topic;
    }

    public setTopic(newTopic:string){
        this.topic = newTopic;
    }
}
