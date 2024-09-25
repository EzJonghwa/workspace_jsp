package beantest;

import java.io.Serializable;

/**
 * JavaBean은 Java프로그래밍에서 재사용 가능한 소프트웨어 컴포넌트를 만들기 위한 규약을 따르는 클래스를 말합니다.
 * 특징
 * 1. 캡슐화된 속성 : 모든 멤버 변수는 private으로 선언합니다.
 *                이에 접근하기 위해서 public접근자(setter, getter) 메소드를 제공합니다.
 * 2. 파라미터가 없는 기본 생성자: public으로 선언된 기본 생성자를 가져야합니다. 이는 객체 생성 시 초기 설정을 가능하게 합니다.
 * 3. 직렬화 가능: Serializable 인터페이스를 구현하여 객체의 상태를 저장하거나 네트워크로 전송할 수 있습니다.
 */
                        //3. 직렬화 가능 인터페이스 구현
public class Person implements Serializable{   
   private static final long serialVersionUID = 1L;      //person ctrl+1 첫번째 선택
   /**
    * serialVersionUID: Java 직렬화 가능 클래스의 고유 식별자
    * 역직렬화 시 발생할 수 있는 오류를 내부적으로 방지함 (권고사항입니다.)
    */
   
   //1. 캡슐화된 속성
   private String name;
   private int age;
   //2. 파라미터가 없는 기본 생성자
   public Person() {}
   //1. public 접근자
   public String getName() {
      return name;
   }
   public void setName(String name) {
      this.name = name;
   }
   public int getAge() {
      return age;
   }
   public void setAge(int age) {
      this.age = age;
   };

}
