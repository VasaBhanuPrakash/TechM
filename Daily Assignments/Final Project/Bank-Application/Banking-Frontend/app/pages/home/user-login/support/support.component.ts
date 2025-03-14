import { Component } from '@angular/core';
import { SupportService } from 'src/app/services/support.service';

@Component({
  selector: 'app-support',
  templateUrl: './support.component.html',
  styleUrls: ['./support.component.css']
})
export class SupportComponent {
  query = { subject: '', message: '' };

  constructor(private supportService: SupportService) {}

  submitQuery() {
    this.supportService.submitQuery('userId', this.query.subject, this.query.message).subscribe({
      next: (response) => {
        console.log('Query Sent:', response);
      },
      error: (err) => {
        console.log('Error sending query');
      }
    });
  }
}
