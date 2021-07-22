import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root'
})
export class PreferenceService {

  private baseUrl = 'http://localhost:8080/cowin';

  constructor(private httpClient: HttpClient) { }

  createPreference(preferenceData: any) {
    return this.httpClient.post<any[]>(`${this.baseUrl}/preferences`,preferenceData);
  }
}
