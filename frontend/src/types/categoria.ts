import { Video } from "./video";

export type Categoria = {
    id: number;
    titulo: string;
    cor: string;
    videos: Video[];
}