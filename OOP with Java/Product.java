import java.util.Calendar;

public class Product {
	//MEHMET ALPER KARABAY 150119044
private String productName;  //creating the data fields
private java.util.Calendar saleDate;
private double price;
//creating the contructors
public Product(String sName , java.util.Calendar sDate , double sPrice) {
	this.price = sPrice;
	this.productName = sName;
	this.saleDate = sDate;
}
@Override
public String toString() {
	return "Product [productName=" + productName + " transactionDate=" + getSaleDate().get(Calendar.DAY_OF_MONTH) + "/" + getSaleDate().get(Calendar.MONTH) + "/" +
			getSaleDate().get(Calendar.YEAR) + " price=" + price + "]";
}
public String getProductName() {
	return productName;    //Creating getters and setters
}
public void setProductName(String productName) throws  Exception {
	if(productName.length()<3)
		throw new Exception("Product Name should has at least 3 letters");
	this.productName = productName;
}
public java.util.Calendar getSaleDate() {
	return saleDate;
}
public void setSaleDate(java.util.Calendar saleDate) {
	this.saleDate = saleDate;
}
public double getPrice() {
	return price;
}
public void setPrice(double price) throws Exception {
	if(price<0)
		throw new Exception("Price cannot be negative");
	this.price = price;
}
}
