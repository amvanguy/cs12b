FLAGS = -std=c99 -Wall
SOURCES = FileReverse.c README Makefile
OBJECTS = FileReverse.o
EXEBIN = FileReverse
SUBMIT = submit cmps012b-pt.u17 lab3
CHECK = /afs/cats.ucsc.edu/class/cmps012b-pt.u17/lab3/amvanguy

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
	ls $(CHECK)
