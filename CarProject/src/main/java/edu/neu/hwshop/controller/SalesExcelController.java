package edu.neu.hwshop.controller;


import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.AbstractController;

import edu.neu.hwmvc.dao.OrdersDao;
import edu.neu.hwmvc.model.Customer;
import java.util.List;
import edu.neu.hwmvc.model.Orders;
import edu.neu.hwshop.validator.CustomerValidator;
import edu.neu.hwshop.validator.OrderValidator;


import java.util.ArrayList;
import javax.servlet.http.Cookie;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
 
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;


@Controller

public class SalesExcelController  {
    private static final long serialVersionUID = 1L;

   
    
    @RequestMapping(value="/salesExcel.htm", method=RequestMethod.GET)
    protected String handler(
            HttpServletRequest request,
            HttpServletResponse response,Customer customer) throws IOException {
  
    
		
		HttpSession session  = request.getSession();
		
		OrdersDao ordDao = new OrdersDao();
		List<Orders> ordList = new ArrayList<Orders>(); 
		ordList = ordDao.getTodos();
		
		XSSFWorkbook workbook = new XSSFWorkbook();
        XSSFSheet sheet = workbook.createSheet("Sales");
        
        int rowCount = 0;
        
        Row row = sheet.createRow(++rowCount);
        writeHeader(row);
        
        for (Orders ord : ordList) {
             row = sheet.createRow(++rowCount);
            writeBook(ord, row);
        }
        
        response.setContentType("application/vnd.openxmlformats-officedocument.spreadsheetml.sheet");
        response.setHeader("Content-Disposition",
                                 "attachment; filename=sales.xlsx");
        OutputStream out = response.getOutputStream();
				workbook.write(out);
			    workbook.close();
		
		
		
		//request.setAttribute("orderList",ordList);
		
		
	
		return null;
    
    }
    
    private void writeBook(Orders ord, Row row) {
        Cell cell = row.createCell(0);
        cell.setCellValue(ord.getCustomer().getCustId());
     
        cell = row.createCell(1);
        cell.setCellValue(ord.getCarName());
     
        cell = row.createCell(2);
        cell.setCellValue(ord.getColor());
        
        cell = row.createCell(3);
        cell.setCellValue(ord.getInterior());
        
        cell = row.createCell(4);
        cell.setCellValue(ord.getAutopilot());
        
        cell = row.createCell(5);
        cell.setCellValue(ord.getPaymentType());
        
        cell = row.createCell(6);
        cell.setCellValue(ord.getPrice());
        
        
        
        
        
        
    }
    
    private void writeHeader(Row row) {
        Cell cell = row.createCell(0);
        cell.setCellValue("Customer Id");
     
        cell = row.createCell(1);
        cell.setCellValue("Car Name");
     
        cell = row.createCell(2);
        cell.setCellValue("Car Color");
        
        cell = row.createCell(3);
        cell.setCellValue("Car Interior");
        
        cell = row.createCell(4);
        cell.setCellValue("Auto Pilot");
        
        cell = row.createCell(5);
        cell.setCellValue("Payment Type");
        
        cell = row.createCell(6);
        cell.setCellValue("Price");
        
        
        
        
        
        
    }
}


	

