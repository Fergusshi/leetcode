package com.bowen.ipo;

import java.util.LinkedList;
import java.util.ListIterator;



public class ipoSolution {

	public static void main(String[] args) {

		int[] c = {1,2,3};
		int max = (new ipoSolution()).findMaximizedCapital(1,0,c,new int[]{1,1,2});
		System.out.println("the max cap is " + max);
	}

	public int findMaximizedCapital(int k, int W, int[] Profits, int[] Capital) {


		LinkedList<CapPro> list = new LinkedList<CapPro>();
		LinkedList<CapPro> temps = new LinkedList<CapPro>();

		int w = W;
		for(int i = 0 ; i<Profits.length; i++) {
			temps.add(new CapPro(Profits[i],Capital[i]));       	
		}
		for(int i = 0; i<k; i++) {
			ListIterator<CapPro> it = temps.listIterator();
			while(it.hasNext()) {
				CapPro currentNode =it.next();
				if(currentNode.Cap <= w) {
					this.insert(list, currentNode);
					it.remove();

				}     		
			}
			if(!list.isEmpty()) {
				w += list.getLast().Pro;
				list.removeLast();
			}
		}
		return w;
	}
	
	public void insert(LinkedList<CapPro> list, CapPro temp) {
		if(list.size()==0) {
			list.add(temp);
		}
		else {
			ListIterator<CapPro> it = list.listIterator();
			while(it.hasNext()) {
				if(temp.Pro<=it.next().Pro) {
					it.previous();
			        it.add(temp);
			        return;
			        
				}
			}
			list.add(temp);
		}
		
		
	}




    class CapPro{
        int Pro;
        int Cap;
        
      public CapPro(int Pro,int Cap){
            this.Pro = Pro;
            this.Cap = Cap;
        }
        
    }
}
