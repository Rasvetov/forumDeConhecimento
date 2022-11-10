import { Component, OnInit } from '@angular/core';
import {MatDialog} from '@angular/material/dialog';
import { ContentFormDialogComponent } from './content-form-dialog/content-form-dialog.component';
import { TopicDTO } from 'src/app/shared/model/TopicDTO';

@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.css']
})
export class HomeComponent implements OnInit {
  
  constructor(public dialog: MatDialog) { }
  ngOnInit(): void {
  }

  openDialog(): void {
    const dialogRef = this.dialog.open(ContentFormDialogComponent, {
      minWidth: '400px',
    });

    dialogRef.disableClose = true;

  }

  
  
}


