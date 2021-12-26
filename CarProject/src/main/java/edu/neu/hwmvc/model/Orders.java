package edu.neu.hwmvc.model;


public class Orders {
    private int orderId;
    
    private String carName;
    private String color;
    private String motor;
    private String modOption;
    private String wheels;
    private String interior;
    private String autopilot;
    private String paymentType;
    private float price;
    private Customer customer;
    
	public Customer getCustomer() {
		return customer;
	}
	public void setCustomer(Customer customer) {
		this.customer = customer;
	}
	public String getMotor() {
		return motor;
	}
	public void setMotor(String motor) {
		this.motor = motor;
	}
	public String getModOption() {
		return modOption;
	}
	public void setModOption(String modOption) {
		this.modOption = modOption;
	}
	public String getWheels() {
		return wheels;
	}
	public void setWheels(String wheels) {
		this.wheels = wheels;
	}
	public String getInterior() {
		return interior;
	}
	public void setInterior(String interior) {
		this.interior = interior;
	}
	
	public String getAutopilot() {
		return autopilot;
	}
	public void setAutopilot(String autopilot) {
		this.autopilot = autopilot;
	}
	public String getPaymentType() {
		return paymentType;
	}
	public void setPaymentType(String paymentType) {
		this.paymentType = paymentType;
	}
	
	
	public float getPrice() {
		return price;
	}
	public void setPrice(float price) {
		this.price = price;
	}
	public int getOrderId() {
		return orderId;
	}
	public void setOrderId(int orderId) {
		this.orderId = orderId;
	}
	public String getCarName() {
		return carName;
	}
	public void setCarName(String carName) {
		this.carName = carName;
	}
	public String getColor() {
		return color;
	}
	public void setColor(String color) {
		this.color = color;
	}
	
	
}
