import { Component, OnDestroy,OnInit } from '@angular/core';
import {FormControl, FormGroup, Validators } from '@angular/forms';
import { MapService } from 'src/app/Services/map/map.service';


@Component({
  selector: 'app-addumps',
  templateUrl: './addumps.component.html',
  styleUrls: ['./addumps.component.css']
})
export class AddumpsComponent implements OnInit, OnDestroy{
  dumps:any[]=[];
  orgDumps:any[]=[];
  filterForm:FormGroup=new FormGroup({
    search:new FormControl("",[Validators.required])
  });
  dumpForm:FormGroup=new FormGroup({
    id:new FormControl("0",[Validators.required]),
    dumpName:new FormControl("",[Validators.required]),
    dumpAddress:new FormControl("",[Validators.required]),
    dumpLocation:new FormControl("",[Validators.required]),
    dumpLaitude:new FormControl("",[Validators.required]),
    dumpLongitude:new FormControl("",[Validators.required]),
    dumpDistrict:new FormControl("",[Validators.required]),
    dumpRegion:new FormControl("",[Validators.required])
  });
  updateForm:FormGroup=new FormGroup({
    id:new FormControl("",[Validators.required]),
    dumpName:new FormControl("",[Validators.required]),
    dumpAddress:new FormControl("",[Validators.required]),
    dumpLocation:new FormControl("",[Validators.required]),
    dumpLaitude:new FormControl("",[Validators.required]),
    dumpLongitude:new FormControl("",[Validators.required]),
    dumpDistrict:new FormControl("",[Validators.required]),
    dumpRegion:new FormControl("",[Validators.required])
  });

  constructor(private dumpServ:MapService) { }
  ngOnDestroy(): void {
    throw new Error('Method not implemented.');
  }
  editDump(dump:any){
    this.updateForm=new FormGroup({
      id:new FormControl(dump.id,[Validators.required]),
      dumpName:new FormControl(dump.dumpName,[Validators.required]),
      dumpAddress:new FormControl(dump.ownerPhone,[Validators.required]),
      dumpLocation:new FormControl(dump.dumpName,[Validators.required]),
      dumpLatitude:new FormControl(dump.dumpName,[Validators.required]),
      dumpLongitude:new FormControl(dump.dumpName,[Validators.required]),
      dumpDistrict:new FormControl(dump.dumpName,[Validators.required]),
      dumpRegion:new FormControl(dump.dumpName,[Validators.required]),
    });
  }

  ngOnInit(): void {
    this.fetchDumps()
  }
  filterDump(){
    this.dumps=this.orgDumps.filter(res=>res.dumpName.includes(this.filterForm.controls["search"].value));
  }
  fetchDumps(){
    // correct
    this.dumpServ.getDump().subscribe((response: any[])=>{
      this.orgDumps=response;
      this.dumps=response;
      console.log(this.dumps)
    });
  }
  saveNewDump(){
    this.dumpServ.newDump(this.dumpForm.value).subscribe(response=>{
      this.fetchDumps();
      alert("Dump has been saved");
    },error=>{
      alert("Fail to save new dump");
    })
  };
  updateDump(){
    this.dumpServ.updateDump(this.updateForm.controls["id"].value,this.updateForm.value).subscribe(response=>{
      this.fetchDumps();
      alert("Dump has been update");
    },error=>{
      alert("Fail to update new dump");
    })
  };

  deleteDump(dump:any){
    this.dumpServ.deleteDump(dump.id).subscribe(response=>{
      this.fetchDumps();
      alert("Dump has been deleted");
    },error=>{
      this.fetchDumps();
      alert("Fail to delete new dump");
    })
  }
}
