package fr.emile.test;

import java.util.Date;

import org.hibernate.Session;

import fr.emile.common.IConstant;
import fr.emile.model.connect.DBConnect;
import fr.emile.utils.DataTest;
import fr.emile.utils.Utils;

public class TUnit implements IConstant {

	public static void main(String[] args) {

		Utils.trace("--------------- begin -----------------------------------");
//		Session session = DBConnect.getSession();

//		Utils.trace(DataTest.genOrderNumber(1));
		double value = 10.2 /2;
		System.out.printf("%.2f\n",value);
		
//		DisplaySentense();
//		DisplayArticle() ;
//		DisplayCategory();
//		DisplayItemName();

		Utils.trace("--------------- end -----------------------------------");
	}

	public void Connection() {
//		Session session = DBConnect.getSession();

	}

	public void addDate() {
//		Session session = DBConnect.getSession();
		Date date = Utils.addDate(DATE_NOW, 3);
		Utils.trace("now : "+ Utils.date2String(DATE_NOW,"dd/MM/yyyy"));
		Utils.trace(" add :"+Utils.date2String(date,"dd/MM/yyyy"));

	}

	public static void DisplaySentense() {

//		Utils.trace(String.format("%s %s %s %s %s %s", DataTest.sentenceVerb(), DataTest.sentenseSubject(),
//				DataTest.sentenseAdjective(), DataTest.sentenseObject(), DataTest.sentenseAdverb()));

		Utils.trace(DataTest.sentence());
		
	}

	public static void DisplayCategory() {
		Utils.trace(DataTest.categoryName());

	}

	public static void DisplayArticle() {
		Utils.trace(DataTest.article());

	}

	public static void DisplayItemName() {
		Utils.trace(DataTest.itemName());

	}

}
