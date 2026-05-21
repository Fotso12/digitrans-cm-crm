import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router, RouterLink } from '@angular/router';
import { FormsModule } from '@angular/forms';
import { UtilisateurService } from '../../../services/utilisateur.service';
import { Utilisateur } from '../../../core/models/utilisateur.model';

@Component({
  selector: 'app-form-utilisateur',
  imports: [FormsModule, RouterLink],
  templateUrl: './form-utilisateur.component.html',
  styleUrl: './form-utilisateur.component.scss'
})
export class FormUtilisateurComponent implements OnInit {
  utilisateur: Utilisateur = {
    nom: '', prenom: '', email: '', motDePasse: '',
    role: 'ROLE_USER', actif: true
  };
  isEdit = false;

  constructor(
    private utilisateurService: UtilisateurService,
    private router: Router,
    private route: ActivatedRoute
  ) {}

  ngOnInit(): void {
    const id = this.route.snapshot.paramMap.get('id');
    if (id) {
      this.isEdit = true;
      this.utilisateurService.getById(Number(id)).subscribe(data => this.utilisateur = data);
    }
  }

  save(): void {
    if (this.isEdit) {
      this.utilisateurService.update(this.utilisateur.id!, this.utilisateur).subscribe(() =>
        this.router.navigate(['/utilisateurs'])
      );
    } else {
      this.utilisateurService.create(this.utilisateur).subscribe(() =>
        this.router.navigate(['/utilisateurs'])
      );
    }
  }
}
