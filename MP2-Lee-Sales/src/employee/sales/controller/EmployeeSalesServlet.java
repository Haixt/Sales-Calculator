package employee.sales.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import employee.sales.model.EmployeeBean;
/**
 * Servlet implementation class EmployeeSalesServlet
 */
@WebServlet("/EmployeeSalesServlet")
public class EmployeeSalesServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	response.setContentType("text/html");
		
		//how do we perform form data extraction?
		String employeeName = request.getParameter("employeeName");
		String salesCode = request.getParameter("salesCode");
		double employeeSales = Double.parseDouble(request.getParameter("employeeSales"));
		
		//create the bean instance
		EmployeeBean employee = new EmployeeBean(employeeName, 
			salesCode, employeeSales, getServletConfig());
		employee.computeEmployeeSales();
		employee.commissionComputation();
		
		ServletConfig config = getServletConfig();
		PrintWriter out = response.getWriter();
		
		out.print("<html>");
		out.print("	<head><title>Employee Sales Calculator</title></head>");
		
		out.print("	<body>");
		
		out.print("		<h2>Employee Sales Calculator</h2>");
		out.print("		<p><b>Employee Details</b></p>");
		out.print("		<p>Employee Name: <b>" + employee.getEmployeeName()+ "</b></p>");
		out.print("		<p>Sales Code: <b>" + employee.getSalesCode() + "</b></p>");
		out.print("		<p>Sales Amount: <b>PHP" + employee.getEmployeeSales() + "</b></p>");
		out.print("		<p>Sales Gross Commission: <b>PHP" + employee.getSalesGrossCommission()+ "</b></p>");	
		out.print("		<p>Sales Commission: <b>PHP" + employee.getSalesCommission()+ "</b></p>");
		
		out.print(		"<p><i>Employee rates as of " + getServletConfig().getInitParameter("PRICES_AS_OF") + "<i/></p>");
		out.print(		"<p>SALES CODE A: <b>" 
			+  getServletConfig().getInitParameter("COMMISSION_A") +" + "+ getServletConfig().getInitParameter("COMMISSION_A_PRINT")+"% OF SALES"+"</b></p>");
		
		out.print(		"<p>SALES CODE B: <b>" 
				+  getServletConfig().getInitParameter("COMMISSION_B")+" + " + getServletConfig().getInitParameter("COMMISSION_B_PRINT")+"% OF SALES"+"</b></p>");
		
		out.print(		"<p>SALES CODE B: <b>" 
				+  getServletConfig().getInitParameter("COMMISSION_C")+" + " + getServletConfig().getInitParameter("COMMISSION_C_PRINT")+"% OF SALES"+"</b></p>");
		
		out.print("		<p></p>");
		out.print("		<form action='compute.html'>");
		out.print("			<input type='submit' value='<< GO BACK >>'/>");
		out.print("		</form>");
		out.print("		<hr/>");
		out.print("		<p><i>LEE EMPLOYEE CALCULATOR INC.</i></p>");
		out.print("	</body>");
		out.print("</html>");
		
		out.close();
	}

}
