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
import edu.neu.hwmvc.dao.ServiceApptDao;
import edu.neu.hwmvc.model.Customer;
import java.util.List;
import edu.neu.hwmvc.model.Orders;
import edu.neu.hwmvc.model.Serviceapt;
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

public class ServiceExcelController  {
    private static final long serialVersionUID = 1L;

   
    
    @RequestMapping(value="/serviceExcel.htm", method=RequestMethod.GET)
    protected String handler(
            HttpServletRequest request,
            HttpServletResponse response,Customer customer) throws IOException {
  
    
		
		HttpSession session  = request.getSession();
		
		ServiceApptDao servApt = new ServiceApptDao();
		List<Serviceapt> serList = new ArrayList<Serviceapt>(); 
		serList = servApt.getTodos();
		
		
		
		XSSFWorkbook workbook = new XSSFWorkbook();
        XSSFSheet sheet = workbook.createSheet("Service");
        
        int rowCount = 0;
        
        Row row = sheet.createRow(++rowCount);
        writeHeader(row);
        
        for (Serviceapt ser : serList) {
             row = sheet.createRow(++rowCount);
            writeBook(ser, row);
        }
        
        response.setContentType("application/vnd.openxmlformats-officedocument.spreadsheetml.sheet");
        response.setHeader("Content-Disposition",
                                 "attachment; filename=serviceappt.xlsx");
        OutputStream out = response.getOutputStream();
				workbook.write(out);
			    workbook.close();
		
		
		
		//request.setAttribute("orderList",ordList);
		
		
	
		return null;
    
    }
    
    private void writeBook(Serviceapt ser, Row row) {
        Cell cell = row.createCell(0);
        cell.setCellValue(ser.getCarName());
     
        cell = row.createCell(1);
        cell.setCellValue(ser.getAppDate());
     
        cell = row.createCell(2);
        cell.setCellValue(ser.getAppTime());
        
        cell = row.createCell(3);
        cell.setCellValue(ser.getRegNumber());
        
        cell = row.createCell(4);
        cell.setCellValue(ser.getMakeYear());
        
        cell = row.createCell(5);
        cell.setCellValue(ser.getCustomer().getCustId());
        
      
        
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
        cell.setCellValue("Customer Id");
        
       
        
        
        
        
        
        
    }
}


	

