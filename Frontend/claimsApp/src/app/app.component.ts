import { Component, OnInit } from '@angular/core';
import { AuthService } from './auth/auth.service';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
})
export class AppComponent implements OnInit {
  error: string | null = null;
  constructor(private authService: AuthService) {}

  ngOnInit() {
    this.authService.timeout.subscribe((isTimeOut) => {
      if (isTimeOut)
        this.error = 'Your session is expired. Please Login again!';
    });
    this.authService.autoLogin();
  }

  handleError() {
    this.error = null;
  }
}
