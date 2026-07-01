public class other {
 public static void main(String[] args) {
    int[] array={3,2,1,7,5};
     System.out.println(reverseArray(array,0,4));

    
 }  
 
 public static int[] reverseArray(int[] arr,int i,int j){

if(i>j){return arr ;}
int t=arr[i];
arr[i]=arr[j];
arr[j]=t;
reverseArray(int[] arr,i+1,j-1);


 }
}
