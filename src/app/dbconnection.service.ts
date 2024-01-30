import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class DbconnectionService {

  private apiUrl = 'http://localhost:8080/api'; // Assicurati che l'URL punti al tuo backend Spring sulla porta corretta

  constructor(private http: HttpClient) { }

  getDati(): Observable<any> {
    return this.http.get(`${this.apiUrl}/task`);
  }
}
