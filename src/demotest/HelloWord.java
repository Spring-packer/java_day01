package demotest;

public class HelloWord {

    public static void main(String[] args) {

        String plat = "plat";
        String pair = "pair";
        String open = "open";
        String close = "close";
        String high = "high";
        String low = "low";
        String volume = "volume";
        String timestamp = "timestamp";
//        ssj.producerSend("20180116parker","20180116parker");
//        ssj.closeProducer();


        String s = "insert into "+plat+" (pair,price,open,close,high,low,volume,timestamp)values('" +
                pair+"','"+
                open+"','"+
                open+"','"+
                close+"','"+
                high+"','"+
                low+"','"+
                volume+"','"+
                timestamp+"'"+
                ");";
        System.out.println(s);

//        System.out.println("demotest.HelloWord");

    }







    public static void insertSort(int[] a ){
        int n  = a.length;
        int temp=0;
        int j=0;
        for(int i=1; i< n; i++){
            if( a[i] < a[i-1]){
                // 0 1 2 3
                // 1 4 2 3
               temp = a[i];//1
               for(j=i-1; j>=0 && a[j]>temp; j-- ){
                   a[j+1]=a[j];
                   a[j+1]=temp;
               }
            }


        }

    }


}
        /**
         *  int i=0,temp=0,j=0;
         for(i=1;i<n;i++)
         {

         if(a[i]<a[i-1])
         {  temp=a[i];
         for(j=i-1;j>=0&&a[j]>temp;j--)
         a[j+1]=a[j];
         a[j+1]=temp;
         }
         */
