## 프로젝트 명 : MySecretary

> [Mysecretary Service URL](http://ec2-13-209-26-145.ap-northeast-2.compute.amazonaws.com/, "project")

> front-end project git address: [Mysecretary_front_gitrepository](https://github.com/pgh7659/mini-mysecretary-frontend/, "front link")

----------
#### 개요

```
sns 로그인(google, naver) 기능 + TODO API SERVER입니다.
```

----------
#### 프로젝트 목표

1. sns 로그인 기능 구현
    - spring-security & oauth2-client 사용하여 구현
    - 최초 로그인 시, DB USER테이블에 사용자정보(email, name, provider) 저장
    


2. todo list API 
    - 조회(GET) - 로그인한 유저의 해당 날짜 todo 목록 조회
    - 생성(POST) - 새로운 목록 생성
    - 수정(PUT) - 선택한 목록 상태 update(완료/미완료)
    - 삭제(DELETE) - 선택한 목록 삭제    


   
3. AWS EC2에 배포하기
----------
#### stack

- springboot
- spring-security & oauth
- JPA
- MariaDB
