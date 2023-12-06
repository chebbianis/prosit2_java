import entities.Departement;
import entities.DepartementHashSet;
import entities.Employe;
import entities.SocieteArrayList;
import interfaces.IGestion;

import java.util.TreeSet;

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

        System.out.println("************************* Test displayEmployee method*************************");
        // Test displayEmployee method
        System.out.println("Test displayEmployee method");
        societe.displayEmploye();

        // Test rechercherEmploye method
        System.out.println("************************* Test rechercherEmploye method*************************");
        societe.rechercherEmploye("anis");
        societe.rechercherEmploye("foulen1");

        societe.rechercherEmploye(emp4);
        societe.rechercherEmploye(emp1);

        System.out.println("************************* Test sorting list with id *************************");

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

        System.out.println("************************* Test sorting list with name , departement and grade *************************");

        System.out.println("List of Employees before sort :");
        for (Employe employe : societe.getListEmploye()) {
            System.out.println("ID : "+employe.getId()+" NOM: "+employe.getNom());
        }
        societe.trierEmployeParNomDepartementEtGrade();


        System.out.println("List of Employees after sort : ");
        for (Employe employe : societe.getListEmploye()) {
            System.out.println("ID : "+employe.getId()+" NOM : "+employe.getNom());
        }

        System.out.println("************************* Test supprimerEmployee *************************");

        societe.supprimerEmploye(emp1);
        for (Employe employe : societe.getListEmploye()) {
            System.out.println("ID : "+employe.getId()+" NOM: "+employe.getNom());
        }

        System.out.println("*********************************** HASHET ***********************************");


        DepartementHashSet departementHashSet = new DepartementHashSet();

        Departement departement1 = new Departement(1, "IT",15);
        Departement departement2 = new Departement(2, "HR",20);
        Departement departement3 = new Departement(3, "Finance",30);

        // Test d'ajout de département
        System.out.println("************************* Test d'ajout de département *************************");

        departementHashSet.ajouterDepartement(departement1);
        departementHashSet.ajouterDepartement(departement2);
        departementHashSet.ajouterDepartement(departement3);

        // Test de recherche de département par nom
        System.out.println("************************* Test de recherche de département par nom ***************************");

        departementHashSet.rechercherDepartement("IT");
        departementHashSet.rechercherDepartement("Marketing");

        // Test de recherche de département par objet
        System.out.println("************************* Test de recherche de département par objet ***************************");
        departementHashSet.rechercherDepartement(departement1);
        departementHashSet.rechercherDepartement(new Departement(4, "Legal",10));

        // Test de suppression de département
        System.out.println("************************* Test de suppression de département ***************************");
        departementHashSet.supprimerDepartement(departement2);
        departementHashSet.displayDepartement();

        // Test de tri par ID
        System.out.println("************************* Test de tri par ID ***************************");
        departementHashSet.ajouterDepartement(new Departement(5, "FINANCE",15));
        departementHashSet.ajouterDepartement(new Departement(6, "MARKETING",15));
        departementHashSet.ajouterDepartement(new Departement(7, "RESEAU",15));
        departementHashSet.displayDepartement();

        TreeSet<Departement> sortedSet = departementHashSet.trierDepartementById();
        System.out.println("Departements tries par ID:");
        for (Departement departement : sortedSet) {
            System.out.println(departement);
        }    }
}