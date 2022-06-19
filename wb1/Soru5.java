package wb1;




public class Soru5 {
	//Burada bir key olu�turuyorum ve keyi Stringin uzunlu�u kadar tekrarlat�yorum.
	static String keyOlustur(String str, String key)
	{
	    int x = str.length(); 
	 
	    for (int i = 0; ; i++) 
	    {					   
	        if (x == i)
	            i = 0;
	        if (key.length() == str.length())
	            break;
	        key+=(key.charAt(i));
	    }
	    return key;
	}
	 
	// Bu fonksiyon �ifreli string �retmek i�in girilen string ile keyin indisini toplaycak
	
	static String sifreliText(String str, String key)
	{
	    String sifreli_text="";
	 
	    for (int i = 0; i < str.length(); i++)
	    {
	    	//Stringe key ekleyerek sifreliText olu�turuyorum
	        int x = (str.charAt(i) + key.charAt(i)) %26;
	 
	        // alfabeyi (ASCII)' ya �eviriyorum 
	        x += 'A';
	 
	        sifreli_text+=(char)(x);
	    }
	    return sifreli_text;
	}
	 
	// Bu fonksiyon �ifreli stringi orjinal haline �evirecek
	
	static String orjinalText(String sifreli_text, String key)
	{
	    String orj_text="";
	 
	    for (int i = 0 ; i < sifreli_text.length() &&
	                            i < key.length(); i++)
	    {
	    	//�ifreliText'ten Key'i ��kararak orjinal metni buluyorum
	        int x = (sifreli_text.charAt(i) -
	                    key.charAt(i) + 26) %26;
	 
	        // alfabe (ASCII)'ya �evriliyor
	        x += 'A';
	        orj_text+=(char)(x);
	    }
	    return orj_text;
	}
	 
	// Bu fonksiyonla girilen k���k harfler b�y�k harflere �evriliyor
	static String LowerToUpper(String s)
	{
	    StringBuffer str =new StringBuffer(s);
	    for(int i = 0; i < s.length(); i++)
	    {
	        if(Character.isLowerCase(s.charAt(i)))
	        {
	            str.setCharAt(i, Character.toUpperCase(s.charAt(i)));
	        }
	    }
	    s = str.toString();
	    return s;
	}
	
	//Key Girilen stringden uzun olursa �ALI�MAZ!!!!!
	//Olu�turdu�um Stringde 0. indis A bu y�zden A ge�en key b�lgelerine denk gelen
	//T�rk�e karakterleri desteklettiremedim hocam kusura bakmay�n :(
	//��frelenecek metine bo�luk koyuldu�unda "T" olarak �eviriyor bunun neden oldu�unu bulamad�m.
	// Kodun Deneme K�sm�
	public static void main(String[] args)
	{											
	    String Str = "ORHAN BURADAN GECTI";	//�ifrelenmek istenen metin				
	    String Sifre = "ABCDE";					
	      										
	      String str = LowerToUpper(Str);		
	      String sifre = LowerToUpper(Sifre);	
	    String key = keyOlustur(str, sifre);	
	    String sifreli_text = sifreliText(str, key);
	 
	    System.out.println("Original/Decrypted Text : "
		        + orjinalText(sifreli_text, key));
	    
	    System.out.println("Key : " + sifre);
	    
	    System.out.println("Ciphertext : "
	        + sifreli_text + "\n");
	 
	    
	    }
	}
	 