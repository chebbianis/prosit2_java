import entities.Employe;
import entities.SocieteArrayList;
import interfaces.IGestion;

public class Main {
    public static void main(String[] args) {
        SocieteArrayList societe = new SocieteArrayList();

        // test ajoute employee
        Employe emp1 = new Employe(1, "foulen", "ben foulen", "IT", "Manager");
        Employe emp2 = new Employe(2, "foulen1", "ben foulen1", "IT", "developer");
        Employe emp3 = new Employe(3, "foulen2", "ben foulen2", "IT", "Manager");
        Employe emp4 = new Employe(4, "foulen3", "ben foulen3", "IT", "developer");
        Employe emp5 = new Employe(5, "foulen4", "ben foulen4", "IT", "developer");


        societe.ajouterEmploye(emp5);
        societe.ajouterEmploye(emp2);
        societe.ajouterEmploye(emp4);
        societe.ajouterEmploye(emp3);

        System.out.println("*************************Test displayEmployee method*************************");
        // Test displayEmployee method
        System.out.println("Test displayEmployee method");
        societe.displayEmploye();

        // Test rechercherEmploye method
        System.out.println("*************************Test rechercherEmploye method*************************");
        societe.rechercherEmploye("anis");
        societe.rechercherEmploye("foulen1");

        societe.rechercherEmploye(emp4);
        societe.rechercherEmploye(emp1);

        System.out.println("*************************Test sorting list with id *************************");

        System.out.println("List of Employees before sort :");
        for (Employe employe : societe.getListEmploye()) {
            System.out.println("ID : "+employe.getId()+" NOM: "+employe.getNom());
        }

        societe.trierEmployeParId();

        System.out.println("List of Employees after sort :");
        for (Employe employe : societe.getListEmploye()) {
            System.out.println("ID : "+employe.getId()+" NOM: "+employe.getNom());
        }

        societe.ajouterEmploye(emp1);

        System.out.println("*************************Test sorting list with name , departement and grade *************************");

        System.out.println("List of Employees before sort :");
        for (Employe employe : societe.getListEmploye()) {
            System.out.println("ID : "+employe.getId()+" NOM: "+employe.getNom());
        }
        societe.trierEmployeParNomDepartementEtGrade();


        System.out.println("List of Employees after sort : ");
        for (Employe employe : societe.getListEmploye()) {
            System.out.println("ID : "+employe.getId()+" NOM : "+employe.getNom());
        }

        System.out.println("*************************Test supprimerEmployee *************************");

        societe.supprimerEmploye(emp1);
        for (Employe employe : societe.getListEmploye()) {
            System.out.println("ID : "+employe.getId()+" NOM: "+employe.getNom());
        }

    }
}