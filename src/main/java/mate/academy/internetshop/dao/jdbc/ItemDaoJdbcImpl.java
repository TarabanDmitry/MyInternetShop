package mate.academy.internetshop.dao.jdbc;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import mate.academy.internetshop.dao.ItemDao;
import mate.academy.internetshop.lib.Dao;
import mate.academy.internetshop.model.Item;
import org.apache.log4j.Logger;

@Dao
public class ItemDaoJdbcImpl extends AbstractDao<Item> implements ItemDao {

    private static String DB_NAME = "test.items";
    private static Logger logger = Logger.getLogger(ItemDaoJdbcImpl.DB_NAME);

    public ItemDaoJdbcImpl(Connection connection) {
        super(connection);
    }

    @Override
    public List<Item> getAllItems() {
        List<Item> list = new ArrayList<>();
        String query = "SELECT * FROM " + DB_NAME;

        try {
            Statement stmt = connection.createStatement();
            ResultSet rs = stmt.executeQuery(query);
            while (rs.next()) {
                Item item = new Item(rs.getString("name"),
                        rs.getDouble("price"));
                item.setId(rs.getLong("item_id"));
                list.add(item);
            }
        } catch (SQLException e) {
            logger.warn("Can't get items");
            logger.warn("Exception was", e);
        }
        return list;
    }

    @Override
    public Item create(Item item) {
        String name = item.getName();
        Double price = item.getPrice();
        String query = "INSERT INTO " + DB_NAME + " (name, price) VALUES ('"
                + name + "', " + price + ");";
        try (Statement stmt = connection.createStatement()) {
            try {
                stmt.executeUpdate(query);
            } catch (SQLException e) {
                logger.error("Item can't be added", e);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return item;
    }

    @Override
    public Item get(Long id) {
        Statement stmt = null;
        String query = " SELECT * FROM " + DB_NAME + ", items WHERE item_id=1";
        try {
            stmt = connection.createStatement();
            ResultSet rs = stmt.executeQuery(query);
            while (rs.next()) {
                long itemId = rs.getLong("item_id");
                String name = rs.getString("name");
                double price = rs.getDouble("price");
                Item item = new Item(itemId);
                item.setName(name);
                item.setPrice(price);
                return item;
            }

        } catch (SQLException e) {
            logger.warn("Can't get item by id " + id);
        } finally {
            if (stmt != null) {
                try {
                    stmt.close();
                } catch (SQLException e) {
                    logger.warn("Can't close statement");
                }
            }
        }
        return null;
    }

    @Override
    public Item update(Item item) {
        Long id = item.getId();
        String name = item.getName();
        Double price = item.getPrice();
        String query = "UPDATE " + DB_NAME + " set name = '" + name + "', price = " + price
                + " WHERE item_id = " + id + ";";
        try (Statement statement = connection.createStatement()) {
            statement.executeUpdate(query);
        } catch (SQLException e) {
            logger.warn("Item couldn't be update", e);
        }
        return item;
    }

    @Override
    public boolean deleteById(Long id) {
        String query = "DELETE FROM " + DB_NAME + " WHERE item_id =" + id + ";";
        try (Statement statement = connection.createStatement()) {
            statement.executeUpdate(query);
        } catch (SQLException e) {
            logger.warn("Can't delete item with id " + id);
            return false;
        }
        return true;
    }

    @Override
    public boolean delete(Item item) {
        return false;
    }
}
