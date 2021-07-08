# <코틀린>

## [문법이 간결]

## [안전하다 : nullable을 선언할 때 지정]

- JAVA

    ```java
    String name;
    ```

    - 기본적으로 Null로 초기화됨
    - null이 들어와도 되는 변수인지 설정해주지 않아 NullPointerException이 발생할 수 있다.
    - @(annotation)을 붙어서 해결

        ```java
        @NonNull String name = "Hello, world!";
        ```

        - 위처럼 앞에 @NonNull을 붙여주면 Null 값이 들어갈 수 없는 변수가 된다.
- Kotlin
    - 선언부터 Nullable을 정한다.

    ```kotlin
    /** 1: Null일 경우 오류 */
    var nameNonNull1: String = "Hello, world!"
    var nameNonNull2: String = null       // ERROR

    /** 2: Null 가능 */
    var nameNull1: String? = "Hello, world!"
    var nameNull2: String? = null    
    ```

    - ? : Null이 들어가도 되는 변수!

## [함수형 프로그래밍 언어]

- 절차지향 프로그래밍 : 로직 위주로 동작   ex) C
- 객체지향 프로그래밍 : 클래스가 프로그램의 최우선   ex) C++, Java
- 함수형 프로그래밍 : 함수의 유기적 연결 및 동작이 최우선
    - 함수가 '일급 객체'로의 의미를 가짐
    - ex) Kotlin, JavaScript

# <코틀린의 문법>

## [세미콜론을 쓰지 않아도 됨]

- 개행(enter)로 구분

## [변수와 상수 (var 와 val)]

```kotlin
var myName = "서시언"        // 뒤에 오는 값을 보고 알아서 타입 결정
var myAge: Int = 22        // 명시적으로 타입을 지정
val myPhone = "Iphone 8"   // 상수. 사용하는 내내 값이 일정
```

## [if문]

- 그냥 다른 거랑 마찬가지로 쓰면 된다.
- 추가적으로 아래와 같이 변수 안에서 사용하는 것이 가능

```kotlin
var a = 5
var b = 88
var bigger = if(a > b) a else b
```

## [When문]

- 자바의 switch문과 동일하게 사용 가능
- 추가로 in을 이용한 범위 조건, 콤마로 여러 개 지정 가능

    ```kotlin
    fun printGrace(Score: Int){
    	when(score){
    		in 95..100 -> println("A+")
    		in 90..94 -> println("A")
    		in 85..89 -> println("B+")
    		in 80..84 -> println("B")
    		else -> println("F")

    ```

    - 자바의 switch를 사용하는 것보다 훨씬 간결

    ![https://s3-us-west-2.amazonaws.com/secure.notion-static.com/4e32c9ec-7d67-4c23-8008-b76811692302/Untitled.png](https://s3-us-west-2.amazonaws.com/secure.notion-static.com/4e32c9ec-7d67-4c23-8008-b76811692302/Untitled.png)

- 파라미터가 없는 when

    ```kotlin
    var curTime = 6;
    when {
    	curTime == 5 -> {
    		// 현재 시간은 5시 입니다.
    	}
    	curTime > 5 -> {
    		// 현재 시간은 5시가 넘었습니다.
    	}
    	else -> {
    		// 현재 시간은 5시 이전입니다.
    	}
    ```

    - 선언되어 있는 변수를 통해 조건 결정

## [배열과 컬렉션]

- 배열(Array) : 선언할 때 개수를 정함 / 코틀린에서는 거의 사용되지 않는다. 대부분 컬렉션 사용

    ```kotlin
    var students = IntArray(10)     // size 지정
    ```

- 컬렉션 (Collection) : 개수가 정해져 있지 않음

    ![https://s3-us-west-2.amazonaws.com/secure.notion-static.com/f7cf46eb-3d72-4d2c-9bbc-155f95fc296f/Untitled.png](https://s3-us-west-2.amazonaws.com/secure.notion-static.com/f7cf46eb-3d72-4d2c-9bbc-155f95fc296f/Untitled.png)

    - readonly는 상수 느낌 (val처럼) / 읽기만 가능
    - mutable은 변수느낌 (var 처럼) / 각각 수정 가능
    - 거의 항상 mutable이 붙은 컬렉션을 사용

    ```kotlin
    var list: MutableList<String> = mutableListOf("시언", "가은", "보경")
    ```

## [list, set, map]

- list : 우리가 아는 배열의 형태, 중복 허용, 인덱스로 접근 가능
    - get, set 함수로 접근/수정 가능
- set : 우리가 아는 배열의 형태이지만 중복 허용 안함, 인덱스로 접근 불가능
    - get 함수 지원 안함, 값으로 직접 조회해서 수정
- map : key-value의 데이터 형태를 가지는 리스트
    - key는 리스트에서의 인덱스와 비슷하지만 리스트와 다르게 키를 직접 입력해줘야 함
    - 값 1에 접근하기 위해 키1이 필요

        ![https://s3-us-west-2.amazonaws.com/secure.notion-static.com/f825536e-f274-49bf-8959-47842aaf51a8/Untitled.png](https://s3-us-west-2.amazonaws.com/secure.notion-static.com/f825536e-f274-49bf-8959-47842aaf51a8/Untitled.png)

    - ex)

        ```kotlin
        var members: Map<String,String> = mapOf(
        	"한국" to "서울",
        	"일본" to "도쿄",
        	"중국" to "베이징",
        ```

        ![https://s3-us-west-2.amazonaws.com/secure.notion-static.com/98a1620d-d64c-4030-853c-0746fcee2c8c/Untitled.png](https://s3-us-west-2.amazonaws.com/secure.notion-static.com/98a1620d-d64c-4030-853c-0746fcee2c8c/Untitled.png)

## [반복문]

### -for문

- 정해진 범위만큼 코드를 반복하기 위해 사용
- 배열/컬렉션의 원소 반복하기

    ```kotlin
    for(name: String in list){
    	Log.d("for", "현재 이름은 ${name}입니다.")
    }
    ```

    - 이런식으로 name이라는 반복자를 이용해 list가 가지고 있는 모든 원소들을 출력할 수 있음

### -while문과 do while문

- 정해진 범위가 아닌, 특정 조건을 만족할 때까지 코드를 반복하기 위해 사용
- 둘의 차이는 조건 비교를 하는 시점
    - while문은 조건을 만족하면 반복문이 실행되고
    - do while문은 일단 한 번 실행하고, while의 조건을 확인해 더 실행할지 판단

### -break와 continue

- break : 반복문을 탈출하게 만듦
    - 반복문을 완전히 벗어나기 위해 사용
- continue : continue이후에 나오는 코드는 실행하지 않고 다음 반복문 조건으로 넘어가게 된다.
    - 반복문 도중에 다음 반복문으로 넘어가기 위해 사용

## [함수]

### -함수의 정의

```kotlin
fun {함수명} ({파라미터 이름}: {타입}): {반환 타입} {
	return {리턴 값}
}
```

### -여러 종류의 함수

```kotlin
// 반환값과 입력값이 있는 함수의 정의
fun square(x: Int): Int {
	return x*x
}

// 반환값이 없는 함수의 정의
fun printSum(x: Int, y: Int) {
	Log.d("fun", "x+y = ${x+y}")
}

// 입력값 없이 반환값만 있는 함수의 정의
fun getPi() : Double{
	return 3.14
}
```

### -함수 파라미터의 정의

- 코틀린에서 모든 함수 파라미터는 val(상수 키워드)이 생략된 형태

    ```kotlin
    fun {함수명} ((val 생략) {파라미터 이름}: {타입}): {반환 타입}
    {실행코드}
    ```

- 파라미터의 기본값 정의

    ```kotlin
    fun {함수명} ((val 생략) name1: String, name2: Int = 157)
    {실행코드}
    ```

    - 위와 같은 함수를 정의한 뒤, 사용할 때 두번째 값을 설정하지 않으면 기본으로 157이 들어감

## [문자열 안에 표현식의 값 집어넣기]

- 문자열 안에 표현식의 값을 바로 넣을 수 있다.
- $값 or ${표현식}

    ```kotlin
    	Log.d("fun", "x+y = ${x+y}")
    ```

## [로그 찍기]

- 아래쪽 Logcat에 로그가 남게 된다.
- 디버깅 용으로 Log를 찍으면 나중에 어디서 에러가 발생했는지 알기 쉽다.

    ```kotlin
    	Log.d("fun", "x+y = ${x+y}")
    ```

- 로그 메서드들
    - d : debug
    - e : error
    - i : info
    - v : verbose (상세한 로그를 출력할 때 이용)
    - w : warning
    - wft : What a Terrible Failure
