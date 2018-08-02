import { Component, OnInit, Input } from '@angular/core';
import { CookieService } from 'ngx-cookie-service';
import { UserPostService } from '../../services/post-service/user-post.service';
import { Comment } from '../../objects/Comment'

@Component({
  selector: 'app-media-post',
  templateUrl: './media-post.component.html',
  styleUrls: ['./media-post.component.css']
})
export class MediaPostComponent implements OnInit {
    @Input() postPic: string;
    @Input() postComments: string;
    @Input() postRecipe: string;

    commentBody = "";
    createCommentDisplay: boolean;
    commentList: Comment[] = new Array();

    //TODO: initialize with values from the database
    likeCounter = 0;
    dislikeCounter = 0;

    img1Path: string;

  constructor(private cookie: CookieService, private postService: UserPostService) {
      //TODO: Delete, these pictures are for testing only
      this.img1Path = 'assets/images/img_avatar1.png';
      // this.testImage = 'assets/images/testImage.png';
      // this.postPic = 'assets/images/main_pic.jpg';
  }

  public favoriteClicked(){
      alert("TODO: favoriteClicked() not implemented yet.");
  }
  public likeClicked(){
      this.likeCounter++;
  }
  public dislikeClicked(){
      this.dislikeCounter++;
  }
  public commentClicked(){
      this.createCommentDisplay = !this.createCommentDisplay;
  }

  public submitComment(){
      console.log(this.commentBody);
      this.postService.createComment(this.cookie.get('username'), this.commentBody).subscribe(
          returnValue => {
              console.log(returnValue);
              this.commentList.push(new Comment(this.cookie.get('username'), returnValue, this.commentBody));
              this.createCommentDisplay = false;
          }, error => {
              console.log("ERROR");
              console.log(error);}
      );
  }

  ngOnInit() {
      this.createCommentDisplay = false;


  }

}
