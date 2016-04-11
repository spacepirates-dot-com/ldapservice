#include <sys/time.h>
#include <stdio.h>

main() {
  struct timeval tim;
  int result = gettimeofday(&tim, NULL);
  if (result == 0) {
    printf("%ld\n", tim.tv_sec);
  } else {
    printf("Something went wrong."); 
  }
}
