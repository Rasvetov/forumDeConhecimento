import { HttpClient } from "@angular/common/http";
import { Injectable } from "@angular/core";
import { Observable } from "rxjs/internal/Observable";
import { url } from "../Const/url";
import { TopicDTO } from "../model/TopicDTO";

@Injectable({
    providedIn: "root"
})
export class TopicService {
    

   

    constructor(
        private http: HttpClient
        ) { }

    public getAll() {
        return this.http.get<TopicDTO[]>(`${url.api}/topico/getAll`);
    }
    
    public postForm(objDTO: TopicDTO): Observable<TopicDTO>{
        return this.http.post<TopicDTO>(`${url.api}/topico`,objDTO);
    }

    public topicUpdate(objDTO: TopicDTO): Observable<TopicDTO>{
        return this.http.put<TopicDTO>(`${url.api}/topico`,objDTO)
    }

    getById(id: any) {
        return this.http.get<TopicDTO>(`${url.api}/topico/${id}`);
      }
      
    getByStatus(topico: TopicDTO){
        return this.http.post<TopicDTO[]>(`${url.api}/topico/getByStatus`,topico);
    } 
    }

    
    

