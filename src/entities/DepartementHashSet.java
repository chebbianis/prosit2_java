package entities;

import interfaces.IDepartement;

import java.util.Comparator;
import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;

public class DepartementHashSet implements IDepartement {

    Set<Departement> setDepartement = new HashSet<>();

    @Override
    public void ajouterDepartement(Object o) {
        if (o instanceof Departement departement) {
            setDepartement.add(departement);
            System.out.println("Department added successfully");
        } else {
            System.out.println("Invalid object type");
        }
    }

    @Override
    public boolean rechercherDepartement(String nom) {
        for (Departement departement : setDepartement) {
            if (departement.getNomDepartement().equalsIgnoreCase(nom)) {
                System.out.println("Department found: " + departement);
                return true;
            }
        }
        System.out.println("Department with name '" + nom + "' not found.");
        return false;
    }

    @Override
    public boolean rechercherDepartement(Object o) {
        if (o instanceof Departement departement) {
            if (setDepartement.contains(departement)) {
                System.out.println("Department found: " + departement);
                return true;
            } else {
                System.out.println("Department not found.");
                return false;
            }
        } else {
            System.out.println("Invalid object type");
            return false;
        }
    }

    @Override
    public void supprimerDepartement(Object o) {
        if (o instanceof Departement departement) {
            if (setDepartement.remove(departement)) {
                System.out.println("Department removed successfully: " + departement);
            } else {
                System.out.println("Department not found. Unable to remove.");
            }
        } else {
            System.out.println("Invalid object type");
        }
    }

    @Override
    public void displayDepartement() {
        System.out.println("List of Departments:");
        for (Departement departement : setDepartement) {
            System.out.println(departement);
        }
    }

    @Override
    public TreeSet trierDepartementById() {
        TreeSet<Departement> sortedSet = new TreeSet<>(Comparator.comparingInt(Departement::getId));
        sortedSet.addAll(setDepartement);
        return sortedSet;    }
}
