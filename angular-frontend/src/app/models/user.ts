export class User {
    private id: number;
    private username: string;
    public userRole: string;

    constructor(id: number, username: string, userRole: string){
            this.id = id;
            this.username = username;
            this.userRole = userRole;
        }

//getters and setters below------------------------------
    public getId():number {
        return this.id;
    }
    public setId(newID:number){
        this.id = newID;
    }

    public getUsername(): string {
        return this.username;
    }

    public setUsername(newUsername:string){
        this.username = newUsername;
    }

    public getUserRole(): string {
        return this.userRole;
    }

    public setUserRole(newUserRole){
        this.userRole = newUserRole;
    }
}
