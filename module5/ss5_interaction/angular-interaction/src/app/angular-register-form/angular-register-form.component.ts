import {Component, OnInit} from '@angular/core';
import {AbstractControl, FormBuilder, FormControl, ReactiveFormsModule, Validators} from "@angular/forms";
import {FormGroup} from "@angular/forms";

@Component({
  selector: 'app-angular-register-form',
  templateUrl: './angular-register-form.component.html',
  styleUrls: ['./angular-register-form.component.css']
})
export class AngularRegisterFormComponent implements OnInit {
  registerForm: FormGroup;

  constructor(private formBuilder: FormBuilder) {
    this.registerForm = formBuilder.group(
      {
        email:['', [Validators.required, Validators.email]],
        passwordGroup:this.formBuilder.group(
          {
            password: ['', [Validators.minLength(6), Validators.required]],
            confirmPassword:['',Validators.required]
          },
          {
            validator: this.comparePassword
          }
        ),
        country:[''],
        age:['',[Validators.min(19),Validators.required]],
        gender:['',Validators.required],
        phone: ['',[Validators.pattern(/^\+84\d{9,10}/),Validators.required]]
      }
    )
  }

  ngOnInit(): void {
  }
  comparePassword(c: AbstractControl) {
    const v = c.value;
    return (v.password === v.confirmPassword) ? null : {password_not_match: true}
  }

  receiveForm(){
    console.log(
      this.registerForm
    ) ;
  }
  protected readonly Validators = Validators;
}
