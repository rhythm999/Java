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
        ListNode mid=midNode(head);
        ListNode nhead=mid.next;
        mid.next=null;
        nhead=reverse(nhead);
        ListNode c1=head,c2=nhead;
        while( c2!=null){
            ListNode f1=c1.next;
            ListNode f2=c2.next;
            c1.next=c2;
            c2.next=f1;
            c1=f1;
            c2=f2;
        }
        return head;
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

    // Q.6 Merge Two Sorted LinkedList

    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode dummy=new ListNode(-1);
        ListNode prev=dummy;
        ListNode c1=l1;
        ListNode c2=l2;
        while(c1!=null && c2!=null){
            if(c1.val<=c2.val){
                dummy.next=c1;
                c1=c1.next;
            }
            else{
                dummy.next= c2;
                c2=c2.next; 
            }
            dummy=dummy.next;
        }
        dummy.next= c1!=null?c1:c2;    
        return prev.next;
    }

    // Q.7 Remove nth node from the end of list

    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode first=head;
        ListNode second=head;
        while(n!=0){
            first=first.next;
            n--;
        }
        if(first==null){
            return head.next;
        }
        while(first.next!=null){
            first=first.next;
            second=second.next;
        }
        second.next=second.next.next;     
        return head;   
    }

    // Q.8 segregate odd even indexes of linked list

    public ListNode oddEvenList(ListNode head) {
        if(head==null || head.next==null){
            return head;
        }
        ListNode d1=new ListNode(-1);
        ListNode d2=new ListNode(-1);
        ListNode c1=d1,c2=d2,c=head;
        while(c!=null){
            if(c.val%2==0){
                c1.next=c;
                c1=c1.next;
            }
            else{
                c2.next=c;
                c2=c2.next;
            }
            c=c.next;
        }
        c1.next=null;
        c2.next=d1.next;
        return d2.next;
    }

    // Q.9 sorting liknedList 

    public ListNode sortList(ListNode head) {
        if(head==null || head.next==null){
            return head;
        }
        ListNode mid=midNode(head);
        ListNode nhead=mid.next;
        mid.next=null;
        ListNode d1=sortList(head);
        ListNode d2=sortList(nhead);
        return mergeTwoLists(d1,d2);
    }

    // Q.10  segregate 0,1,2 in a list  

    public static ListNode segregate(ListNode head){
        ListNode d1=new Node(-1);
        ListNode d2=new Node(-1);
        ListNode d3=new Node(-1);
        ListNode c1=d1,c2=d2,c3=d3,c=head;
        while(c!=null){
            if(c.data==0){
                c1.next=c;
                c1=c1.next;
            }
            else if(c.data==1){
                c2.next=c;
                c2=c2.next;
            }
            else{
                c3.next=c;
                c3=c3.next;
            }
            c=c.next;
        }
        c3.next=c2.next=null;
        c2.next=d3.next;
        c1.next=d2.next;
        return d1.next;
    }

    //Q.11 Merge k sorted Linked List 

    public ListNode mergeKLists(ListNode[] lists) {
        if(lists.length==0){
            return null;
        }
        if(lists.length==1){
            if(lists[0]==null){
                return null;
            }
            if(lists[0].next==null){
                return lists[0];
            }
        }
        return mergeKLists(lists,0,lists.length-1);
    }
    public ListNode mergeKLists(ListNode[] lists,int si,int ei){
        
        if(si==ei){
            return lists[si];
        }
        ListNode d1=mergeKLists(lists,si,(si+ei)/2);
        ListNode d2=mergeKLists(lists,((si+ei)/2)+1,ei);
        
        return mergeLists(d1,d2);
    }
    public ListNode mergeLists(ListNode l1,ListNode l2){
        ListNode d1=new ListNode(-1);
        ListNode c=d1;
        ListNode c1=l1,c2=l2;
        while(c1!=null & c2!=null){
            if(c1.val<=c2.val){
                c.next=c1;
                c1=c1.next;
            }
            else{
                c.next=c2;
                c2=c2.next;
            }
            c=c.next;
        }
        c.next=c1==null?c2:c1;
        return d1.next;
    }

    //


    public static void main(String[] args){

    }
}