import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router, RouterLink } from '@angular/router';
import { FormsModule } from '@angular/forms';
import { RestaurantService } from '../../../services/restaurant.service';
import { Restaurant } from '../../../core/models/restaurant.model';

@Component({
  selector: 'app-form-restaurant',
  imports: [FormsModule, RouterLink],
  templateUrl: './form-restaurant.component.html',
  styleUrl: './form-restaurant.component.scss'
})
export class FormRestaurantComponent implements OnInit {
  restaurant: Restaurant = {
    nom: '', ville: '', actif: true
  };
  isEdit = false;

  constructor(
    private restaurantService: RestaurantService,
    private router: Router,
    private route: ActivatedRoute
  ) {}

  ngOnInit(): void {
    const id = this.route.snapshot.paramMap.get('id');
    if (id) {
      this.isEdit = true;
      this.restaurantService.getById(Number(id)).subscribe(data => this.restaurant = data);
    }
  }

  save(): void {
    if (this.isEdit) {
      this.restaurantService.update(this.restaurant.id!, this.restaurant).subscribe(() =>
        this.router.navigate(['/restaurants'])
      );
    } else {
      this.restaurantService.create(this.restaurant).subscribe(() =>
        this.router.navigate(['/restaurants'])
      );
    }
  }
}
