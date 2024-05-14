import { Component } from '@angular/core';
import {
  FormBuilder,
  FormGroup,
  FormsModule,
  ReactiveFormsModule,
  Validators,
} from '@angular/forms';
import {
  HttpClient,
  HttpClientModule,
  HttpHeaders,
} from '@angular/common/http';
import { RouterOutlet } from '@angular/router';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.scss'],
  imports: [RouterOutlet, FormsModule, ReactiveFormsModule, HttpClientModule],
  standalone: true,
})
export class AppComponent {
  userForm: FormGroup;

  constructor(private fb: FormBuilder, private http: HttpClient) {
    this.userForm = this.fb.group({
      fname: ['', Validators.required],
      lname: ['', Validators.required],
      pid: ['', Validators.required],
      address: ['', Validators.required],
      nationality: ['', Validators.required],
      language: ['', Validators.required],
    });
  }

  onSubmit() {
    if (this.userForm.valid) {
      const userData = this.userForm.value;
      this.http.post('http://localhost:8080/submitInfo', userData).subscribe(
        (response) => {
          console.log('Data sent successfully:', response);
        },
        (error) => {
          console.error('Error occurred while sending data:', error);
        }
      );
    } else {
      console.error('Form is invalid. Please fill in all the required fields.');
    }
  }

}
