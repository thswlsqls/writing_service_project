# writing_service_project

---------
## 1. 개요
---------
자바언어와 오라클 데이터베이스를 사용한 글쓰기 서비스입니다. 
사용자의 감정 응답에 따라 글감을 제공하고 타인의 글에 반응을 등록할 수 있습니다.
오라클 클라우드 데이터베이스, AWS 클라우드를 사용해 리눅스 서버에 배포하고 쉘스크립트로 무중단 되도록 했습니다.

### 배포주소: 3.39.148.41

--------
## 2. 개발인원 및 일정
--------
### 개발인원
5명 - 김용헌, 김찬기, 박인혁, 손은빈, 장현희 

### 개발일정
20220506 ~ 20220517

### 업무분업과 공유내역 버전관리
[4팀_업무리스트.xlsx](https://github.com/thswlsqls/writing_service_project/files/8721893/4._.xlsx)


--------
## 3. 개발환경 및 설계
--------
### 요구사항 명세
<img width="1295" alt="image" src="https://user-images.githubusercontent.com/58901024/170381646-596298ab-19f8-4ced-a60a-9de944e285f4.png">

### 사이트맵 구조도
<img width="1295" alt="image" src="https://user-images.githubusercontent.com/58901024/170381691-21a9d80a-fb92-4db1-87a7-2917bc9cad77.png">

### 데이터 모델링
<img width="1295" alt="image" src="https://user-images.githubusercontent.com/58901024/170381713-17961899-3727-4dba-8170-6d5f3623b898.png">


--------
## 4. 배포환경
--------
Database : Oracle Cloud

Server Instance : AWS

Web Server : Apache Tomcat 9.0

etc : ctontab, shellscript, iptables 등 활용해 자동화, 포트포워딩 설정함

<img width="1295" alt="image" src="https://user-images.githubusercontent.com/58901024/170381810-514204fa-151d-4485-96fa-2fb87b4fe7b4.png">

<img width="1295" alt="image" src="https://user-images.githubusercontent.com/58901024/170381819-24bd34f3-bd81-419d-b573-7769662d9d6d.png">


--------
## 5. 실행영상 및 캡처화면
--------

https://user-images.githubusercontent.com/58901024/169180982-eded01ea-d493-4f14-bdc7-1e4de524394f.mp4


### 테스트 배포 주소 - 3.39.148.41

<img width="1295" alt="image" src="https://user-images.githubusercontent.com/58901024/170381878-4cc641b1-96cb-490d-8854-4eac786bc478.png">

<img width="1295" alt="image" src="https://user-images.githubusercontent.com/58901024/170381897-d1621269-b18d-436e-9c85-d1cc83bfb72c.png">

<img width="1295" alt="image" src="https://user-images.githubusercontent.com/58901024/170381887-2f8e22c7-958d-44a0-807e-fefe680eaf3e.png">

<img width="1295" alt="image" src="https://user-images.githubusercontent.com/58901024/170381907-42280bbb-52a8-453f-b3ae-0e2abf6df40a.png">


## 6. 구현 산출물

### 클래스 다이어그램

<img width="1295" alt="image" src="https://user-images.githubusercontent.com/58901024/170381993-7fe02f26-6960-4f69-bf5a-8f3de23dee79.png">

<img width="1295" alt="image" src="https://user-images.githubusercontent.com/58901024/170382009-cf8026bc-1ee4-4ea2-90e7-bbb9c6087fc3.png">



## 7. 팀 후기
### 이식성 있게 UI 를 설계하고 인수테스트 후 수정사항에 반영함
<img width="1295" alt="image" src="https://user-images.githubusercontent.com/58901024/170382160-03930251-03be-4045-a5a1-14e9b52e7463.png">


