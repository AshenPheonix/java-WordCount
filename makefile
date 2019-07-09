all: compile link

compile:
	javac src/counter/*.java -d build

link:
	jar cvfe WordCount.jar counter.Main -C build counter/