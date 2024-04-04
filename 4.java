//Q4:Write a Java Program to find the duplicate characters in a string.


class DuplicateCharacters{
	public static void main(String[]args){
		String str=new String("Shrutii");
		int count=0;
		char ch[]=str.toCharArray();
		for(int i=0;i<ch.length;i++){
			for(int j=1;j<ch.length;j++){
				if(ch[i]==ch[j]){
					System.out.println("Duplicate character :"+ch[j]);
					count++;
				}
			}
		}
		System.out.println("Duplicate character count:"+count);
	}
}
