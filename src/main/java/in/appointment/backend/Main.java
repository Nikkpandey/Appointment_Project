package in.appointment.backend;

import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        AppointmentDAO appointmentDAO = new AppointmentDAO();
        while (true) {
            System.out.println("1. Add Appointment");
            System.out.println("2. View Appointments");
            System.out.println("3. Delete Appointment");
            System.out.println("4. Exit");
            int choice = scanner.nextInt();
            switch (choice) {
                case 1:
                    Appointment appointment = new Appointment();
                    System.out.println("Enter Customer Name:");
                    appointment.setCustomerName(scanner.next());
                    System.out.println("Enter Appointment Date (YYYY-MM-DD):");
                    appointment.setAppointmentDate(scanner.next());
                    System.out.println("Enter Appointment Time (HH:MM:SS):");
                    appointment.setAppointmentTime(scanner.next());
                    System.out.println("Enter Service:");
                    appointment.setService(scanner.next());
                    appointmentDAO.addAppointment(appointment);
                    break;
                case 2:
                    List<Appointment> appointments = appointmentDAO.listAppointments();
                    for (Appointment a : appointments) {
                        System.out.println("ID: " + a.getId() + ", Name: " + a.getCustomerName() + 
                            ", Date: " + a.getAppointmentDate() + ", Time: " + a.getAppointmentTime() + 
                            ", Service: " + a.getService());
                    }
                    break;
                case 3:
                    System.out.println("Enter Appointment ID to delete:");
                    int id = scanner.nextInt();
                    appointmentDAO.deleteAppointment(id);
                    break;
                case 4:
                    System.exit(0);
            }
        }
    }
}
