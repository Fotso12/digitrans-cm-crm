import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { environment } from '../../environments/environment';
import { Reclamation } from '../core/models/reclamation.model';

@Injectable({ providedIn: 'root' })
export class ReclamationService {
  private apiUrl = `${environment.apiUrl}/reclamations`;

  constructor(private http: HttpClient) {}

  getAll(): Observable<Reclamation[]> {
    return this.http.get<Reclamation[]>(this.apiUrl);
  }

  getById(id: number): Observable<Reclamation> {
    return this.http.get<Reclamation>(`${this.apiUrl}/${id}`);
  }

  create(data: Reclamation): Observable<Reclamation> {
    return this.http.post<Reclamation>(this.apiUrl, data);
  }

  update(id: number, data: Reclamation): Observable<Reclamation> {
    return this.http.put<Reclamation>(`${this.apiUrl}/${id}`, data);
  }

  delete(id: number): Observable<void> {
    return this.http.delete<void>(`${this.apiUrl}/${id}`);
  }
}
