package com.wipro.ems.main; 
 
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Scanner;
import com.wipro.ems.entity.*; 
import com.wipro.ems.service.EventService; 
 
public class Main { 
    public static void main(String[] args) { 
 
    	Scanner sc = new Scanner(System.in);

        ArrayList<Event> events = new ArrayList<>();
        ArrayList<Task> tasks = new ArrayList<>();
        ArrayList<Staff> staffList = new ArrayList<>();
        ArrayList<TaskUpdate> updates = new ArrayList<>();

        EventService service = new EventService(events, tasks, staffList, updates);

        boolean running = true;

        while (running) {
            System.out.println("\n EVENT MANAGEMENT SYSTEM");
            System.out.println("1. Add Event");
            System.out.println("2. Add Task");
            System.out.println("3. Add Staff");
            System.out.println("4. Assign Staff to Task");
            System.out.println("5. Record Task Update");
            System.out.println("6. Generate Event Summary");
            System.out.println("7. Exit");
            System.out.print("Choose option: ");

            int choice = sc.nextInt();
            sc.nextLine();

            try {
                switch (choice) {

                    case 1:
                        System.out.print("Event ID: ");
                        String eventId = sc.nextLine();

                        System.out.print("Event Name: ");
                        String eventName = sc.nextLine();

                        System.out.print("Venue: ");
                        String venue = sc.nextLine();

                        LocalDate date = null;
                        try {
                            System.out.print("Enter date (YYYY-MM-DD): ");
                            String input = sc.nextLine();
                            date = LocalDate.parse(input);
                        } catch (Exception e) {
                            System.out.println("❌ Invalid date format. Use YYYY-MM-DD");
                        }


                        System.out.print("Description: ");
                        String desc = sc.nextLine();

                        events.add(new Event(eventId, eventName, venue, date, desc));
                        System.out.println("✅ Event added successfully");
                        break;

                    case 2:
                        System.out.print("Task ID: ");
                        String taskId = sc.nextLine();

                        System.out.print("Event ID: ");
                        String taskEventId = sc.nextLine();

                        System.out.print("Task Name: ");
                        String taskName = sc.nextLine();

                        System.out.print("Estimated Hours: ");
                        int hours = sc.nextInt();
                        sc.nextLine();

                        Task task = new Task(taskId, taskEventId, taskName, null, TaskStatus.PENDING, hours);
                        service.addTask(task);
                        System.out.println("✅ Task added");
                        break;

                    case 3:
                        System.out.print("Staff ID: ");
                        String staffId = sc.nextLine();

                        System.out.print("Staff Name: ");
                        String staffName = sc.nextLine();

                        System.out.print("Role: ");
                        String role = sc.nextLine();

                        staffList.add(new Staff(staffId, staffName, role));
                        System.out.println("✅ Staff added");
                        break;

                    case 4:
                        System.out.print("Task ID: ");
                        String tId = sc.nextLine();

                        System.out.print("Staff ID: ");
                        String sId = sc.nextLine();

                        service.assignStaffToTask(tId, sId);
                        System.out.println("✅ Staff assigned to task");
                        break;

                    case 5:
                        System.out.print("Update ID: ");
                        String updateId = sc.nextLine();

                        System.out.print("Task ID: ");
                        String utaskId = sc.nextLine();

                        System.out.print("Date: ");
                        String udate = sc.nextLine();

                        System.out.print("Notes: ");
                        String notes = sc.nextLine();

                        service.recordTaskUpdate(updateId, utaskId, udate, notes);
                        System.out.println("✅ Task update recorded");
                        break;

                    case 6:
                        System.out.print("Event ID: ");
                        String summaryEventId = sc.nextLine();

                        System.out.println("\n" + service.generateEventSummary(summaryEventId));
                        break;

                    case 7:
                        running = false;
                        System.out.println("👋 Exiting system. Bye!");
                        break;

                    default:
                        System.out.println("❌ Invalid option. Try again.");
                }

            } catch (Exception e) {
                System.out.println("Error: " + e.getMessage());
            }
        }

        sc.close();
    }
}