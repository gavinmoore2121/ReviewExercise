package com.servlets;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class FileDisplayTool extends HttpServlet {
	
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.getWriter().append("Served at: ").append(request.getContextPath());
		response.getWriter().append("Program printing successfully.");
		response.setContentType("text/html"); // Set the content type
		PrintWriter pw = response.getWriter(); // Get stream to write data
		
		BufferedReader reader = new BufferedReader(new FileReader("Fitness.txt"));
		
		reader.lines().forEach(e -> pw.println(e));
		
		reader.close();
		
		pw.close();
	}

	// Reroute to doGet.
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
	
}
