import { Component, OnInit } from '@angular/core';
import {FormBuilder, FormGroup, Validators} from "@angular/forms";

@Component({
  selector: 'app-angular-login',
  templateUrl: './angular-login.component.html',
  styleUrls: ['./angular-login.component.css']
})
export class AngularLoginComponent implements OnInit {
loginForm: FormGroup;
  constructor(private formBuilder:FormBuilder) {
    this.loginForm = formBuilder.group(
      {
        email: ['',[Validators.email,Validators.required]],
        password: ['',[Validators.minLength(6),Validators.required]]
      }
    )
  }

  ngOnInit(): void {
  }

}
