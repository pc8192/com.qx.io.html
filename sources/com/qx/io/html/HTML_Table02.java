package com.qx.io.html;

import java.io.IOException;
import java.io.Writer;
import java.util.ArrayList;
import java.util.List;


/**
 * 
 * @author pierreconvert
 *
 */
public class HTML_Table02 extends HTML_Block {

	
	/**
	 * 
	 */
	private int n;
	
	
	/**
	 * 
	 */
	private String title;
	
	
	/**
	 * 
	 */
	private String[] columnNames;
	
	
	/**
	 * 
	 */
	private String[] columnComments;
	
	
	/**
	 * 
	 */
	private List<String[]> body;

	
	/**
	 * 
	 * @param title
	 * @param columnNames
	 * @param columnComments
	 */
	public HTML_Table02(String title, String[] columnNames, String[] columnComments) {
		this.title = title;
		this.columnNames = columnNames;
		this.columnComments = columnComments;
		n = columnNames.length;
		body = new ArrayList<>();
	}


	/**
	 * 
	 * @param row
	 */
	public void push(String[] row) {
		if (row.length != n) {
			throw new RuntimeException("Wrong number of cells while inserting new row in Table02");
		}
		body.add(row);
	}
	

	@Override
	public void print(Writer writer) throws IOException {
		writer.write("<table class=\"table02\">");

		writer.write("<thead>");

		writer.write("<tr>");
		writer.write("<td colspan=\"" + n + "\">" + title + "</td>");
		writer.write("</tr>");


		writer.write("</tr>");
		for (String cell : columnNames) {
			writer.write("<td>");
			writer.write(cell);
			writer.write("</td>");
		}
		writer.write("</tr>");


		writer.write("</tr>");
		for (String cell : columnComments) {
			writer.write("<td>");
			writer.write(cell);
			writer.write("</td>");
		}
		writer.write("</tr>");
		writer.write("</thead>");



		writer.write("<tbody>");
		for (String[] row : body) {
			writer.write("<tr>");
			for (String cell : row) {
				writer.write("<td>");
				writer.write(cell);
				writer.write("</td>");
			}
			writer.write("</tr>");
		}
		writer.write("</tbody>");
		writer.write("</table>");
	}


}