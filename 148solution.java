/* -----------------------------------
 *  WARNING:
 * -----------------------------------
 *  Your code may fail to compile
 *  because it contains public class
 *  declarations.
 *  To fix this, please remove the
 *  "public" keyword from your class
 *  declarations.
 */

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */

//heap sort

class Solution {
    public ListNode sortList(ListNode head) {
        ListNode list1,list2;
        ListNode list_1_tail,list_2_tail;
        int i =0;
        list1 = head;        
        list2 = head.next;
        if (list2 == null){
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
        }
        
        list1 = sortList(list1);
        list2 = sortList(list2);
        head = merge(list1,list2);
        return head;
        
    }
    public ListNode merge(ListNode list1,ListNode list2){
        ListNode head = list1.val>=list2.val?list2:list1;
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
            }else{
                tail.next = list1;
                list1 = list1.next;
            }
        }
        return head;

    }
}

public class MainClass {
    public static int[] stringToIntegerArray(String input) {
        input = input.trim();
        input = input.substring(1, input.length() - 1);
        if (input.length() == 0) {
          return new int[0];
        }
    
        String[] parts = input.split(",");
        int[] output = new int[parts.length];
        for(int index = 0; index < parts.length; index++) {
            String part = parts[index].trim();
            output[index] = Integer.parseInt(part);
        }
        return output;
    }
    
    public static ListNode stringToListNode(String input) {
        // Generate array from the input
        int[] nodeValues = stringToIntegerArray(input);
    
        // Now convert that list into linked list
        ListNode dummyRoot = new ListNode(0);
        ListNode ptr = dummyRoot;
        for(int item : nodeValues) {
            ptr.next = new ListNode(item);
            ptr = ptr.next;
        }
        return dummyRoot.next;
    }
    
    public static String listNodeToString(ListNode node) {
        if (node == null) {
            return "[]";
        }
    
        String result = "";
        while (node != null) {
            result += Integer.toString(node.val) + ", ";
            node = node.next;
        }
        return "[" + result.substring(0, result.length() - 2) + "]";
    }
    
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        String line;
        while ((line = in.readLine()) != null) {
            ListNode head = stringToListNode(line);
            
            ListNode ret = new Solution().sortList(head);
            
            String out = listNodeToString(ret);
            
            System.out.print(out);
        }
    }
}
