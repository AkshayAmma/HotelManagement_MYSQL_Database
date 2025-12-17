package HotelManagement.service;

import java.util.List;
import java.util.Map;

import HotelManagement.model.Room;
import HotelManagement.repository.RoomRepository;

public class RoomService {
 
    private final RoomRepository roomRepository;

    public RoomService(RoomRepository roomRepository) {
        this.roomRepository=roomRepository;
    }


    public void addRoom(Room room)
    {
       roomRepository.addRoom(room);
    }

    public void removeRoom(int roomId)
    {
       roomRepository.removeRoom(roomId);
    }

    public void updateRoom(Room room)
    {
        roomRepository.updateRoom(room);
    }

    public List<Room> getAvailableRooms()
    {
        return roomRepository.getAllRooms().stream().filter(room -> !room.isBooked()).toList();
    }

    public List<Room> searchRoomByType(String type) {
        return roomRepository.getRoomsByType(type)
                .stream()
                .filter(room -> !room.isBooked())
                .toList();
    }

    public List<Room> searchRoomByCapacity(int capacity) {
        return roomRepository.getRoomByCapacity(capacity)
                .stream()
                .filter(room -> !room.isBooked())
                .toList();
    }


    public void markRoomAsBooked(int roomId)
    {
        Room room=roomRepository.getRoomById(roomId);
        if(room!=null)
        {
            room.setBooked(true);
            roomRepository.updateRoom(room);
        }else{
            System.out.println("Room Not Available ");
        }
    }

    public void markRoomAsAvailable(int roomId)
    {
        Room room=roomRepository.getRoomById(roomId);

        if(room!=null)
        {
            room.setBooked(false);
            roomRepository.updateRoom(room);
        }
        else{
            System.out.println("Room Not Available");
        }
    }

    public Room getRoomById(int roomId) {
        return roomRepository.getRoomById(roomId);
    }
}
