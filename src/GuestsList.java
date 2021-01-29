import java.util.ArrayList;
import java.util.Scanner;

public class GuestsList {
	private final int capacity;
	private ArrayList<Guest> guestsList = new ArrayList<Guest>();
	private ArrayList<Guest> waitingList = new ArrayList<Guest>();
	
	
	public GuestsList() {
		this.capacity = 4;
	}
	
	public GuestsList (int capacity) {
		this.capacity = capacity;
	}
	
	public boolean checkCapacity() {
		if (this.guestsList.size() < this.capacity)
			return true;
		return false;
					
	}
	
	// 1 add
	public int add(String lastName, String firstName, String email, String phoneNumber) {
		if (checkName(lastName, firstName, false, this.guestsList) || checkEmail(email, false, this.guestsList)
				|| checkPhone(phoneNumber, false, this.guestsList))
			return -1;
		
		Guest guest = new Guest(lastName, firstName, email, phoneNumber);
		
		if (available() > 0) {
			this.guestsList.add(guest);
			return 0;
		} else {
			this.waitingList.add(guest);
			return waitingList.size(); // X - locul pe lista de asteptare
		}
			
	}
	
	
	// 2 check
	public boolean check(int nr, boolean remove, int listFlag) {
		Scanner sc = new Scanner(System.in);
		boolean response = false;
		ArrayList<Guest> list = new ArrayList<Guest>();
		
		if (listFlag == 1)
			list = this.guestsList;
		else if (listFlag == 2)
			list = this.waitingList;
		
		switch (nr) {
		case 0:
			System.out.println("Exit");
			break;
		
		case 1:
			System.out.println("Scrieti numele de familie:");
			String lastName = sc.nextLine();
			System.out.println("Scrieti prenumele:");
			String firstName = sc.nextLine();
			response = checkName(lastName, firstName, remove, list);
			break;
			
		case 2:
			System.out.println("Scrieti adresa de email:");
			String email = sc.nextLine();
			response = checkEmail(email, remove, list);
			break;
			
		case 3:
			System.out.println("Scrieti numarul de telefon:");
			String phoneNumber = sc.nextLine();
			response = checkPhone(phoneNumber, remove, list);
			break;
			
		default:
			System.out.println("Optiunea selectata nu este valida.");
			System.out.println("Alegeti una din optiunile:\n0. exit\n1. lastName si firstName\n" + 
					"2. email\n" + 
					"3. phoneNumber");
			int number = sc.nextInt();
			check(number, remove, listFlag);
		}
		//sc.close();
		return response;
		
	}
	
	public boolean checkName(String lastName, String firstName, boolean remove, ArrayList<Guest> list) {
		for (Guest g : list) {
			if(g.getLastName().equals(lastName) && g.getFirstName().equals(firstName)) {
				if (remove) {
					list.remove(g);
				}
				return true;
			}
		}
		return false;
	}
	
	public boolean checkEmail(String email, boolean remove, ArrayList<Guest> list) {
		for (Guest g : list) {
			if (g.getEmail().equals(email)) {
				if (remove) {
					list.remove(g);
				}
				return true;
			}		
		}
		return false;
	}
	
	public boolean checkPhone(String phoneNumber, boolean remove, ArrayList<Guest> list) {
		for (Guest g : list) {
			String nr = g.getPhoneNumber();
			if (nr.equals(phoneNumber)) {
				if (remove) {
					list.remove(g);
				}
				return true;
			}
				
		}
		return false;
	
	}
	
	public Guest checkGuestByPhoneNumber(String phoneNumber) {
		for (Guest g : this.guestsList) {
			String nr = g.getPhoneNumber();
			if (nr.equals(phoneNumber))
				return g;
		}
		System.out.println("Nu exista acest invitat.");
		return null;
	}
	
	// 3 remove
	public boolean remove(int nr) {
		// apelam metoda check pe lista participantilor cu flagul de remove setat true
		if(check(nr, true ,1)) {
			// cautam in lista de asteptare pentru a adauga urmatoarea persoana pe lista de participare
			if (this.waitingList.size() > 0) {
				this.guestsList.add(this.waitingList.get(0));
				System.out.println("Invitatul fost sters de pe lista participantilor.");
				System.out.println(this.waitingList.get(0).getFirstName() + " " +
				this.waitingList.get(0).getLastName() + " a fost adaugat de pe lista de asteptare in lista de participanti.");
				this.waitingList.remove(0);
			}
			return true;
		// apelam metoda check pe lista participantilor cu flagul de remove setat true	
		// parcurge iar toata lista de interogari de la check, trebuie extrase din main toate datele si dupa apelata metoda
		// atat pentru lista participanti cat si pentru lista de asteptare
		} else if (check(nr, true, 2)) {
			System.out.println("Invitatul a fost sters de pe lista de asteptare.");
			return true;
		}
		
		return false;
	}
	
	// 4 update
	public void update(String phoneNumber) {
		Guest g = checkGuestByPhoneNumber(phoneNumber);
		if (g != null) {
			Scanner sc = new Scanner(System.in);
			System.out.println("Ce informatie doriti sa actualizati?\nSelectati una din optiunile:\n1 - Nume"
					+ "\n2 - Prenume\n3 - email\n4 - numar de telefon");
			int option = sc.nextInt();
			sc.nextLine();
			
			switch (option) {
			
			case 1:
				System.out.println("Scrieti un nume:");
				String nume = sc.nextLine();
				g.updateLastName(nume);
				break;
				
			case 2:
				System.out.println("Scrieti un prenume:");
				String prenume = sc.nextLine();
				g.updateFirstName(prenume);
				break;
				
			case 3:
				System.out.println("Scrieti o adresa de email:");
				String email = sc.nextLine();
				g.updateEmail(email);
				break;
				
			case 4:
				System.out.println("Scrieti un numar de telefon:");
				String phoneNr = sc.nextLine();
				g.updatePhoneNumber(phoneNr);
				break;
				
			default:
					
			}
		}
		
		//sc.close();
	}
	
	// 6 lista de participare
	public void guests() {
		int nr = 1;
		for (Guest g : this.guestsList) {
			System.out.println(nr + ". " + g.getFirstName() + " " + g.getLastName() + ", " +
					g.getEmail() + ", " + g.getPhoneNumber()) ;
			nr++;
		}
	}
	
	// 7 lista de asteptare
	public void waitlist() {
		int nr = 1;
		for (Guest g : this.waitingList) {
			System.out.println(nr + ". " + g.getFirstName() + " " + g.getLastName() + ", " +
					g.getEmail() + ", " + g.getPhoneNumber());
			nr++;
		}
	}
	
	// 8 numarul de locuri libere
	public int available() {
		return (this.capacity - this.guestsList.size());
	}
	
	// 9 numarul de persoane care participa la eveniment
	public int guestsNo() {
		return this.guestsList.size();
	}
	
	// 10 numarul de persoane de pe lista de asteptare
	public int waitlistNo() {
		return this.waitingList.size();
	}
	
	// 11 numarul total de persoane inscrise
	public int subscribeNo() {
		return (this.guestsList.size() + this.waitingList.size());
	}
	
	// 12 search
	public void search(String str) {
		if (this.guestsList.size() > 0) {
			str = str.toLowerCase();
			System.out.println(str);
			int nr = 1;
			for (Guest g : this.guestsList) {
				if (g.getFirstName().toLowerCase().contains(str) || g.getLastName().toLowerCase().contains(str) || 
						g.getEmail().toLowerCase().contains(str) || g.getPhoneNumber().toLowerCase().contains(str)) {
					System.out.println(nr + ". " + g.getFirstName() + " " + g.getLastName() + ", " +
							g.getEmail() + ", " + g.getPhoneNumber());
					nr++;
				}
						
			}
		} else {
			System.out.println("Lista de participanti la eveniment este goala.");
		}
	}

}
