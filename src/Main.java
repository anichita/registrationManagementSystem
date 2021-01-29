import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		//Guest guest = new Guest("Alex","Alex","alex@gmail.com","0722123654");
		//Guest guest2 = new Guest("Ion","Ion","ion@gmail.com","0722123654");
		GuestsList gl = new GuestsList();
		
		gl.add("Alex","Alex","alex@gmail.com","0722123654");
		gl.add("Aleexssss","Allex","alllex@gmail.com","0722123652");
		gl.add("Altefsdxssss","Allex","aleefsfeex@gmail.com","011113652");
		
		//System.out.println(gl.check(1, false));
		//gl.guests();
		//gl.update("0722123654");
		//gl.guests();
		//gl.search("ALtE");
		//System.out.println(gl.check(1, false));
		
		//System.out.println(gl.remove(1));
		//System.out.println(gl.remove(1));
		
		//System.out.println("ASdFGHj@test.com".toLowerCase().contains("Dfg".toLowerCase()));
		
		
		System.out.println(". . . Sistem de gestiune inscrieri . . .\n");
		String option = "help";
		do {
			switch (option) {
			
			case "help":
				System.out.println("help         - Afiseaza aceasta lista de comenzi\r\n" + 
						"add          - Adauga o noua persoana (inscriere)\r\n" + 
						"check        - Verifica daca o persoana este inscrisa la eveniment\r\n" + 
						"remove       - Sterge o persoana existenta din lista\r\n" + 
						"update       - Actualizeaza detaliile unei persoane\r\n" + 
						"guests       - Lista de persoane care participa la eveniment\r\n" + 
						"waitlist     - Persoanele din lista de asteptare\r\n" + 
						"available    - Numarul de locuri libere\r\n" + 
						"guests_no    - Numarul de persoane care participa la eveniment\r\n" + 
						"waitlist_no  - Numarul de persoane din lista de asteptare\r\n" + 
						"subscribe_no - Numarul total de persoane inscrise\r\n" + 
						"search       - Cauta toti invitatii conform sirului de caractere introdus\r\n" + 
						"quit         - Inchide aplicatia");
				System.out.println();
				break;
				
			case "add":
				System.out.println("Nume de familie:");
				String lastName = sc.nextLine();
				System.out.println("Prenume:");
				String firstName = sc.nextLine();
				System.out.println("email:");
				String email = sc.nextLine();
				System.out.println("numar de telefon:");
				String phoneNumber = sc.nextLine();
				int addGuest = gl.add(lastName, firstName, email, phoneNumber);
				
				switch (addGuest) {
				
				case -1:
					System.out.println("Persoana a fost deja inscrisa la eveniment.");
					break;
					
				case 0:
					System.out.println("Felicitari! Locul tau la eveniment este confirmat. Te asteptam!");
					break;
					
				default:
					System.out.println(String.format("Te-ai inscris cu succes in lista de asteptare si ai primit numarul de ordine %d. "
							+ "Te vom notifica daca un loc devine disponibil.", addGuest));	
				}
				
				break;
			
			case "check":
				System.out.println("Selectati o optiune:\r\n"
						+ "1. lastName si firstName\r\n" + 
						"2. email\r\n" + 
						"3. phoneNumber");
				int op = sc.nextInt();
				sc.nextLine();
				switch (op) {
				
				case 1:
					if(gl.check(1, false, 1))
						System.out.println("Se afla pe lista.");
					else
						System.out.println("Nu se afla pe lista.");
					
					break;
					
				case 2:
					if(gl.check(2, false, 1))
						System.out.println("Se afla pe lista.");
					else
						System.out.println("Nu se afla pe lista.");
					break;
				
				case 3:
					if(gl.check(3, false, 1))
						System.out.println("Se afla pe lista.");
					else
						System.out.println("Nu se afla pe lista.");
					break;
				
				default:
					System.out.println("Nu este o optiune valida.");
				}
				
				break;
				
			case "remove":
				System.out.println("Selectati o optiune:\r\n"
						+ "1. lastName si firstName\r\n" + 
						"2. email\r\n" + 
						"3. phoneNumber");
				int opRemove = sc.nextInt();
				sc.nextLine();
				switch (opRemove) {
				
				case 1:
					if(gl.remove(1))
						System.out.println("A fost sters.");
					else
						System.out.println("Nu se afla pe lista.");
					
					break;
					
				case 2:
					if(gl.remove(2))
						System.out.println("A fost sters.");
					else
						System.out.println("Nu se afla pe lista.");
					break;
				
				case 3:
					if(gl.remove(3))
						System.out.println("A fost sters.");
					else
						System.out.println("Nu se afla pe lista.");
					break;
				
				default:
					System.out.println("Nu este o optiune valida.");
				}
				
				break;
			
			case "update":
				System.out.println("Scrieti numarul de telefon al invitatului:");
				String phoneNo = sc.nextLine();
				gl.update(phoneNo);
				break;
				
			case "guests":
				gl.guests();
				break;
				
			case "waitlist":
				gl.waitlist();
				break;
				
			case "available":
				System.out.println("Numarul de locuri libere: " + gl.available());
				break;
				
			case "guests_no":
				System.out.println("Numarul de persoane care participa la eveniment: " + gl.guestsNo());
				break;
				
			case "waitlist_no":
				System.out.println("Numarul de persoane din lista de asteptare: "  + gl.waitlistNo());
				break;
				
			case "subscribe_no":
				System.out.println("Numarul total de persoane inscrise: " + gl.subscribeNo());
				break;
				
			case "search":
				System.out.println("Cautati:");
				String str = sc.nextLine();
				gl.search(str);
				break;
				
			default:
				System.out.println("Nu este o optiune valida.");
			
			}
			option = sc.nextLine().toLowerCase();
			
		} while (!option.equals("quit"));
		
		sc.close();

	}

}
