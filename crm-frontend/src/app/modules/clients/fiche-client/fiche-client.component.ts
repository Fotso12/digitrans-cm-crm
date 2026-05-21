import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, RouterLink } from '@angular/router';
import { CommonModule } from '@angular/common';
import { ClientService } from '../../../services/client.service';
import { Client } from '../../../core/models/client.model';

@Component({
  selector: 'app-fiche-client',
  imports: [RouterLink, CommonModule],
  templateUrl: './fiche-client.component.html',
  styleUrl: './fiche-client.component.scss'
})
export class FicheClientComponent implements OnInit {
  client: Client | null = null;

  constructor(
    private route: ActivatedRoute,
    private clientService: ClientService
  ) {}

  ngOnInit(): void {
    const id = Number(this.route.snapshot.paramMap.get('id'));
    this.clientService.getById(id).subscribe(data => this.client = data);
  }
}
