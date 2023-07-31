import { Component, OnInit } from '@angular/core';
import{HackerNewsComponent} from "../hacker-news.component";

@Component({
  selector: 'app-nav-bar',
  templateUrl: './nav-bar.component.html',
  styleUrls: ['./nav-bar.component.css'],
})
export class NavBarComponent implements OnInit {
news:HackerNewsComponent;
changePet():void{
  this.news.changePetArticle()
}

  constructor(private hackerNewsComponent:HackerNewsComponent ) {
    this.news = hackerNewsComponent;
  }

  ngOnInit(): void {
  }

}
