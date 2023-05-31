import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { environment } from 'src/environments/environment';

const url4=environment.basePath+"dump/";
@Injectable({
  providedIn: 'root'
})
export class MapService {
  constructor(private http: HttpClient) { }
  getDump(){
    return this.http.get<any[]>(`${url4}`);
  }
  newDump(data:any){
    return this.http.post(`${url4}`,data);
  }
  updateDump(id:any,data:any){
    return this.http.put(`${url4}/${id}`,data);
  }
  deleteDump(id:any){
    return this.http.delete(`${url4}/${id}`);
  }
}
