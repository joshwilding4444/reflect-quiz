import { Question } from './question';

export class Quiz{
    private id: number;
    private quizLength: number;
    private startingDifficulty: number;
    private topic: string;
    private questions: Question[];

    constructor(id: number, quizLength: number, startingDifficulty: number, topic: string, questions: Question[]){
        this.id = id;
        this.quizLength = quizLength;
        this.startingDifficulty = startingDifficulty;
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
        return this.quizLength;
    }
    public setQuizLength(value: number) {
        this.quizLength = value;
    }
    public getStartingDifficulty(): number {
        return this.startingDifficulty;
    }
    public setStartingDifficulty(value: number) {
        this.startingDifficulty = value;
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