public class Hanoi{
    public static void Hanoi(int disk, String source, String dest, String aux){
        if (disk == 0){
            System.out.println("Move disk from " + source +  " to " + dest);
        }else{
            Hanoi(disk-1, source, aux, dest);
            Hanoi(disk-1, aux, dest, source);
        }              
    }

    public static void main(String[] args){
        Hanoi(new Integer(args[0]), args[1], args[2], args[3]);
    }
}
