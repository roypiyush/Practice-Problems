#include <sys/types.h>
#include <sys/stat.h>
#include <fcntl.h>
#include <stdio.h>


int main(void)
{
    int fd = open("/home/piyush/mnt/D/Programming/Programs_C-C++/testFile", O_RDONLY);
    printf("File IO Result %i\n", fd);
    int fdc = close(fd);
    printf("Closing the file %i\n", fdc);
}
