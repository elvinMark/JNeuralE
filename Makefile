test:
	javac -d ./build -sourcepath ./src src/com/etest/eTest.java
	java -cp ./build com.etest.eTest

clean:
	rm -r build/*

