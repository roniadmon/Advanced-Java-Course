### Generics - annotations - reflection

Intro to generics

https://docs.oracle.com/javase/tutorial/extra/generics/intro.html

Intro to annotations

https://docs.oracle.com/javase/tutorial/java/annotations/index.html

Intro to reflection

1. https://www.journaldev.com/1789/java-reflection-example-tutorial
2. https://howtodoinjava.com/java/reflection/real-usage-examples-of-reflection-in-java/

Exercise

1. Create an annotation named `MyAnnotation`.
2. Create a class `MyClass` with some fields and 4 methods:
  - `@MyAnnotation public void a()`
  - `public void b()`
  - `@MyAnnotation public <T extends String> void c(T t)`
  - `@MyAnnotation public <T extends Long> void d(T t)`
3. In the main, create an instance of `MyClass` and print all the annotated fields and methods
4. Why do you not see `<T extends String>`?
