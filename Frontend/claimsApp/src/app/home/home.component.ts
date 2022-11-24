import { Component } from '@angular/core';

@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.css'],
})
export class HomeComponent {
  onScrollTo(element: HTMLElement) {
    const elementPosition = element.getBoundingClientRect().top;
    const offsetPosition = elementPosition - 45;
    window.scrollTo({
      top: offsetPosition,
      behavior: 'smooth',
    });
  }
}
