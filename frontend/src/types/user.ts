import { Role } from "./role";

export type User = {
    id: number;
    name: User;
    email: string;
    password: string;
    roles: Role[];
}