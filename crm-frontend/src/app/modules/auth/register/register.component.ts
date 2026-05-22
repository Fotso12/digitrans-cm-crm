import { Component } from '@angular/core';
import { Router, RouterLink } from '@angular/router';
import { FormsModule } from '@angular/forms';
import { NgIf } from '@angular/common';
import { AuthService } from '../../../core/auth/auth.service';

@Component({
  selector: 'app-register',
  imports: [FormsModule, RouterLink, NgIf],
  templateUrl: './register.component.html',
  styleUrl: './register.component.scss'
})
export class RegisterComponent {
  nom = '';
  prenom = '';
  email = '';
  motDePasse = '';
  role = 'ROLE_USER';
  errorMessage = '';

  constructor(private authService: AuthService, private router: Router) {}

  register(): void {
    this.authService.register({
      nom: this.nom,
      prenom: this.prenom,
      email: this.email,
      motDePasse: this.motDePasse,
      role: this.role
    }).subscribe({
      next: () => {
        this.router.navigate(['/dashboard']);
      },
      error: (err) => {
        this.errorMessage = err.error?.message || "Une erreur est survenue lors de l'inscription.";
      }
    });
  }
}
