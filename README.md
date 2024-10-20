# java-calculator-precourse

# 문자열 덧셈 계산기

입력한 문자열에서 구분자를 기준으로 숫자를 추출하여 더하는 계산기를 구현한다.

## 기능 요구 사항

1. 쉼표(,) 또는 콜론(:)을 구분자로 가진 문자열을 전달하는 경우, 구분자를 기준으로 숫자들을 분리한 후 각 숫자의 합을 반환한다.
    - 예시:
        - `""` => 0
        - `"1,2"` => 3
        - `"1,2,3"` => 6
        - `"1:2:3"` => 6
        - `"1,2:3"` => 6
        - `"11111111111111111111111111111111111111111111111111111111111111111111111111111110.1,1"` => 11111111111111111111111111111111111111111111111111111111111111111111111111111111.1


2. 앞의 기본 구분자(쉼표, 콜론) 외에 **커스텀 구분자**를 지정할 수 있다. 커스텀 구분자는 문자열 앞부분에 `//`와 `"\n"` 사이에 위치하는 문자를 구분자로 사용한다. 커스텀 구분자를 활성화한다면 기본 구분자는 비활성화된다.
    - 예시:
        - `"//;\n1;2;3"` => 커스텀 구분자는 세미콜론(`;`), 결과 값은 6


3. 사용자가 잘못된 값을 입력한 경우, `IllegalArgumentException`을 발생시키고 애플리케이션은 종료되어야 한다.

---

## 입력 형식 제약

1. 구분자를 연속으로 사용할 수 있다. 
   - 예시:
       - `"1,,2"`
       - `"//;\n1;;;;;;;;;2;3"`  
     

2. 구분자는 문자열의 처음이나 끝에 위치할 수 있다.
   - 예시:
       - `","` (입력 문자열에 구분자만 있다면, 문자열의 처음과 끝에 구분자가 위치하는 것이다)
       - `",1,2"`
       - `"1,2,"`
       - `":1:2:3:"`
       - `"//;\n;1;2;3"`
       - `"//%\n%1%2%3"`


3. 커스텀 구분자는 단일 문자만 허용된다. 문자열로 이루어진 구분자는 사용할 수 없다.
    - 잘못된 입력 예시:
        - `"//;;\n1;;2;;3"`
        - `"//$#\n$#1$#2$#3"`
        - `"//\r\n1\ra\r2"` (커스텀 구분자로 \r를 설정할 수 없다.)


4. 커스텀 구분자는 한 개만 사용할 수 있다.
    - 잘못된 입력 예시:
        - `"//;&\n1;2&3"`
        - `"//;,&\n1;2&3"`
        - `"//[;][&]\n1;2&3"`


5. **숫자는 양수만 입력할 수 있다**. 음수나 0은 허용되지 않는다.
    - 올바른 입력 예시:
        - `"//;\n3.14159265358979;3.141592;3.14;3"`
        - `"1998,6.08"`
        - `"0.000000001`
    - 잘못된 입력 예시:
        - `"//;\n-1;2;3"`
        - `"//;\n-1.5;2.5"`
        - `"//;\n0;2;3"`


6. **숫자 대신 문자 입력은 허용되지 않는다**. 숫자 대신 문자가 들어오면 예외가 발생해야 한다.
    - 잘못된 입력 예시:
        - `"mybirthday,6.08"`
        - `"//;\n1;a;2"`
        

7. **숫자는 앞에 불필요한 0을 포함할 수 없다**.
    - 잘못된 입력 예시:
        - `"1998,06.08"`
        - `"//;\n03.14;2;3"`
        - `"1000,0001,0101,01"`


8. **커스텀 구분자에 숫자는 사용할 수 없다**.
    - 올바른 입력 예시:
        - `"//a\n1a2a3"` (알파벳 소문자가 구분자로 사용됨)
        - `"//C\n1C2C3"` (알파벳 대문자가 구분자로 사용됨)
    - 잘못된 입력 예시:
        - `"//1\n11213"` (숫자가 구분자로 사용됨)


9. **입력 문자열에 공백은 허용되지 않는다**.
    - 잘못된 입력 예시:
        - `"1, 2, 3, 45 67 89"`
        - `"//;\n1; 2; 3"`
        - `"// ; \n1 ; 2 ; 3"`


---

## 입출력 요구 사항

- **입력**: 구분자와 양수로 구성된 문자열
- **출력**: 덧셈 결과
  - 사용자가 잘못된 형식의 입력을 제공할 경우, `IllegalArgumentException`을 발생시켜 프로그램이 종료되도록 한다.


## 실행 결과 예시
- 커스텀 구분자를 사용하지 않은 경우
    - 입력: `"1,2:3"`
    - 출력:
      ```
      결과 : 6
      ```

- 커스텀 구분자를 사용한 경우:
    - 입력: `"//;\n1;2;3"`
    - 입력: `"//a\n1a2a3"`
    - 출력:
      ```
      결과 : 6
      ```

- 잘못된 입력:
    - 입력: `"//;;\n1;;2;;3"`
    - 입력: `"//;,&\n1;2&3"`
    - 입력: `"//;\n-1;2;3"`
    - 입력: `"mybirthday,6.08"`
    - 입력: `"1998,06.08"`
    - 입력: `"//1\n11213"`
    - 입력: `"1, 2, 3, 45 67 89"`
    - 출력:
      ```
      IllegalArgumentException 발생
      ```


---


## 프로그래밍 요구 사항

1. **JDK 버전**: JDK 21 버전에서 실행 가능해야 한다.
2. **프로그램 시작점**: `Application` 클래스의 `main()` 메서드에서 프로그램이 시작되어야 한다.
3. **외부 라이브러리 사용 제한**: `build.gradle` 파일은 변경할 수 없으며, 제공된 라이브러리 이외의 외부 라이브러리는 사용할 수 없다.
4. **프로그램 종료 방식**: 프로그램 종료 시 `System.exit()`를 호출하지 않는다.
5. **파일 및 패키지 구조 유지**: 요구 사항에서 달리 명시하지 않는 한, 파일 및 패키지의 이름을 바꾸거나 이동하지 않는다.
6. **코드 컨벤션**: 자바 코드 컨벤션을 지키면서 프로그래밍하며, 기본적으로 **Java Style Guide**를 준수한다.
7. **입력 처리**: `camp.nextstep.edu.missionutils.Console`에서 제공하는 `readLine()` 메서드를 사용하여 사용자 입력을 처리한다.


---


## 프로그램 전체 흐름

- **입력**: 사용자가 올바른 형식의 문자열을 입력한다.
- **구분자 추출**: 입력된 문자열에서 기본 구분자 또는 커스텀 구분자를 파악한다. 잘못된 형식일 경우 예외를 발생시킨다.
- **숫자 추출**: 구분자를 기준으로 숫자를 추출한다. 구분자가 연속되거나 잘못된 위치에 있을 경우 예외를 발생시킨다.
- **숫자 변환**: 추출된 숫자를 모두 `BigDecimal`로 변환하고 배열로 저장한다. 변환 과정에서 잘못된 형식이거나 변환 불가능한 값이 있을 경우 예외를 처리한다.
- **양수 체크**: 변환된 `BigDecimal` 값이 양수인지 검사한다. 음수나 0이 있을 경우 예외를 발생시킨다.
- **덧셈**: 유효한 `BigDecimal` 배열로 덧셈을 수행한다.
- **출력**: 결과를 `결과: <결과값>` 형식으로 출력한다.


## 클래스 - 역할과 책임

### 1. **InputOutputHandler**

- **역할**: 입력과 출력을 처리하는 역할을 맡는다.

- **책임**:
    - 사용자의 입력을 받는다.
    - 최종 계산 결과를 적절한 형식으로 출력한다.

---

### 2. **DelimiterManager**

- **역할**: 구분자 처리와 입력 문자열의 분리를 담당하는 역할을 맡는다.

- **책임**:
    - 구분자가 없는 경우 기본 구분자(쉼표, 콜론)를 사용해 문자열을 분리한다.
    - 커스텀 구분자가 있으면 이를 추출하고, 구분자를 기준으로 숫자를 분리하여 **NumberProcessor**에게 전달할 준비를 한다.

---

### 3. **NumberProcessor**

- **역할**: 숫자를 처리하고 계산하는 역할을 맡는다.

- **책임**:
    - **DelimiterManager**로부터 전달받은 숫자 배열을 `BigDecimal`로 변환하여 덧셈 연산을 수행한다.
    - 숫자가 유효한지 검사하고, 음수나 0이 있으면 예외를 발생시킨다.
    - 최종 계산 결과를 반환한다.

---

### 4. **Coordinator**

- **역할**: **InputOutputHandler**, **DelimiterManager**, **NumberProcessor** 간의 조정 역할을 맡는다.

- **책임**:
    - **InputOutputHandler**로부터 입력을 받아 **DelimiterManager**에 구분자 처리를 요청한다.
    - 구분자 처리 후, **NumberProcessor**에게 숫자 처리와 계산을 요청한다.
    - 계산된 결과를 **InputOutputHandler**에 전달하여 출력을 수행하게 한다.