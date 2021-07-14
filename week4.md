# <지난시간 복습>

## [recyclerView의 구조]

### -데이터와 뷰의 연결

![https://s3-us-west-2.amazonaws.com/secure.notion-static.com/fa181e1a-254a-4705-ba47-62fb1e3620fe/Untitled.png](https://s3-us-west-2.amazonaws.com/secure.notion-static.com/fa181e1a-254a-4705-ba47-62fb1e3620fe/Untitled.png)

![https://s3-us-west-2.amazonaws.com/secure.notion-static.com/4d8b96e1-7155-4485-84f5-37105ee839f4/Untitled.png](https://s3-us-west-2.amazonaws.com/secure.notion-static.com/4d8b96e1-7155-4485-84f5-37105ee839f4/Untitled.png)

- 빨간 네모 부분이 실제로 데이터를 연결시켜주는 부분

## -constructor와 init의 차이

- init 블록 내부는 객체가 생성될 때 호출됨

    ![https://s3-us-west-2.amazonaws.com/secure.notion-static.com/61cc4131-c8e6-4395-88d0-7a79d6ef8476/Untitled.png](https://s3-us-west-2.amazonaws.com/secure.notion-static.com/61cc4131-c8e6-4395-88d0-7a79d6ef8476/Untitled.png)

- 객체가 생성될 때 constructor와 init 블록 모두 호출됨
    - constructor는 특정한 형태로 데이터를 받고싶을 때 이용
    - init은 어떤 constructor를 이용해서 객체를 생성하더라도 호출된다.

# <DataBase>

## [DB가 무엇인가?]

### -데이터베이스 (DB)

- 데이터 저장소
- 우리가 액티비티에서 생성한 데이터는 앱이 실행될 때마다 초기화됨
    - 변경사항이 저장되지 않음

        ⇒ 앱 외부적으로 저장할 필요가 있다 → DB 사용

### -DBMS (Database Management System)

- 데이터베이스를 만들고, 저장/관리해주는 소프트웨어

## [안드로이드 기본 DB]

### -SQLite

## [DB의 구조]

### -테이블

- 데이터가 저장되는 단위

    ![https://s3-us-west-2.amazonaws.com/secure.notion-static.com/ded8860d-2bf2-4985-9795-c05adecb2510/Untitled.png](https://s3-us-west-2.amazonaws.com/secure.notion-static.com/ded8860d-2bf2-4985-9795-c05adecb2510/Untitled.png)

## [SQL]

- Structure Query Language
- 데이터를 정의, 조작, 제어하는 용도의 언어
- 이때 사용하는 명령어를 SQL 구문 또는 쿼리(Query)라고 함

## [Query와 그 종류]

### -Query (쿼리)

- 테이블을 전부 읽어오기

    ```sql
    SELECT * FROM 테이블A
    ```

    - SELECT : 읽어와라
    - * : 전부
    - FROM : 어디서
    - 테이블A : 데이터를 읽어올 테이블
- 특정 컬럼만 읽기

    ```sql
    SELECT title, content FROM 테이블A
    ```

- 특정 레코드만 읽기

    ```sql
    SELECT * FROM 테이블A where no=2
    ```

    - where 뒤에 오는게 조건
- 특정 레코드의 특정 컬럼만 읽기

    ```sql
    SELECT title FROM 테이블A where no=3     //3번 레코드의 title만 가져온다.
    ```

### -쿼리의 종류

- DDL(Data Definition Language)
    - 데이터 **구조**를 정의하는 명령어

        ![https://s3-us-west-2.amazonaws.com/secure.notion-static.com/eb3ce102-352f-4ca5-b77b-2e5767c4a954/Untitled.png](https://s3-us-west-2.amazonaws.com/secure.notion-static.com/eb3ce102-352f-4ca5-b77b-2e5767c4a954/Untitled.png)

- DML(Data Manipulation Language)
    - 데이터를 조작하는 명령어

        ![https://s3-us-west-2.amazonaws.com/secure.notion-static.com/5dbfeb4c-e773-4ff8-926f-bb925d5e102e/Untitled.png](https://s3-us-west-2.amazonaws.com/secure.notion-static.com/5dbfeb4c-e773-4ff8-926f-bb925d5e102e/Untitled.png)

- DCL(Data Control Language)
    - 데이터베이스 권한과 관련된 명령어 (거의 안쓰임)

## [SQLite 사용법]

### -SQLite DB

- 데이터 구조 설계 → DDL 사용

    ![https://s3-us-west-2.amazonaws.com/secure.notion-static.com/6b294e75-7a38-4b6d-a972-a10dffaff24d/Untitled.png](https://s3-us-west-2.amazonaws.com/secure.notion-static.com/6b294e75-7a38-4b6d-a972-a10dffaff24d/Untitled.png)

### - 쿼리 작성하기

```sql
CREATE TABLE memo(no INTEGER PRIMARY KEY,     //[컬럼][타입][옵션] 순서
									title TEXT,                 //[컬럼][타입]만 있는 경우
									content TEXT, 
									datetime INTEGER)
```

- PRIMARY KEY : 해당 컬럼에 중복 값이 없는 유일한 키로 사용
- SQLite에서는 PRIMARY KEY가 INTEGER일 때 숫자 자동 증가 (레코드가 추가될 때마다 자동으로 1씩 증가)

### -Key

- 유일한 레코드를 구분할 수 있는 컬럼의 최소 집한
- primary key : 기본키
- 키가 여러 컬럼으로 이루어져 있을 수 있음

### -SQLite Open Helper 사용하기

- SQLite를 사용하기 위해서 SQLiteOpenHelper 클래스를 상속받아서 사용
- SQLiteOpenHelper 클래스 : 데이터베이스를 파일로 생성하고 코틀린 코드에서 사용할 수 있게 DB와 연결

![https://s3-us-west-2.amazonaws.com/secure.notion-static.com/a18c20b4-565f-4b9b-95a0-eb997fc58c74/Untitled.png](https://s3-us-west-2.amazonaws.com/secure.notion-static.com/a18c20b4-565f-4b9b-95a0-eb997fc58c74/Untitled.png)

### - 커서 (Cursor)

- data set을 처리할 때 현재 위치를 포함하는 데이터 요소
- 쿼리를 통해 반환된 data set을 반복문으로 하나씩 처리 가능
    - 한 레코드씩 읽을 수 있게 해줌

        ![https://s3-us-west-2.amazonaws.com/secure.notion-static.com/f0cef020-1595-482e-91f5-208ea821f213/Untitled.png](https://s3-us-west-2.amazonaws.com/secure.notion-static.com/f0cef020-1595-482e-91f5-208ea821f213/Untitled.png)

# <코드짜기>

## [StartActivityForResult]

- startActivity : 새 액티비티를 열어줌 (단방향)
- startActivityForResult : 새 액티비티를 열어줌 + 결과값 전달 (양방향)

## [액티비티 스택]

- 새 액티비티를 시작할 때마다 전 액티비티가 백스택에 저장됨
- 뒤로가기, finish()등으로 액티비티 종료

    ![https://s3-us-west-2.amazonaws.com/secure.notion-static.com/3b73b778-e7f3-4712-b3c1-904a22fb34c9/Untitled.png](https://s3-us-west-2.amazonaws.com/secure.notion-static.com/3b73b778-e7f3-4712-b3c1-904a22fb34c9/Untitled.png)
