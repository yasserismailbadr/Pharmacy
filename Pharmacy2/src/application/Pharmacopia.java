package application;

public class Pharmacopia {
private int id;
private String name_medication;
private int quantity;
private int price;
private String type;
private String concentrates;
private String effective_substance;
private String Purpose_of_medications;
private String production_date;
private String expiry_date;

public Pharmacopia() {
	super();
	// TODO Auto-generated constructor stub
}
public Pharmacopia(int id, String name_medication, int quantity, int price, String type, String concentrates,
		String effective_substance, String purpose_of_medications, String production_date, String expiry_date) {
	super();
	this.id = id;
	this.name_medication = name_medication;
	this.quantity = quantity;
	this.price = price;
	this.type = type;
	this.concentrates = concentrates;
	this.effective_substance = effective_substance;
	Purpose_of_medications = purpose_of_medications;
	this.production_date = production_date;
	this.expiry_date = expiry_date;
}

public int getId() {
	return id;
}



public void setId(int id) {
	this.id = id;
}



public String getName_medication() {
	return name_medication;
}



public void setName_medication(String name_medication) {
	this.name_medication = name_medication;
}



public int getQuantity() {
	return quantity;
}



public void setQuantity(int quantity) {
	this.quantity = quantity;
}



public int getPrice() {
	return price;
}



public void setPrice(int price) {
	this.price = price;
}



public String getType() {
	return type;
}



public void setType(String type) {
	this.type = type;
}



public String getConcentrates() {
	return concentrates;
}



public void setConcentrates(String concentrates) {
	this.concentrates = concentrates;
}



public String getEffective_substance() {
	return effective_substance;
}



public void setEffective_substance(String effective_substance) {
	this.effective_substance = effective_substance;
}



public String getPurpose_of_medications() {
	return Purpose_of_medications;
}



public void setPurpose_of_medications(String purpose_of_medications) {
	Purpose_of_medications = purpose_of_medications;
}



public String getProduction_date() {
	return production_date;
}



public void setProduction_date(String production_date) {
	this.production_date = production_date;
}



public String getExpiry_date() {
	return expiry_date;
}



public void setExpiry_date(String expiry_date) {
	this.expiry_date = expiry_date;
}
}
