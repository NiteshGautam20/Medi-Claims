import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { AuthComponent } from './auth/auth.component';
import { AuthGuard } from './auth/auth.guard';
import { ClaimsFormComponent } from './claims/claims-form/claims-form.component';
import { ClaimsResultComponent } from './claims/claims-result/claims-result.component';
import { UnsavedChangesGuard } from './claims/guards/claims.candeactivate-guard';
import { ClaimsComponent } from './claims/claims.component';
import { SubmitClaimFormComponent } from './claims/submit-claim-form/submit-claim-form.component';
import { HomeComponent } from './home/home.component';
import { ClaimsGuard } from './claims/guards/claims.guard';

const routes: Routes = [
  { path: '', pathMatch: 'full', redirectTo: 'home' },
  { path: 'home', component: HomeComponent },
  { path: 'auth', component: AuthComponent },
  {
    path: ':username',
    component: ClaimsComponent,
    canActivate: [AuthGuard],
    children: [
      {
        path: 'viewClaims',
        component: ClaimsFormComponent,
        data: { mode: 'billMode' },
      },
      {
        path: 'viewClaims/result',
        component: ClaimsResultComponent,
        canActivate: [ClaimsGuard],
      },
      {
        path: 'getClaimStatus',
        component: ClaimsFormComponent,
        data: { mode: 'claimStatusMode' },
      },
      {
        path: 'getClaimStatus/result',
        component: ClaimsResultComponent,
        canActivate: [ClaimsGuard],
      },
      {
        path: 'submitClaim',
        component: SubmitClaimFormComponent,
        canDeactivate: [UnsavedChangesGuard],
      },
      {
        path: 'submitClaim/result',
        component: ClaimsResultComponent,
        canActivate: [ClaimsGuard],
      },
    ],
  },
];
@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule],
})
export class AppRoutingModule {}
