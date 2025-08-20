package com.coep.genericque;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class Intern_0901_108_Assign1_Abhay {
	//global array declare for use in multiple method
	static int[] RandomFruitIndex;
	static int[] RandomFruitCount;
	//array of Fruit
	static String FruitsE[] = {"mango", "apple", "orange", "guava", "pomegranate", "custard apple", "banana", "strawberry", "sweet lime", "cheeku"};
	static String FruitsM[] = {"आंबा", "सफरचंद", "संत्र", "पेरू", "डाळिंब", "सीताफळ", "केळं", "स्ट्रॉबेरी", "मोसंब", "चिकू"};

	public static void main(String[] args)throws IOException,FileNotFoundException {
		File dir = new File("Excel");
		if (!dir.exists()) {
			dir.mkdirs(); // creates the folder
		}

		String filename = "Excel//Intern_0901_108_Assign1_Abhay.xlsx";
		XSSFWorkbook workbook;
		File file = new File(filename);

		if (file.exists()) {
			// Load existing file
			FileInputStream fis = new FileInputStream(file);
			workbook = new XSSFWorkbook(filename);
			fis.close();
		} else {
			// Create new workbook
			workbook = new XSSFWorkbook();
		}

		//String filename = "Excel//Intern_0901_108_Assign1_Abhay.xlsx";     //Location where excel file is getting generated
		XSSFSheet sheet = workbook.createSheet("Instruction");      //Generating first sheet as Instruction
		//XSSFSheet sheet1 = workbook.createSheet("Questions");       //Generating second sheet as Questions
		XSSFSheet sheet1 = workbook.createSheet("Questions");       //Generating second sheet as Questions

		//Adding first row in second sheet(Questions)
		String[] header = {"Sr. No","Question Type","Answer Type","Topic Number","Question (Text Only)","Correct Answer 1","Correct Answer 2",
				"Correct Answer 3","Correct Answer 4","Wrong Answer 1","Wrong Answer 2","Wrong Answer 3","Time in seconds","Difficulty Level",
				"Question (Image/ Audio/ Video)","Contributor's Registered mailId","Solution (Text Only)","Solution (Image/ Audio/ Video)","Variation Number"};
		XSSFRow rowhead = sheet1.createRow((short)0);	

		//Set height and width to the column and row
		//sheet2.setColumnWidth(4, 35*250);
		//sheet2.setColumnWidth(16, 45*250);

		//Adding header to the second sheet
		for(int head=0; head<header.length; head++) {
			rowhead.createCell(head).setCellValue(header[head]);

		}

		//Taking input for number of question you want to generate
		System.out.println("How many question you want to enter:-");
		Scanner sc=new Scanner(System.in); 
		int mapsize,mapsizeafter;
		HashMap<String, Integer> map = new HashMap<String, Integer> ();
		int q = sc.nextInt();
		for(int i =1;i<q+1;i++) {
			// Create row
			XSSFRow row = sheet1.createRow(i);
			row.createCell(0).setCellValue(i); 
			row.createCell(1).setCellValue("Text"); 
			row.createCell(2).setCellValue(1);
			row.createCell(3).setCellValue("0901");


			Random random=new Random();
			// Generate random number to perform the operation
			int fruitNumber = random.nextInt(3) + 3; // 3 to 5 fruits
			System.out.println("Number of fruits: " + fruitNumber);

			// Step 1: Create list of indices and shuffle
			List<Integer> indexList = new ArrayList<>();
			for (int j = 0; j < FruitsE.length; j++) {
				indexList.add(j);
			}
			Collections.shuffle(indexList); // randomize

			List<Integer> uniqueCounts = new ArrayList<>();
			for (int k = 1; k <= 9; k++) {
				uniqueCounts.add(k);
			}
			Collections.shuffle(uniqueCounts); // Randomize the list

			// Step 2: Take first 'fruitNumber' indices (they are guaranteed unique)
			RandomFruitIndex = new int[fruitNumber];
			RandomFruitCount = new int[fruitNumber];
			for (int k = 0; k < fruitNumber; k++) {
				RandomFruitIndex[k] = indexList.get(k);
				RandomFruitCount[k] = uniqueCounts.get(k); // pick unique count
			}


			//generate the radnom one fruit of our select fruit
			int randomIndexFromSelected = random.nextInt(RandomFruitIndex.length); 
			int fruitArrayIndex = RandomFruitIndex[randomIndexFromSelected];

			//Generate question english
			String Que = "In class $3$ of Prabhukrupa Primary School, everyone is asked about the fruit they like. Based on there answers a table was prepared in form of tally chart as given here.<br>"
					+ "Based on this tally chart, find out,<br>"
					+ "$1.$ Name of different fruits they like?<br>"
					+ "$2.$ Number of students who like "+FruitsE[fruitArrayIndex]+"?<br>"
					+ "$3.$ Name of the fruit  liked by few?<br>"
					+ "$4.$ Number of students to whom the question was asked?<br>";
			//Generate question marathi
			String Que1 = "#"
					+ "प्रभुकृपा शाळेतील तिसरीच्या वर्गातील प्रत्येक विद्यार्थ्याला कोणते फळ आवडते असा प्रश्न विचारण्यात आला. त्यांच्या उत्तरांवर आधारित खाली दिलेले ताळ्याच्या खुणांचा तक्ता बनविला.<br>"
					+ "या तक्त्या नुसार पुढील माहिती शोधा.<br>$1.$ विद्यार्थ्यांना आवडणाऱ्या फळांची नावे?<br>"
					+ "$2.$ "+FruitsM[fruitArrayIndex]+" आवडणाऱ्या विद्यार्थ्यांची संख्या?<br>"
					+ "$3.$ सगळ्यात कमी आवडणारे फळ?<br>"
					+ "$4.$ प्रश्न विचारलेल्या विद्यार्थ्यांची एकूण संख्या?<br><br>";
			String Que2="<table border=1 style=\"border-style: solid; border-width: 2px; border-color: black;text-align:center;\">"
					+ "<tr><th style=\"border-width: 2px; border-color: black;padding: 10px;\"><b>Fruit Name/<br>फळांची नावे</b> </th><th style='border-width: 2px; border-color: black;padding: 10px;'><b>tally chart/<br>ताळ्याचा तक्ता</b></th></tr>"
					+ fruitName(fruitNumber)+"</table><br>";
			String Question=Que+" "+Que1+" "+Que2;

			//Generate Correct answer
			String Correct_ans = "$1)$ "+getFruitE()+"."
					+ "#$1)$"+getFruitM()+".<br>"
					+ "$2)"+ RandomFruitCount[randomIndexFromSelected] + "$ students."
					+ "#$2) " + RandomFruitCount[randomIndexFromSelected] + "$ विद्यार्थी.<br>"					
					+ "$3)$ " +getMinFruitE()+"."
					+ "#$3)$ " +getMinFruitM()+".<br>"
					+ "$4)\\"+" "+ getNumberOfChildren() + "$ students."			
					+ "#$4)\\"+" "+ getNumberOfChildren() + "$ विद्यार्थी.<br>";

			int wrongIndex1 = (randomIndexFromSelected + 1) % RandomFruitIndex.length;
			int wrongIndex2 = (randomIndexFromSelected + 2) % RandomFruitIndex.length;
			int wrongIndex3 = (randomIndexFromSelected + 3) % RandomFruitIndex.length;

			//			int fruitIndex1 = RandomFruitIndex[wrongIndex1];
			//			int fruitIndex2 = RandomFruitIndex[wrongIndex2];
			//			int fruitIndex3 = RandomFruitIndex[wrongIndex3];

			//Generate wrong options 1
			String wrong_ans = "$1)$ "+getWrongFruitE1()+"."
					+ "#$1)$"+getWrongFruitM1()+".<br>"
					+ "$2)"+ RandomFruitCount[wrongIndex1] + "$ students."
					+ "#$2) " + RandomFruitCount[wrongIndex1] + "$ विद्यार्थी.<br>"					
					+ "$3)$ " +getMinFruitE()+"."
					+ "#$3)$ " +getMinFruitM()+".<br>"
					+ "$4)\\ "+(getNumberOfChildren()-1) + "$ students."			
					+ "#$4)\\ "+ (getNumberOfChildren()-1) + "$ विद्यार्थी.<br>";

			//Generate wrong options 2
			String wrong_ans1 = "$1)$ "+getWrongFruitE2()+"."
					+ "#$1)$"+getWrongFruitM2()+".<br>"
					+ "$2)"+ RandomFruitCount[wrongIndex2] + "$ students."
					+ "#$2) " + RandomFruitCount[wrongIndex2] + "$ विद्यार्थी.<br>"					
					+ "$3)$ " +getMinFruitE()+"."
					+ "#$3)$ " +getMinFruitM()+".<br>"
					+ "$4)\\ "+ (getNumberOfChildren()+5) + "$ students."			
					+ "#$4)\\ "+ (getNumberOfChildren()+5) + "$ विद्यार्थी.<br>";

			//Generate wrong options 3
			String wrong_ans2 = "$1)$ "+getWrongFruitE3()+"."
					+ "#$1)$"+getWrongFruitM3()+".<br>"
					+ "$2)"+RandomFruitCount[wrongIndex3]+"$ students"
					+ "#$2) "+RandomFruitCount[wrongIndex3]+"$ विद्यार्थी.<br>"					
					+ "$3)$ "+getMinFruitE()+"."
					+ "#$3)$ "+getMinFruitM()+".<br>"
					+ "$4)\\ "+ (getNumberOfChildren()-3) + "$ students."			
					+ "#$4)\\ "+ (getNumberOfChildren()-3) + "$ विद्यार्थी.<br><br>";


			row.createCell(4).setCellValue(Question);
			row.createCell(5).setCellValue(Correct_ans);
			//			 row.createCell(6).setCellValue(" ");
			//			 row.createCell(7).setCellValue(" ");
			//			 row.createCell(8).setCellValue(" ");
			row.createCell(9).setCellValue(wrong_ans);
			row.createCell(10).setCellValue(wrong_ans1);
			row.createCell(11).setCellValue(wrong_ans2);
			row.createCell(12).setCellValue(120);
			row.createCell(13).setCellValue(3);
			//			  row.createCell(14).setCellValue(" ");
			row.createCell(15).setCellValue("abhaygadge8@gmail.com");

			//Generate Solution
			String Solu = "<b>Ans</b> : <br>"
					+ "$1.$ "+getFruitE()+".<br>"
					+ "$2.\\ "+ RandomFruitCount[randomIndexFromSelected] + "$ students.<br>"
					+ "$3.$ "+getMinFruitE()+".<br>"
					+ "$4.\\ " + getNumberOfChildren() +"$ students.<br>"
					+ "By listing fruits mentioned in the tally chart, we get the list of fruits, which students like.<br>"
					+ "These fruits are "+getFruitE()+". $. . . . (i)$<br>"
					+ "Counting the tally marks in the row for " + FruitsE[fruitArrayIndex] + ", it will tell us number of students who like " + FruitsE[fruitArrayIndex] + ".<br>"
					+ "These are $" + RandomFruitCount[randomIndexFromSelected] + "$ tally marks.<br>"
					+ "Therefore $" + RandomFruitCount[randomIndexFromSelected] + "$ children like " + FruitsE[fruitArrayIndex] + ". $. . . . . (ii)$<br>"
					+ "The fruit which is liked least, is the row corresponding to the fruit which has minimum tally marks.<br>"
					+ "Such fruit is "+getMinFruitE()+", as it has only "+min+" tally mark, which is least.<br>"
					+ "Hence, "+getMinFruitE()+" is the fruit which is liked least. $. . . . (iii)$<br>"
					+ "To find the number of children, who were asked this question, we will add all the tally marks in all rows.<br>"
					+ "As each tally mark represents one student.<br>"
					+ "This sum is $"+getCalculationChildren()+" = " + getNumberOfChildren() + "$.<br>"
					+ "Hence $" + getNumberOfChildren() + "$ students were asked this question.$.. . . . (iv)$<br>"
					+ "Hence, according to $(i , ii, iii)$ and $(iv)$ <br>"
					+ "$1.$ "+getFruitE()+".<Br>"
					+ "$2.\\ "+RandomFruitCount[randomIndexFromSelected]+"$ students.<br>"
					+ "$3.$ "+ getMinFruitE()+".<br>"
					+ "$4.\\ "+getNumberOfChildren()+"$ students, is the answer.<br>";
			String Sol1 = "<b>#उत्तर :</b> <br>"
					+ "#$1.$ "+getFruitM()+".<br>"
					+ "#$2.\\ " + RandomFruitCount[randomIndexFromSelected] + "$ विद्यार्थी.<br>"
					+ "#$3.$ "+getMinFruitM()+".<Br>"
					+ "#$4.\\ " + getNumberOfChildren() +"$ विद्यार्थी.<br>"
					+ "दिलेल्या ताळ्याचा तक्त्यातील फळांची यादी केली म्हणजे विद्यार्थ्यांना आवडणारी फळे कोणती, हे कळेल.<br>"
					+ "ही फळे "+getFruitM()+" , अशी आहेत. $. . . . (i)$<br>"
					+  FruitsM[fruitArrayIndex] + " या फळाच्या ओळीतील ताळ्याच्या खुणा मोजल्या म्हणजे आपल्याला किती मुलांना " + FruitsM[fruitArrayIndex] + " आवडतो हे समजेल.<br>या ओळीतील एकूण खुणा $" + RandomFruitCount[randomIndexFromSelected] +"$ आहेत.<br>"
					+ "म्हणजे " + FruitsM[fruitArrayIndex] + " आवडणारी एकूण विद्यार्थी $" + RandomFruitCount[randomIndexFromSelected] + "$ आहेत$. . . . . (ii)$<br>\r\n"
					+ "जे फळ सगळ्यात कमी आवडते, म्हणजे ज्या फळाच्या ओळीत सगळ्यात कमी ताळ्याच्या खुणा आहेत, असे फळ.<br>"
					+ "असे फळ म्हणजे "+getMinFruitM()+". या फळाच्या ओळीत फक्त "+min+" ताळ्याची खूण आहे.<br>"
					+ "म्हणून, "+getMinFruitM()+" हे सर्वात कमी आवडणारे फळ आहे $. . . . (iii)$<br>"
					+ "प्रश्न विचारलेल्या विद्यार्थ्यांची एकूण संख्या शोधण्यासाठी सर्व ओळीतील ताळ्याच्या खुणांची बेरीज केली असता आपल्याला एकूण विद्यार्थ्यांची संख्या कळेल.<br>"
					+ "ही बेरीज $"+getCalculationChildren()+" = "+getNumberOfChildren()+"$ अशी मिळते.<br>"
					+ "म्हणून प्रश्न विचारलेल्या विद्यार्थ्यांची एकूण संख्या $"+getNumberOfChildren()+"$ आहे $.. . . . (iv)$<br>"
					+ "$(i , ii, iii)$ आणि $(iv)$ नुसार,<br>"
					+ "$1.$ "+getFruitM()+".<Br>"
					+ "$2.\\ "+ RandomFruitCount[randomIndexFromSelected] + "$ विद्यार्थी.<Br>"
					+ "$3.$ "+getMinFruitM()+".<br>"
					+ "$4.\\ "+getNumberOfChildren() +"$ विद्यार्थी, हे उत्तर. <br>" ;
			String Solution = " "+Solu+" "+Sol1+" ";
			System.out.println(Solution);		 
			row.createCell(16).setCellValue(Solution);
			//			  row.createCell(17).setCellValue(" ");
			row.createCell(18).setCellValue(108);

			mapsize = map.size();
			map.put(Question, i);
			mapsizeafter = map.size();

			//In Java, a map can consist of virtually any number of key-value pairs, but the keys must always be unique — non-repeating.
			if(mapsize == mapsizeafter) {
				System.out.println("duplicate Question"+i+". " + Question);
				i--;
			}

			if(Correct_ans.equalsIgnoreCase(wrong_ans)||Correct_ans.equalsIgnoreCase(wrong_ans1)||Correct_ans.equalsIgnoreCase(wrong_ans2)||wrong_ans.equalsIgnoreCase(wrong_ans1)||wrong_ans.equalsIgnoreCase(wrong_ans2)||wrong_ans1.equalsIgnoreCase(wrong_ans2)) {
				System.out.println("duplicate"+ i);  
				i--;
			}


		}

		sc.close();

		int rowTotal = sheet1.getLastRowNum();
		//		  System.out.println(rowTotal);
		XSSFRow row = sheet1.createRow((short)rowTotal+1);
		row.createCell(0).setCellValue("****");

		//Writing data to the file
		try (FileOutputStream fileout = new FileOutputStream(filename)) {
			workbook.write(fileout);
		}

		System.out.println("file created");

	}
	//method for generate random fruit index and size in the fruit
	private static String fruitName(int fruitNumber) {
		StringBuilder entry = new StringBuilder();
		for (int i = 0; i < fruitNumber; i++) {
			int index = RandomFruitIndex[i];
			int count = RandomFruitCount[i];
			entry.append("<tr><td style=\"border-width: 2px; border-color: black;\">")
			.append(FruitsE[index]).append("/").append(FruitsM[index])
			.append("</td><td style=\"border-width: 2px; border-color: black;\">")
			.append(formatTally(count))
			.append("</td></tr>\n");
		}
		return entry.toString();
	}
	//generate tally mark in the question
	private static String formatTally(int count) {
		StringBuilder sb = new StringBuilder();
		sb.append("<span style='font-size:25px; font-weight:10px; gap:2px;'>");
		for (int i = 1; i <= count; i++) {

			sb.append("| ");

		}
		sb.append("</span>");
		return sb.toString();
	}
	//generate right fruit list in our question fruit in English
	private static String getFruitE() {
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < RandomFruitIndex.length; i++) {
			sb.append(FruitsE[RandomFruitIndex[i]]);
			if (i != RandomFruitIndex.length - 1) {
				sb.append(", ");
			}
		}
		return sb.toString();
	}
	//fruit in marathi
	private static String getFruitM() {
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < RandomFruitIndex.length; i++) {
			sb.append(FruitsM[RandomFruitIndex[i]]);
			if (i != RandomFruitIndex.length - 1) {
				sb.append(", ");
			}
		}
		return sb.toString();
	}
	//generate wrong fruit 1 list in our question fruit in English
	private static String getWrongFruitE1() {
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < RandomFruitIndex.length; i++) {
			sb.append(FruitsE[i]);
			if (i != RandomFruitIndex.length - 1) {
				sb.append(", ");
			}
		}
		return sb.toString();
	}
	//wrong fruit in marathi
	private static String getWrongFruitM1() {
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < RandomFruitIndex.length; i++) {
			sb.append(FruitsM[i]);
			if (i != RandomFruitIndex.length - 1) {
				sb.append(", ");
			}
		}
		return sb.toString();
	}
	//generate wrong fruit 2 list in our question fruit in English
	private static String getWrongFruitE2() {
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < RandomFruitIndex.length; i++) {
			sb.append(FruitsE[i+1]);
			if (i != RandomFruitIndex.length - 1) {
				sb.append(", ");
			}
		}
		return sb.toString();
	}
	//wrong fruit 2 in marathi
	private static String getWrongFruitM2() {
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < RandomFruitIndex.length; i++) {
			sb.append(FruitsM[i+1]);
			if (i != RandomFruitIndex.length - 1) {
				sb.append(", ");
			}
		}
		return sb.toString();
	}
	//generate wrong fruit 3 list in our question fruit in English
	private static String getWrongFruitE3() {
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < RandomFruitIndex.length; i++) {
			sb.append(FruitsE[i+2]);
			if (i != RandomFruitIndex.length - 1) {
				sb.append(", ");
			}
		}
		return sb.toString();
	}
	//wrong fruit 3 in marathi
	private static String getWrongFruitM3() {
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < RandomFruitIndex.length; i++) {
			sb.append(FruitsM[i+2]);
			if (i != RandomFruitIndex.length - 1) {
				sb.append(", ");
			}
		}
		return sb.toString();
	}
	//3 ans to get the not like many student fruit from student give fruit
	static int min;
	private static String getMinFruitE() {
		min=RandomFruitCount[0];
		int index=0;
		for(int i=1;i<RandomFruitCount.length;i++) {
			if(RandomFruitCount[i]<min) {
				min=RandomFruitCount[i];
				index=i;
			}
		}
		return FruitsE[RandomFruitIndex[index]];
	}
	//minimum fruit found in marathi
	private static String getMinFruitM() {
		min=RandomFruitCount[0];
		int index=0;
		for(int i=1;i<RandomFruitCount.length;i++) {
			if(RandomFruitCount[i]<min) {
				min=RandomFruitCount[i];
				index=i;
			}
		}
		return FruitsM[RandomFruitIndex[index]];
	}
	//to number of total student in that school
	private static int getNumberOfChildren() {
		int total=0;
		for(int a:RandomFruitCount) {
			total+=a;
		}
		return total;
	}
	//torepresent string of calculate children
	private static String getCalculationChildren() {
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < RandomFruitCount.length; i++) {
			sb.append(RandomFruitCount[i]);
			if (i < RandomFruitCount.length - 1) {
				sb.append("+");
			}
		}
		return sb.toString();
	}

}
