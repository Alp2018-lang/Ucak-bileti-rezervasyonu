package uçakbileti;

import java.util.Scanner;


public class UcakBiletiHesaplama implements Irezervasyon{
	
	public static void main(String[] args) {
		
		//km birim fiyatı 0.10 dolar
		//12 yaşından küçükse toplam fiyata 50% indirim
		//12-24 yaş arası 10% indirim
		//65 yaşından büyükse 30% indirim
		//gidiş dönüş alıcaksa 20% indirim
		//bu koşullara göre uçak bileti hesaplayan program
		
		Scanner scan = new Scanner(System.in);
		int km,yas,tip;
		System.out.print("Mesafeyi giriniz : ");
		km = scan.nextInt();
		System.out.print("\nYaşınızı Giriniz : ");
		yas = scan.nextInt();
		System.out.print("\nYolculuk Tipini Seçiniz (1=Tek Gidiş, 2=Gidiş/Dönüş) : ");
		tip = scan.nextInt();
		// ilk olarak kullanıcının girdiği mesafeye göre 0.10 dolar ile 
	    // çarparak mesafenin nekadar bir ücret tuttuğunu hesaplayacağım
		// basitçe girilen KM * 0.10
		
		double normalFiyat,yasIndirimi,tipIndirimi;
		
		if(km > 0 && yas > 0 && (tip==1 || tip==2)) {
			// ilk olarak bir normal fiyat tarifesini belirleyelim
			normalFiyat = km * 0.10;
			
			// şimdiki aşama koşulları gerçekleştirme
			// ilk olarak yaş koşulunu yapmak istedim
			
			if(yas< 12) {
				// yaş 12 den küçük ise yüzde 50 indirim uygulamak için 0.5 ile çarparım
				// sonra bu indirimi normal tarifeden çıkartırım
				yasIndirimi = normalFiyat * 0.5 ;
				normalFiyat = normalFiyat - yasIndirimi;
				// sıra geldi ikinci koşuluma
				
			}else if(yas >= 12 && yas<= 24) {
				// bu aşamada indirimi vermek için 0.10 ile normal fiyatımı çarparım
				// tekrardan çıkartma işlemini tekrar ediyorum 
				yasIndirimi = normalFiyat * 0.10;
				normalFiyat = normalFiyat - yasIndirimi;
				
				//şimdi sıra geldi 65 yaş indirimine 
				//eğer yaş 65 den büyük veya eşit ise yüzde 30 indirim uygulanır
			}else if(yas >= 65) {
				yasIndirimi = normalFiyat * 0.30;
				normalFiyat = normalFiyat - yasIndirimi;
			}
				// uçuş tipine göre indirim sağlama
				// tip 2 seçilirse yani gidiş dönüş yüzde 20 indirim
				// tip 1 seçilirse indirim uygulanmayacağıu için tekrar yazmadım
				if(tip == 2) {
					tipIndirimi = normalFiyat * 0.20;
					// Gidiş dönüş için normalfiyatın indirimli halini 2 ile çarpmam gerekir
					normalFiyat = (normalFiyat - tipIndirimi) * 2;		
				}
				System.out.print("Bilet Tutarı : " +  normalFiyat);

			
			System.out.print("Girilen Bilgiler Doğru !");
		}else {
			
			// girilen bilgiler yanlış mı doğru mu feedback vermek için bunları yazdırıyorum
			System.out.print(" Girilen Bilgiler Yanlış !");
			System.out.print("Girdiğiniz bilgiler eksik veya hatalı lütfen tekrar deneyiniz !");
			
		}
	
		}

	@Override
	public void log() {
		// TODO Auto-generated method stub
		System.out.println("");
		
	}
 		
		
		
	}
	
	

