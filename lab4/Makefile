#-------------------------------------------------------------------------
#Amanda Nguyen 
#amvanguy@ucsc.edu
#CMPS 12M: Tantalo (Summer 2017)
#
#Lab #4: The purpose of this assignment is to  get more practice programming 
#in C, including the character functions in the library ctype.h, and dynamic 
#memory allocation using malloc, calloc, and free
#-------------------------------------------------------------------------
# Makefile for charType.c
# ------------------------------------------------------------------------


FLAGS = -std=c99 -Wall
SOURCES = charType.c README Makefile
OBJECTS = charType.o
EXEBIN = charType
SUBMIT = submit cmps012b-pt.u17 lab4

all: $(EXEBIN)
$(EXEBIN) : $(OBJECTS)
	gcc -o $(EXEBIN) $(OBJECTS)

$(OBJECTS) : $(SOURCES)
	gcc -c $(FLAGS) $(SOURCES)

clean :
	rm -f $(EXEBIN) $(OBJECTS)

submit: $(SOURCES)
	$(SUBMIT) $(SOURCES)

check:
	valgrind --leak-check=full $(EXEBIN) in out
