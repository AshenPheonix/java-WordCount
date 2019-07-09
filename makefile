all: compile link

compile:
	javac src/counter/*.java -d build

link:
	jar cvfe Dogs.jar counter.Main -C build counter/