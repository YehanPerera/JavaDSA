public class TowersOfHanoi {
    static void towersOfHanoi(int disks,String source,String aux,String dest){
       if(disks!=0){
           towersOfHanoi(disks-1,source,dest,aux);
           System.out.println("Move disk from "+source+ " to "+dest);
           towersOfHanoi(disks-1,aux,source,dest);
       }
    }
    static void towersOfHanoi(int disks,String source,String aux1,String aux2,String dest){
       if (disks!=0){
           if (disks==1){
               System.out.println("Move disk from "+source+" to "+dest);
           }else{
               towersOfHanoi(disks-2,source,dest,aux2,aux1);
               System.out.println("Move disk from "+source+" to "+aux2);
               System.out.println("Move disk from "+source+" to "+dest);
               System.out.println("Move disk from "+aux2+" to "+dest);
               towersOfHanoi(disks-2,aux1,source,aux2,dest);



           }
       }
    }


    public static void main(String[] args) {
       /// towersOfHanoi(3,"A","B","C");
        towersOfHanoi(5,"A","B","C","D");
    }

}
