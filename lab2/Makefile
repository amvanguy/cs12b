#-------------------------------------------------------------------
#Amanda Nguyen 
#amvanguy@ucsc.edu
#CMPS 12M: Intro to Data Structures - Tantalo (Summer 2017)
#
##Program #1: The purpose of this assignment is to
#gain experience implementing recursive algorithms in Java. You 
#will write five recursive methods with headings. 
#---------------------------------------------------------------
# Programming Assignment #1: Makefile
# ---------------------------------------------------------------

JAVASRC = FileReverse.java
SOURCES = README Makefile $(JAVASRC)
MAINCLASS = FileReverse
CLASSES = FileReverse.class
JARFILE = FileReverse
SUBMIT = submit cmps012b-pt.u17 lab2
CHECK = /afs/cats.ucsc.edu/class/cmps012b-pt.u17/lab2/amvanguy

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

