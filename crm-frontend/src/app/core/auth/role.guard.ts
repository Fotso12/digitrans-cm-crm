import { inject } from '@angular/core';
import { Router, type CanActivateFn } from '@angular/router';
import { AuthService } from './auth.service';

export const roleGuard = (allowedRoles: string[]): CanActivateFn => {
  return () => {
    const authService = inject(AuthService);
    const router = inject(Router);

    const token = authService.getToken();
    if (!token) {
      return router.parseUrl('/auth/login');
    }

    const payload = JSON.parse(atob(token.split('.')[1]));
    const userRole = payload.role || payload.authorities?.[0]?.authority;

    if (allowedRoles.includes(userRole)) {
      return true;
    }

    return router.parseUrl('/dashboard');
  };
};
