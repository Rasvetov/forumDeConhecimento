import { Component, OnInit,} from '@angular/core';
import { MatDialog } from '@angular/material/dialog';
import { _TooltipComponentBase } from '@angular/material/tooltip';
import { TopicDTO } from 'src/app/shared/model/TopicDTO';
import { TopicService } from 'src/app/shared/service/TopicService';
import { ContentDialogComponent } from '../../content-dialog/content-dialog.component';
import { ContentFormDialogComponent } from '../content-form-dialog/content-form-dialog.component';




@Component({
  selector: 'app-search-list',
  templateUrl: './search-list.component.html',
  styleUrls: ['./search-list.component.css']
})

export class SearchListComponent implements OnInit {
  status: Boolean;
  content: TopicDTO;
  topicos : ContentFormDialogComponent;
  listTopics: TopicDTO[] = [];
  listaFiltrada: TopicDTO[] = [];
  displayedColumns = ['titulo','categoria','data','view','edit'];
  searchText: string;

  constructor(
    private topicService: TopicService,
    public dialog: MatDialog,
  ) { }

  ngOnInit() {
    this.listTopics = [];
    this.getAllTopics();
  }

getAllTopics(){
  this.topicService.getAll().subscribe(
    data => {
      this.listTopics = data;
    }
    
  );
}

view(topico:any) {
  
  const dialogRef = this.dialog.open(ContentDialogComponent,{data:{topico:topico}});

  dialogRef.disableClose = true;
}

edit(id:string=''){
  const dialogRef = this.dialog.open(ContentFormDialogComponent,{data: id})

  dialogRef.disableClose = true
}

value:string

search(e:Event): void{

  const target = e.target as HTMLInputElement
  this.value = target.value
  
}

checkBox(){
  if(this.status == false){
    let topico = TopicDTO.of(this.status);
    this.topicService.getByStatus(topico).subscribe(data => {
      this.listTopics = data;
    });
  }else{
    this.getAllTopics();
  }
}

}








