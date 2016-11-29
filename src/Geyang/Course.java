package Geyang;

public class Course {
	public String level;
	public String date;
	public String time;
	public String prof;
	public int dateNum;
	
	public Course(String l, String d, String t, String prof){
		char[] temp = l.toCharArray();
		temp[3] = ' ';
		this.level = new String(temp);
		
		this.date = d;
		if(this.date.equals("M")) dateNum = 0;
		else if(this.date.equals("T")) dateNum = 1;
		else if(this.date.equals("W")) dateNum = 2;
		else if(this.date.equals("R")) dateNum = 3;
		else dateNum = -1;
		this.time = t.substring(0, 5);
		String[] s = prof.split(" ");
		
		this.prof = s[2].substring(0, 1) + s[1].substring(0, 1) ;
		//System.out.println(this.dateNum);
	}
	
	
}
