package javaBasic;

import java.util.Locale;

import com.github.javafaker.CreditCardType;
import com.github.javafaker.Faker;

public class Faker_Lesson {
	public static void main(String[] agrs) {
		// US
		Faker faker = new Faker();
		System.out.println(faker.address().firstName());
		System.out.println(faker.address().lastName());
		System.out.println(faker.business().creditCardNumber());
		System.out.println(faker.business().creditCardExpiry());
		System.out.println(faker.finance().creditCard(CreditCardType.VISA));
		// VI
		Faker fakeVi = new Faker(new Locale("vi"));
		System.out.println(fakeVi.address().firstName());
		System.out.println(fakeVi.address().lastName());
	}
}
