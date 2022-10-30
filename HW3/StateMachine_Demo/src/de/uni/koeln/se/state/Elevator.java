package de.uni.koeln.se.state;


public class Elevator{
	
	public static int current_Floor=5;
	int dest_Floor;
	private Elv_States State = new Elv_States();
	
	public Elevator (int dest_floor) {
		
		this.dest_Floor = dest_floor;
		System.out.println("*** Destination floor is: "+ dest_Floor);
		
		if(current_Floor < dest_Floor) {
			go_up();
		}
		else if(current_Floor > dest_Floor) {
			go_down();
		}
		else if(current_Floor == dest_Floor) {
			arrive_atFloor();
		}
		
		
	}

	private void arrive_atFloor() {
		State.current_State = State.idle;
		exit();
	}
	
	private void exit() {
		System.out.println("Elevator has reached floor "+current_Floor
				+", you can now exit");
		
	}

	private void go_up() {
		State.current_State = State.moving_up;
		while(current_Floor < dest_Floor) {
			System.out.println("|");
			current_Floor += 1;
		}
		arrive_atFloor();
	}
	
	private void go_down() {
		State.current_State = State.moving_down;
		while(current_Floor > dest_Floor) {
			System.out.println("|");
			current_Floor -= 1;
		}
		arrive_atFloor();
	}
	
	

	
}
