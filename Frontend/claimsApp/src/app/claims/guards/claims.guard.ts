import { Injectable } from '@angular/core';
import {
  ActivatedRouteSnapshot,
  CanActivate,
  Router,
  RouterStateSnapshot,
  UrlTree,
} from '@angular/router';
import { Observable } from 'rxjs';
import { AuthService } from '../../auth/auth.service';
import { ClaimsService } from '../claims.service';

@Injectable({
  providedIn: 'root',
})
export class ClaimsGuard implements CanActivate {
  username: string | undefined;
  constructor(
    private claimsService: ClaimsService,
    private router: Router,
    private authService: AuthService
  ) {
    this.authService.user.subscribe((user) => {
      this.username = user?.username;
    });
  }

  canActivate(
    route: ActivatedRouteSnapshot,
    router: RouterStateSnapshot
  ): boolean | Promise<boolean | UrlTree> | Observable<boolean | UrlTree> {
    if (
      this.claimsService.billResponse ||
      this.claimsService.claimStatusResponse
    ) {
      return true;
    }

    return this.router.navigate([this.username, 'viewClaims']);
  }
}
