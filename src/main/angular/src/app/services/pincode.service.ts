import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Pincode } from '../common/pincode';

@Injectable({
  providedIn: 'root'
})
export class PincodeService {
 
  private baseUrl = 'http://localhost:8080/cowin';

  constructor(private httpClient: HttpClient) { }

  retrieveAllPincodes() : Observable<Pincode[]> {
    return this.httpClient.get<Pincode[]>(`${this.baseUrl}/pincodes`);
  }

  createPincode(pincodeData: Pincode) {
    return this.httpClient.post<Pincode[]>(`${this.baseUrl}/pincodes`,pincodeData);
  }
  
}