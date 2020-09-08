# springboot-portfolio-resume(무중단 배포 nginx)  [![Build Status](https://travis-ci.org/lang2s/springboot-portfolio-resume.svg?branch=master)](https://travis-ci.org/lang2s/springboot-portfolio-resume)
- http://ec2-52-79-163-154.ap-northeast-2.compute.amazonaws.com/

## index
 <img width="430" alt="index" src="https://user-images.githubusercontent.com/56714431/91278979-e4b41b80-e7bf-11ea-8e88-8eeecdf57e15.PNG"> <img width="465" alt="Portfolio-resume" src="https://user-images.githubusercontent.com/56714431/91277196-7706f000-e7bd-11ea-8da4-352c1b1e659c.PNG">

+ intelliJ
+ Gradle 4.10.2 
+ java8(JDK 1.8)
+ SpringDataJpa
+ SprigBoot 2.1.7
+ 단위 테스트
+ H2(테스트용 데이터 베이스)
+ Mustache, bootstrap 4.3.1
+ OAuth2
+ AWS(IaaS), RDS(MariaDB), E3, CodeDeploy, EC2, putty
+ google, Naver login Api
+ Travis Ci
+ Nginx

---------------------------------------------------------------------

## login & out

<img width="632" alt="로그인" src="https://user-images.githubusercontent.com/56714431/90774172-fc0f8680-e331-11ea-969a-894aec01bc15.PNG">

<img width="416" alt="로그아웃" src="https://user-images.githubusercontent.com/56714431/90774178-fd40b380-e331-11ea-9dbe-6a984f9f8413.PNG">

------------------------------------------------------------------------

## About

<img width="464" alt="About" src="https://user-images.githubusercontent.com/56714431/90774575-a5ef1300-e332-11ea-945f-3271e05edded.PNG">

-----------------------------------------------------------------------

## Works

<img width="921" alt="works" src="https://user-images.githubusercontent.com/56714431/90774191-029dfe00-e332-11ea-8f78-048200390646.PNG">

------------------------------------------------------------------------

## Board
- BoardList GetMapping("/board") Model model, @LoginUser SessionUser user

   <img width="600" alt="boardList" src="https://user-images.githubusercontent.com/56714431/91276427-7faaf680-e7bc-11ea-8b6e-13b5f848314f.PNG">

- BoardDetail GetMapping("/board/detail/{id}") @PathVariable Long id, Model model, @LoginUser SessionUser user

   <img width="600" alt="boardDetail" src="https://user-images.githubusercontent.com/56714431/91282183-fa2b4480-e7c3-11ea-84a4-79f3683e7557.PNG">

   <img width="460" alt="detail" src="https://user-images.githubusercontent.com/56714431/91282203-00b9bc00-e7c4-11ea-9108-584afc6bd869.PNG"> 

- BoardSave PostMapping("/api/board") @RequestBody BoardSaveRequestDto

  <img width="600" alt="boardSave" src="https://user-images.githubusercontent.com/56714431/91288108-8c831680-e7cb-11ea-9a80-00a52d10ef6c.PNG">
  
  <img width="435" alt="boardsave" src="https://user-images.githubusercontent.com/56714431/91288226-b6d4d400-e7cb-11ea-949d-23478d9cdeb3.PNG">
  
- BoardUpdate PutMapping("/api/board/{id}") @PathVariable Long id, @RequestBody BoardUpdateRequestDto

 <img width="600" alt="update" src="https://user-images.githubusercontent.com/56714431/91291750-79bf1080-e7d0-11ea-829c-4165b3133977.PNG">
 
 <img width="437" alt="update" src="https://user-images.githubusercontent.com/56714431/91291777-8479a580-e7d0-11ea-9ecb-b8874766d782.PNG">
 
- BoardDelete DeleteMapping @PathVariable Long id

 <img width="600" alt="delete" src="https://user-images.githubusercontent.com/56714431/91292636-c22afe00-e7d1-11ea-953a-aceae9e6fa27.PNG">
