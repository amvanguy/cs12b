#-------------------------------------------------------------------------
#Amanda Nguyen 
#amvanguy@ucsc.edu
#CMPS 12M: Tantalo (Summer 2017)
#
#Lab #1: The purpose of this assignment is to
#(1)get a basic introduction to the Andrew File System(AFS)
#(2)learn how to create an executable jar file containing a
#Java program
#(3) learn to automate compilation and other tasks using Makefiles.
#---------------------------------------------------------------
# Another Makefile with macros
#---------------------------------------------------------------------------

JAVASRC = HelloUser.java HelloUser2.java
SOURCES = README Makefile $(JAVASRC)
MAINCLASS = HelloUser2
CLASSES = HelloUser.class HelloUser2.class
JARFILE = Hello
SUBMIT = submit cmps012b-pt.u17 lab1
CHECK = /afs/cats.ucsc.edu/class/cmps012b-pt.u17/lab1/amvanguy

all: $(JARFILE)

$(JARFILE): $(CLASSES)
	echo Main-class: $(MAINCLASS) > Manifest
	jar cvfm $(JARFILE) Manifest $(CLASSES)
	rm Manifest
	chmod +x $(JARFILE)

$(CLASSES): $(JAVASRC)
	javac -Xlint $(JAVASRC)

clean:
	rm $(CLASSES) $(JARFILE)

submit: $(SOURCES)
	$(SUBMIT) $(SOURCES)

check:
	ls $(CHECK)
