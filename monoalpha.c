/*
HARSHIT KOOLWAL
0801CS141035

MONO-ALPHABETIC CAESAR
*/

#include<stdio.h>
#include<string.h>

char index_table[26]={"qwertyuiopasdfghjklzxcvbnm"};

void encrypt(char old_msg[],char new_msg[],int length);
void decrypt(char enc_msg[],char old_msg[],int length);
int index_of_character(char x);
int index_of_key_characters(char x);

int main()
{
	char message[100];	
	char encrypted_message[100]={""};
	char decrypted_message[100]={""};
	int length = 0;

	printf("\nEnter msg : ");
	gets(message);
	printf("\nMESSAGE -> %s",message);
	
	length = strlen(message);	

	encrypt(message,encrypted_message,length);	
	printf("\nENCRYPTED MESSAGE : %s\n",encrypted_message);

	decrypt(encrypted_message,decrypted_message,length);	
	printf("\nDECRYPTED MESSAGE : %s\n\n\n",decrypted_message);

	return 0;
}

void encrypt(char old_msg[],char new_msg[],int length)
{
	int i=0;
	int temp=0;
	for(i=0;i<length;i++)
	{	
		temp = index_of_character(old_msg[i]);
			
		if(temp!=26)
			new_msg[i] = index_table[temp];		
		else
			new_msg[i] = old_msg[i];
	}
}


void decrypt(char enc_msg[],char old_msg[],int length)
{
	int i=0;
	int temp=0;
	for(i=0;i<length;i++)
	{	
		temp = index_of_key_characters(enc_msg[i]);
			
		if(temp!=-1)
		{
			old_msg[i] = temp+'a';	
		}
		else
			old_msg[i] = enc_msg[i];
	}
}

int index_of_key_characters(char x)
{
	int i=0;

	for(i=0;i<26;i++)
	{
		if(index_table[i]==x)
			return i;		
	}

	return -1;
}

int index_of_character(char x)
{
	return x-'a';	
}

