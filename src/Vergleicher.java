import java.io.*;




public class Vergleicher {

	public boolean istEqual (File eins, File zwei) throws IOException{

		if(eins.length()==zwei.length()){
		FileInputStream data1 =new FileInputStream(eins);
		FileInputStream data2 =new FileInputStream(zwei);
		int temp=0;
		while((temp =data1.read())!=-1){
			if(temp!=data2.read()){
				return false;
			}
	    }
	      	return true;
        }
		return false;
	}

public static void main(String args[]){
	try{
	File file1=new File("Text1.txt");
	File file2=new File("Text2.txt");

	Vergleicher vD =new Vergleicher();
	System.out.println("Ergebniss nach dem Vergleich: "+vD.istEqual(file1, file2));
	}
	catch (Exception ex){
		ex.printStackTrace();

	}
	System.out.println("------------"+"Lies die Daten ein"+"---------------");
	try{
		File file1=new File("Text1.txt");
		File file2=new File("Text2.txt");


		FileReader file1Reader =new FileReader(file1);

		BufferedReader reader1= new BufferedReader(file1Reader);

		String zeile1;
		while ((zeile1=reader1.readLine())!=null){
		System.out.println(zeile1);

		}
		reader1.close();

         FileReader file1Reader2 =new FileReader(file2);

		BufferedReader reader2= new BufferedReader(file1Reader2);

		String zeile2;
		while ((zeile2=reader2.readLine())!=null){
		System.out.println(zeile2);

		}
		reader2.close();



	}
	catch(Exception ex){
		ex.printStackTrace();
	 }

   }

}