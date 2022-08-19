package employee.sales.model;

import java.io.Serializable;

import javax.servlet.ServletConfig;


public class EmployeeBean implements Serializable{
	
	//user input values
	private String employeeName;
	private String salesCode;
	private double employeeSales;
	
	// computed values
	private double salesGrossCommission;
	private double salesCommission;
	private String commissionName;
	
	private ServletConfig config; 
	
	
	public EmployeeBean(){
		
	}
	

	public EmployeeBean(String employeeName, String salesCode, double employeeSales ,ServletConfig config){
			
		this.employeeName = employeeName;
		this.salesCode = salesCode;
		this.employeeSales = employeeSales;
		this.config = config;
	}
	
	// setter & getter
	public String getEmployeeName() {
		return employeeName;
	}

	public void setEmployeeName(String employeeName) {
		this.employeeName = employeeName;
	}

	public String getSalesCode() {
		return salesCode;
	}

	public void setSalesCode(String salesCode) {
		this.salesCode = salesCode;
	}

	public double getEmployeeSales() {
		return employeeSales;
	}

	public void setEmployeeSales(double employeeSales) {
		this.employeeSales = employeeSales;
	}

	public double getSalesGrossCommission() {
		return salesGrossCommission;
	}

	public void setSalesGrossCommission(double salesGrossCommission) {
		this.salesGrossCommission = salesGrossCommission;
	}

	public double getSalesCommission() {
		return salesCommission;
	}

	public void setSalesCommission(double salesCommission) {
		this.salesCommission = salesCommission;
	}
	
	
	public String getCommissionName() {
		return commissionName;
	}


	public void setCommissionName(String commissionName) {
		this.commissionName = commissionName;
	}


	public void computeEmployeeSales() {
		switch (this.salesCode) {
			case "A":
				this.salesGrossCommission = 
				Double.parseDouble(config.getInitParameter("COMMISSION_A"))
				+(this.employeeSales* Double.parseDouble(config.getInitParameter("COMMISSION_A_PERC")));
				this.commissionName = config.getInitParameter("COMMISSION_A_COMPUTATION");
				break;
			case "B":
				this.salesGrossCommission = 
				Double.parseDouble(config.getInitParameter("COMMISSION_B"))
				+(this.employeeSales* Double.parseDouble(config.getInitParameter("COMMISSION_B_PERC")));
				this.commissionName = config.getInitParameter("COMMISSION_B_COMPUTATION");
				break;
			case "C":	
				this.salesGrossCommission = 
				Double.parseDouble(config.getInitParameter("COMMISSION_C"))
				+(this.employeeSales* Double.parseDouble(config.getInitParameter("COMMISSION_C_PERC")));
				this.commissionName = config.getInitParameter("COMMISSION_C_COMPUTATION");
				break;
		}
	}	
	
	
	
	 public  void commissionComputation(){
		
		 if (this.employeeSales>Double.parseDouble(config.getInitParameter("COMMISSION_RANGE")))
		 {
			 this.salesCommission = 
			 this.employeeSales*Double.parseDouble(config.getInitParameter("COMMISSION_RANGE_PERC"));
		 }
		 else
		 {
			this.salesCommission =Double.parseDouble(config.getInitParameter("NO_COMMISSION"));
		 }
	 }
	 
	}



