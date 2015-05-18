# FlyCapture2Test makefile
# To compile the debug verison need to overwrite CXXFLAGS variable to include -ggdb

CC = gcc
#-fPIC flag is related to memory position of the library
CFLAGS = -fPIC -c
#linker flag I think for shared library
#LDFLAGS = -shared

TARGET = libflyCapture2JNI_Interface64_TEST.so

SOURCES = FlyCapture2JNI_Interface.c 
#HEADERS = PointGreyCameraInterface.h /usr/include/flycapture/C/*.h
OBJECTS = FlyCapture2JNI_Interface.o

#OUTPUTNAME = libFlyCapture2JNI_Interface_64.so
INCLUDE = -I/usr/lib/jvm/java-7-openjdk-amd64/include -I/usr/lib/jvm/java-7-openjdk-amd64/include/linux -I/usr/include/flycapture/C
LIBS = -L/usr/lib -lflycapture-c 

#OUTDIR = .

#OBJS = FlyCapture2Test.o


all: $(TARGET)
	
#$(TARGET): $(OBJECTS)
#	$(CC) $(CFLAGS) -o $@ $(LDFLAGS)
	
#FlyCapture2JNI_Inferface.o : FlyCapture2JNI_Inferface.c PointGreyCameraInterface.h /usr/include/flycapture/C/FlyCapture2_C.h
#	$(CC) $(CFLAGS) $<
	

${TARGET}: ${OBJECTS}
	ld -shared -o $@ ${LIBS} $<
	
	
${OBJECTS}: ${SOURCES} 
	${CC} ${CFLAGS} ${INCLUDE} $< -o $@
	

#${OUTPUTNAME}: ${OBJS}
#	${CC} -o ${OUTPUTNAME} ${OBJS} ${LIBS} ${COMMON_LIBS} 
	

#%.o: %.cpp
#	${CC} ${CFLAGS} ${INCLUDE} -c $*.cpp
	
clean_obj:
	rm -f ${OBJS}	@echo "all cleaned up!"

clean:
	rm -f ${OBJECTS} ${TARGET}	@echo "all cleaned up!"
