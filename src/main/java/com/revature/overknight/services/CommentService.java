package com.revature.overknight.services;

import java.sql.Date;
import java.time.LocalDate;

import com.revature.overknight.beans.Comments;
import com.revature.overknight.dao.CommentDaoImpl;
import com.revature.overknight.dao.PostDaoImpl;

public class CommentService {
	
	static CommentDaoImpl cd = new CommentDaoImpl();
	
	public static Boolean createNewComment(int postId, String name, String text)
	{
		//SETUP DATE AND CONVERT IT
		LocalDate lDate = LocalDate.now();
		Date date = java.sql.Date.valueOf( lDate );
		Comments comment = new Comments(name, date, text);
		
		
		if(cd.insertComment(comment) != null && new PostDaoImpl().addCommentToPost(postId, comment))
		{
			return true;
		}
		
		System.out.println("Sorry! You did NOT create this new comment! :(");
		return false;
		
		
		
		
		
	}
	

}
