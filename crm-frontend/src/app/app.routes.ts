import { Routes } from '@angular/router';
import { authGuard } from './core/auth/auth.guard';
import { LoginComponent } from './modules/auth/login/login.component';
import { DashboardComponent } from './modules/dashboard/dashboard.component';
import { ListeClientsComponent } from './modules/clients/liste-clients/liste-clients.component';
import { FicheClientComponent } from './modules/clients/fiche-client/fiche-client.component';
import { FormClientComponent } from './modules/clients/form-client/form-client.component';
import { ListeCommandesComponent } from './modules/commandes/liste-commandes/liste-commandes.component';
import { FormCommandeComponent } from './modules/commandes/form-commande/form-commande.component';
import { ListeReclamationsComponent } from './modules/reclamations/liste-reclamations/liste-reclamations.component';
import { FormReclamationComponent } from './modules/reclamations/form-reclamation/form-reclamation.component';
import { ListeCampagnesComponent } from './modules/campagnes/liste-campagnes/liste-campagnes.component';
import { FormCampagneComponent } from './modules/campagnes/form-campagne/form-campagne.component';
import { ListeProduitsComponent } from './modules/produits/liste-produits/liste-produits.component';
import { FormProduitComponent } from './modules/produits/form-produit/form-produit.component';
import { ListeUtilisateursComponent } from './modules/utilisateurs/liste-utilisateurs/liste-utilisateurs.component';
import { FormUtilisateurComponent } from './modules/utilisateurs/form-utilisateur/form-utilisateur.component';
import { ListeRestaurantsComponent } from './modules/restaurants/liste-restaurants/liste-restaurants.component';
import { FormRestaurantComponent } from './modules/restaurants/form-restaurant/form-restaurant.component';

export const routes: Routes = [
  { path: 'auth/login', component: LoginComponent },
  { path: 'dashboard', component: DashboardComponent, canActivate: [authGuard] },
  { path: 'clients', component: ListeClientsComponent, canActivate: [authGuard] },
  { path: 'clients/nouveau', component: FormClientComponent, canActivate: [authGuard] },
  { path: 'clients/:id', component: FicheClientComponent, canActivate: [authGuard] },
  { path: 'clients/:id/edit', component: FormClientComponent, canActivate: [authGuard] },
  { path: 'commandes', component: ListeCommandesComponent, canActivate: [authGuard] },
  { path: 'commandes/nouveau', component: FormCommandeComponent, canActivate: [authGuard] },
  { path: 'commandes/:id/edit', component: FormCommandeComponent, canActivate: [authGuard] },
  { path: 'reclamations', component: ListeReclamationsComponent, canActivate: [authGuard] },
  { path: 'reclamations/nouveau', component: FormReclamationComponent, canActivate: [authGuard] },
  { path: 'reclamations/:id/edit', component: FormReclamationComponent, canActivate: [authGuard] },
  { path: 'campagnes', component: ListeCampagnesComponent, canActivate: [authGuard] },
  { path: 'campagnes/nouveau', component: FormCampagneComponent, canActivate: [authGuard] },
  { path: 'campagnes/:id/edit', component: FormCampagneComponent, canActivate: [authGuard] },
  { path: 'produits', component: ListeProduitsComponent, canActivate: [authGuard] },
  { path: 'produits/nouveau', component: FormProduitComponent, canActivate: [authGuard] },
  { path: 'produits/:id/edit', component: FormProduitComponent, canActivate: [authGuard] },
  { path: 'utilisateurs', component: ListeUtilisateursComponent, canActivate: [authGuard] },
  { path: 'utilisateurs/nouveau', component: FormUtilisateurComponent, canActivate: [authGuard] },
  { path: 'utilisateurs/:id/edit', component: FormUtilisateurComponent, canActivate: [authGuard] },
  { path: 'restaurants', component: ListeRestaurantsComponent, canActivate: [authGuard] },
  { path: 'restaurants/nouveau', component: FormRestaurantComponent, canActivate: [authGuard] },
  { path: 'restaurants/:id/edit', component: FormRestaurantComponent, canActivate: [authGuard] },
  { path: '', redirectTo: '/dashboard', pathMatch: 'full' },
  { path: '**', redirectTo: '/dashboard' }
];
