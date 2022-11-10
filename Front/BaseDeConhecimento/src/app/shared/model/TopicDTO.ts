
import { Categoria } from "./Categoria";

export class TopicDTO{
    public id: string;
    public titulo: string;
    public status: Boolean;
    public categoria: Categoria;
    public data: Date;
    public conteudo: string;

    static of(status: Boolean):TopicDTO{
        const topico = new TopicDTO();
        topico.status = status;
        return topico;
    }
}