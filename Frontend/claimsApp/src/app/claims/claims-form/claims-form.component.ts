import { Component, OnInit } from '@angular/core';
import { NgForm } from '@angular/forms';
import { ActivatedRoute, Router } from '@angular/router';
import { ClaimsService } from '../claims.service';

@Component({
  selector: 'app-claims-form',
  templateUrl: './claims-form.component.html',
  styleUrls: ['./claims-form.component.css'],
})
export class ClaimsFormComponent implements OnInit {
  isValidating: boolean = false;
  isLoading: boolean = false;
  isClaimStatusMode: boolean = false;
  isBillMode: boolean = false;
  error: null | string = null;

  constructor(
    private claimsService: ClaimsService,
    private router: Router,
    private route: ActivatedRoute
  ) {}

  ngOnInit(): void {
    this.route.data.subscribe((data) => {
      if (data) {
        if (data['mode'] === 'claimStatusMode') {
          this.isClaimStatusMode = true;
          this.isBillMode = false;
        } else if (data['mode'] === 'billMode') {
          this.isBillMode = true;
          this.isClaimStatusMode = false;
        }
      }
    });
  }

  fetchBill(memberID: string) {
    this.isValidating = true;
    this.claimsService.viewBills({ memberID }).subscribe(
      (response) => {
        this.isValidating = false;
        this.error = null;
        this.router.navigate(['./result'], { relativeTo: this.route });
      },
      (errorMessage) => {
        this.isValidating = false;
        this.error = errorMessage;
        console.log(errorMessage);
      }
    );
  }

  fetchStatus(claimID: string) {
    this.isValidating = true;
    this.claimsService.viewStatus({ claimID }).subscribe(
      (response) => {
        this.isValidating = false;

        this.router.navigate(['./result'], { relativeTo: this.route });
      },
      (errorMessage) => {
        this.isValidating = false;
        this.error =
          'Invalid Details Provided. Please check your details again';
        console.log(errorMessage);
      }
    );
  }

  onSubmit(form: NgForm) {
    const memberID = form.value.memberID;

    if (this.isBillMode) {
      this.fetchBill(memberID);
    } else if (this.isClaimStatusMode) {
      this.fetchStatus(form.value.claimID);
    }

    form.reset();
  }

  handleError() {
    this.error = null;
  }
}
