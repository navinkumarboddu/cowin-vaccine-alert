import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Sessions } from '../common/session';
import { Vaccine } from '../common/vaccine';

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

  retrieveAllVaccines(): Observable<Vaccine[]> {
    return this.httpClient.get<Vaccine[]>(`${this.baseUrl}/vaccines`);
    //console.log("Hello World");
  }

  createVaccine(vaccineData: Vaccine) {
    return this.httpClient.post<Vaccine[]>(`${this.baseUrl}/vaccines`,vaccineData);
  }
}

interface GetVaccines {
  _embedded: {
    vaccines: Sessions[];
  }
}