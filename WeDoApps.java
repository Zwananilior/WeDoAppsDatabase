/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package wedoapps;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import za.ac.tut.bl.SALGAManager;
import za.ac.tut.entity.City;
import za.ac.tut.entity.Mayor;

/**
 *
 * @author DELL
 */
public class WeDoApps {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
    List<City> cities =new ArrayList<>();
    City cty;
    SALGAManager sm = new SALGAManager();
    
    Integer opt,cityId;
    
    opt =displayOption();
            
    while(opt!=6){
    
        switch (opt) {
            case 1:
                cty =getCity();
                if(sm.add(cty, cities)){
                        System.out.println("City was added.");
                    } else {
                        System.out.println("City was not added.");
                    }break;
            case 2:
                cityId =getId();
                if(sm.delete(cityId, cities)){
                System.out.println("Deleted succefully");
                }else{
                System.out.println("Couldn't Delete");
                }
                break;
            case 3:cityId =getId();
            Mayor my = new Mayor();
            sm.update(cityId, my, cities);break;
            case 4:cityId =getId();
            sm.getCity(cityId, cities);
            break;
            
            case 5: System.out.println("All the cities.\n" + cities);
            break;
            
            
            default:
               System.err.println("Invalid option.Please enter the option 1,2,3,4,5");
        }
        opt =displayOption();
    }
    System.out.println("Good bye!!!!");
    
    
    
    }
    private static Integer displayOption(){
    Scanner scanner =new Scanner(System.in);
    System.out.print("Menu: "
            + "\n1. Store city information"
            + "\n2. Delete a city record based on its unique id."
            + "\n3. Update the name and surname of a city mayor"
            + "\n4. Get city information based on a unique id."
            + "\n5. Display the information of all the cities.\n"
            + "\nYour option: ");
    Integer option =scanner.nextInt();
    return option;
    }
    private static City getCity(){
    City cy ;    
    Scanner scanner =new Scanner(System.in);
    
    System.out.print("Enter the cities id: ");
    Integer id =scanner.nextInt();
    
    scanner.nextLine();
    System.out.print("Enter the cities name: ");
    String name =scanner.nextLine();
    
    System.out.print("Enter the mayors id: ");
    Integer idmayor =scanner.nextInt();
    
    scanner.nextLine();
    System.out.print("Enter the mayors name: ");
    String nameMayor =scanner.nextLine();
    
    System.out.print("Enter the Mayors surname: ");
    String surname =scanner.nextLine();
    
    Mayor mayor =new Mayor(idmayor, nameMayor, surname);
    cy =new City(id, name, mayor);
    
    return cy;
    }
    private  static Integer getId(){
    Scanner scanner =new Scanner(System.in);
    
    System.out.print("Enter the cities id: ");
    Integer id =scanner.nextInt();
    
    return id;
    }
    private static Mayor getMayor(){
    Scanner scanner =new Scanner(System.in);
    
    System.out.print("Enter the Mayor id: ");
    Integer id =scanner.nextInt();
    
    System.out.print("Enter the Mayor name: ");
    String name =scanner.nextLine();
    
    System.out.print("Enter the Mayor surname: ");
    String surname =scanner.nextLine();
    
    Mayor mayor = new Mayor();
    mayor.setId(id);
    mayor.setSurname(surname);
    mayor.setName(name);
    
    return mayor;
    
    }
}
