package HotelManagement.controller;

import HotelManagement.model.Room;
import HotelManagement.service.RoomService;
import HotelManagement.util.InputUtil;

import java.util.List;

public class RoomController {

    private RoomService roomservice;

    public RoomController(RoomService roomService) {
        this.roomservice = roomService;
    }

    public void addRoom() {

        String roomNumber = InputUtil.getString("Enter Room Number: ");
        String roomType = InputUtil.getString("Enter Room Type: ");
        double pricePerNight = InputUtil.getDouble("Enter Price Per Night: ");
        boolean isBooked = InputUtil.getBoolean("Enter IsBooked (True/False): ");
        int capacity = InputUtil.getInt("Enter Capacity Of Room: ");
        int floorNumber = InputUtil.getInt("Enter Floor Number: ");

        roomservice.addRoom(
                new Room(roomNumber, roomType, pricePerNight, isBooked, capacity, floorNumber));
        System.out.println("Room Added Successfully");

    }

    public void removeRoom() {
        int rId = InputUtil.getInt("Enter Room Id: ");

        roomservice.removeRoom(rId);
        System.out.println("Removed Room Successfully");
    }

    public void updateRoom() {
        int rId = InputUtil.getInt("Enter Room Id: ");
        String roomNumber = InputUtil.getString("Enter Room Number: ");
        String roomType = InputUtil.getString("Enter Room Type: ");
        double pricePerNight = InputUtil.getDouble("Enter Price Per Night: ");
        boolean isBooked = InputUtil.getBoolean("Enter IsBooked (True/False): ");
        int capacity = InputUtil.getInt("Enter Capacity Of Room: ");
        int floorNumber = InputUtil.getInt("Enter Floor Number: ");

        roomservice.updateRoom(
                new Room(rId, roomNumber, roomType, pricePerNight, isBooked, capacity, floorNumber));

        System.out.println("Room Updated Successfully");
    }

    public void getAvailableRooms() {
        System.out.println("Available Rooms: ");
        List<Room> rooms = roomservice.getAvailableRooms();
        rooms.forEach(System.out::println);
    }

    public void searchRoomByType() {
        String roomType = InputUtil.getString("Enter Room Type: ");

        System.out.println("Rooms That Are Available For This Type " + roomType + " :");
        List<Room> rooms = roomservice.searchRoomByType(roomType);
        rooms.forEach(System.out::println);

    }

    public void searchRoomByCapacity() {
        int capacity = InputUtil.getInt("Enter Capacity Of Room: ");

        System.out.println("Rooms That Are Available Are:");
        List<Room> rooms = roomservice.searchRoomByCapacity(capacity);
        rooms.forEach(System.out::println);
    }


    public void markRoomAsBooked() {
        int rId = InputUtil.getInt("Enter Room Id: ");
        Room room = roomservice.getRoomById(rId);
        if (room != null) {
            roomservice.markRoomAsBooked(rId);
            System.out.println("Successfully Marked Room As Booked");
        } else {
            System.out.println("Room Not Found!");
        }
    }

    public void markRoomAsAvailable() {
        int rId = InputUtil.getInt("Enter Room Id: ");
        Room room = roomservice.getRoomById(rId);
        if (room != null) {
            roomservice.markRoomAsAvailable(rId);
            System.out.println("Successfully Marked Room As Available");
        } else {
            System.out.println("Room Not Found!");
        }
    }


    public void getRoomById() {
        int rId = InputUtil.getInt("Enter Room Id: ");

        Room room = roomservice.getRoomById(rId);

        if (room == null) {
            System.out.println("Room Not Found");
        } else {
            System.out.println("Room Found");
            System.out.println(room);
        }
    }


}
