package model;

public class Absense {

	private String date;
	private int group;
	private String Students;
	private String teacher;
	public Absense( String date, int group, String students, String teacher) {
		this.date = date;
		this.group = group;
		Students = students;
		this.teacher = teacher;
	}

	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public int getGroup() {
		return group;
	}
	public void setGroup(int group) {
		this.group = group;
	}
	public String getStudents() {
		return Students;
	}
	public void setStudents(String students) {
		Students = students;
	}
	public String getTeacher() {
		return teacher;
	}
	public void setTeacher(String teacher) {
		this.teacher = teacher;
	}
	
	
	
	
}
