/*
HARSHIT KOOLWAL
0801CS141035

CAESAR CYPHER
*/

//MESSAGE SHOULD BE IN LOWER CASE ONLY

#include<stdio.h>
#include<string.h>

int index_of_character(char x);
char char_of_index(int x);
void encrypt(char old_msg[],char new_msg[],int length,int key);
void decrypt(char enc_msg[],char old_msg[],int length, int key);

int main()
{
	int key;
	char message[100];	
	char encrypted_message[100];
	char decrypted_message[100];
	int length = 0;

	printf("\nEnter msg : ");
	gets(message);
	printf("\nMESSAGE -> %s",message);
	
	printf("\nEnter key : ");
	scanf("%d",&key);

	length = strlen(message);	
	printf("\n%d is length of message.",length);

	encrypt(message,encrypted_message,length,key);	
	printf("\nEncrypted msg : %s\n\n\n",encrypted_message);

	decrypt(encrypted_message,decrypted_message,length,key);	
	printf("\nDecrypted msg : %s\n\n\n",decrypted_message);

	return 0;
}

void encrypt(char old_msg[],char new_msg[],int length,int key)
{
	int temp;
	int i;

	for(i=0;i<length;i++)
	{
		temp = index_of_character(old_msg[i]);		
		
		if(temp!=26)
		{
			temp = (temp+key)%26;		
			new_msg[i]=char_of_index(temp);	
		}	
		else
		{
			new_msg[i]=old_msg[i];			
		}
	}
}

void decrypt(char enc_msg[],char old_msg[],int length, int key)
{
	int temp;
	int i;

	for(i=0;i<length;i++)
	{
		temp = index_of_character(enc_msg[i]);		
		
		if(temp!=26)
		{
			temp = (temp-key)%26;		
			old_msg[i]=char_of_index(temp);	
		}	
		else
		{
			old_msg[i]=enc_msg[i];			
		}
	}
}

int index_of_character(char x)
{
	return x-'a';	
}

char char_of_index(int x)
{
	return x+'a';
}
