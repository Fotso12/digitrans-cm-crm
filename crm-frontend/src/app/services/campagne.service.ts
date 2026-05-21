import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { environment } from '../../environments/environment';
import { Campagne, CampagneClient } from '../core/models/campagne.model';

@Injectable({ providedIn: 'root' })
export class CampagneService {
  private apiUrl = `${environment.apiUrl}/campagnes`;

  constructor(private http: HttpClient) {}

  getAll(): Observable<Campagne[]> {
    return this.http.get<Campagne[]>(this.apiUrl);
  }

  getById(id: number): Observable<Campagne> {
    return this.http.get<Campagne>(`${this.apiUrl}/${id}`);
  }

  create(data: Campagne): Observable<Campagne> {
    return this.http.post<Campagne>(this.apiUrl, data);
  }

  update(id: number, data: Campagne): Observable<Campagne> {
    return this.http.put<Campagne>(`${this.apiUrl}/${id}`, data);
  }

  delete(id: number): Observable<void> {
    return this.http.delete<void>(`${this.apiUrl}/${id}`);
  }
}
