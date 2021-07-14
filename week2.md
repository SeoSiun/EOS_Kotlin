# <코틀린 문법>

## [클래스]

### -생성자

- 자바는 클래스 내에 생성자를 만들지만, 코틀린은 기본 생성자를 바로 만들 수 있다.
    - Java

        ```java
        class EOSManager {
        	public EOSManager(int member){}
        }
        ```

    - Kotlin

        ```kotlin
        class EOSManagerKt (val member: Int){}
        ```

- 생성자가 여러 개면 아래처럼 구현 (constructor 키워드)

    ```kotlin
    class EOSManagerKt(val member: Int){
    	constructor(memberList: List<String>): this(memberList.size)      // this는 기본 생성자
    	constructor(memberD : Double): this(memberD.toInt())
    }

    ```

    - 생성자도 함수. 파라미터로 받는 건 전부 val
- 생성자 객체 선언 방법
    - Java : new [클래스] (생성자)

        ```java
        EOSManager eosManager = new EOSManager(10);
        ```

    - Kotlin : [클래스](생성자)     ⇒ new가 없다.

        ```kotlin
        val eosManager = EOSManagerKt(10)
        ```

### -멤버변수와 멤버함수

- 멤버변수 == 프로퍼티
- 멤버 함수 == 메서드

### -데이터 클래스

- 간단한 값의 저장용도

    ```kotlin
    data class Site (val url: String, val title: String) {
    	val description = ""
    }
    ```

    - 생성자에서 val인지 var인지 명시해줘야 함
- copy() 메서드
    - 값을 복사해주는 메서드

    ```kotlin
    var newOne = Site("www.naver.com", "naver")
    var newTwo = newOne.copy()
    ```

### -상속과 확장

- 상속을 하기 위해서는 open 키워드를 상속될 부모 클래스 앞에 붙여줘야 함

    ```kotlin
    open class Parent {
    	var hello: String = "Hey"
    	fun sayHello() {
    		// hello 출력
    	}
    }

    class Child : Parent() {
    	fun myHello() {
    		hello = "Hello, world!"
    		sayHello()
    	}
    }
    ```

### -메서드 오버라이드

- 메서드, 프로퍼티 전부 오버라이드 가능
- open 키워드가 붙어있지 않은 메서드/프로퍼티는 오버라이드 불가능

### -추상화

- 프로그래밍을 하기 전 개념 설계를 하는 단계
- 클래스의 이름과 클래스 안에 있음직한 기능들을 유추해서 메서드 이름으로 먼저 나열한다.
- 구현단계에서 추상화된 클래스를 상속받아서 구현되지 않은 부분을 마저 만드는 것

```kotlin
abstract class Animal {
	fun walk() {
		// 걷기
	}
	abstract fun move()
		//동물마다 다르게 움직이므로,
		// ex) 새는 날고 고래는 수영함
}

class Bird: Animal() {
	override fun move() {
		//날아서 이동
	}
}
```

### -인터페이스

- 어떤 실행코드도 없이 메서드 이름만 가진 추상 클래스

### -접근제한자

### -접근제한자

- **접근제한자**           /              **제한범위**
- private           /       다른 파일에서 접근할 수 없다
- internal           /      같은 모듈에 있는 파일만 접근할 수 있다.
- protected           /     private와 같지만 상속관계에서 자식클래스가 접근할 수 있다.
- public               /    제한 없이 모든 파일에서 접근할 수 있다.

### -제네릭

- 코드를 작성할 때, 자동완성에 다오는 <E>가 제네릭
- <>에 들어가는 타입으로 리스트를 만든다.
- <>에 들어가는 타입을 바꿔서 원하는대로 사용 가능

## [일급객체]

- 다음 조건을 충족한다면 1급 객체
    1. 변수나 데이터에 할당할 수 있어야 한다.
    2. 객체의 인자로 넘길 수 있어야 한다.
    3. 객체의 리턴값으로 리턴할 수 있어야 한다.

        ⇒ 함수형 프로그래밍에서는 함수가 일급객체

- 쉽게 말해 포함관계에 있어서 가장 최상위 레벨
    - ex) 객체지향 java에서는 클래스
        - 클래스가 변수, 함수, 클래스 자체를 안에 품을 수 있다.

### -Kotlin에서의 일급객체

- 함수형 프로그래밍

    ⇒ 함수 안에 변수, 함수, 클래스 등을 담을 수 있다. (== 선언 및 정의가 가능하다)

- EX)

    ```kotlin
    fun firstClass() {
    	val eos = "EOS"
    	fun lecture() {
    		println("$eos Advance Lecture 02")
    	}
    	class SubClass{
    		fun subFun(){
    			lecture()
    			println("this is a sub function")
    		}
    	}
    	SubClass().subFun()
    }
    ```

    - 변수, 함수, 클래스가 전부 존재
    - 하지만 완전한 일급객체로서의 역할을 의미하지 않음
    - 일급객체라고 하려면 함수를 변수처럼 사용할 수 있어야 함

### -함수를 변수처럼

- 일단 변수에 함수를 대입   ⇒ ERROR!

    ```kotlin
    val value21 = fun fun21()    // ERROR
    ```

⇒ 어떻게 해야할까?

1. 함수 참조 (function reference)
    - 미리 fun을 통해 만든 함수를 [::] 키워드를 통해 변수에 그대로 대입

        ```kotlin
        fun fun21(par: Int){
        	println("This is a function made in $par")
        }

        val value21 = ::fun21

        fun main(args: Array<String>){
        	value21.call(2021)
        }
        ```

        - 안에 파라미터를 넣는 것도 가능
2. 람다식
    - 익명함수 == fun을 이용하지 않고 만든 함수

        ```kotlin
        val lambda={par1:Int, par2:Int -> par1+par2} //[파라미터 정보] → [return값]

        fun main(args: Array<String>){
        	println(lambda21(1,2))
        }
        ```

        - 여러줄일 때 : 가장 마지막 줄이 반환값

            ```kotlin
            val lambda22 = {par1: Int, par2: Int ->
            	println("here is new lambda")
            	par1 + par2 ^lambda
            }
            ```

        - 인자가 없는 경우 : 파라미터 부분을 비워두면 된다.

            ```kotlin
            val lambda23 = {
            	val lamV1 = 10
            	val lamV2 = 20
            	println("no parameters, ${lamV1 + lamV2}")
            }

            fun main(args: Array<String>){
            	println(labda21(1,2))
            	lambda23()
            }
            ```

### -함수 타입

- 함수가 변수처럼 쓰일 수 있다면 타입 지정도 가능한 것 아닐까? ⇒ 가능!
- 함수형 변수 타입 지정
    - 일반 변수와 다른 점
        - [(인자들) → 반환형]

        ```kotlin
        val lambda21a: (Int) -> Int = {par1: Int -> par1 *10}
        ```

        - 함수 파라미터   /    함수 리턴값   /   함수 내용
- 함수형 변수 - it 키워드
    - 파라미터가 1개인 경우 it을 이용
    - 단, 타입이 무엇인지 꼭 명시되어야 함

        ```kotlin
        val lambda21aa: (Int) -> Int = {it * 10}
        ```

## [Null Safety]

### -nullable  -   [?]

- null 값이 들어가는 것을 허용한다.
    - 선언하는 변수의 타입 다음에 ?
    - null을 입력받기 위해 사용
    - var nullable : 타입?

    ```kotlin
    var nullable: String?
    nullable = null

    fun nullParameter(str: String?){
    	// 파라미터 str에 null이 허용되었기 때문에
    	// 함수 내부에서 null 체크를 하기 전에는 str을 사용할 수 없다.
    	if(str != null) {
    		var length2 = str.length
    	}
    }

    // 리턴값에 null 허용
    fun nullReturn(): String? {
    	return null
    }
    ```

### -Safe call  -  [?.]

- nullable인 변수 다음에 ?.을 사용하면 해당 변수가 null일 경우 ?. 다음의 메서드나 프로퍼티를 호출하지 않는다.
    - 선언된 변수의 이름 다음에 ?.
    - null일 때 ?. 다음에 나오는 속성이나 명령어를 처리하지 않기 위해 사용
    - var result = 변수?.length 또는 변수?.프로퍼티?.something

    ```kotlin
    fun testSafeCall(str: String?): Int? {
    	//str이 null이면 length를 체크하지 않고 null을 반환
    	var resultNull: Int? = str?.length
    	return resultNull
    ```

### -Elvis operator  -  [?:]

- 원본 변수가 null일 때 넘겨줄 기본값을 설정
    - 선언된 변수의 이름 다음에 ?:
    - null일때 ?: 다음에 나오는 값을 기본값으로 사용
    - var result = 변수?:0 또는 변수?.프로퍼티?:0

    ```kotlin
    // Null 값 대체하기 (Elvis operator)

    fun testElvis(str: String?): Int {
    	// length 오른쪽에 ?:를 사용하면 null일 경우 ?: 오른쪽의 값이 반환된다.
    	var resultNonNull: Int = str?.length?:0
    	return resultNonNull
    ```

# <안드로이드 4대 컴포넌트>

## [액티비티 (Activity)]

- 사용자 인터페이스(UI, User Interface) 화면을 관리하는 컴포넌트
- 생명주기 메소드를 재정의해서 원하는 기능을 구현

### -안드로이드 액티비티 생명주기

![https://s3-us-west-2.amazonaws.com/secure.notion-static.com/0abe4852-efbe-4e78-923e-84bad14cf729/Untitled.png](https://s3-us-west-2.amazonaws.com/secure.notion-static.com/0abe4852-efbe-4e78-923e-84bad14cf729/Untitled.png)

## [서비스]

- 특정 액티비티와 상관없이 백그라운드에서 실행되는 컴포넌트

## [브로드캐스트 리시버]

- 특정 브르드캐스트에 반응하는 컴포넌트, 사용자 인터페이스가 없음

## [콘텐트 프로바이더]

- 애플리케이션 간의 데이터 공유를 위해 표준화된 인터페이스를 제공하는 컴포넌트

## [인텐트]

- 컴포넌트에 액션, 데이터 등을 전달하는 메시지 객체
- 인텐트 객체의 구성요소
    - 액션 (Action)
        - 주요 액티비티 액션

            ![https://s3-us-west-2.amazonaws.com/secure.notion-static.com/85da8217-9dad-41ed-ad39-8b6d9bcc3a28/Untitled.png](https://s3-us-west-2.amazonaws.com/secure.notion-static.com/85da8217-9dad-41ed-ad39-8b6d9bcc3a28/Untitled.png)

    - 데이터 (data)
    - 카테고리 (Category)
    - 타입 (Type)
    - 컴포넌트 이름 (Component name)
    - 추가정보 (Extras)
