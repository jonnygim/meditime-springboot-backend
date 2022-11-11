# README
![image](https://user-images.githubusercontent.com/97663140/161197133-fb470543-0ce9-4fb4-8479-a125896ec91b.png)

# 복약방

## :pill:프로젝트 주제
#### 안전한 약 복용을 위한 약 정보 검색 & 소통 사이트

</br>

## 프로젝트 배경
- 임상실험으로 밝혀진 부작용과 주의사항등의 정보를 자세히 알고 싶다.
- 약을 먹으면서 변화되는 증상을 다른 사람들과 나누고 싶다.
- 폐쇄적인 부작용을 개방적으로 공유하고 싶다.

</br>

## :pencil2:팀원

:cyclone: 김영애 (백엔드)

:ocean: 김종원 (백엔드)

:fountain:양지현 (프론트엔드)

:runner: 이동빈 (프론트엔드)

</br>

## :alarm_clock:프로젝트 기간

- 초기 팀프로젝트 기간
    
    2022/3/28 ~ 2022/4/1 
    
- Gradle 프로젝트로 변경
    
    2022/9/21 
    
- 개인 리팩토링
    
    2022/11/07 ~


</br>

## :hammer:사용 기술 스택

### Backend

- Java 1.8 → Java 17
- SpringBoot 2.7.4
- Spring Data JPA
- Spring Secutiry
- queryDSL
- GCP → Oracle Cloud
- MariaDB

### Frontend

- React.js
- javascript

</br>

## :black_nib: 사전 계획

### 노션

[https://successful-hydrofoil-f44.notion.site/1-8d5c1bd184d94ffe9f0fa8277a2f5820](https://www.notion.so/1-8d5c1bd184d94ffe9f0fa8277a2f5820)

![image](https://user-images.githubusercontent.com/97663140/161192927-eb0d2bbe-0362-46f2-89fa-938f0500f53f.png)

</br>

## 유즈케이스 다이어그램
![use-case](https://user-images.githubusercontent.com/90269036/200480126-87922e17-9e92-4f6b-a9bf-1d20be083b28.svg)

</br>

## ERD
![erd](https://user-images.githubusercontent.com/90269036/200480171-28652467-a421-4d0e-8e1f-457e4d9c6e87.svg)

</br>

## 기능 명세서

![https://user-images.githubusercontent.com/97663140/161193088-e2a8a2ff-7450-4cf2-a370-64694d8da45d.png](https://user-images.githubusercontent.com/97663140/161193088-e2a8a2ff-7450-4cf2-a370-64694d8da45d.png)

</br>

## 화면 설계

### **카카오 오븐**

[https://ovenapp.io/view/d6XaZI0DjKuzgYnvhdzS2d8D7XGRIZ13/05y1u]
![image](https://user-images.githubusercontent.com/90269036/200480359-fee74c3f-33cd-4657-8bb6-473faa1df920.png)


<br/>


## :gem: 기능 구현

```
📆 기간 2022/3/28 ~ 2022/4/1 
```

### 1.google cloud platform 사용 서버 구축 
 <br/>
 google cloud platform을 이용하여 mySQL 서버를 구축하였다. 프록시를 사용하여 로컬에서 값 확인 및 수정을 할 수 있는 설정을 하였다.
 
### 2. 약 정보 조회

 ![image](https://user-images.githubusercontent.com/97663140/161197447-60320d7a-0c8e-4cee-95a6-46f5a9c1b783.png)
 
 ![image](https://user-images.githubusercontent.com/97663140/161197505-fbae5f70-8a91-4c5c-9d0a-86bd767b88a3.png)
 
 ![image](https://user-images.githubusercontent.com/97663140/161197580-92fd3918-7e29-4efa-a67f-39fcd33654ad.png)
 <br/>
 약 조회 화면에서는 검색창에 약 이름을 입력하면 그 이름이 포함된 의약품의 목록을 키워드를 포함한 GET요청으로 모두 불러온다. 원래는 의약품 API를 사용하려 했지만 DB를 스스로  구축했으니 활용해보자는 취지에서 약 정보를 따로 20개 정도 저장해서 불러오도록 했다. 
 <br/>
 상세보기를 누르면 약에 대한 상세한 정보들을 확인할 수 있고, 다시 접을 수도 있다.
 
### 3. 로그인/회원가입  
 ![image](https://user-images.githubusercontent.com/97663140/161198755-6ab8c4f6-8a3e-4f2c-aa4d-254a4d08b67e.png)
 로그인이 필요한 화면에서는 로그인을 하지 않으면 화면을 이용할 수 없게 하였다. 
 <br/>
 회원가입은 POST로 이루어지며, 아이디는 중복확인이 가능하게 하였다. 비밀번호와 이메일도 조건에 맞지 않으면 회원가입을 할 수 없도록 하는 로직을 추가하였다. 
 
 

로그인을 유지시키기 위해서 세션 스토리지를 이용해 회원 아이디를 저장해서 이용하였다. 로그아웃하면 아이디가 지워지게 된다. 
### 4.카트에 해당하는 테이블에 저장 
 ![image](https://user-images.githubusercontent.com/97663140/161197580-92fd3918-7e29-4efa-a67f-39fcd33654ad.png)
 <br/>
상세보기 옆의 추가를 클릭하면 자신이 현재 로그인한 아이디와 약품 이름을 POST 요청으로 서버에 보낸다. 이는 사용자와 약을 연결하는 테이블에 저장된다. 

</br>

## :cat:깃허브 활용
기존에 프로젝트를 진행할 때, 제대로 사용하지 못했던 깃허브의 기능들을 활용하고자 했다. (221107~)

- 깃허브 프로젝트 기능을 활용하여 이슈와 연결시켜 프로젝트를 관리
- 깃 플로우 활용
main 브랜치와 Feature 브랜치만 활용하여
로컬에서 main 브랜치를 개발 브랜치로 선정하고
기능 개발할 때만 feature/ 를 붙여 관리하였다.
- 커밋 메시지 컨벤션
프로젝트에서 발행된 이슈 번호를 달아 커밋 메시지를 작성했다.

</br>

## :interrobang: Trouble Shooting

```
📆 기간 2022/3/28 ~ 2022/4/1 
```

### 1. 회원가입 요청을 할 때 post요청을 보내면 CORS에러, 400, 500에러가 종류별로 떴다. 

- METHOD:’post’를 METHOD: ‘POST’로 고쳐주었더니 해결^^

### 2. 약 정보 조회에서 검색이 한번밖에 안되는 오류

서버 실행후 브라우저에서 처음 검색시 데이터를 잘 받아오지만 두번째 검색시 해당 에러 발생.

" java.lang.IllegalArgumentException: Parameter value [] did not match expected type [java.lang.String (n/a)] "

- 처음 코드

List findByitemNameContainingOrEfcItemContaining(String itemName, String efcItem);

Spring에서 제공하는 findBy함수를 이용하여 실행하였지만 두번째 실행했을때 해당 키워드가 제대로 입력되지 않았다.

- 수정 코드

**[@query](https://github.com/query)**("select m from Medi m where m.itemName like %:itemName% or m.efcItem like %:efcItem%")

List searchMediList(**[@param](https://github.com/param)**("itemName") String itemName, **[@param](https://github.com/param)**("efcItem") String efcItem );

- 결론
복잡한 쿼리문은 해당함수가 잘 인식을 못한다고 하는데 복잡한 쿼리문은 Join 정도 되어야지 복잡한 쿼리문인줄 알았다.포함 단어 찾는 조건문이 있는 쿼리문도 복잡한 쿼리문으로 포함하는가 보다.문제 생길시 빠르게 **[@query](https://github.com/query)** 사용해서 처리하면 된다.

##### 주의사항<br/>
쿼리문 작성시 DB 기준이 아닌 Entity 기준으로 작성해야 한다.

### 3. 다대다 테이블 오류

상의 하에 medicinebox에 primarykey를 사용하지 않기로 했는데 스프링에서 primarykey를 넣으라는 말만 남기고 서버를 켜주지 않았다. 

→ 데이터베이스 테이블인 medicinebox에 primarykey를 다시 추가하여 진행하여서 해결하였다.
