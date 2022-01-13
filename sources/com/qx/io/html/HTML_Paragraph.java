package com.qx.io.html;

import java.io.IOException;
import java.io.Writer;


/**
 * 
 * @author pierreconvert
 *
 */
public class HTML_Paragraph extends HTML_Block {

  private String text;
  
  public HTML_Paragraph(String text)
  {
    this.text = text;
  }
  
  @Override
  public void print(Writer writer) throws IOException {
    writer.write("<p>");
    writer.write(text);
    writer.write("</p>");
  }
  
}