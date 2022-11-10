import { CdkTextareaAutosize } from '@angular/cdk/text-field';
import { Component, NgZone, OnInit, ViewChild, Inject } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { MatDialogRef, MAT_DIALOG_DATA } from '@angular/material/dialog';
import { MatSlideToggleChange } from '@angular/material/slide-toggle';
import * as moment from 'moment';
import { Categoria } from 'src/app/shared/model/Categoria';
import { TopicDTO } from 'src/app/shared/model/TopicDTO';
import { CatService } from 'src/app/shared/service/CatService';
import { TopicService } from 'src/app/shared/service/TopicService';

@Component({
  selector: 'app-content-form-dialog',
  templateUrl: './content-form-dialog.component.html',
  styleUrls: ['./content-form-dialog.component.css']
})
export class ContentFormDialogComponent implements OnInit {
  public topicForm: FormGroup;
  topicoRegister: TopicDTO;
  listCategoria: Categoria[];

  constructor(
    private fb: FormBuilder,
    private rest: TopicService,
    private categoriaService: CatService,
    public dialogRef: MatDialogRef<ContentFormDialogComponent>,
    private _ngZone: NgZone,
    @Inject(MAT_DIALOG_DATA) public id: any
  ) {

    this.topicForm = this.fb.group({
      id: [],
      titulo: ['', [Validators.required]],
      data: ['', [Validators.required]],
      status: [''],
      categoria: ['', [Validators.required]],
      conteudo: ['', [Validators.required]]
    });
  }

  @ViewChild('autosize') autosize: CdkTextareaAutosize;

  ngOnInit() {
    if (this.id !== null) { this.changes(this.id); }


    this.topicoRegister = new TopicDTO();
          this.categoriaS();

  }

  ngOnChanges() {


  }

  changes(id: any) {

    this.rest.getById(id).subscribe(data => {
      this.topicoRegister = data;
      this.atualizaFormulario();
    });


  }

  categoriaS() {
    this.categoriaService.getAll().subscribe(cat => {
      this.listCategoria = cat;
    })
  }

  CreateForm() {
    this.setValue();

    this.rest.postForm(this.topicoRegister).subscribe(result => {
      this.dialogRef.close();
      this.topicForm.reset();
      window.location.reload();
    });

    if(this.id!=null){
      this.rest.topicUpdate(this.topicoRegister).subscribe(result =>{
        this.dialogRef.close();
        this.topicForm.reset();
        window.location.reload();
      })
    }

  }


  setValue() {
    let newDate: moment.Moment = moment.utc(this.topicForm.value.data).local();
    this.topicForm.value.data = newDate.format("YYYY-MM-DD");
    this.topicoRegister.titulo = this.topicForm.get('titulo')?.value;
    if(this.id!=null){
    this.topicoRegister.status = this.topicForm.get('status')?.value;
    }else{
    this.topicoRegister.status = true;
    }
    this.topicoRegister.data = this.topicForm.get('data')?.value;
    this.topicoRegister.categoria = this.topicForm.get('categoria')?.value;
    this.topicoRegister.conteudo = this.topicForm.get('conteudo')?.value;
    console.log(this.topicForm)
  }

  atualizaFormulario() {
    this.topicForm.setValue({
      id: this.topicoRegister.id,
      titulo: this.topicoRegister.titulo,
      status: this.topicoRegister.status,
      data: this.topicoRegister.data,
      categoria: this.topicoRegister.categoria,
      conteudo: this.topicoRegister.conteudo
    })
  }

  Cancelar(): void {
    this.dialogRef.close();
    this.topicForm.reset();
  }


}
