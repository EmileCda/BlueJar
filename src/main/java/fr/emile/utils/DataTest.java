package fr.emile.utils;

import java.time.Duration;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.ResourceBundle;
import java.util.concurrent.TimeUnit;

import fr.emile.common.IConstant;
import fr.emile.entity.Address;
import fr.emile.entity.BankCard;
import fr.emile.entity.Comment;
import fr.emile.entity.Item;
import fr.emile.entity.Order;
import fr.emile.entity.User;
import fr.emile.entity.Category;

import fr.emile.enums.Gender;
import fr.emile.enums.Profile;
import fr.emile.utils.Utils;

public final class DataTest implements IConstant {

	private static List<String> firstnameList;
	private static List<String> lastnameList;
	private static List<String> numberTypeList;
	private static List<String> streetNameList;
	private static List<String> cityList;
	private static List<String> streetTypeList;
	private static List<String> domainList;
	private static List<String> domainExtensionList;
	private static List<String> articleList;
	private static List<String> commentList;
	private static List<String> categoryList;
	private static List<String> itemList;

	private static List<String> sentenseSubjectListOneMale;
	private static List<String> verbListOneMale;
	private static List<String> sentenseAdverbListOneMale;
	private static List<String> sentenseObjectListOneMale;
	private static List<String> sentenseAdjectiveListOneMale;

	private static List<String> sentenseSubjectListOneFemale;
	private static List<String> verbListOneFemale;
	private static List<String> sentenseAdverbListOneFemale;
	private static List<String> sentenseObjectListOneFemale;
	private static List<String> sentenseAdjectiveListOneFemale;

	private static List<String> sentenseSubjectListManyMale;
	private static List<String> verbListManyMale;
	private static List<String> sentenseAdverbListManyMale;
	private static List<String> sentenseObjectListManyMale;
	private static List<String> sentenseAdjectiveListManyMale;

	private static List<String> sentenseSubjectListManyFemale;
	private static List<String> verbListManyFemale;
	private static List<String> sentenseAdverbListManyFemale;
	private static List<String> sentenseObjectListManyFemale;
	private static List<String> sentenseAdjectiveListManyFemale;

	// ---------------------------------------------------------------------------------------------------
	public static Category genCategory() {

		return new Category(DataTest.categoryName(), Utils.randInt(5, 90), Utils.randInt(0, 1) > 0 ? true : false,
				DataTest.picUrl());

	}

	// ---------------------------------------------------------------------------------------------------
	public static String genOrderNumber(int id) {
		
		
		return String.format("DT%s-ID%d-RN%06d-FR",Utils.date2String(DATE_NOW, "yyyyMMdd"),id,Utils.randInt(0, 999999) );
		
		
	}

	// ---------------------------------------------------------------------------------------------------
	public static Comment genComment() {
		return new Comment (DataTest.sentence(), Utils.randInt(0, 5));
	}

	// ---------------------------------------------------------------------------------------------------
	public static BankCard genBankCardNoName() {

		BankCard myBankCard = new BankCard();
		int bin = Utils.randInt(111111, 999999);
		int digit3 = Utils.randInt(0, 999);
		int digit8 = Utils.randInt(11111111, 99999999);

		myBankCard.setCardClairNumber(String.format("%06d%08d", bin, digit8));
		Date startDate = Utils.string2Date("01/01/2023", "dd/MM/yyyy");
		Date endDate = Utils.string2Date("01/01/2025", "dd/MM/yyyy");
		myBankCard.setExpiryDateJava(DataTest.date(startDate, endDate));
		myBankCard.setClairCrypto(String.format("%03d", digit3));

		return myBankCard;
	}

	// ---------------------------------------------------------------------------------------------------
	public static BankCard genBankCard() {

		BankCard myBankCard = new BankCard();

		myBankCard = DataTest.genBankCardNoName();

		Gender gender = DataTest.gender();
		String firstname1 = DataTest.firstname(gender);
		String lastname = DataTest.lastname();

		myBankCard.setOwnerGender(gender);
		myBankCard.setOwnerFirstname(firstname1);
		myBankCard.setOwnerLastname(lastname);

		return myBankCard;
	}

	// ---------------------------------------------------------------------------------------------------
	public static User genUser() {

		Date startDate = Utils.string2Date("01/01/1900", "dd/MM/yyyy");
		Date endDate = Utils.string2Date("01/01/2023", "dd/MM/yyyy");
		Gender gender = DataTest.gender();
		String firstname = DataTest.firstname(gender);
		String lastname = DataTest.lastname();

		return new User(gender, firstname, lastname, DataTest.date(startDate, endDate), DataTest.profile(),
				DataTest.email(firstname, lastname), DataTest.pass(firstname), DataTest.phone());

	}

	// ---------------------------------------------------------------------------------------------------
	public static Item genItem() {
		return new Item(DataTest.itemName(), DataTest.sentence(), Utils.randInt(1, 1000) / 10.0, Utils.randInt(0, 99),
				Utils.randInt(0, 9999), DataTest.picUrl(), DataTest.videoUrl());

	}

//---------------------------------------------------------------------------------------------------
	public static Address genAddress() {

		return new Address(DataTest.number(), DataTest.numberType(), DataTest.streetType(), DataTest.street(),
				DataTest.city(), DataTest.zipcode());
	}

	// ---------------------------------------------------------------------------------------------------
	public static String sentence() {

		int sujectType = subjectType();

		return (String.format(" %s %s %s %s ", DataTest.subject(sujectType),
				DataTest.verb(sujectType), DataTest.subject(sujectType), DataTest.complement(sujectType)
				));

	}

	// ---------------------------------------------------------------------------------------------------

	public static int subjectType() {
		return Utils.randInt(0, 3);

	}

	// ---------------------------------------------------------------------------------------------------
	private static List<String> subjectOneMaleList;
	private static List<String> subjectOneFemalebList;
	private static List<String> subjectManyMaleList;
	private static List<String> subjectManyFemaleList;

	public static String subject(int sentenseType) {

		switch (sentenseType) {

		case 1: return DataTest.subjectOneFemale();
		case 2: return DataTest.subjectManyMale();
		case 3: return DataTest.subjectManyFemale();
		default: return DataTest.subjectOneMale();

		}

	}

	// ---------------------------------------------------------------------------------------------------
	public static String subjectOneMale() {
		DataTest.subjectOneMaleList = InitList(DataTest.subjectOneMaleList, "sentense.subject.one.male");
		int position = Utils.randInt(0, DataTest.subjectOneMaleList.size() - 1);
		return DataTest.subjectOneMaleList.get(position);

	}
	// ---------------------------------------------------------------------------------------------------
	public static String subjectOneFemale() {
		DataTest.subjectOneFemalebList = InitList(DataTest.subjectOneFemalebList, "sentense.subject.one.female");
		int position = Utils.randInt(0, DataTest.subjectOneFemalebList.size() - 1);
		return DataTest.subjectOneFemalebList.get(position);

	}
	// ---------------------------------------------------------------------------------------------------
	public static String subjectManyMale() {
		DataTest.subjectManyMaleList = InitList(DataTest.subjectManyMaleList, "sentense.subject.many.male");
		int position = Utils.randInt(0, DataTest.subjectManyMaleList.size() - 1);
		return DataTest.subjectManyMaleList.get(position);

	}
	// ---------------------------------------------------------------------------------------------------
	public static String subjectManyFemale() {
		DataTest.subjectManyFemaleList = InitList(DataTest.subjectManyFemaleList, "sentense.subject.many.female");
		int position = Utils.randInt(0, DataTest.subjectManyFemaleList.size() - 1);
		return DataTest.subjectManyFemaleList.get(position);

	}
	
	
	private static List<String> verbOneMaleList;
	private static List<String> verbOneFemalebList;
	private static List<String> verbManyMaleList;
	private static List<String> verbManyFemaleList;

	public static String verb(int sentenseType) {

		switch (sentenseType) {

		case 1: return DataTest.verbOneFemale();
		case 2: return DataTest.verbManyMale();
		case 3: return DataTest.verbManyFemale();
		default: return DataTest.verbOneMale();

		}

	}

	// ---------------------------------------------------------------------------------------------------
	public static String verbOneMale() {
		DataTest.verbOneMaleList = InitList(DataTest.verbOneMaleList, "sentense.verb.one.male");
		int position = Utils.randInt(0, DataTest.verbOneMaleList.size() - 1);
		return DataTest.verbOneMaleList.get(position);

	}
	// ---------------------------------------------------------------------------------------------------
	public static String verbOneFemale() {
		DataTest.verbOneFemalebList = InitList(DataTest.verbOneFemalebList, "sentense.verb.one.female");
		int position = Utils.randInt(0, DataTest.verbOneFemalebList.size() - 1);
		return DataTest.verbOneFemalebList.get(position);

	}
	// ---------------------------------------------------------------------------------------------------
	public static String verbManyMale() {
		DataTest.verbManyMaleList = InitList(DataTest.verbManyMaleList, "sentense.verb.many.male");
		int position = Utils.randInt(0, DataTest.verbManyMaleList.size() - 1);
		return DataTest.verbManyMaleList.get(position);

	}
	// ---------------------------------------------------------------------------------------------------
	public static String verbManyFemale() {
		DataTest.verbManyFemaleList = InitList(DataTest.verbManyFemaleList, "sentense.verb.many.female");
		int position = Utils.randInt(0, DataTest.verbManyFemaleList.size() - 1);
		return DataTest.verbManyFemaleList.get(position);

	}

	
	// ---------------------------------------------------------------------------------------------------
	

	private static List<String> complementOneMaleList;
	private static List<String> complementOneFemalebList;
	private static List<String> complementManyMaleList;
	private static List<String> complementManyFemaleList;

	public static String complement(int sentenseType) {

		switch (sentenseType) {

		case 1: return DataTest.complementOneFemale();
		case 2: return DataTest.complementManyMale();
		case 3: return DataTest.complementManyFemale();
		default: return DataTest.complementOneMale();

		}

	}

	// ---------------------------------------------------------------------------------------------------
	public static String complementOneMale() {
		DataTest.complementOneMaleList = InitList(DataTest.complementOneMaleList, "sentense.complement.one.male");
		int position = Utils.randInt(0, DataTest.complementOneMaleList.size() - 1);
		return DataTest.complementOneMaleList.get(position);

	}
	// ---------------------------------------------------------------------------------------------------
	public static String complementOneFemale() {
		DataTest.complementOneFemalebList = InitList(DataTest.complementOneFemalebList, "sentense.complement.one.female");
		int position = Utils.randInt(0, DataTest.complementOneFemalebList.size() - 1);
		return DataTest.complementOneFemalebList.get(position);

	}
	// ---------------------------------------------------------------------------------------------------
	public static String complementManyMale() {
		DataTest.complementManyMaleList = InitList(DataTest.complementManyMaleList, "sentense.complement.many.male");
		int position = Utils.randInt(0, DataTest.complementManyMaleList.size() - 1);
		return DataTest.complementManyMaleList.get(position);

	}
	// ---------------------------------------------------------------------------------------------------
	public static String complementManyFemale() {
		DataTest.complementManyFemaleList = InitList(DataTest.complementManyFemaleList, "sentense.complement.many.female");
		int position = Utils.randInt(0, DataTest.complementManyFemaleList.size() - 1);
		return DataTest.complementManyFemaleList.get(position);

	}

	
	// ---------------------------------------------------------------------------------------------------
	
	// ---------------------------------------------------------------------------------------------------

	public static String email(String firstname, String lastname) {

		return Utils.stripAccent(String.format("%s.%s@%s.%s", firstname.toLowerCase(), lastname.toLowerCase(),
				DataTest.domain(), DataTest.domainExtension()));

	}

	// ---------------------------------------------------------------------------------------------------
	public static String picUrl() {

		return DataTest.url() + ".jpg";
	}

	// ---------------------------------------------------------------------------------------------------
	public static String videoUrl() {

		return DataTest.url() + ".mp4";
	}

	// ---------------------------------------------------------------------------------------------------
	public static String url() {

		return String.format("http://www.%s.%s/%s", DataTest.domain(), DataTest.domainExtension(),
				DataTest.article().replace(' ', '-'));

	}

//---------------------------------------------------------------------------------------------------
	public static String phone() {

		return String.format("%05d", Utils.randInt(0, 99999)) + String.format("%05d", Utils.randInt(0, 99999));

	}

	// ---------------------------------------------------------------------------------------------------
	public static String pass(String inString) {

		char[] charTab = inString.toCharArray();
		int length = inString.length();

		for (int index = 0; index < length; index++) {
			if ((index % 2) == 0) {
				charTab[length - index - 1] = Character.toUpperCase(inString.charAt(index));
			} else
				charTab[length - index - 1] = Character.toLowerCase(inString.charAt(index));
		}

		return new String(charTab);
//		return inString;
	}

//---------------------------------------------------------------------------------------------------
	public static String firstname() {

		return DataTest.firstname(Gender.OTHER);

	}

// ---------------------------------------------------------------------------------------------------
	public static String domainExtension() {
		if (domainExtensionList == null) {
			domainExtensionList = new ArrayList<String>();

			ResourceBundle myResource = ResourceBundle.getBundle("testData"); // retreive data from Dbase.properties
			String propertieValue = myResource.getString("domain.extension");
			String propertieArray[] = propertieValue.split(";");

			for (String value : propertieArray) {

				domainExtensionList.add(value.toLowerCase());
			}
		}
		int position = Utils.randInt(0, domainExtensionList.size() - 1);

		return Utils.stripAccent(domainExtensionList.get(position));

	}

// ---------------------------------------------------------------------------------------------------
	public static String domain() {
		if (domainList == null) {
			domainList = new ArrayList<String>();

			ResourceBundle myResource = ResourceBundle.getBundle("testData"); // retreive data from Dbase.properties
			String propertieValue = myResource.getString("domain");
			String propertieArray[] = propertieValue.split(";");

			for (String value : propertieArray) {

				domainList.add(value.toLowerCase());
			}
		}
		int position = Utils.randInt(0, domainList.size() - 1);

		return Utils.stripAccent(domainList.get(position));

	}

	// ---------------------------------------------------------------------------------------------------
	public static String firstname(Gender gender) {

//		Utils.trace(gender.getValue());
		if (firstnameList == null) {
			firstnameList = new ArrayList<String>();

			ResourceBundle myResource = ResourceBundle.getBundle("testData"); // retreive data from Dbase.properties
			String propertieValue = myResource.getString("FirstName." + gender.getValue());
			String propertieArray[] = propertieValue.split(";");

			for (String value : propertieArray) {

				firstnameList.add(Utils.firstToUpper(value));
			}
		}
		int position = Utils.randInt(0, firstnameList.size() - 1);

		return firstnameList.get(position);
	}

//---------------------------------------------------------------------------------------------------
	public static String article() {
		if (articleList == null) {
			articleList = new ArrayList<String>();

			ResourceBundle myResource = ResourceBundle.getBundle("testData"); // retreive data from Dbase.properties
			String propertieValue = myResource.getString("item.name");
			String propertieArray[] = propertieValue.split(";");

			for (String value : propertieArray) {

				articleList.add(value);
			}
		}
		int position = Utils.randInt(0, articleList.size() - 1);

		return articleList.get(position);
	}

//---------------------------------------------------------------------------------------------------
	public static String categoryName() {
		if (categoryList == null) {
			categoryList = new ArrayList<String>();

			ResourceBundle myResource = ResourceBundle.getBundle("testData"); // retreive data from Dbase.properties
			String propertieValue = myResource.getString("category");
			String propertieArray[] = propertieValue.split(";");

			for (String value : propertieArray) {

				categoryList.add(value);
			}
		}
		int position = Utils.randInt(0, categoryList.size() - 1);

		return categoryList.get(position);
	}

//---------------------------------------------------------------------------------------------------
	public static String lastname() {
		if (lastnameList == null) {
			lastnameList = new ArrayList<String>();

			ResourceBundle myResource = ResourceBundle.getBundle("testData"); // retreive data from Dbase.properties
			String propertieValue = myResource.getString("LastName");
			String propertieArray[] = propertieValue.split(";");

			for (String value : propertieArray) {

				lastnameList.add(Utils.firstToUpper(value));
			}
		}
		int position = Utils.randInt(0, lastnameList.size() - 1);

		return lastnameList.get(position);
	}

//---------------------------------------------------------------------------------------------------
	public static String numberType() {

//		Utils.trace("numberType");
		if (numberTypeList == null) {
			numberTypeList = new ArrayList<String>();

			ResourceBundle myResource = ResourceBundle.getBundle("testData"); // retreive data from Dbase.properties
			String propertieValue = myResource.getString("NumberType");
//			Utils.trace(propertieValue);
			String propertieArray[] = propertieValue.split(";");
			for (String value : propertieArray) {

				numberTypeList.add(value);
			}
		}
		int position = Utils.randInt(0, numberTypeList.size() - 1);
//		Utils.trace(String.format("%d %d", position,numberTypeList.size()));
//		Utils.trace(numberTypeList.get(position));

		return numberTypeList.get(position);
	}

	// ---------------------------------------------------------------------------------------------------

	public static String street() {
		if (streetNameList == null) {
			streetNameList = new ArrayList<String>();

			ResourceBundle myResource = ResourceBundle.getBundle("testData"); // retreive data from Dbase.properties
			String propertieValue = myResource.getString("StreetName");
			String propertieArray[] = propertieValue.split(";");

			for (String value : propertieArray) {

				streetNameList.add(Utils.firstToUpper(value));
			}
		}
		int position = Utils.randInt(0, streetNameList.size() - 1);

		return streetNameList.get(position);
	}

	// ---------------------------------------------------------------------------------------------------

	public static String streetType() {
		if (streetTypeList == null) {
			streetTypeList = new ArrayList<String>();

			ResourceBundle myResource = ResourceBundle.getBundle("testData"); // retreive data from Dbase.properties
			String propertieValue = myResource.getString("StreetType");
			String propertieArray[] = propertieValue.split(";");

			for (String value : propertieArray) {

				streetTypeList.add(Utils.firstToUpper(value));
			}
		}
		int position = Utils.randInt(0, streetTypeList.size() - 1);

		return streetTypeList.get(position);
	}

	// ---------------------------------------------------------------------------------------------------
	public static String itemName() {
		if (itemList == null) {
			itemList = new ArrayList<String>();
			ResourceBundle myResource = ResourceBundle.getBundle("testData"); // retreive data from Dbase.properties
			String propertieValue = myResource.getString("item.name");
			String propertieArray[] = propertieValue.split(";");

			for (String value : propertieArray) {
				itemList.add(Utils.firstToUpper(value));
			}
		}
		int position = Utils.randInt(0, itemList.size() - 1);

		return itemList.get(position);
	}


	// ---------------------------------------------------------------------------------------------------
	public static List<String> InitList(List<String> listName, String Key) {
		if (listName == null) {
			listName = new ArrayList<String>();
			ResourceBundle myResource = ResourceBundle.getBundle("testData"); // retreive data from Dbase.properties
			String propertieValue = myResource.getString(Key);
			String propertieArray[] = propertieValue.split(";");
			for (String value : propertieArray) {

				listName.add(value);
			}
		}
		return listName;
	}


	// ---------------------------------------------------------------------------------------------------
	public static String city() {
		if (cityList == null) {
			cityList = new ArrayList<String>();

			ResourceBundle myResource = ResourceBundle.getBundle("testData"); // retreive data from Dbase.properties
			String propertieValue = myResource.getString("CityName");
			String propertieArray[] = propertieValue.split(";");

			for (String value : propertieArray) {

				cityList.add(Utils.firstToUpper(value));
			}
		}
		int position = Utils.randInt(0, cityList.size() - 1);

		return cityList.get(position);
	}

//---------------------------------------------------------------------------------------------------

	public static String zipcode() {

		return String.format("%05d", Utils.randInt(1000, 99999));
	}

//---------------------------------------------------------------------------------------------------
	public static Integer number() {
		return Utils.randInt(1, 999);
	}

//---------------------------------------------------------------------------------------------------
	public static String numberString() {

		String numberType = DataTest.numberType();

		if (numberType.equals("")) {
			return String.format("%d", Utils.randInt(0, 999));
		}

		return String.format("%d %s", Utils.randInt(0, 999), numberType);
	}

	// ---------------------------------------------------------------------------------------------------
	public static Date date(Date lowerDate, Date upperDate) {

		Date randomDate = null;
		LocalDate localDate = null;

		LocalDate loDate = Utils.date2localDate(lowerDate);
		LocalDate upDate = Utils.date2localDate(upperDate);
		long periode = loDate.until(upDate, ChronoUnit.DAYS);
		int nbDays = Utils.randInt(0, (int) periode);
		localDate = loDate.plusDays(nbDays);

		return Utils.localDate2Date(localDate);
	}

	// ---------------------------------------------------------------------------------------------------
	public static Profile profile() {

		Profile[] profileTab = Profile.values();

		int profileSize = Profile.values().length;

		int profileRandom = Utils.randInt(0, profileSize - 2); // do not user last value : Null

		return profileTab[profileRandom];
	}

	// ---------------------------------------------------------------------------------------------------
	public static Gender gender() {

		Gender[] genderTab = Gender.values();

		int genderSize = Gender.values().length;

		int genderRandom = Utils.randInt(0, genderSize - 2); // do not user last value : Null

		return genderTab[genderRandom];
	}

	// ---------------------------------------------------------------------------------------------------
	public static LocalDate localDate(LocalDate lowerDate, LocalDate upperDate) {
//			Date date = Date.from(localDate.atStartOfDay(ZoneId.systemDefault()).toInstant());
		long periode = lowerDate.until(upperDate, ChronoUnit.DAYS);

		int nbDays = Utils.randInt(0, (int) periode);

		Utils.trace(String.format("%s %s %d %d", upperDate.toString(), lowerDate.toString(), periode, nbDays));

		return lowerDate.plusDays(nbDays);
	}

//---------------------------------------------------------------------------------------------------

}
