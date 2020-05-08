import { Question } from './question';

export class Quiz{
    public id: number;
    public quizlength: number;
    public startingdifficulty: number;
    public topic: string;
    public questions: Question[];

    constructor(id: number, quizLength: number, startingDifficulty: number, topic: string, questions: Question[]){
        this.id = id;
        this.quizlength = quizLength;
        this.startingdifficulty = startingDifficulty;
        this.topic = topic;
        this.questions = questions;
    }
    
    public getId(): number {
        return this.id;
    }
    public setId(value: number) {
        this.id = value;
    }
    public getQuizLength(): number {
        return this.quizlength;
    }
    public setQuizLength(value: number) {
        this.quizlength = value;
    }
    public getStartingDifficulty(): number {
        return this.startingdifficulty;
    }
    public setStartingDifficulty(value: number) {
        this.startingdifficulty = value;
    }
    public getTopic(): string {
        return this.topic;
    }
    public setTopic(value: string) {
        this.topic = value;
    }
    public getQuestions(): Question[] {
        return this.questions;
    }
    public setQuestions(value: Question[]) {
        this.questions = value;
    }
}