import { CorrentistasService } from '../../services/correntistas.service';
import { Component, OnInit } from '@angular/core';
import { MovimentacaoService } from '../../services/movimentacao.service';

@Component({
  selector: 'app-movimentacao-new',
  templateUrl: './movimentacao-new.component.html',
  styleUrls: ['./movimentacao-new.component.css']
})
export class MovimentacaoNewComponent implements OnInit {

  correntistas: any;
  correntista: any;

  data:any;
  hora:any;
  descricao:any;
  valor:any;
  tipo:any;

  constructor(
    private movimentacaoService: MovimentacaoService,
    private CorrentistasService: CorrentistasService,
  ) {}

  ngOnInit(): void {
      this.exibirCorrentistas();
  }
  exibirCorrentistas(): void {
    this.CorrentistasService.list()
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
    console.log(this.correntista)
    const movimentacao = {
      valor:this.valor,
      descricao:this.descricao,
      tipo:this.tipo,
      idConta:this.correntista.id,
      data:this.data,
      hora:this.hora
    };
    console.log(movimentacao);
    this.movimentacaoService.create(movimentacao)
    .subscribe(
      response => {
        console.log(response);
      },
      error => {
        console.log(error);
      });
  }

}
