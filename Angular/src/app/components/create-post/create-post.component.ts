import { Component, OnInit } from '@angular/core';
import { RequestOptions } from '@angular/http';
import { HttpClient } from '@angular/common/http';
import { UserPostService } from '../../services/post-service/user-post.service';

@Component({
  selector: 'app-create-post',
  templateUrl: './create-post.component.html',
  styleUrls: ['./create-post.component.css']
})
export class CreatePostComponent implements OnInit {

  constructor(private http: HttpClient, private postService: UserPostService) { }

  ngOnInit() {
      this.displayModal = "none";
  }

    rejectRequest = false;

    postName:string;
    recipe:string;
    picture:any;    //TODO: define this
    comment:string
    displayModal:string;
    image:any;
    fileList:any;
    data:any;

    public onSubmitClicked(){
        //send data to Service Layer
        //recieve boolean success status
    }

    public showModal(){
        //if file exists
        if(this.fileList.length>0){
          let file: File = this.fileList[0];
          this.displayModal = "block";
        }

    }

    public closeModal(){
        //"div.style.display='none';img1.src=''"
    }

    fileChange(e){
    this.fileList = e.target.files;
  }

    uploadPost(){
        if(this.fileList.length>0){
          let file: File = this.fileList[0];
          let formData:FormData = new FormData();

          formData.append('uploadFile', file, file.name);
          // formData.append('info', new Blob([JSON.stringify(this.model)],
          //   {
          //       type: "application/json"
          //   }));
          console.log(file);
          console.log(file.name);
          console.log(file.size);

          this.postService.createPost(formData).subscribe(
              data =>{
                this.data = data;
                console.log(this.data);
              }, error => console.log(error)
            )
        }
    }





}