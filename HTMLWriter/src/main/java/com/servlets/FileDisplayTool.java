package com.servlets;
import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
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
		
		// Find file
		InputStream stream = Thread.currentThread().getContextClassLoader().getResourceAsStream("Fitness.txt");
		if (stream == null) {
			System.out.println("öh fuck");
		}
		
		// Read from input stream and add to a string builder.
		StringBuilder sb = new StringBuilder();
		for (int ch; (ch = stream.read()) != -1; ) {
		    sb.append((char) ch);
		}
		pw.append(sb);
		
		stream.close();
		
		pw.close();
	}

	// Reroute to doGet.
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
	
}
