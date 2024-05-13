#include <stdio.h>
#include <string.h>
int main() {
	char s[30001], key[30001];
	int j = 0;
	gets(s); gets(key);
    for (int i = 0; i < strlen(s); i++) {
		if (s[i] != ' ') {
			if (s[i] <= key[j]) 
			    s[i] = s[i] - key[j] + ('a' - 1) + 26;
		    else
			    s[i] = s[i] - key[j] + ('a' - 1);
		}
		j = (j + 1) % strlen(key);
	}
	printf("%s", s);
}