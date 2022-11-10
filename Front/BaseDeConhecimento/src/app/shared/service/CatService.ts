import { HttpClient } from "@angular/common/http";
import { Injectable } from "@angular/core";
import { Observable } from "rxjs/internal/Observable";
import { url } from "../Const/url";
import { Categoria } from "../model/Categoria";


@Injectable({
    providedIn: "root"
})

export class CatService {

    constructor(
        private http: HttpClient
    )   { }

    public getAll() {
        return this.http.get<Categoria[]>(`${url.api}/categoria/getAll`);
    }

    public postCat(catDTO: Categoria): Observable<Categoria>{
        return this.http.post<Categoria>(`${url.api}/categoria`,catDTO);
        
      }

      public catUpdate(catDTO: Categoria): Observable<Categoria>{
        return this.http.put<Categoria>(`${url.api}/categoria`,catDTO);
      }

}


