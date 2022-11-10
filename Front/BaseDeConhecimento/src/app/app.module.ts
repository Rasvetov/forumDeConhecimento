import { NgModule } from '@angular/core';
import { MatFormFieldModule } from '@angular/material/form-field';
import { MatInputModule } from '@angular/material/input';
import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { MatAutocompleteModule } from '@angular/material/autocomplete';
import { BrowserModule } from '@angular/platform-browser';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations'
import { HomeComponent } from './views/home/home.component';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { MatToolbarModule } from '@angular/material/toolbar';
import { SearchListComponent } from './views/home/Topic/search-list.component';
import { MatCardModule } from '@angular/material/card';
import { MatDividerModule } from '@angular/material/divider';
import { MatIconModule } from '@angular/material/icon';
import { MatTabsModule } from '@angular/material/tabs';
import { LocalDateTimePipe } from './shared/pipe/local-date-time.pipe';
import { MatButtonModule } from '@angular/material/button';
import { MatDialogContent, MatDialogModule } from '@angular/material/dialog';
import { ContentFormDialogComponent } from './views/home/content-form-dialog/content-form-dialog.component';
import { MatNativeDateModule } from '@angular/material/core';
import { MatDatepickerModule } from '@angular/material/datepicker';
import { HttpClientModule } from '@angular/common/http';
import { MatTableModule } from '@angular/material/table';
import { MatSelectModule } from '@angular/material/select';
import { TextFieldModule } from '@angular/cdk/text-field';
import { ContentDialogComponent } from './views/content-dialog/content-dialog.component';
import { SearchFilterPipe } from './shared/pipe/search-filter.pipe';
import {MatSlideToggleModule} from '@angular/material/slide-toggle';
import {MatCheckboxModule} from '@angular/material/checkbox';




@NgModule({
  declarations: [
    AppComponent,
    HomeComponent,
    SearchListComponent,
    LocalDateTimePipe,
    ContentFormDialogComponent,
    ContentDialogComponent,
    SearchFilterPipe
  ],
  entryComponents: [
    ContentFormDialogComponent,
    MatDialogContent
  ],
  imports: [
    MatCheckboxModule,
    MatSlideToggleModule,
    MatButtonModule,
    TextFieldModule,
    MatSelectModule,
    MatTableModule,
    HttpClientModule,
    MatDatepickerModule,
    MatDialogModule,
    MatButtonModule,
    MatTabsModule,
    MatIconModule,
    BrowserModule,
    BrowserAnimationsModule,
    AppRoutingModule,
    MatAutocompleteModule,
    MatFormFieldModule,
    MatInputModule,
    FormsModule,
    ReactiveFormsModule,
    MatToolbarModule,
    MatCardModule,
    MatDividerModule,
    MatInputModule,
    MatNativeDateModule,
    FormsModule,
    ReactiveFormsModule,
  ],
  providers: [
    LocalDateTimePipe
  ],
  bootstrap: [AppComponent],
  exports: [
    AppComponent,
    ContentDialogComponent,
  ]
})
export class AppModule { }
