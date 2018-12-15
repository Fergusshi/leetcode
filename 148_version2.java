class Solution {
    public ListNode sortList(ListNode head) {
        ListNode list1,list2;
        ListNode list_1_tail,list_2_tail;
        int i =0;
        list1 = head;        
        list2 = head.next;
        if (list2 == null){
            System.out.println("hahahaha");
            return list1;
        }
               
        list_1_tail = head;
        list_2_tail = head.next;
        head = head.next.next;
        
        while (head != null){
            if (i%2 == 0){
                list_1_tail.next = head;
                head = head.next;
                list_1_tail = list_1_tail.next;                               
            }else{
                list_2_tail.next = head;
                list_2_tail = head;
                head = head.next;
            }
            i++;
           
        }
        list_1_tail.next = null;
        list_2_tail.next = null;
        
    
        
        list1 = sortList(list1);
        list2 = sortList(list2);
        head = merge(list1,list2);
        return head;
        
    }
    public ListNode merge(ListNode list1,ListNode list2){
        
        ListNode head = new ListNode(0);
          //  list1.val>=list2.val?list2:list1;
        ListNode tail = head;
        
        
        
        while (list1 != null || list2 != null){
            if(list1 == null){
                tail.next = list2;
                break;
            }    
            if(list2 == null){
                tail.next = list1;
                break;
            }
                
            if (list1.val>=list2.val){
                tail.next = list2;
                list2 = list2.next;
                tail = tail.next;
            }else{
                tail.next = list1;
                list1 = list1.next;
                tail = tail.next;
            }

            
            
        }
        
        
        return head.next;

    }
}

