test:
	javac -d ./build -sourcepath ./src src/com/etest/eTest.java
	java -cp ./build com.etest.eTest
all:
	javac -d ./build -sourcepath ./src src/com/emath/*.java
	javac -d ./build -sourcepath ./src src/com/eneural/*.java
	javac -d ./build -sourcepath ./src src/com/eutil/*.java
clean:
	rm -r build/*

jar:
	jar -cf JNeuralE -C ./build .
