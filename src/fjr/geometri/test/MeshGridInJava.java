package fjr.geometri.test;

/**
 *
 * @author mamat
 */
public class MeshGridInJava {

    public static void main(String[] args) {

        int a[];
        a = new int[]{1, 3, 5, 7, 9};
        int b[];
        b = new int[]{2, 4, 6, 8};
  
        int[][] meshgridX = new int[b.length][a.length];
        int[][] meshgridY = new int[b.length][a.length];

   
        for (int i = 0; i < b.length; i++) {
            for (int j = 0; j < a.length; j++) {
                meshgridX[i][j] = a[j];
                meshgridY[i][j] = b[i];
            }
        }
        
       print(meshgridX);
       print(meshgridY);
       
    }
    
    static void print(int[][] a){
        for(int i=0; i< a.length ;i++){
            for(int j=0; j< a[0].length;  j++){
                System.out.print(a[i][j]+"   ");
            }
            System.out.println();
        }
        System.out.println("================");
    }
}
//Hasil eksekusi
//1   3   5   7   9   
//1   3   5   7   9   
//1   3   5   7   9   
//1   3   5   7   9   
//================
//2   2   2   2   2   
//4   4   4   4   4   
//6   6   6   6   6   
//8   8   8   8   8   
//================
