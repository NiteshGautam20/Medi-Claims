import { Injectable } from '@angular/core';
import { CanDeactivate } from '@angular/router';

export interface CanComponentLeave {
  canLeave: () => boolean;
}

@Injectable({
  providedIn: 'root',
})
export class UnsavedChangesGuard implements CanDeactivate<CanComponentLeave> {
  canDeactivate(component: CanComponentLeave): boolean {
    if (component.canLeave) {
      return component.canLeave();
    }

    return true;
  }
}
