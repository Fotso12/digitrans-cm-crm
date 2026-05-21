import { Component, OnInit } from '@angular/core';
import { RouterLink } from '@angular/router';
import { CommonModule } from '@angular/common';
import { RestaurantService } from '../../../services/restaurant.service';
import { Restaurant } from '../../../core/models/restaurant.model';

@Component({
  selector: 'app-liste-restaurants',
  imports: [RouterLink, CommonModule],
  templateUrl: './liste-restaurants.component.html',
  styleUrl: './liste-restaurants.component.scss'
})
export class ListeRestaurantsComponent implements OnInit {
  restaurants: Restaurant[] = [];

  constructor(private restaurantService: RestaurantService) {}

  ngOnInit(): void {
    this.restaurantService.getAll().subscribe(data => this.restaurants = data);
  }

  delete(id: number): void {
    if (confirm('Supprimer ce restaurant ?')) {
      this.restaurantService.delete(id).subscribe(() => {
        this.restaurants = this.restaurants.filter(r => r.id !== id);
      });
    }
  }
}
