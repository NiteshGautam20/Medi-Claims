import { Component, OnInit } from '@angular/core';
import { ClaimsService } from '../claims.service';

interface BillsReponse {
  LastPaidDate: string;
  PremiumAmountDue: string;
  DueDate: string;
}

@Component({
  selector: 'app-claims-result',
  templateUrl: './claims-result.component.html',
  styleUrls: ['./claims-result.component.css'],
})
export class ClaimsResultComponent implements OnInit {
  dueAmount: number | null = null;
  dueDate: string = '';
  lastPaidDate: string = '';
  lateCharge: number | null = null;
  memberId: number | null = null;
  policyId: number | null = null;
  claimId: string = '';
  claimStatus: string = '';
  claimDescription: string = '';
  isBillMode: boolean = false;

  constructor(private claimsService: ClaimsService) {}

  ngOnInit() {
    if (this.claimsService.billResponse) {
      this.dueAmount = this.claimsService.billResponse.dueAmount;
      this.dueDate = this.claimsService.billResponse.dueDate;
      this.lastPaidDate = this.claimsService.billResponse.lastPaidDate;
      this.lateCharge = this.claimsService.billResponse.lateCharge;
      this.isBillMode = true;
    } else if (this.claimsService.claimStatusResponse) {
      this.claimStatus = this.claimsService.claimStatusResponse.claimStatus;
      this.claimDescription =
        this.claimsService.claimStatusResponse.claimDescription;
      this.isBillMode = false;
      this.claimId = this.claimsService.claimStatusResponse.claimId;
    }
  }
}
