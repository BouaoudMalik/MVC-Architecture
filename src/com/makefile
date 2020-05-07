CMD = java
COMPILE = javac



compile: 
	@echo "-------------------------------------------------------------------------"
	@echo "compilation des classes puzzle..."
	@echo "-------------------------------------------------------------------------"
	cp -rf ../ressources ressources && $(COMPILE) model/*.java util/*.java view/*.java 
	

compile-tests:
	@echo "-------------------------------------------------------------------------"
	@echo "compilation des classes de tests..."
	@echo "-------------------------------------------------------------------------"
	$(COMPILE) -cp ../../jarJunit/hamcrest-core-1.3.jar:../../jarJunit/junit-4.13-rc-1.jar:. test/*.java 	


start:
	@echo "-------------------------------------------------------------------------"
	@echo "lancement de l'application..."
	@echo "-------------------------------------------------------------------------"
	$(CMD) model.Main
	
start-tests:
	@echo "-------------------------------------------------------------------------"
	@echo "lancement des tests unitaires..."
	@echo "-------------------------------------------------------------------------"
	$(CMD) -cp .:../../jarJunit/hamcrest-core-1.3.jar:../../jarJunit/junit-4.13-rc-1.jar org.junit.runner.JUnitCore test.PuzzleTest

	

pipeline: compile compile-tests start-tests start clean delete   

clean:
	rm -r model/*.class
	rm -r util/*.class
	rm -r test/*.class
	rm -r view/*.class

delete:
	rm -rf ressources		