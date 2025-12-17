package HotelManagement.repository;

import HotelManagement.model.Room;
import HotelManagement.util.DatabaseUtil;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class RoomRepository {
    public void addRoom(Room room) {
        String sql = "INSERT INTO rooms(RoomNumber,RoomType,PricePerNight,IsBooked,Capacity,FloorNumber) VALUES (?,?,?,?,?,?)";

        try (Connection connection = DatabaseUtil.getConnection();
             PreparedStatement statement = connection.prepareStatement(sql)) {


            statement.setString(1, room.getRoomNumber());
            statement.setString(2, room.getRoomType());
            statement.setDouble(3, room.getPricePerNight());
            statement.setBoolean(4, room.isBooked());
            statement.setInt(5, room.getCapacity());
            statement.setInt(6, room.getFloorNumber());

            statement.executeUpdate();

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public List<Room> getAllRooms() {
        List<Room> rooms = new ArrayList<>();
        String sql = "SELECT * FROM rooms";

        try (Connection connection = DatabaseUtil.getConnection();
             Statement statement = connection.createStatement();
             ResultSet rs = statement.executeQuery(sql)) {

            while (rs.next()) {
                rooms.add(new Room(rs.getInt("RoomId"),
                        rs.getString("RoomNumber"),
                        rs.getString("RoomType"),
                        rs.getDouble("PricePerNight"),
                        rs.getBoolean("IsBooked"),
                        rs.getInt("Capacity"),
                        rs.getInt("FloorNumber")));
            }

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

        return rooms;
    }

    public Room getRoomById(int roomId) {
        String sql = "SELECT * FROM rooms WHERE RoomId=?";

        try (Connection connection = DatabaseUtil.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(sql)) {

            preparedStatement.setInt(1, roomId);
            ResultSet resultSet = preparedStatement.executeQuery();

            if (resultSet.next()) {
                return new Room(
                        resultSet.getInt("RoomId"),
                        resultSet.getString("RoomNumber"),
                        resultSet.getString("RoomType"),
                        resultSet.getDouble("PricePerNight"),
                        resultSet.getBoolean("IsBooked"),
                        resultSet.getInt("Capacity"),
                        resultSet.getInt("FloorNumber")
                );
            }

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return null;
    }


    public void removeRoom(int roomId) {
        String sql = "DELETE FROM rooms  WHERE RoomId = ?";

        try (Connection connection = DatabaseUtil.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            preparedStatement.setInt(1, roomId);

            preparedStatement.executeUpdate();

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public void updateRoom(Room room) {
        String sql = "UPDATE rooms SET RoomNumber=?, RoomType=?, PricePerNight=?, " +
                "IsBooked=?, Capacity=?, FloorNumber=? WHERE RoomId=?";

        try (Connection connection = DatabaseUtil.getConnection();
             PreparedStatement statement = connection.prepareStatement(sql)) {

            statement.setString(1, room.getRoomNumber());
            statement.setString(2, room.getRoomType());
            statement.setDouble(3, room.getPricePerNight());
            statement.setBoolean(4, room.isBooked());
            statement.setInt(5, room.getCapacity());
            statement.setInt(6, room.getFloorNumber());
            statement.setInt(7, room.getRoomId());

            statement.executeUpdate();

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

    }

    public List<Room> getRoomsByType(String type) {
        String sql = "SELECT * FROM rooms WHERE RoomType=?";
        List<Room> rooms = new ArrayList<>();

        try (Connection connection = DatabaseUtil.getConnection();
             PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setString(1, type);

            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                Room room = new Room();
                room.setRoomId(resultSet.getInt("RoomId"));
                room.setRoomNumber(resultSet.getString("RoomNumber"));
                room.setRoomType(resultSet.getString("RoomType"));
                room.setPricePerNight(resultSet.getDouble("PricePerNight"));
                room.setBooked(resultSet.getBoolean("IsBooked"));
                room.setCapacity(resultSet.getInt("Capacity"));
                room.setFloorNumber(resultSet.getInt("FloorNumber"));


                rooms.add(room);
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return rooms;
    }

    public List<Room> getRoomByCapacity(int capacity) {
        List<Room> rooms = new ArrayList<>();
        String sql = "SELECT * FROM rooms WHERE Capacity = ?";

        try (Connection connection = DatabaseUtil.getConnection();
             PreparedStatement statement = connection.prepareStatement(sql)) {

            statement.setInt(1, capacity);
            ResultSet rs = statement.executeQuery();

            while (rs.next()) {
                Room room = new Room();
                room.setRoomId(rs.getInt("RoomId"));
                room.setRoomNumber(rs.getString("RoomNumber"));
                room.setRoomType(rs.getString("RoomType"));
                room.setPricePerNight(rs.getDouble("PricePerNight"));
                room.setBooked(rs.getBoolean("IsBooked"));
                room.setCapacity(rs.getInt("Capacity"));
                room.setFloorNumber(rs.getInt("FloorNumber"));

                rooms.add(room);
            }

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

        return rooms;
    }

}
