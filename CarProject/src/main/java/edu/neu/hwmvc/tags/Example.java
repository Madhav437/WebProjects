/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.neu.hwmvc.tags;

import javax.servlet.jsp.tagext.*;
import javax.servlet.jsp.*;
import java.io.*;


public class Example extends SimpleTagSupport {
   public void doTag() throws JspException, IOException {
      /*This is just to display a message, when
       * we will use our custom tag. This message
       * would be displayed
       */
      JspWriter out = getJspContext().getOut();
      out.println("This is my own custom tag");
   }
}