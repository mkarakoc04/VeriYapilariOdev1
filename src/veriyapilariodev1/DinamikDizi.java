/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package veriyapilariodev1;

import java.util.Arrays;
/**
 *
 * @author Mehdi
 */
public class DinamikDizi {
   public static int Boyut=5;
   public static int[] Items=new int[Boyut];
   
   public static int Doluindis=0;

   DinamikDizi()
   {
       for (int i = 0; i < Boyut; i++) {
           Items[i]=Integer.MIN_VALUE;//boş veri olarak int'in minimum değerini atadık
       }
   }
   
    public void ekle(int veri)//Gelen veriyi son elemana ekledik
    {
       if(Doluindis>(Boyut-1))
       {
           genislet();
       }
       Items[Doluindis]=veri;
       Doluindis++;
       
    }
    public void ekle(int veri,int index)
    {
        if(index>(Boyut-1))
        {
            genislet();
        }
        Items[index]=veri;
        if(Doluindis<index)//Son elemandan sonrasına eklenmişse indexe son elemanı ata
            Doluindis=index;
    }
    public void genislet()
    {
        Boyut*=2;
        Items=Arrays.copyOf(Items,Boyut);
        
    }
  
    public void sil()//sonuncu elemanı sildik
    {
        Items=Arrays.copyOf(Items,Boyut-1);
    }
    /*Buradaki iki methodun imzası aynı olduğundan hata verir; bunun yerine tek bir method tanımladım ve 2. parametre olarak
    Gelen parametrenin index mi veri mi olduğunu gösteren bir veri gönderiyorum. (tur=0-->veri, tur=1-->index)
    public void sil(int veri)
    {

    }
    public void sil(int index)
    {

    }*/
    public void sil(int gelen,int tur)
    {
        int[] yenidizi=new int[Boyut-1];
        int eksilt=0;
        if (tur==0) {//veriye göre sil
            for (int i = 0; i < Boyut; i++) {
                if (Items[i-eksilt]!=gelen) {
                    yenidizi[i]=Items[i];
                }else
                {
                    eksilt++;
                }
        }
        }
        else//index'e göre sil
        {
            for (int i = 0; i < Boyut; i++) {
                if ((i-eksilt)!=gelen) {
                    yenidizi[i]=Items[i];
                }else
                {
                    eksilt++;
                }
        }
        }
        Items=Arrays.copyOf(yenidizi,Boyut-1);
    }
    public int kapasite()
    {
        return Items.length;
    }
    public int uzunluk()
    {
        int dolueleman=0;
        for (int i = 0; i < Boyut; i++) {
            if (Items[i]!=Integer.MIN_VALUE) {
                dolueleman++;
            }
        }
        return dolueleman;
    }
    public void temizle()
    {
        Items=new int[Boyut];
    }
}