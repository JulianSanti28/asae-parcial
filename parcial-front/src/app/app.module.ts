import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { AppComponent } from './app.component';
import { FooterComponent } from './footer/footer.component';
import { HeaderComponent } from './header/header.component';
import { StudentComponent } from './student/list/student.component';
import { RouterModule, Routes } from '@angular/router';
import { FormsModule } from '@angular/forms';
import { CreateComponent } from './student/create/create.component';
import { HttpClientModule } from '@angular/common/http';
import {ReactiveFormsModule} from '@angular/forms';
import { UpdateComponent } from './student/update/update.component';
import { CourseComponent } from './course/course.component';
import {MatIconModule} from '@angular/material/icon';
import { FormComponent } from './course/form/form.component';
import {MatSelectModule} from '@angular/material/select';





const routes: Routes = [
  { path: '', redirectTo: '/students', pathMatch: 'full' },
  { path: 'students/form', component: CreateComponent },
  { path: 'students', component: StudentComponent },
  { path: 'students/details', component: UpdateComponent },
  { path: 'course', component: CourseComponent },
  { path: 'course/form', component: FormComponent },

];

@NgModule({
  declarations: [
    AppComponent,
    FooterComponent,
    HeaderComponent,
    StudentComponent,
    CreateComponent,
    UpdateComponent,
    CourseComponent,
    FormComponent,
  ],
  imports: [
    BrowserModule,
    RouterModule.forRoot(routes),
    HttpClientModule,
    FormsModule,
    ReactiveFormsModule,
    MatIconModule,
    MatSelectModule,

  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
