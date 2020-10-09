package model;

import java.time.LocalDate;

public class Blog
{
String blogTitle;
String blogDescription;
LocalDate postedOn;

public String getBlogTitle() {
	return blogTitle;
}
public void setBlogTitle(String blogTitle) {
	this.blogTitle = blogTitle;
}
public String getBlogDescription() {
	return blogDescription;
}
public void setBlogDescription(String blogDescription) {
	this.blogDescription = blogDescription;
}
public LocalDate getPostedOn() {
	return postedOn;
}
public void setPostedOn(LocalDate postedOn) {
	this.postedOn = postedOn;
}
public long getBlogId() {
	// TODO Auto-generated method stub
	return 0;
}


}