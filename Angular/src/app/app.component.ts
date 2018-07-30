import { Component } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent {
  title = 'app';

  constructor(private activatedRoute: ActivatedRoute, private router: Router) { }
  
  ngOnInit() {
    const path = this.activatedRoute.snapshot.queryParams['path'];
    const navigateTo = '/' + path;
    
    if (path) {
      this.router.navigate([navigateTo]);
    }
  }
}