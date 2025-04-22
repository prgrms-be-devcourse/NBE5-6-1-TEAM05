# Project Convention

## Rest API

1. (/)는 계층 관계를 나타내는 데 사용한다.
2. URI 끝에 (/)를 포함하지 않는다.
3. (-)은 URI 가독성을 높이는데 사용한다.
4. 밑줄(_)은 URI에 사용하지 않는다.
5. URI 경로에는 소문자가 적합하다. 
* RFC 3986(URI 문법 형식)은 URI 스키마와 호스트를 제외하고는 대소문자를 구별하도록 규정
6. 파일 확장자는 URI에 포함 시키지 않는다 (확장자는 Accept header를 사용)
7. 리소스간 has 관계인 경우 **‘/리소스명/리소스ID/관계가 있는 리소스명 ‘** 형태로 표현한다. 
    
    다른 동사가 필요한 경우에는 서브리소스에 명시적으로 추가한다.
    
    ex) /user/azi/pick/product
    

### 자바 code convention

기본적으로 Google Java Style Guide 를 따른다.

https://google.github.io/styleguide/javaguide.html

### 클래스 명명 규칙

1. DTO 와 VO 의 구분은 DTO로 통일한다.
2. DTO 클래스의 이름 뒤에 Dto 를 붙인다.
ex) MemberDto
3. 요청 파라미터를 받는 DTO 이름 뒤에  Request 를 붙인다.
ex) SignupRequest
4. 응답 데이터를 저장하는 DTO 뒤에 Response 를 붙인다. 
ex) ProductListResponse

### 변수 명명 규칙

1. List 자료형 변수명은 복수형으로 끝낸다.  
ex) coffees
2. 그 외의 자료형 변수명 은 뒤에 자료형 타입을 명시한다.  
ex) coffeeSet, coffeeMap
3. 약어의 사용은 지양한다.
4. 매개변수에는 예외적으로 약어를 허용한다.

### 메서드 명명 규칙

1. 클래스 + 메서드 이름을 통해 기능이 적확히 명시될 수 있도록 작성한다.
2. 불필요한 명사의 중복은 제거한다.
ex) Book.getBookList (x), Book.getList(o)

# Git Commit Convention

## 커밋 메시지의 7가지 규칙

제목과 본문을 빈 행으로 구분한다.
제목은 50글자 이내로 제한한다.
제목의 첫 글자는 대문자로 작성한다.
제목 끝에는 마침표를 넣지 않는다.
제목은 명령문으로 사용하며 과거형을 사용하지 않는다.
본문의 각 행은 72글자 내로 제한한다.
어떻게 보다는 무엇과 왜를 설명한다.

### 커밋 메시지 구조
```
// Header, Body, Footer는 빈 행으로 구분한다.
타입(스코프): 주제(제목) // Header(헤더)

본문 // Body(바디)

바닥글 // Footer
Header는 필수이며 스코프는 생략 가능하다.
```

### 커밋 타입

타입은 해당 커밋의 성격을 나타내며 아래 중 하나여야 한다.

| 타입 이름 | 내용 |
|-----------|------|
| feat      | 새로운 기능에 대한 커밋 |
| fix       | 버그 수정에 대한 커밋 |
| build     | 빌드 관련 파일 수정 / 모듈 설치 또는 삭제에 대한 커밋 |
| chore     | 그 외 자잘한 수정에 대한 커밋 |
| ci        | CI 관련 설정 수정에 대한 커밋 |
| docs      | 문서 수정에 대한 커밋 |
| style     | 코드 스타일 혹은 포맷 등에 관한 커밋 |
| refactor  | 코드 리팩토링에 대한 커밋 |
| test      | 테스트 코드 수정에 대한 커밋 |
| perf      | 성능 개선에 대한 커밋 |


Body는 Header에서 표현할 수 없는 상세한 내용을 적는다.

Header에서 충분히 표현할 수 있다면 생략 가능하다.

Footer는 바닥글로 어떤 이슈에서 왔는지 같은 참조 정보들을 추가하는 용도로 사용한다.

예를 들어 특정 이슈를 참조하려면 Issues #1234 와 같이 작성하면 된다.

Footer는 생략 가능하다.
