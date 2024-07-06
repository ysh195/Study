package ch12.sec12;


import java.lang.annotation.*;


@Target({ElementType.METHOD}) // 이건 {} 있음
@Retention(RetentionPolicy.RUNTIME) // 이건 {} 없음

public @interface PrintAnnotation {
	String value() default "-"; // default 뒤의 값은 여기에 아무것도 입력 안 되면 기본적으로 있는 걸로 취급할 값임
	int number() default 15;

}
