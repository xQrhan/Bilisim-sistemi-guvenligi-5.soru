package wb1;




public class Soru5 {
	//Burada bir key oluþturuyorum ve keyi Stringin uzunluðu kadar tekrarlatýyorum.
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
	 
	// Bu fonksiyon þifreli string üretmek için girilen string ile keyin indisini toplaycak
	
	static String sifreliText(String str, String key)
	{
	    String sifreli_text="";
	 
	    for (int i = 0; i < str.length(); i++)
	    {
	    	//Stringe key ekleyerek sifreliText oluþturuyorum
	        int x = (str.charAt(i) + key.charAt(i)) %26;
	 
	        // alfabeyi (ASCII)' ya çeviriyorum 
	        x += 'A';
	 
	        sifreli_text+=(char)(x);
	    }
	    return sifreli_text;
	}
	 
	// Bu fonksiyon þifreli stringi orjinal haline çevirecek
	
	static String orjinalText(String sifreli_text, String key)
	{
	    String orj_text="";
	 
	    for (int i = 0 ; i < sifreli_text.length() &&
	                            i < key.length(); i++)
	    {
	    	//ÞifreliText'ten Key'i çýkararak orjinal metni buluyorum
	        int x = (sifreli_text.charAt(i) -
	                    key.charAt(i) + 26) %26;
	 
	        // alfabe (ASCII)'ya çevriliyor
	        x += 'A';
	        orj_text+=(char)(x);
	    }
	    return orj_text;
	}
	 
	// Bu fonksiyonla girilen küçük harfler büyük harflere çevriliyor
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
	
	//Key Girilen stringden uzun olursa ÇALIÞMAZ!!!!!
	//Oluþturduðum Stringde 0. indis A bu yüzden A geçen key bölgelerine denk gelen
	//Türkçe karakterleri desteklettiremedim hocam kusura bakmayýn :(
	//ÞÝfrelenecek metine boþluk koyulduðunda "T" olarak çeviriyor bunun neden olduðunu bulamadým.
	// Kodun Deneme Kýsmý
	public static void main(String[] args)
	{											
	    String Str = "ORHAN BURADAN GECTI";	//Þifrelenmek istenen metin				
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
	 