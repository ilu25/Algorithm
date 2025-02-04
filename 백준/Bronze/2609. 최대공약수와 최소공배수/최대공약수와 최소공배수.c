#include <stdio.h>
int main() {
	int a, b, max = 0, min = 0, i;
	scanf("%d %d", &a, &b);
	for (i = 1; i <= a && i <= b; i++)
	{
		if (a % i == 0 && b % i == 0)
			max = i;
	}
	i = 1;
	if (max == 1)
		min = a * b;
	else
	{
		while (1)
		{
			if ((max * i) % a == 0 && (max * i) % b == 0)
			{
				min = max * i;
				break;
			}
			i++;
		}
	}
	printf("%d\n%d\n", max, min);
	return 0;
}