#-------------------------------------------------------------------
#Amanda Nguyen 
#amvanguy@ucsc.edu
#CMPS 12B: Intro to Data Structures - Tantalo (Summer 2017)
#
#Program #2: The purpose of this assignment is to
#implement the Binary Search and Merge Sort algorithms to read a file 
#that the user prompts on the command line and searches the file for 
#the target word.
#-----------------------------------------------------------------
# Programming Assignment #2: Makefile
#-----------------------------------------------------------------

JAVASRC = Search.java
SOURCES = README Makefile $(JAVASRC)
MAINCLASS = Search
CLASSES = Search.class
JARFILE = Search
SUBMIT = submit cmps012b-pt.u17 pa2
CHECK = /afs/cats.ucsc.edu/class/cmps012b-pt.u17/pa2/amvanguy

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
