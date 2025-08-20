package com.coep.genericque;

import java.util.Random;
import java.util.*;

public class DemoMain {
	static int[] RandomFruitIndex;
	static int[] RandomFruitCount;

	static String FruitsE[] = {"mango", "apple", "orange", "guava", "pomegranate", "custard apple", "banana", "strawberry", "sweet lime", "cheeku"};
	static String FruitsM[] = {"आंबा", "सफरचंद", "संत्रं", "पेरू", "डाळिंब", "सीताफळ", "केळं", "स्ट्रॉबेरी", "मोसंबी", "चिकू"};

	public static void main(String[] args) {
		Random random = new Random();

		int fruitNumber = random.nextInt(3) + 3; // 3 to 5 fruits
		System.out.println("Number of fruits: " + fruitNumber);

		// Step 1: Create list of indices and shuffle
		List<Integer> indexList = new ArrayList<>();
		for (int i = 0; i < FruitsE.length; i++) {
			indexList.add(i);
		}
		Collections.shuffle(indexList); // randomize

		// Step 2: Take first 'fruitNumber' indices (they are guaranteed unique)
		RandomFruitIndex = new int[fruitNumber];
		RandomFruitCount = new int[fruitNumber];
		for (int k = 0; k < fruitNumber; k++) {
			RandomFruitIndex[k] = indexList.get(k);
			RandomFruitCount[k] = random.nextInt(9) + 1; // 1 to 9 count
		}

		//generate the radnom one fruit of our select fruit
		int randomIndexFromSelected = random.nextInt(RandomFruitIndex.length); 
		int fruitArrayIndex = RandomFruitIndex[randomIndexFromSelected];



		//Generate question english
		String Que = "In class $3$ of Prabhukrupa Primary School, everyone is asked about the fruit they like. Based on there answer a table was prepared in form of tally chart as given here.<br>\r\n"
				+ "Based on this tally chart, find out,<br>\r\n"
				+ "$1.$ Name of different fruits they like.<br>\r\n"
				+ "$2.$ How many of them liked " + FruitsE[fruitArrayIndex] + ".<br>\r\n"
				+ "$3.$ Which is the fruit not liked by many.<br>\r\n"
				+ "$4.$ Number of children to whom the question was asked.<br>";
		//Generate question marathi
		String Que1 = "#\r\n"
				+ "प्रभुकृपा शाळेतील तिसरीच्या वर्गातील प्रत्येक विद्यार्थ्याला कोणते फळ आवडते असा प्रश्न विचारण्यात आला. त्यांच्या उत्तरांवर आधारित खाली दिलेले ताळ्याचा तक्ता बनविला.<br>\r\n"
				+ "या तक्त्या नुसार पुढील माहिती शोधा.<br>$1.$ मुलांना आवडणाऱ्या फळांची नावे.<br>\r\n"
				+ "$2.$ " + FruitsM[fruitArrayIndex] + " आवडणाऱ्या मुलांची संख्या.<br>\r\n"
				+ "$3.$ सगळ्यात कमी आवडणारे फळ.<br>\r\n"
				+ "$4.$ प्रश्न विचारलेल्या मुलांची एकूण संख्या.<br>";
		String Que2="<table border='2' style='border-collapse: collapse; text-align: center; width: 100%;'>\r\n"
				+ "<tr><th>Fruit Name/<br>फळांची नावे </th><th>tally chart/<br>ताळ्याचा तक्ता</th></tr>\r\n"
				+ fruitName(fruitNumber)+"</table>";
		String Question=Que+" "+Que1+" "+Que2;
		System.out.println(Question);


		//Generate Correct answer
		String Correct_ans = "$1.$ "+getFruitE()+".<br>"
				+ "$2.$ Children who like " + FruitsE[fruitArrayIndex] + " is $" + RandomFruitCount[randomIndexFromSelected] + "$<br>"
				+ "$3.$ " +getMinFruitE()+".<br>"
				+ "$4.\\"+" "+ getNumberOfChildren() + "$.<br>"
				+ "#$1.$"+getFruitM()+".<br>"
				+ "#$2.$ " + FruitsE[fruitArrayIndex] + " आवडणाऱ्या मुलांची संख्या $" + RandomFruitCount[randomIndexFromSelected] + "$.<br>"
				+ "#$3.$ " +getMinFruitM()+".<br>"
				+ "#$4.\\"+" "+ getNumberOfChildren() + "$.<br>";

		int wrongIndex1 = (randomIndexFromSelected + 1) % RandomFruitIndex.length;
		int wrongIndex2 = (randomIndexFromSelected + 2) % RandomFruitIndex.length;
		int wrongIndex3 = (randomIndexFromSelected + 3) % RandomFruitIndex.length;

		int fruitIndex1 = RandomFruitIndex[wrongIndex1];
		int fruitIndex2 = RandomFruitIndex[wrongIndex2];
		int fruitIndex3 = RandomFruitIndex[wrongIndex3];

		//Generate wrong options 1
		String wrong_ans = "$1.$"+getFruitE()+".<br>"
				+ "$2.$ NUMBER OF children who like " + FruitsE[fruitIndex1] + " is $" + RandomFruitCount[wrongIndex1] + "$.<br>"
				+ "$3.$ " +getMinFruitE()+".<br>"
				+ "$4.\\"+" "+ (getNumberOfChildren()-1) + "$.<br>"
				+ "#$1.$"+getFruitM()+".<br>"
				+ "#$2.$ " + FruitsM[fruitIndex1] + " आवडणाऱ्या मुलांची संख्या $" + RandomFruitCount[wrongIndex1] + "$.<br>"
				+ "#$3.$ " +getMinFruitM()+".<br>"
				+ "#$4.\\"+" "+ (getNumberOfChildren()-1) + "$.<br>";

		//Generate wrong options 2
		String wrong_ans1 = "$1.$"+getFruitE()+".<br>"
				+ "$2.$ NUMBER OF children who like " + FruitsE[fruitIndex2] + " is $" + RandomFruitCount[wrongIndex2] + "$.<br>"
				+ "$3.$ " +getMinFruitE()+".<br>"
				+ "$4.\\"+" "+ (getNumberOfChildren()+5) + "$.<br>"
				+ "#$1.$"+getFruitM()+".<br>"
				+ "#$2.$ " + FruitsM[fruitIndex2] + " आवडणाऱ्या मुलांची संख्या $" + RandomFruitCount[wrongIndex2] + "$.<br>"
				+ "#$3.$ " +getMinFruitM()+".<br>"
				+ "#$4.\\"+" "+(getNumberOfChildren()+5) + "$.<br>";

		//Generate wrong options 3
		String wrong_ans2 = "$1.$"+getFruitE()+".<br>"
				+ "$2.$ NUMBER OF children who like " + FruitsE[fruitIndex3] + " is $" + RandomFruitCount[wrongIndex3] + "$.<br>"
				+ "$3.$ " +getMinFruitE()+".<br>"
				+ "$4.\\"+" "+(getNumberOfChildren()-3) + "$.<br>"
				+ "#$1.$"+getFruitM()+".<br>"
				+ "#$2.$ " + FruitsM[fruitIndex3] + " आवडणाऱ्या मुलांची संख्या $" + RandomFruitCount[wrongIndex3] + "$.<br>"
				+ "#$3.$ " +getMinFruitM()+".<br>"
				+ "#$4.\\"+" "+(getNumberOfChildren()-3) + "$.<br>";
//		System.out.println(Correct_ans);
//		System.out.println(wrong_ans);
//		System.out.println(wrong_ans1);
//		System.out.println(wrong_ans2);

		//Generate Solution
		String Solu = "<b>Ans</b> : <br>"
				+ "$1.$ "+getFruitE()+".<br>"
				+ "$2.$ Children who like " + FruitsE[fruitArrayIndex] + " is $" + RandomFruitCount[randomIndexFromSelected] + "$<br>"
				+ "$3.$ "+getMinFruitE()+"<br>"
				+ "$4.\\ " + getNumberOfChildren() +"$<br>"
				+ "By listing fruits mentioned in the tally chart, we get the list of fruits, which children like.<br>"
				+ "These fruits are "+getFruitE()+". $. . . . (i)$<br>"
				+ "Counting the tally marks in the row for " + FruitsE[fruitArrayIndex] + ", it will tell us number of children who like " + FruitsE[fruitArrayIndex] + ".<br>"
				+ "These are $" + RandomFruitCount[randomIndexFromSelected] + "$ tally marks.<br>"
				+ "Therefore $" + RandomFruitCount[randomIndexFromSelected] + "$ children like " + FruitsE[fruitArrayIndex] + ". $. . . . . (ii)$<br>"
				+ "The fruit which is liked least, is the row corresponding to the fruit which has minimum tally marks.<br>"
				+ "Such fruit is "+getMinFruitE()+", as it has only "+min+" tally mark.<br>"
				+ "Hence, "+getMinFruitE()+" is the fruit which is liked least. $. . . . (iii)$<br>"
				+ "To find the number of children, who were asked this question, we will add all the tally marks in all rows.<br>"
				+ "<b>As each tally mark represent one child.</b><br>"
				+ "This sum is $"+getCalculationChildren()+" = " + getNumberOfChildren() + "$.<br>"
				+ "Hence $" + getNumberOfChildren() + "$ children were asked this question.$.. . . . (iv)$<br>"
				+ "Hence, according to $(i , ii, iii)$ and $(iv)$ <br>"
				+  getFruitE()+"<Br>"
				+ "$2.$ Children who like " + FruitsE[fruitArrayIndex] + " $" + RandomFruitCount[randomIndexFromSelected] + "$<br>"
				+ "$3.$"+ getMinFruitE()+"<br>"
				+ "$4.\\ "+getNumberOfChildren()+"$ is the answer.<br>";
		String Sol1 = "<b>#उत्तर :</b> <br>"
				+ "#$1.$ "+getFruitM()+"<br>"
				+ "#$2.$ " + FruitsM[fruitArrayIndex] + " आवडणाऱ्या मुलांची संख्या $" + RandomFruitCount[randomIndexFromSelected] + "$<br>"
				+ "#$3.$ "+getMinFruitM()+"<Br>"
				+ "#$4.\\ " + getNumberOfChildren() +"$<br>"
				+ "दिलेल्या ताळ्याचा तक्त्यातील फळांची यादी केली म्हणजे मुलांना आवडणारी फळे कोणती, हे कळेल.<br>"
				+ "ही फळे "+getFruitM()+" , अशी आहेत. $. . . . (i)$<br>"
				+  FruitsM[fruitArrayIndex] + " या फळाच्या ओळीतील ताळ्याच्या खुणा मोजल्या म्हणजे आपल्याला किती मुलांना " + FruitsM[fruitArrayIndex] + " आवडतो हे समजेल.<br>या ओळीतील एकूण खुणा $" + RandomFruitCount[randomIndexFromSelected] +"$ आहेत.<br>"
				+ "म्हणजे " + FruitsM[fruitArrayIndex] + " आवडणारी एकूण मुले $" + RandomFruitCount[randomIndexFromSelected] + "$ आहेत$. . . . . (ii)$<br>\r\n"
				+ "जे फळ सगळ्यात कमी आवडते, म्हणजे ज्या फळाच्या ओळीत सगळ्यात कमी ताळ्याच्या खुणा आहेत, असे फळ.<br>"
				+ "असे फळ म्हणजे "+getMinFruitM()+". या फळाच्या ओळीत फक्त "+min+" ताळ्याची खूण आहे.<br>"
				+ "म्हणून, "+getMinFruitM()+" हे सर्वात कमी आवडणारे फळ आहे $. . . . (iii)$<br>"
				+ "प्रश्न विचारलेल्या मुलांची एकूण संख्या शोधण्यासाठी सर्व ओळीतील ताळ्याच्या खुणांची बेरीज केली असता आपल्याला एकूण मुलांची संख्या कळेल.<br>\r\n"
				+ "ही बेरीज $"+getCalculationChildren()+" = "+getNumberOfChildren()+"$ अशी मिळते.<br>"
				+ "म्हणून प्रश्न विचारलेल्या मुलांची एकूण संख्या $"+getNumberOfChildren()+"$ आहे $.. . . . (iv)$<br>"
				+ "$(i , ii, iii)$ आणि $(iv)$ नुसार<br>"
				+ "#$1.$ "+getFruitM()+"<Br>"
				+ "#$2.$ "+ FruitsM[fruitArrayIndex] +" आवडणाऱ्या मुलांची संख्या $ " + RandomFruitCount[randomIndexFromSelected] + "$<Br>"
				+ "#$3.$ "+getMinFruitM()+"<br>"
				+ "#$4.\\ " + getNumberOfChildren() +" $ हे उत्तर. <br>" ;
		String Solution = " "+Solu+" "+Sol1+" ";
		//System.out.println(Solution);
	}
	//generate 1 question answer fruit in English
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
	//to generate fruit and student count
	private static String fruitName(int fruitNumber) {
		StringBuilder entry = new StringBuilder();
		for (int i = 0; i < fruitNumber; i++) {
			int index = RandomFruitIndex[i];
			int count = RandomFruitCount[i];
			entry.append("<tr><td>")
			.append(FruitsE[index]).append("/").append(FruitsM[index])
			.append("</td><td>")
			.append(formatTally(count))
			.append("</td></tr>\n");
		}
		return entry.toString();
	}

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
