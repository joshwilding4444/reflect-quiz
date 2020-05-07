export class Options {
    constructor(){}
    public getAnswers() {
        return [
            { id: 1, name: 'A' },
            { id: 2, name: 'B' },
            { id: 3, name: 'C' },
            { id: 4, name: 'D' }
        ];
    }

    public getTopic() {
        return [
            { id: 1, name: 'Math' },
            { id: 2, name: 'Science' },
            { id: 3, name: 'History' },
            { id: 4, name: 'Grammer' }
        ];
    }

    public getDifficulty() {
        return [
            { id: 1, name: 1 },
            { id: 2, name: 2 },
            { id: 3, name: 3 },
            { id: 4, name: 4 },
            { id: 5, name: 5 },
        ];
    }
}