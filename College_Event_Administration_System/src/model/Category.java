package model;

public class Category {
	
private int cat_Id;
private String cat_name;

public int getCat_Id() {
	return cat_Id;
}
public void setCat_Id(int cat_Id) {
	this.cat_Id = cat_Id;
}
public String getCat_name() {
	return cat_name;
}
public void setCat_name(String cat_name) {
	this.cat_name = cat_name;
}
public Category(int cat_Id, String cat_name) {
	super();
	this.cat_Id = cat_Id;
	this.cat_name = cat_name;
}
public Category(String cat_name) {
	super();
	
	this.cat_name = cat_name;
}


}
