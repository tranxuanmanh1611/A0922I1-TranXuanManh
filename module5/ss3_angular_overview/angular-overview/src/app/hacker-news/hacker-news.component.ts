import {Component, OnInit} from '@angular/core';
import {Article} from "./article";

@Component({
  selector: 'app-hacker-news',
  templateUrl: './hacker-news.component.html',
  styleUrls: ['./hacker-news.component.css']
})
export class HackerNewsComponent implements OnInit {
  article: Article = {
    name: "",
    url: ""
  }
  newArticles: Article[] = [ {
  name: "Seeking early feedback: AI-personalized learning platform launches next week"
,
  url: "https://www.sociask.co/"
},{
    name:"OpenTTD 13.4 Released",
    url:"https://www.openttd.org/news/2023/07/29/openttd-13-4"
},
    {
      name:"Tribal Knowledge",
      url:"https://daedtech.com/tribal-knowledge/"
    }
]
  petArticles: Article[]=[
    {name:"Ở đây có thú cưng và nhiều hơn nữa",url:"https://monspet.com/"},
    {name:"Thực hư chó xả chét",url:"https://cuoi.tuoitre.vn/thuc-hu-chuyen-cho-xa-chet-bang-video-20230730115307336.htm"}
  ]
  displayedArticles: Article[]=this.newArticles;
  addArticle():void{
    this.newArticles.push(this.article);
  }
 changePetArticle():void{
    this.displayedArticles=[];
    this.displayedArticles = this.petArticles;
 }
constructor()
{
}

ngOnInit()
:
void {}

}
