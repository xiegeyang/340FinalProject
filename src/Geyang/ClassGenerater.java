package Geyang;

import java.io.*;
import java.util.*;

public class ClassGenerater {
	public List<Course> readFile(String path){
		 	String content = null;
		 	List<Course> res = null;
		    File file = new File(path); //for ex foo.txt
		    FileReader reader = null;
		    try {
		        reader = new FileReader(file);
		        char[] chars = new char[(int) file.length()];
		        reader.read(chars);
		        content = new String(chars);
		        
		        //System.out.println(content);
		        res = processString(content);
				
		        reader.close();
		    } catch (IOException e) {
		        e.printStackTrace();
		    } finally {
		        if(reader !=null){try {
					reader.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}}
		    }
		    return res;
	}
	
	private List<Course> processString(String content){
		if(content == null) return new ArrayList<>();
		List<Course> res = new ArrayList<>();
		String[] strs = content.split("--------------------------");
		for(String str : strs){
			if(str.length() <=2) continue;
			String[] temp = str.split("\\|");
			String[] dateTime = temp[5].split(" ");
			Course course = new Course(temp[1].substring(1,temp[1].length()-1), dateTime[1].substring(0, 1), 
					dateTime[2], temp[7].split("\n")[0]);
			res.add(course);
			//System.out.println(course.level);
			if(dateTime[1].length()>1){
				Course course3 = new Course(temp[1].substring(1,temp[1].length()-1), dateTime[1].substring(1, 2), 
						dateTime[2], temp[7].split("\n")[0]);
				res.add(course3);
				//System.out.println(course3.level);
			}
			if(temp.length > 8){
				String[] dateTime2 = temp[8].split(" ");
				Course course2 = new Course(temp[1].substring(1,temp[1].length()-1), dateTime2[1].substring(0, 1), 
						dateTime2[2], temp[10].split("\n")[0]);
				res.add(course2);
				//System.out.println(course2.level);
				if(dateTime2[1].length()>1){
					Course course4 = new Course(temp[1].substring(1,temp[1].length()-1), dateTime2[1].substring(1, 2), 
							dateTime2[2], temp[7].split("\n")[0]);
					res.add(course4);
					//System.out.println(course4.level);
				}
				
			}
		}
		return res;
	}
	
	
}
