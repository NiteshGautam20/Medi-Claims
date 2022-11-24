import { Component, OnDestroy, OnInit } from '@angular/core';
import { Subscription } from 'rxjs';
import { AuthService } from '../auth/auth.service';

@Component({
  selector: 'app-header',
  templateUrl: './header.component.html',
  styleUrls: ['./header.component.css'],
})
export class HeaderComponent implements OnInit, OnDestroy {
  username: string = '';
  isAuthenticated: boolean = false;
  authSubscription: Subscription = new Subscription();
  constructor(private authService: AuthService) {}

  ngOnInit() {
    this.authSubscription = this.authService.user.subscribe((user) => {
      this.isAuthenticated = user ? true : false;
      this.username = user ? user.username : '';
    });
  }

  ngOnDestroy() {
    this.authSubscription.unsubscribe();
  }

  onLogout() {
    this.authService.logout();
  }
}
