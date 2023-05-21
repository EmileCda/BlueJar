package fr.emile.test;

import org.hibernate.Session;

import fr.emile.model.connect.DBConnect;
import fr.emile.utils.DataTest;
import fr.emile.utils.Utils;

public class TUnit {

	public static void main(String[] args) {

		Utils.trace("--------------- begin -----------------------------------");
//		Session session = DBConnect.getSession();

		DisplaySentense();
		DisplaySentense();
		DisplaySentense();
		DisplaySentense();

//		DisplayArticle() ;
//		DisplayCategory();
//		DisplayItemName();

		Utils.trace("--------------- end -----------------------------------");
	}

	public void Connection() {
//		Session session = DBConnect.getSession();

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
