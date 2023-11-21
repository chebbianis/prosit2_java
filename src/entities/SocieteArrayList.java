package entities;

import interfaces.IGestion;

import java.util.ArrayList;
import java.util.Comparator;

public class SocieteArrayList implements IGestion {
    ArrayList<Employe> listEmploye = new ArrayList<>();



    public void ajouterEmploye(Object o) {
        if (o instanceof Employe employe) {
            listEmploye.add(employe);
            System.out.println("Employee added successfully");
        } else {
            System.out.println("Invalid object type");
        }
    }
    @Override
    public boolean rechercherEmploye(String nom) {
        for (Employe employe : listEmploye) {
            if (employe.getNom().equalsIgnoreCase(nom)) {
                System.out.println("Employee found: " + employe);
                return true;
            }
        }
        System.out.println("Employee with name '" + nom + "' not found.");
        return false;
    }

    @Override
    public boolean rechercherEmploye(Object o) {
        if (o instanceof Employe employe) {
            if (listEmploye.contains(employe)) {
                System.out.println("Employee found : " + employe);
                return true;
            } else {
                System.out.println("Employee "+o+" not found.");
                return false;
            }
        } else {
            System.out.println("Invalid object type");
            return false;
        }
    }

    @Override
    public void supprimerEmploye(Object o) {
        if (o instanceof Employe employe) {
            if (listEmploye.remove(employe)) {
                System.out.println("Employee removed successfully : " + employe);
            } else {
                System.out.println("Employee not found. Unable to remove.");
            }
        } else {
            System.out.println("Invalid object type");
        }
    }

    public ArrayList<Employe> getListEmploye() {
        return listEmploye;
    }

    public void setListEmploye(ArrayList<Employe> listEmploye) {
        this.listEmploye = listEmploye;
    }

    @Override
    public void displayEmploye() {
        System.out.println("List of Employees:");
        for (Employe employe : listEmploye) {
            System.out.println(employe);
        }
    }

    @Override
    public void trierEmployeParId() {
        listEmploye.sort(Comparator.comparingInt(Employe::getId));
        System.out.println("Employees sorted by ID :");
    }

    @Override
    public void trierEmployeParNomDepartementEtGrade() {
        listEmploye.sort(Comparator
                .comparing(Employe::getNom)
                .thenComparing(Employe::getNomDepartement)
                .thenComparing(Employe::getGrade));
        System.out.println("Employees sorted by Name, Department, and Grade:");
    }
}

