package example2;

import java.util.ArrayList;

import example1.RatonRunnable;

public class States {

	public static void main(String[] args) {
		RatonRunnable mickey = new RatonRunnable("Mickey", 6);
		ArrayList<Thread.State> estadosHilo = new ArrayList<>();
		Thread h = new Thread(mickey);
		estadosHilo.add(h.getState());
		h.start();
		while(h.getState()!=Thread.State.TERMINATED) {
			if(!estadosHilo.contains(h.getState())) {
				estadosHilo.add(h.getState());
			}
			
		}
		
		if(!estadosHilo.contains(h.getState())) {
			estadosHilo.add(h.getState());
		}
		
		for(Thread.State estado : estadosHilo) {
			System.out.println(estado);
		}
	}

}
