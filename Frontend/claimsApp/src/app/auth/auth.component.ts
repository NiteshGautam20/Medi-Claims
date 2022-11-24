import { Component, OnDestroy, OnInit } from '@angular/core';
import { NgForm } from '@angular/forms';
import { Router } from '@angular/router';
import { Subscription } from 'rxjs';
import { AuthService } from './auth.service';

@Component({
  selector: 'app-auth',
  templateUrl: './auth.component.html',
  styleUrls: ['./auth.component.css'],
})
export class AuthComponent implements OnInit, OnDestroy {
  isValidating: boolean = false;
  isLoading: boolean = false;
  error = null;
  userSubscription: Subscription = new Subscription();

  constructor(private authService: AuthService, private router: Router) {}

  ngOnInit() {
    this.userSubscription = this.authService.user.subscribe((user) => {
      if (user) {
        this.router.navigate(['./home']);
      }
    });
  }

  ngOnDestroy() {
    this.userSubscription.unsubscribe();
  }

  login(username: string, password: string) {
    this.isValidating = true;

    this.authService.login({ username, password }).subscribe(
      (response) => {
        this.isValidating = false;
        this.error = null;
        this.router.navigate(['./home']);
      },
      (errorMessage) => {
        this.isValidating = false;
        this.error = errorMessage;
      }
    );
  }

  onSubmit(form: NgForm) {
    const username = form.value.username;
    const password = form.value.password;

    this.login(username, password);

    form.reset();
  }

  handleError() {
    this.error = null;
  }
}
