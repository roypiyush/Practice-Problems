#include <stdio.h>
#include <string.h>

void swap (char *x, char *y)
{
    char temp;
    temp = *x;
    *x = *y;
    *y = temp;
}

/* Function to print permutations of string
   This function takes three parameters:
   1. String
   2. Starting index of the string
   3. Ending index of the string. */
void permute(char *a, int i, int n)
{
   int j;
   if (i == n)
     printf("%s\n", a);
   else
   {
        for (j = i; j <= n; j++)
       {
          swap((a+i), (a+j));
          permute(a, i+1, n);
          swap((a+i), (a+j)); //backtrack
       }
   }
} 

/* Driver program to test above functions */
int main()
{
    
   char a[] = "cdefghmnopqrstuvw";
   int len = strlen(a);
   printf("%d", len);
   permute(a, 0, len - 1);
   return 0;
}
