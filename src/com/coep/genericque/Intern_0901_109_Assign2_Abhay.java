package com.coep.genericque;


import java.io.File;
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

public class Intern_0901_109_Assign2_Abhay {
	//global array declare for use in multiple method
	static int[] Index;
	static int[] Count;
	//array of Fruit
	static String FruitPlantE[] = {"mango", "apple", "orange", "guava", "pomegranate", "custard apple", "banana", "strawberry", "sweet lime", "cheeku","Rose", "Lily", "Daisy", "Sunflower", "Tulip","Rose plant","Jasmine plant", "Plumeria plant ",  "Marigold plant","Sunflower plant","Brinjal","Potato","Onion", "Tomato","Capsicum","Bitter gourd"};
	static String FruitPlantM[] = {"आंबा", "सफरचंद", "संत्रं", "पेरू", "डाळिंब", "सीताफळ", "केळं", "स्ट्रॉबेरी", "मोसंब", "चिकू","गुलाब", "लिली", "डेझी", "सूर्यफूल", "ट्यूलिप","गुलाबाचे झाड", "मोगऱ्याचे झाड", "चाफ्याचे झाड", "झेंडूचे झाड", "सूर्यफुलाचे झाड","वांगी","बटाटा",  "कांदा", "टोमॅटो", "शिमला मिर्ची", "कारले" };

	public static void main(String[] args)throws IOException,FileNotFoundException {
		File dir = new File("Excel");
		if (!dir.exists()) {
			dir.mkdirs(); // creates the folder
		}
		String filename = "Excel//Intern_0901_108_Assign2_Abhay.xlsx";     //Location where excel file is getting generated
		XSSFWorkbook workbook = new XSSFWorkbook();
		XSSFSheet sheet = workbook.createSheet("Instruction");      //Generating first sheet as Instruction

		XSSFSheet sheet1 = workbook.createSheet("Questions");       //Generating second sheet as Questions

		//Adding first row in second sheet(Questions)
		String[] header = {"Sr. No","Question Type","Answer Type","Topic Number","Question (Text Only)","Correct Answer 1","Correct Answer 2",
				"Correct Answer 3","Correct Answer 4","Wrong Answer 1","Wrong Answer 2","Wrong Answer 3","Time in seconds","Difficulty Level",
				"Question (Image/ Audio/ Video)","Contributor's Registered mailId","Solution (Text Only)","Solution (Image/ Audio/ Video)","Variation Number"};
		XSSFRow rowhead = sheet1.createRow((short)0);	

		//Set height and width to the column and row
		//sheet1.setColumnWidth(4, 35*250);
		//sheet1.setColumnWidth(16, 45*250);

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
			for (int j = 0; j < FruitPlantE.length; j++) {
				indexList.add(j);
			}
			Collections.shuffle(indexList); // randomize

			// Step 2: Take first 'fruitNumber' indices (they are guaranteed unique)
			Index = new int[fruitNumber];
			Count = new int[fruitNumber];
			for (int k = 0; k < fruitNumber; k++) {
				Index[k] = indexList.get(k);
				Count[k] = random.nextInt(9) + 1; // 1 to 9 count
			}
			List<Integer> uniqueCounts = new ArrayList<>();
			for (int k = 1; k <= 9; k++) {
				uniqueCounts.add(k);
			}
			Collections.shuffle(uniqueCounts); // Randomize the list


			//generate the radnom one fruit of our select fruit
			int randomIndexFromSelected = random.nextInt(Index.length); 
			int fruitArrayIndex = Index[randomIndexFromSelected];

			//Generate question english
			String Que = "To display the number of different flower plants in a garden a table is prepared with tally marks as shown in the fugure. From the table decide the type and number of plants which are maximum<br>";
			//Generate question marathi
			String Que1 = "एका बागेतील	वेगवेगळ्या प्रकारच्य	फुलझाडांची संख्या दाखवण्यासाठी खालील तक्त्यात दाखवलेल्या प्रमाणे त्याच्या खुणा केलेल्या आहेत.तर बागेत सर्वात जास्त कोणत्या फुलांची आणि किती झाडे आहेत ते तक्त्यावरून उत्तर द्या. <br>"; 
			String Que2="<table border='2' style='border-collapse: collapse; text-align: center; width: 100%;'>\r\n"
					+ "<tr><th>Names /<br>नावे </th><th>tally chart/<br>ताळ्याचा तक्ता</th></tr>"
					+ fruitPlantNameE(fruitNumber)+"</table>";
			String Question=Que+" "+Que1+" "+Que2;
			System.out.println(Question);

			//Generate Correct answer
			String Correct_ans = maxCountFruitE()+"= "+max;

			int wrongIndex1 = (randomIndexFromSelected + 1) % Index.length;
			int wrongIndex2 = (randomIndexFromSelected + 2) % Index.length;
			int wrongIndex3 = (randomIndexFromSelected + 3) % Index.length;

			//Generate wrong options 1
			String wrong_ans = FruitPlantE[wrongIndex1]+"= "+(max+1);
			//System.out.println(wrong_ans);
			//Generate wrong options 2
			String wrong_ans1 = FruitPlantE[wrongIndex2]+"= "+(max+5);
			//System.out.println(wrong_ans1);

			//Generate wrong options 3
			String wrong_ans2 = FruitPlantE[wrongIndex3]+"= "+(max-3);
			//System.out.println(wrong_ans2);


			row.createCell(4).setCellValue(Question);
			row.createCell(5).setCellValue(Correct_ans);
			row.createCell(6).setCellValue(" ");
			row.createCell(7).setCellValue(" ");
			row.createCell(8).setCellValue(" ");
			row.createCell(9).setCellValue(wrong_ans);
			row.createCell(10).setCellValue(wrong_ans1);
			row.createCell(11).setCellValue(wrong_ans2);
			row.createCell(12).setCellValue(150);
			row.createCell(13).setCellValue(3);
			//			  row.createCell(14).setCellValue(" ");
			row.createCell(15).setCellValue("abhaygadge8@gmail.com");

			//Generate Solution
			String Sol ="<b>Ans : </b><br>Maximum plants - "+FruitPlantE[Index[randomIndexFromSelected]]+", No. of plants - $"+Count[randomIndexFromSelected]+"$<br>"
					+ "To decide the number of flower plants of each type, we will count the"
					+ "tally marks for each type.<br>"
					+ "They are "+getFruitWithCountE()
					+ FruitPlantE[Index[randomIndexFromSelected]]+" plants are $"+Count[randomIndexFromSelected]+"$ and they are maximum.<br>"
					+ "Hence the Answer is - Maximum palnts - "+FruitPlantE[Index[randomIndexFromSelected]]+", and Number of"
					+ "plants $"+Count[randomIndexFromSelected]+"$ is the answer.<br># ";
			String Sol1 = " ";
			String Solution =Sol+" "+Sol1;
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
		row.createCell(0).setCellValue("");

		//Writing data to the file
		try (FileOutputStream fileout = new FileOutputStream(filename)) {
			workbook.write(fileout);
		}

		System.out.println("file created");

	}
	//get all fruit and plant name
	private static String getFruitWithCountE() {
		StringBuilder sb=new StringBuilder();
		for(int i=0;i<Count.length;i++) {
			sb.append(FruitPlantE[i]).append("=").append(Count[i]);
			if(i<Count.length-1) {
				sb.append(", ");
			}
		}
		return sb.toString();
	}
	//global maximum value
	static int max;
	//count maximum fruitPlant english
	private static String maxCountFruitE() {
		max=Count[0];
		int index=0;
		for(int i=1;i<Count.length;i++) {
			if(Count[i]>max) {
				max=Count[i];
				index=i;
			}
		}
		return FruitPlantE[Index[index]];

	}
	//count maximum fruitPlant in marathi
	private static String maxCountFruitM() {
		max=Count[0];
		int index=0;
		for(int i=1;i<Count.length;i++) {
			if(Count[i]>max) {
				max=Count[i];
				index=i;
			}
		}
		return FruitPlantM[Index[index]];

	}
	//method for generate random fruit index and size in the fruit
	private static String fruitPlantNameE(int fruitNumber) {
		StringBuilder entry = new StringBuilder();
		for (int i = 0; i < fruitNumber; i++) {
			int index = Index[i];
			int count = Count[i];
			entry.append("<tr><td>")
			.append(FruitPlantE[index]).append("/").append(FruitPlantM[index])
			.append("</td><td>")
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
}
