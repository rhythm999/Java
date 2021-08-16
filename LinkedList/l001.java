import java.util.*;
public class l001{
    public static Scanner scn=new Scanner(System.in);

    public static class ListNode{
        int val=0;
        ListNode next=null;

        ListNode(int val){
            this.val=val;
        }
    }

    // Q.1  Finding the mid node of LinkedList 

    public static ListNode midNode(ListNode head){
        if(head==null || head.next==null){
            return head;
        }
        ListNode fast=head;
        ListNode slow=head;
        while(fast.next!=null && fast.next.next!=null){
            slow=slow.next;
            fast=fast.next.next;
        }
        return slow;
    }

    // Q.2 Reversing the LinkedList

    public static ListNode reverse(ListNode head){
        if(head==null || head.next==null){
            return head;
        }
        ListNode prev=null;
        ListNode curr= head;
        while(curr!=null){
            ListNode forward=curr.next;
            curr.next=prev;
            prev=curr;
            curr=forward
        }
        return prev
    }

    // Q.3 Check LinkedList is palindrome or not

    public static boolean is_palindrome(ListNode head){
        if(head==null && head.next==null){
            return true;
        }
        ListNode mid=midNode(head);
        ListNode nhead=reverse(mid.next);
        while(nhead!=null){
            if(nhead.val!=head.val){
                return false;
            }
        }
        return true;
    }

    // Q.4 Fold of LinkedList

    public static ListNode FoldOfLinkedList(ListNode head){
        if(head==null || head.next==null){
            return head;
        }
        ListNOde mid=midNode(head);
        ListNOde nhead=reverse(mid.next);
        ListNode mainHead=head;
        mid.next=null;
        while(head!null){
            ListNode f1=head.next;
            ListNode f2=nhead.next;
            head.next=nhead;
            nhead.next=f1;
            head=f1;
            nhead=f2;
        }
        return mainHead;
    } 


    // Q.5 UnFold of LinkedList

    public static ListNode UnFoldOfLinkedList(ListNode head){
        if(head==null || head.next==null){
            return head;
        }
        ListNode d1=new ListNode(-1);
        ListNode d2=new ListNode(-1);
        ListNode c1=d1;
        ListNode c2=d2;
        ListNode c=head;
        while(c!=null){
            c1.next=c;
            c2.next=c.next;
            c1=c1.next;
            c2=c2.next;
            c=c.next;
            if(c!=null){
                c=c.next;
            }
        }
        ListNode nhead=reverse(c2);
        c1.next=c2;
        return d1.next;
    }




    public static void main(String[] args){

    }
}