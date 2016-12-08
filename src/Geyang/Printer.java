package Geyang;

import java.util.LinkedList;
import java.util.List;

public class Printer {
	private static Printer Instence = null;
	
	private Printer(){}
	public static Printer getInstence(){
		if(Instence == null) Instence = new Printer();
		return Instence;
	}
	public void printSch(String filePath){
		System.out.println("***********************************************************************************************");
		//System.out.println("-----------------------------------------------------------------------------------------------");
		ClassGenerater cg = new ClassGenerater();
		List<Course> li = cg.readFile(filePath);
		List<String> sch = new LinkedList<>();
		String row000 = "-----------------------------------------------------------------------------------------------";
		String row001 = "|    Time     |      Monday       |      Tuesday      |     Wesnesday     |      Thursday     |";
		String row002 = "|-------------|-------------------|-------------------|-------------------|-------------------|";
		String row003 = "| 08:00-09:50 |                   |                   |                   |                   |";
		String row004 = "|-------------|-------------------|-------------------|-------------------|-------------------|";
		String row005 = "| 10:00-11:50 |                   |                   |                   |                   |";
		String row006 = "|-------------|-------------------|-------------------|-------------------|-------------------|";
		String row007 = "| 12:00-01:50 |                   |                   |                   |                   |";
		String row008 = "|-------------|-------------------|-------------------|-------------------|-------------------|";
		String row009 = "| 02:00-03:50 |                   |                   |                   |                   |";
		String row010 = "|-------------|-------------------|-------------------|-------------------|-------------------|";
		String row011 = "| 04:00-05:50 |                   |                   |                   |                   |";
		String row012 = "|-------------|-------------------|-------------------|-------------------|-------------------|";
		String row013 = "| 06:00-07:50 |                   |                   |                   |                   |";
		String row014 = "-----------------------------------------------------------------------------------------------";
		sch.add(row000);
		sch.add(row001); 
		sch.add(row002);
		sch.add(row003);
		sch.add(row004);
		sch.add(row005);
		sch.add(row006);
		sch.add(row007);
		sch.add(row008);
		sch.add(row009);
		sch.add(row010);
		sch.add(row011);
		sch.add(row012);
		sch.add(row013);
		sch.add(row014);
		
		for(Course c: li){
			//System.out.println(c.dateNum);
			if(c.dateNum == -1){
				String dis ="Distance Learning : " + c.level + " "+c.prof;
				sch.add(dis);
			}
			for(int i = 0;i<4;i++){
				if(c.dateNum == i){
					String s = c.time;
					for(int j = 0;j<sch.size();j++){
						//System.out.println(sch.get(j).substring(2, 7));
						//System.out.println(c.time);
						int start =15 + i*20;
						int end = 15+ i*20 + 19;
						if(sch.get(j).substring(2, 7).equals(c.time)){
							
							/*if(sch.get(j).substring(start, end).equals("                   ")){
								String temp1 = sch.get(j).substring(0, 15 + i*20) +
										"  " + c.level + " " + c.prof+ "  " +
										sch.get(j).substring(15+ i*20 + 19,sch.get(j).length());
								sch.set(j, temp1);
							}else{*/
								
								int index = j;
								while(!sch.get(index).substring(start, end).equals("                   ")){
									if(sch.get(index).substring(start, end).equals("-------------------")){
										String orange = "|             |                   |                   |                   |                   |";
										sch.add(index,orange);
										break;
									}
									index++;
								}
								String temp2 = sch.get(index).substring(0, 15 + i*20) +
										"  " + c.level + " " + c.prof+ "  " +
										sch.get(index).substring(15+ i*20 + 19,sch.get(index).length());;
								sch.set(index, temp2);
							//}
						}
					}
				}
			}
		}
		
		for(int i =0;i<sch.size();i++){
			System.out.println(sch.get(i));
		}
		
		System.out.println("***********************************************************************************************");
	}
}
