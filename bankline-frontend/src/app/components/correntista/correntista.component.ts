import { CorrentistasService } from './../../services/correntistas.service';
import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-correntista',
  templateUrl: './correntista.component.html',
  styleUrls: ['./correntista.component.css']
})
export class CorrentistaComponent implements OnInit {

  cpf:any;
  nome:any;
  correntistas:any;

  constructor(
    private correntistasService: CorrentistasService
  ){ }

  ngOnInit(): void {
      this.exibirCorrentistas();
  }

  exibirCorrentistas(): void {
    this.correntistasService.list()
    .subscribe(
      data => {
        this.correntistas = data;
        console.log(data);
      },
      error => {
        console.log(error);
      });
  }

  save(): void {
    const correntista = {
      cpf:this.cpf,
      nome:this.nome
    };
    console.log(correntista);
    this.correntistasService.create(correntista)
    .subscribe(
      response => {
        console.log(response);
        this.exibirCorrentistas();
      },
      error => {
        console.log(error);
      });
  }

}
