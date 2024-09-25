package beantest;


import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class BeanTest {

	public static void main(String[] args) {
		//saveObj();

		getObj();
	}
	// 직렬화
	public static void saveObj() {
		Person person = new Person();
		person.setName("펭수");
		person.setAge(10);
	
	
	try {
		FileOutputStream fos = new FileOutputStream("person.ser");
		ObjectOutputStream oos = new ObjectOutputStream(fos);
		oos.writeObject(person);
		System.out.println("직렬화 완료");
		
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
		
	}
	
	public static void getObj() {
		try {
			FileInputStream fis = new FileInputStream("person.ser");
			ObjectInputStream ois = new ObjectInputStream(fis);
			Person person = (Person) ois.readObject();
			System.out.println(person.getName());
			System.out.println(person.getAge());
			
		} catch (IOException | ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}
	
	
	
	
}
