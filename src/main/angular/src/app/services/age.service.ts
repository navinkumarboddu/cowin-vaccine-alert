import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Age } from '../common/age';

@Injectable({
  providedIn: 'root'
})
export class AgeService {

  private baseUrl = 'http://localhost:8080/cowin';

  constructor(private httpClient: HttpClient) { }

  retrieveAllAges() : Observable<Age[]> {
    return this.httpClient.get<Age[]>(`${this.baseUrl}/ages`);
    //console.log("Hello World");
  }

  createPincode(ageData: Age) {
    return this.httpClient.post<Age[]>(`${this.baseUrl}/ages`,ageData);
  }
}
