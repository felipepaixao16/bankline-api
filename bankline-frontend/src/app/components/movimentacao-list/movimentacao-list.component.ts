import { MovimentacaoService } from './../../services/movimentacao.service';
import { CorrentistasService } from '../../services/correntistas.service';
import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-movimentacao-list',
  templateUrl: './movimentacao-list.component.html',
  styleUrls: ['./movimentacao-list.component.css']
})

export class MovimentacaoListComponent implements OnInit {
  movimentacoes:any;
  correntistas:any;
  correntista:any={};

  constructor (
    private movimentacaoService: MovimentacaoService,
    private correntistasService: CorrentistasService,
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
  

  listMovimentacoes(): void {
    this.movimentacaoService.findByIdConta(this.correntista.id)
    .subscribe(data => {this.movimentacoes = data;
    console.log(data);
  }, 
  error => {
    console.log(error);    
  });
  }
}
