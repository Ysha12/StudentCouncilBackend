import { Component, OnInit, AfterViewInit } from '@angular/core';
import * as L from 'leaflet';
import { MarkerService } from 'src/app/Services/Maker/marker.service';
import { MapService } from 'src/app/Services/map/map.service';


const iconRetinaUrl = 'assets/mapcomponents/marker-icon-2x.png';
const iconUrl = 'assets/mapcomponents/marker-icon.png';
const shadowUrl = 'assets/mapcomponents/marker-shadow.png';
const iconDefault = L.icon({
  iconRetinaUrl,
  iconUrl,
  shadowUrl,
  iconSize: [25, 41],
  iconAnchor: [12, 41],
  popupAnchor: [1, -34],
  tooltipAnchor: [16, -28],
  shadowSize: [41, 41]
});
L.Marker.prototype.options.icon = iconDefault;

@Component({
  selector: 'app-map',
  templateUrl: './map.component.html',
  styleUrls: ['./map.component.css']
})
export class MapComponent implements OnInit,AfterViewInit {
  private map!: L.Map;

  private initMap(): void {
    this.map = L.map('map', {
      center: [  -6.09990, 39.36448],
      zoom: 10
    });

    const tiles = L.tileLayer('https://{s}.tile.openstreetmap.org/{z}/{x}/{y}.png', {
      maxZoom: 3000,
      attribution: '&copy; <a href="http://www.openstreetmap.org/copyright">OpenStreetMap</a>'
    });

    tiles.addTo(this.map);
  }

  constructor(private mapService: MapService) { }

  ngOnInit(): void {
        this.initMap();

    }
  displayMakers(): void {
    this.mapService.getDump().subscribe((res: any) => {
      console.log(res)
      for (const c of res) {
        const lon = c.dumpLongitude;
        const lat = c.dumpLatitude;
        const marker = L.marker([lat, lon]);

        marker.addTo(this.map);
        marker.bindPopup(c.dumpName +"<br>"+ c.dumpAddress +"<br>"+ c.dumpLatitude +"<br>"+ c.dumpLongitude);
      }
    });
  }
  ngAfterViewInit(): void {
    // this.mapService.existingDump(L.map);
    this.displayMakers();
  }
}
