import java.util.*;
public class l001{

    // Q.1  Factorial of a number

    public static int factorial(int n){
        if(n==1){
            return 1;
        }
        int x=factorial(n-1);
        return x*n;
    }

    //Q.2 Power function

    public static int power(int n,int m){
        if(m==1){
            return n;
        }
        int x=power(n,m-1);
        return x*n;
    }

    //Q.3 Power Optimized

    public static int power_opt(int n,int m){
        if(m==1){
            return n;
        }
        int x=power_opt(n,m/2);
        if(m%2==0){
            return x*x;
        }
        return x*x*n;
    }

    //Q.4 Maximum of given Array

    public static int max_of_array(int[] arr,int idx){
        if(idx==arr.length){
            return -1;
        }
        int x=max_of_array(arr,idx+1);
        if(arr[idx]>x){
            return arr[idx];
        }
        return x;
    }

    // Q.5 Find element in an array

    public static boolean find(int[] arr,int idx,int tar){
        if(idx==arr.length){
            return false;
        }
        boolean ans=find(arr,idx+1,tar);
        if(arr[idx]==tar){
            return true;
        }
        return ans;
    } 

    // Q.6.a First index of element

    public static int first_idx(int[] arr,int idx,int tar){
        if(idx==arr.length){
            return -1;
        }
        return arr[idx]==tar? idx:first_idx(arr,idx+1,tar);
    }

    //Q.6.b Last index of element

    public static int last_idx(int[] arr,int idx,int tar){
        if(idx==arr.length){
            return -1;
        }
        int x=last_idx(arr,idx+1,tar);
        if(x!=-1){
            return x;
        }
        if(arr[idx]==tar){
            return idx;
        }
        return x;
    }

    // Q.6.c All indexes of element

    public static int[] all_idx(int[] arr,int idx,int tar,int count){
        if(idx==arr.length){
            int[] ans=new int[count];
            return ans;
        }
        if(arr[idx]==tar)
            count++;
        int[] ans=all_idx(arr,idx+1,tar,count);
        if(arr[idx]==tar){
            ans[count-1]=idx;
        }
        return ans;
    }

    //Q.7.a Subsequence  ArrayList as an argument

    public static int subsequence(String str,int idx,String ans,ArrayList<String> finall){
        if(str.length()==idx){
            finall.add(ans);
            return 1;
        }
        int count=0;
        count+=subsequence(str,idx+1,ans,finall);
        count+=subsequence(str,idx+1,ans + (str.charAt(idx)),finall);
        return count;
    }

    //Q.7.b Subsequence  ArrayList as an return type

    public static ArrayList<String>  subsequenceReturn(String str,int idx){
        if(idx==str.length()){
            ArrayList<String> base=new ArrayList<>();
            base.add("");
            return base;
        }
        ArrayList<String> myAns=new ArrayList<>();
        ArrayList<String> recAns=subsequenceReturn(str,idx+1);
        for(String s:recAns){
            myAns.add(s);
            myAns.add(str.charAt(idx)+s);
        }
        return myAns;
    }

    // Q.8 Nokia Key Pad

    public static String[] nokiaKeys ={ ".;", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tu", "vwx", "yz" };

    public static int nokiakeypath(String str,String ans,ArrayList<String> finall){
        if(str.length()==0){
            finall.add(ans);
            return 1;
        }
        int count=0;
        int charIdx=str.charAt(0);
        String reqstr=nokiaKeys[charIdx-'0'];
        for(int i=0;i<reqstr.length();i++){
            count+=nokiakeypath(str.substring(1),ans+reqstr.charAt(i),finall);
        }
        return count;
    }

    //Q.9 Stair Path where arrayList is passed as a argument

    public static int stairPath( int n , int k , String ans , ArrayList<String> finall ){
        if(k==0){
            finall.add(ans);
            return 1;
        }
        int count=0;
        for(int i=1;i<=n && k-i>=0;i++){
            count+=stairPath(n,k-i,ans+i,finall);
        }
        return count;
    }

    //Q.9 Stair Path where arrayList is return type

    public static ArrayList<String> stairPath_return(int n,int k){
        if(k==0){
            ArrayList<String> base=new ArrayList<>();
            base.add("");
            return base;
        }
        ArrayList<String> myAns=new ArrayList<>();
        for(int i=1;i<=n && k-i>=0;i++){
            ArrayList<String> recAns=stairPath_return(n,k-i);
            for(String s:recAns){
                myAns.add(i+s);
            }
        }
        return myAns;
    }

    


    public static void main(String[] args){
        // System.out.println (factorial(5));
        // System.out.println(power(16,2));
        // System.out.println(power_opt(2,3));
        // int[] arr={69,69,69,69,4,234,69};
        // System.out.println(max_of_array(arr,0));
        // System.out.println(find(arr,0,649));
        // System.out.println(first_idx(arr,0,69));
        // int[] ans=all_idx(arr,0,69,0);
        // for(int i=0;i<ans.length;i++){
        //     System.out.print(ans[i]+" ");
        // }
        // String str="abc";
        // ArrayList<String> finall=new ArrayList<>();
        // subsequence(str,0,"",finall);
        // System.out.println(finall);
        // System.out.println(subsequenceReturn(str,0));
        // String str="78";
        // nokiakeypath(str,"",finall);
        // System.out.println(finall);
        // stairPath(3,3,"",finall);
        // System.out.println(finall);
        System.out.println(stairPath_return(3,3));




    }
}