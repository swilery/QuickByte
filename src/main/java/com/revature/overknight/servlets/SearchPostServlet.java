package com.revature.overknight.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.io.StringReader;
import java.util.List;

import javax.json.Json;
import javax.json.JsonObject;
import javax.json.JsonReader;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.codehaus.jackson.map.ObjectMapper;

import com.revature.overknight.beans.Post;
import com.revature.overknight.services.PostService;

/**
 * Servlet implementation class SearchPostServlet
 */
@WebServlet("/SearchPostServlet")
public class SearchPostServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SearchPostServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		 // SETUP
        String input = "";
        StringBuilder sb = new StringBuilder();
        while ((input = request.getReader().readLine()) != null) sb.append(input);
		input = sb.toString();

		//GET TAG FIELDS
		String tag = input.toLowerCase();
		//GET POSTS BASED ON TAG
		PostService ps = new PostService();
		List<Post> posts = ps.SearchPostByTag(tag);

        //SETUP REPLY
        response.setContentType("text/json");
        PrintWriter out = response.getWriter();

    	// RETURN THE POSTS
        out.println(new ObjectMapper().writeValueAsString(posts));
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
