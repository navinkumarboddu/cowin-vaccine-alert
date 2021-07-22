import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Dose } from '../common/dose';

@Injectable({
  providedIn: 'root'
})
export class DoseService {

  private baseUrl = 'http://localhost:8080/cowin';

  constructor(private httpClient: HttpClient) { }

  retrieveAllDoses() : Observable<Dose[]> {
    return this.httpClient.get<Dose[]>(`${this.baseUrl}/doses`);
    //console.log("Hello World");
  }
}
