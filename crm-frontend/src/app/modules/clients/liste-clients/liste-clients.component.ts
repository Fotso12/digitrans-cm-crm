import { Component, OnInit } from '@angular/core';
import { RouterLink } from '@angular/router';
import { CommonModule } from '@angular/common';
import { ClientService } from '../../../services/client.service';
import { Client } from '../../../core/models/client.model';

@Component({
  selector: 'app-liste-clients',
  imports: [RouterLink, CommonModule],
  templateUrl: './liste-clients.component.html',
  styleUrl: './liste-clients.component.scss'
})
export class ListeClientsComponent implements OnInit {
  clients: Client[] = [];

  constructor(private clientService: ClientService) {}

  ngOnInit(): void {
    this.clientService.getAll().subscribe(data => this.clients = data);
  }

  delete(id: number): void {
    if (confirm('Supprimer ce client ?')) {
      this.clientService.delete(id).subscribe(() => {
        this.clients = this.clients.filter(c => c.id !== id);
      });
    }
  }
}
