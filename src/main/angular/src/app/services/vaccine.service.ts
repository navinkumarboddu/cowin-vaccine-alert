import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Sessions } from '../common/session';

@Injectable({
  providedIn: 'root'
})
export class VaccineService {

  private baseUrl = 'http://localhost:8080/cowin';

  constructor(private httpClient: HttpClient) { }

  retrieveAllSessions() : Observable<Sessions[]> {
    return this.httpClient.get<Sessions[]>(`${this.baseUrl}/findByPin`);
    //console.log("Hello World");
  }
}

interface GetVaccines {
  _embedded: {
    vaccines: Sessions[];
  }
}