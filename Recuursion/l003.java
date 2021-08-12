import java.util.*;
public class l003{

    // Q.1.a infinite permutation 

    public static int infi_permuatation(int[] arr,int tar,String psf){
        if(tar==0){
            System.out.println(psf);
            return 1;
        }
        int count=0;
        for(int i=0;i<arr.length && tar-arr[i]>=0;i++){
            count+=infi_permuatation(arr,tar-arr[i],psf+arr[i]);
        }
        return count;
    }

    // Q.1.b infinite permutation subset method

    public static int infi_permuatation_subset(int[] arr,int tar,int idx,String psf){
        if(idx==arr.length || tar==0){
            if(tar==0){
                System.out.println(psf);
                return 1;
            }
            return 0;
        }
        int count=0;
        if(tar-arr[idx]>=0){
            count+=infi_permuatation_subset(arr,tar-arr[idx],0,psf+arr[idx]);
            count+=infi_permuatation_subset(arr,tar,idx+1,psf);
        }
        return count;
    } 

    // Q.2.a infinite combination 

    public static int infi_combination(int[] arr,int tar,int idx,String psf){
        if(tar==0){
            System.out.println(psf);
            return 1;
        }
        int count=0;
        for(int i=idx;i<arr.length && tar-arr[i]>=0;i++){
            count+=infi_combination(arr,tar-arr[i],i,psf+arr[i]);
        }
        return count;
    }

    // Q.2.b infinite combination subset method

    public static int infi_combination_subset(int[] arr,int tar,int idx,String psf){
        if(idx==arr.length || tar==0){
            if(tar==0){
                System.out.println(psf);
                return 1;
            }
            return 0;
        }
        int count=0;
        if(tar-arr[idx]>=0){
            count+=infi_combination_subset(arr,tar-arr[idx],idx,psf+arr[idx]);
            count+=infi_combination_subset(arr,tar,idx+1,psf);
        }
        return count;
    } 

    //Q.3 single combination

    public static void main(String[] args){
        int[] arr={1,2,3,4,5,6};
        System.out.println(infi_combination_subset(arr,10,0,""));
    }
}