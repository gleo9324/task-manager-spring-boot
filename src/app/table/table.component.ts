import { Component, OnInit } from '@angular/core';
import {MatTableModule} from '@angular/material/table';
import { DbconnectionService } from '../dbconnection.service';
import { DataSource } from '@angular/cdk/collections';

export interface PeriodicElement {
  titolo: string;
  id: number;
  descrizione: string;
}

/**
 * @title Basic use of `<table mat-table>`
 */
@Component({
  selector: 'app-table',
  templateUrl: './table.component.html',
  styleUrls: ['./table.component.css']
})
export class TableComponent implements OnInit {
data: PeriodicElement[]= [{id: 1, titolo: '', descrizione: ''}];

  constructor(private dbService: DbconnectionService){}
  
  displayedColumns: string[] = ['id', 'titolo', 'descrizione'];
  ngOnInit(): void {
    this.dbService.getDati().subscribe((data:any) =>{
      // console.log(data);
      const keys = Object.keys(data);
      const nestedObj = data[keys[0]];
      const innerKeys = Object.keys(nestedObj);
      this.data[0].id = nestedObj[innerKeys[0]]
      this.data[0].titolo = nestedObj[innerKeys[1]]
      this.data[0].descrizione = nestedObj[innerKeys[2]]
      });
  }

  
}
